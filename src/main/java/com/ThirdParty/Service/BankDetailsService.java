package com.ThirdParty.Service;

import com.ThirdParty.Model.BankApiResponse;
import com.ThirdParty.Model.BankDetail;
import com.ThirdParty.Repo.BankDetailRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class BankDetailsService {

    @Autowired
    private BankDetailRepository bankDetailRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final String API_URL = "https://enach.npci.org.in/apiservices/getLiveBankDtls";

    @Cacheable("bankDetails")
    public List<BankDetail> getBankDetails() {
        return bankDetailRepository.findAll();
    }

    @Scheduled(fixedRate = 21600000) // 6 hours in milliseconds
    @CacheEvict(value = "bankDetails", allEntries = true)
    @CachePut("bankDetails")
    public List<BankDetail> updateBankDetails() {
        String response = restTemplate.getForObject(API_URL, String.class);
        Gson gson = new Gson();
        BankApiResponse apiResponse = gson.fromJson(Objects.requireNonNull(response), BankApiResponse.class);
        
        List<BankDetail> liveBankList = apiResponse.getLiveBankList();
        
        List<BankDetail> existingBankDetails = bankDetailRepository.findAll();
        
        if (!liveBankList.equals(existingBankDetails)) {
            bankDetailRepository.deleteAll();
            bankDetailRepository.saveAll(liveBankList);
        }

        return liveBankList;
    }
}