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

import java.sql.Time;
import java.time.LocalTime;
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
    	System.out.println("excecuting call to db....");
        return bankDetailRepository.findAll();
    }

    @Scheduled(fixedRate = 100000) // 6 hours in milliseconds
    @CacheEvict(value = "bankDetails", allEntries = true)
    @CachePut("bankDetails")
//    public List<BankDetail> updateBankDetails() {
    public void updateBankDetails() { 
    	 LocalTime currentTime = LocalTime.now();
         
         // Extract hours, minutes, and seconds
         int hour = currentTime.getHour();
         int minute = currentTime.getMinute();
         int second = currentTime.getSecond();
         
         // Print the current time
         System.out.println("Current Time: " + hour + ":" + minute + ":" + second);
         
        String response = restTemplate.getForObject(API_URL, String.class);
        Gson gson = new Gson();
        BankApiResponse apiResponse = gson.fromJson(Objects.requireNonNull(response), BankApiResponse.class);
        
        List<BankDetail> liveBankList = apiResponse.getLiveBankList();
        
        List<BankDetail> existingBankDetails = bankDetailRepository.findAll();
        
        System.out.println("Comparing live list with existing list...");
        if (!liveBankList.equals(existingBankDetails)) {
        	System.out.println("****Mismatched found..****");
            bankDetailRepository.deleteAll();
            bankDetailRepository.saveAll(liveBankList);
        }else {
        	System.out.println("Existing list and live list are same....");
        }

//        System.out.println("returning live list...");
//        return liveBankList;
    }
}