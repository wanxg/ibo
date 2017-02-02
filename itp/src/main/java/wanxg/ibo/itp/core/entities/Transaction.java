package wanxg.ibo.itp.core.entities;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ITP_TRN")
public class Transaction {

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LOC_DAT_TIM")
	private Date localDateAndTime;
	
	@Column(name="TRN_AMT")
	private Double transactionAmount;
	
	@Column(name="CUR")
	private String currency;
	
	@Column(name="MER")
	private String merchant;
	
	@Column(name="TRN_TYP")
	private String transactionType;
	
	@Column(name="CRD_SCM")
	private String cardScheme;
	
	@Column(name="ISS_BNK")
	private String issuerBank;
	
	@Transient
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
