package com.wanxg.ibo.itp.contract;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ExtTransaction {
	
	private Long id;
	private long messageTypeIdentifier;
	private String functionCode;
	private String transactionCategory;
	private String transactionStatus;
	private String cardSchemeCode;
	private long issuingBankId;
	private String cardType;
	private String brand;
	private String acquiringReferenceData;
	private Date transactionLocalDateAndTime;
	private String terminalCategory;
	private boolean rejectedFlag;
	private boolean reversalFlag;
	private Date processingDate;
	private Date transmissionDateAndTime;
	private boolean reversedFlag;
	private Set<ExtUserAction> userActions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getMessageTypeIdentifier() {
		return messageTypeIdentifier;
	}

	public void setMessageTypeIdentifier(long messageTypeIdentifier) {
		this.messageTypeIdentifier = messageTypeIdentifier;
	}

	public String getFunctionCode() {
		return functionCode;
	}

	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}

	public String getTransactionCategory() {
		return transactionCategory;
	}

	public void setTransactionCategory(String transactionCategory) {
		this.transactionCategory = transactionCategory;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getCardSchemeCode() {
		return cardSchemeCode;
	}

	public void setCardSchemeCode(String cardSchemeCode) {
		this.cardSchemeCode = cardSchemeCode;
	}

	public long getIssuingBankId() {
		return issuingBankId;
	}

	public void setIssuingBankId(long issuingBankId) {
		this.issuingBankId = issuingBankId;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getAcquiringReferenceData() {
		return acquiringReferenceData;
	}

	public void setAcquiringReferenceData(String acquiringReferenceData) {
		this.acquiringReferenceData = acquiringReferenceData;
	}

	public Date getTransactionLocalDateAndTime() {
		return transactionLocalDateAndTime;
	}

	public void setTransactionLocalDateAndTime(Date transactionLocalDateAndTime) {
		this.transactionLocalDateAndTime = transactionLocalDateAndTime;
	}

	public String getTerminalCategory() {
		return terminalCategory;
	}

	public void setTerminalCategory(String terminalCategory) {
		this.terminalCategory = terminalCategory;
	}

	public boolean isRejectedFlag() {
		return rejectedFlag;
	}

	public void setRejectedFlag(boolean rejectedFlag) {
		this.rejectedFlag = rejectedFlag;
	}

	public boolean isReversalFlag() {
		return reversalFlag;
	}

	public void setReversalFlag(boolean reversalFlag) {
		this.reversalFlag = reversalFlag;
	}

	public Date getProcessingDate() {
		return processingDate;
	}

	public void setProcessingDate(Date processingDate) {
		this.processingDate = processingDate;
	}

	public Date getTransmissionDateAndTime() {
		return transmissionDateAndTime;
	}

	public void setTransmissionDateAndTime(Date transmissionDateAndTime) {
		this.transmissionDateAndTime = transmissionDateAndTime;
	}

	public boolean isReversedFlag() {
		return reversedFlag;
	}

	public void setReversedFlag(boolean reversedFlag) {
		this.reversedFlag = reversedFlag;
	}
	
	public void addUserAction(ExtUserAction action){
		
		if (this.userActions==null)
			this.userActions = new HashSet<ExtUserAction>();
		
		this.userActions.add(action);
	}

}
