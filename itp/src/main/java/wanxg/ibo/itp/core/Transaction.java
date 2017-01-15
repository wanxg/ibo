package wanxg.ibo.itp.core;

import java.util.Date;

import wanxg.ibo.itp.contract.Card;

public class Transaction {

	private Long id;
	
	private Date localDateAndTime;
	
	private Double transactionAmount;
	
	private String currency;
	
	private String merchant;
	
	private String transactionType;
	
	private String cardScheme;
	
	private String issuerBank;
	
	private Card card;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getLocalDateAndTime() {
		return localDateAndTime;
	}

	public void setLocalDateAndTime(Date localDateAndTime) {
		this.localDateAndTime = localDateAndTime;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getMerchant() {
		return merchant;
	}

	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getCardScheme() {
		return cardScheme;
	}

	public void setCardScheme(String cardScheme) {
		this.cardScheme = cardScheme;
	}

	public String getIssuerBank() {
		return issuerBank;
	}

	public void setIssuerBank(String issuerBank) {
		this.issuerBank = issuerBank;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
}
