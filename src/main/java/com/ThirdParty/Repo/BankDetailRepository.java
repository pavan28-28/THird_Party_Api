package com.ThirdParty.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ThirdParty.Model.BankDetail;

@Repository
public interface BankDetailRepository extends JpaRepository<BankDetail, String> {
}