package com.ThirdParty.Model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class BankDetail {

    @Id
    private String bankId;
    private String bankName;
    private String aadhaarFlag;
    private String debitcardFlag;
    private String netbankFlag;
    private String aadhaarActiveFrom;
    private String activeFrm;
    private String dcActiveFrom;
	public String getBankId() {
		return bankId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAadhaarFlag() {
		return aadhaarFlag;
	}
	public void setAadhaarFlag(String aadhaarFlag) {
		this.aadhaarFlag = aadhaarFlag;
	}
	public String getDebitcardFlag() {
		return debitcardFlag;
	}
	public void setDebitcardFlag(String debitcardFlag) {
		this.debitcardFlag = debitcardFlag;
	}
	public String getNetbankFlag() {
		return netbankFlag;
	}
	public void setNetbankFlag(String netbankFlag) {
		this.netbankFlag = netbankFlag;
	}
	public String getAadhaarActiveFrom() {
		return aadhaarActiveFrom;
	}
	public void setAadhaarActiveFrom(String aadhaarActiveFrom) {
		this.aadhaarActiveFrom = aadhaarActiveFrom;
	}
	public String getActiveFrm() {
		return activeFrm;
	}
	public void setActiveFrm(String activeFrm) {
		this.activeFrm = activeFrm;
	}
	public String getDcActiveFrom() {
		return dcActiveFrom;
	}
	public void setDcActiveFrom(String dcActiveFrom) {
		this.dcActiveFrom = dcActiveFrom;
	}
	@Override
	public int hashCode() {
		return Objects.hash(aadhaarActiveFrom, aadhaarFlag, activeFrm, bankId, bankName, dcActiveFrom, debitcardFlag,
				netbankFlag);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankDetail other = (BankDetail) obj;
		return Objects.equals(aadhaarActiveFrom, other.aadhaarActiveFrom)
				&& Objects.equals(aadhaarFlag, other.aadhaarFlag) && Objects.equals(activeFrm, other.activeFrm)
				&& Objects.equals(bankId, other.bankId) && Objects.equals(bankName, other.bankName)
				&& Objects.equals(dcActiveFrom, other.dcActiveFrom)
				&& Objects.equals(debitcardFlag, other.debitcardFlag) && Objects.equals(netbankFlag, other.netbankFlag);
	}
	@Override
	public String toString() {
		return "BankDetail [bankId=" + bankId + ", bankName=" + bankName + ", aadhaarFlag=" + aadhaarFlag
				+ ", debitcardFlag=" + debitcardFlag + ", netbankFlag=" + netbankFlag + ", aadhaarActiveFrom="
				+ aadhaarActiveFrom + ", activeFrm=" + activeFrm + ", dcActiveFrom=" + dcActiveFrom + "]";
	}
	public BankDetail(String bankId, String bankName, String aadhaarFlag, String debitcardFlag, String netbankFlag,
			String aadhaarActiveFrom, String activeFrm, String dcActiveFrom) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.aadhaarFlag = aadhaarFlag;
		this.debitcardFlag = debitcardFlag;
		this.netbankFlag = netbankFlag;
		this.aadhaarActiveFrom = aadhaarActiveFrom;
		this.activeFrm = activeFrm;
		this.dcActiveFrom = dcActiveFrom;
	}
	public BankDetail() {
		super();
	}
    
    
    
}