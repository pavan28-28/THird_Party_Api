package com.ThirdParty.Model;

import java.util.List;

public class BankApiResponse {
    private List<BankDetail> liveBankList;

    // Getters and setters
    public List<BankDetail> getLiveBankList() {
        return liveBankList;
    }

    public void setLiveBankList(List<BankDetail> liveBankList) {
        this.liveBankList = liveBankList;
    }
}