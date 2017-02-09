package com.wanxg.ibo.itp.transaction;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "ITP_CRD")
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "P_ITP_CRD")
	private Long id;
	
	
	@Column(name = "CRD_NUM")
	private Long cardNumber;
	
	@Column(name = "CRD_EXP")
	@Temporal(value = TemporalType.DATE)
	private Date expiryDate;
	
	@Column(name = "CRD_SEQ")
	private Integer sequenceNumber;
	
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
