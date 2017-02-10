package com.wanxg.ibo.itp.contract;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ExtTransaction {
	
	private Long id;
	private long messageTypeIdentifier;
	private String functionCode;
	private ExtTransactionType transactionType;
	private ExtTransactionStatus transactionStatus;
	private String cardSchemeCode;
	private long issuingBankId;
	private String cardType;
	private String brand;
	private String acquiringReferenceData;
	private Date transactionLocalDateAndTime;
	private ExtTerminalCategory terminalCategory;
	private boolean rejectedFlag;
	private boolean reversalFlag;
	private Date processingDate;
	private Date transmissionDateAndTime;
	private boolean reversedFlag;
	private Set<ExtUserAction> userActions;
	private String suspendDescription;
	private String acquiringBankCode;
	private ExtAmount transactionAmount;
	private ExtAmount reconciliationAmount;
	private Date exchangeRateDate;
	private long processorId;
	private ExtCard card;
	private String merchant;
	private String extractedStatus;
	private Date extractedTimestamp;
	private String creditDebitIndicator;
	private String panToken;
	
	

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

	public ExtTransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(ExtTransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public ExtTransactionStatus getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(ExtTransactionStatus transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public ExtTerminalCategory getTerminalCategory() {
		return terminalCategory;
	}

	public void setTerminalCategory(ExtTerminalCategory terminalCategory) {
		this.terminalCategory = terminalCategory;
	}

	public Set<ExtUserAction> getUserActions() {
		return userActions;
	}

	public void setUserActions(Set<ExtUserAction> userActions) {
		this.userActions = userActions;
	}

	public String getSuspendDescription() {
		return suspendDescription;
	}

	public void setSuspendDescription(String suspendDescription) {
		this.suspendDescription = suspendDescription;
	}

	public String getAcquiringBankCode() {
		return acquiringBankCode;
	}

	public void setAcquiringBankCode(String acquiringBankCode) {
		this.acquiringBankCode = acquiringBankCode;
	}

	public ExtAmount getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(ExtAmount transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public ExtAmount getReconciliationAmount() {
		return reconciliationAmount;
	}

	public void setReconciliationAmount(ExtAmount reconciliationAmount) {
		this.reconciliationAmount = reconciliationAmount;
	}

	public Date getExchangeRateDate() {
		return exchangeRateDate;
	}

	public void setExchangeRateDate(Date exchangeRateDate) {
		this.exchangeRateDate = exchangeRateDate;
	}

	public long getProcessorId() {
		return processorId;
	}

	public void setProcessorId(long processorId) {
		this.processorId = processorId;
	}

	public ExtCard getCard() {
		return card;
	}

	public void setCard(ExtCard card) {
		this.card = card;
	}

	public String getMerchant() {
		return merchant;
	}

	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}

	public String getExtractedStatus() {
		return extractedStatus;
	}

	public void setExtractedStatus(String extractedStatus) {
		this.extractedStatus = extractedStatus;
	}

	public Date getExtractedTimestamp() {
		return extractedTimestamp;
	}

	public void setExtractedTimestamp(Date extractedTimestamp) {
		this.extractedTimestamp = extractedTimestamp;
	}

	public String getCreditDebitIndicator() {
		return creditDebitIndicator;
	}

	public void setCreditDebitIndicator(String creditDebitIndicator) {
		this.creditDebitIndicator = creditDebitIndicator;
	}

	public String getPanToken() {
		return panToken;
	}

	public void setPanToken(String panToken) {
		this.panToken = panToken;
	}
	
	

}
