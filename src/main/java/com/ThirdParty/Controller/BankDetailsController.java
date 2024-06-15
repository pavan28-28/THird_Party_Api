package com.ThirdParty.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ThirdParty.Model.BankDetail;
import com.ThirdParty.Service.BankDetailsService;

import java.util.List;

@RestController
public class BankDetailsController {

    @Autowired
    private BankDetailsService bankDetailsService;

    @GetMapping("/bankDetails")
    public List<BankDetail> getBankDetails() {
        return bankDetailsService.getBankDetails();
    }
}