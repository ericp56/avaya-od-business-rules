package com.nextivr.demo.model;

import java.math.BigDecimal;

/**
 * Just a model for business rules. Getters, setters, contstructor and toString.
 * 
 * @author eric
 *
 */
public class Account {
	private String accountNumber;
	private String primaryPhone;
	private String accountStatus;
	private BigDecimal accountBalance;
	private String zipCode;

	public Account(String accountNumber, String primaryPhone, String accountStatus, BigDecimal accountBalance,
			String zipCode) {
		super();
		this.accountNumber = accountNumber;
		this.primaryPhone = primaryPhone;
		this.accountStatus = accountStatus;
		this.accountBalance = accountBalance;
		this.zipCode = zipCode;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPrimaryPhone() {
		return primaryPhone;
	}

	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [accountNumber=");
		builder.append(accountNumber);
		builder.append(", primaryPhone=");
		builder.append(primaryPhone);
		builder.append(", accountStatus=");
		builder.append(accountStatus);
		builder.append(", accountBalance=");
		builder.append(accountBalance);
		builder.append(", zipCode=");
		builder.append(zipCode);
		builder.append("]");
		return builder.toString();
	}

}
