package com.wanxg.ibo.itp.contract;

import java.util.Date;

public class ExtCard {
	
	private Long cardNumber;
	private Date expiryDate;
	private Integer sequenceNumber;
	
	public ExtCard(Long cardNumber, Date expiryDate, Integer sequenceNumber){
		
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.sequenceNumber = sequenceNumber;
		
	}
	
	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Integer getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(Integer sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

}
