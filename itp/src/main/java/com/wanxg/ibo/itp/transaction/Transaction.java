package com.wanxg.ibo.itp.transaction;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 */

@Entity
@Table(name = "ITP_TRN")
@DiscriminatorColumn(name = "DTYPE", length = 40)
@NamedQueries({
		@NamedQuery(name = "com.wanxg.ibo.itp.transaction.Transaction.findAll", query = "SELECT t FROM Transaction t"),
		@NamedQuery(name = "com.wanxg.ibo.itp.transaction.Transaction.findCount", query = "SELECT count(t) FROM Transaction t"),
		
		@NamedQuery(name = "com.wanxg.ibo.itp.transaction.Transaction.findByIdFull", query = "SELECT t FROM Transaction t WHERE t.id = :id"),
		@NamedQuery(name = "com.wanxg.ibo.itp.transaction.Transaction.findByTrnStatusIssuingBankId", query = "SELECT t FROM Transaction t WHERE t.transactionStatus=com.wanxg.ibo.itp.transaction.TransactionStatus.REPROCESS AND t.issuingBankId=:issuerId"),
		@NamedQuery(name = "com.wanxg.ibo.itp.transaction.Transaction.findTransactionFromPurgesetDtl", query = " SELECT t.id FROM Transaction t where t.id in(:objIdList)"),
		@NamedQuery(name = "com.wanxg.ibo.itp.transaction.Transaction.findInvalidTransactions", query = "SELECT t FROM Transaction t WHERE"
				+ "(t.issuingBankId= :issuerId)"
				+ "AND (t.transactionStatus= com.wanxg.ibo.itp.transaction.TransactionStatus.IN_ERROR or t.transactionStatus=com.wanxg.ibo.itp.transaction.TransactionStatus.CREATED)"
				+ "AND (t.processingDate < :transactionDate)"),
		@NamedQuery(name = "com.wanxg.ibo.itp.transaction.Transaction.findTransactionsForTxnIds", query = "SELECT t FROM Transaction t WHERE t.id IN(:idList)") })
public abstract class Transaction {
	/**
	 * 
	 * id: long
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "P_ITP_TRN")
	private Long id;

	/**
	 * 
	 * messageTypeIdentifier: long
	 */

	@Column(name = "MSG_TYP_ID")
	private long messageTypeIdentifier;

	/**
	 * 
	 * functionCode: long
	 */

	@Column(name = "FCT_CDE")
	private String functionCode;

	/**
	 * 
	 * transactionCategory: TransactionCategory
	 */
	@Enumerated(value = EnumType.STRING)
	@Column(name = "TRN_TYP", length = 25)
	private TransactionType transactionType;

	/**
	 * 
	 * transactionStatus: TransactionStatus
	 */
	@Enumerated(value = EnumType.STRING)
	@Column(name = "TRN_STA", length = 25)
	private TransactionStatus transactionStatus;

	/**
	 * 
	 * suspendDescription: String
	 */

	@Column(name = "SUS_DSC", length = 200)
	private String suspendDescription;

	/**
	 * 
	 * cardSchemeCode: String
	 */

	@Column(name = "CRT_SCM_CDE", length = 10)
	private String cardSchemeCode;

	/**
	 * 
	 * acquiringBankCode: String
	 */

	@Column(name = "ACQ_BNK_CDE")
	private String acquiringBankCode;

	/**
	 * 
	 * issuingBankId: long
	 */

	@Column(name = "ISS_BNK_ID")
	private long issuingBankId;

	// JIRA ITP-425 Replaced brandType to cardType and BRD_TYP to CRD_TYP
	/**
	 * cardType: String
	 */

	@Column(name = "CRD_TYP", length = 25)
	private String cardType;

	/**
	 * 
	 * brand: String
	 */

	@Column(name = "BRD", length = 25)
	private String brand;

	/**
	 * 
	 * acquiringReferenceData: String
	 */

	@Column(name = "ACQ_REF_DTA", length = 23)
	private String acquiringReferenceData;

	/**
	 * 
	 * transactionLocalDateAndTime: Date
	 */

	@Column(name = "TRN_LOC_DTE_AND_TIM")
	@Temporal(value = TemporalType.TIMESTAMP)
	private java.util.Date transactionLocalDateAndTime;

	/**
	 * 
	 * terminalCategory: TerminalCategory
	 */
	@Enumerated(value = EnumType.STRING)
	@Column(name = "TRM_CAT", length = 25)
	private TerminalCategory terminalCategory;

	
	@Embedded()
	@AttributeOverrides({
       @AttributeOverride(name="exponent",column=@Column(name="TRN_AMT_EXP")),
       @AttributeOverride(name="value",column=@Column(name="TRN_AMT_VAL")),
       @AttributeOverride(name="isoCode", column=@Column(name="TRN_AMT_ISO"))
    })
	private Amount transactionAmount;
	
	
	@Embedded()
	@AttributeOverrides({
      @AttributeOverride(name="exponent",column=@Column(name="REC_AMT_EXP")),
      @AttributeOverride(name="value",column=@Column(name="REC_AMT_VAL")),
      @AttributeOverride(name="isoCode", column=@Column(name="REC_AMT_ISO"))
   })
	private Amount reconciliationAmount;
	
	/**
	 * 
	 * exchangeRateDate: Date
	 */

	@Column(name = "XCH_RTE_DTE")
	@Temporal(value = TemporalType.TIMESTAMP)
	private java.util.Date exchangeRateDate;

	/**
	 * 
	 * rejectedFlag: boolean
	 */

	@Column(name = "RJT_FLG")
	private boolean rejectedFlag;

	/**
	 * 
	 * reversalFlag: boolean
	 */

	@Column(name = "REV_FLG")
	private boolean reversalFlag;

	/**
	 * Date and time when the transaction has been created within ITP. [ Source
	 * : WLP] [ Data Type : Date] processingDate: Date
	 */

	@Column(name = "PCG_DTE")
	@Temporal(value = TemporalType.DATE)
	private java.util.Date processingDate;

	/**
	 * Identifier of the genericIssuer defined as processor of the transaction.
	 * [ Source : WLP] [ Data Type : N11] processorId: long
	 */

	@Column(name = "PCR_ID")
	private long processorId;

	/**
	 * Contains the date and time the request or advice was submitted to the
	 * cardscheme. Transmission date and time is a key data element used to
	 * match a response to its request or advice. This field indicates when a
	 * transaction entered the network. The sender of a transaction enters a new
	 * date and time with each request. The receiving member saves the field and
	 * returns it in the response message. This field is used in every message
	 * generated by acquirers and issuers and is present in every message
	 * generated by the cardscheme. Correspond to the Visa Central Processing
	 * Date and to the Master Card Settlement Date [ Source : 8583 de7] [ Data
	 * Type : Timestamp] transmissionDateAndTime: Date
	 */

	@Column(name = "TRX_DTE_TIM")
	private java.util.Date transmissionDateAndTime;

	/**
	 * Relation hasForOriginal
	 */
	@ManyToOne

	@JoinColumn(name = "FK_REV_ORI_TRN_ID")
	private com.wanxg.ibo.itp.transaction.Transaction original = null;

	/**
	 * reversedFlag: boolean
	 */

	@Column(name = "REV")
	private boolean reversedFlag;

	/**
	 * The id of the card from CMS cardId: long
	 */
	@ManyToOne
	@JoinColumn(name = "FK_ITP_CRD")
	private Card card;

	/**
	 * Relation hasForOriginal
	 */

	@OneToMany(mappedBy = "original", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private java.util.Set<com.wanxg.ibo.itp.transaction.Transaction> reversals = new java.util.HashSet<com.wanxg.ibo.itp.transaction.Transaction>();

	/**
	 * brandId: long
	 */

	@Column(name = "MRC")
	private String merchant;

	/**
	 * extractedStatus: String
	 */

	@Column(name = "EXT_STA")
	private String extractedStatus;

	/**
	 * extractedTimestamp: date
	 */

	@Column(name = "EXT_DTE")
	private java.util.Date extractedTimestamp;
	/**
	 * creditDebitIndicator: String
	 */

	@Column(name = "CRD_DEB_IND")
	private String creditDebitIndicator;

	@Column(name = "PAN_TKN")
	private String panToken;

	@OneToMany(mappedBy = "transaction", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<com.wanxg.ibo.itp.transaction.UserAction> userActions = new HashSet<com.wanxg.ibo.itp.transaction.UserAction>();

	
	public String getPanToken() {
		return panToken;
	}

	public void setPanToken(String panToken) {
		this.panToken = panToken;
	}
	// IDM4Sempris end

	/**
	 * Return value of attribute id
	 * 
	 * @return <code>long</code> :
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Set value of attribute id
	 * 
	 * @param id
	 *            : the new value of id
	 */
	public void setId(final long id) {
		this.id = id;
	}

	/**
	 * Return value of attribute messageTypeIdentifier
	 * 
	 * @return <code>long</code> :
	 */
	public long getMessageTypeIdentifier() {
		return this.messageTypeIdentifier;
	}

	/**
	 * Set value of attribute messageTypeIdentifier
	 * 
	 * @param messageTypeIdentifier
	 *            : the new value of messageTypeIdentifier
	 */
	public void setMessageTypeIdentifier(final long messageTypeIdentifier) {
		this.messageTypeIdentifier = messageTypeIdentifier;
	}

	/**
	 * Return value of attribute functionCode
	 * 
	 * @return <code>long</code> :
	 */
	public String getFunctionCode() {
		return this.functionCode;
	}

	/**
	 * Set value of attribute functionCode
	 * 
	 * @param functionCode
	 *            : the new value of functionCode
	 */
	public void setFunctionCode(final String functionCode) {
		this.functionCode = functionCode;
	}

	/**
	 * Return value of attribute transactionCategory
	 * 
	 * @return <code>net.atos.wlp.tp.transaction.TransactionCategory</code> :
	 */
	public TransactionType getTransactionType() {
		return this.transactionType;
	}

	/**
	 * Return value of attribute transactionStatus
	 * 
	 * @return <code>net.atos.wlp.tp.transaction.TransactionStatus</code> :
	 */
	public TransactionStatus getTransactionStatus() {
		return this.transactionStatus;
	}

	/**
	 * Return value of attribute suspendDescription
	 * 
	 * @return <code>String</code> :
	 */
	public String getSuspendDescription() {
		return this.suspendDescription;
	}

	/**
	 * Set value of attribute suspendDescription
	 * 
	 * @param suspendDescription
	 *            : the new value of suspendDescription
	 */
	public void setSuspendDescription(final String suspendDescription) {
		this.suspendDescription = suspendDescription;
	}

	/**
	 * Return value of attribute cardSchemeCode
	 * 
	 * @return <code>String</code> :
	 */
	public String getCardSchemeCode() {
		return this.cardSchemeCode;
	}

	/**
	 * Set value of attribute cardSchemeCode
	 * 
	 * @param cardSchemeCode
	 *            : the new value of cardSchemeCode
	 */
	public void setCardSchemeCode(final String cardSchemeCode) {
		this.cardSchemeCode = cardSchemeCode;
	}

	/**
	 * Return value of attribute acquiringBankCode
	 * 
	 * @return <code>String</code> :
	 */
	public String getAcquiringBankCode() {
		return this.acquiringBankCode;
	}

	/**
	 * Set value of attribute acquiringBankCode
	 * 
	 * @param acquiringBankCode
	 *            : the new value of acquiringBankCode
	 */
	public void setAcquiringBankCode(final String acquiringBankCode) {
		this.acquiringBankCode = acquiringBankCode;
	}

	/**
	 * Return value of attribute issuingBankId
	 * 
	 * @return <code>long</code> :
	 */
	public long getIssuingBankId() {
		return this.issuingBankId;
	}

	/**
	 * Set value of attribute issuingBankId
	 * 
	 * @param issuingBankId
	 *            : the new value of issuingBankId
	 */
	public void setIssuingBankId(final long issuingBankId) {
		this.issuingBankId = issuingBankId;
	}

	/**
	 * Return value of attribute cardType
	 * 
	 * @return <code>String</code> :
	 */
	public String getCardType() {
		return this.cardType;
	}

	/**
	 * Set value of attribute cardType
	 * 
	 * @param cardType
	 *            : the new value of cardType
	 */
	public void setCardType(final String cardType) {
		this.cardType = cardType;
	}

	/**
	 * Return value of attribute brand
	 * 
	 * @return <code>String</code> :
	 */
	public String getBrand() {
		return this.brand;
	}

	/**
	 * Set value of attribute brand
	 * 
	 * @param brand
	 *            : the new value of brand
	 */
	public void setBrand(final String brand) {
		this.brand = brand;
	}

	/**
	 * Return value of attribute acquiringReferenceData
	 * 
	 * @return <code>String</code> :
	 */
	public String getAcquiringReferenceData() {
		return this.acquiringReferenceData;
	}

	/**
	 * Set value of attribute acquiringReferenceData
	 * 
	 * @param acquiringReferenceData
	 *            : the new value of acquiringReferenceData
	 */
	public void setAcquiringReferenceData(final String acquiringReferenceData) {
		this.acquiringReferenceData = acquiringReferenceData;
	}

	/**
	 * Return value of attribute transactionLocalDateAndTime
	 * 
	 * @return <code>java.util.Date</code> :
	 */
	public java.util.Date getTransactionLocalDateAndTime() {
		return this.transactionLocalDateAndTime;
	}

	/**
	 * Set value of attribute transactionLocalDateAndTime
	 * 
	 * @param transactionLocalDateAndTime
	 *            : the new value of transactionLocalDateAndTime
	 */
	public void setTransactionLocalDateAndTime(final java.util.Date transactionLocalDateAndTime) {
		this.transactionLocalDateAndTime = transactionLocalDateAndTime;
	}

	/**
	 * Return value of attribute terminalCategory
	 * 
	 * @return <code>net.atos.wlp.tp.transaction.TerminalCategory</code> :
	 */
	public TerminalCategory getTerminalCategory() {
		return this.terminalCategory;
	}
	
	public Amount getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Amount transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Amount getReconciliationAmount() {
		return reconciliationAmount;
	}

	public void setReconciliationAmount(Amount reconciliationAmount) {
		this.reconciliationAmount = reconciliationAmount;
	}

	/**
	 * Return value of attribute exchangeRateDate
	 * 
	 * @return <code>java.util.Date</code> :
	 */
	public java.util.Date getExchangeRateDate() {
		return this.exchangeRateDate;
	}

	/**
	 * Set value of attribute exchangeRateDate
	 * 
	 * @param exchangeRateDate
	 *            : the new value of exchangeRateDate
	 */
	public void setExchangeRateDate(final java.util.Date exchangeRateDate) {
		this.exchangeRateDate = exchangeRateDate;
	}

	/**
	 * Return value of attribute rejectedFlag
	 * 
	 * @return <code>boolean</code> :
	 */
	public boolean isRejectedFlag() {
		return this.rejectedFlag;
	}

	/**
	 * Set value of attribute rejectedFlag
	 * 
	 * @param rejectedFlag
	 *            : the new value of rejectedFlag
	 */
	public void setRejectedFlag(final boolean rejectedFlag) {
		this.rejectedFlag = rejectedFlag;
	}

	/**
	 * Return value of attribute reversalFlag
	 * 
	 * @return <code>boolean</code> :
	 */
	public boolean isReversalFlag() {
		return this.reversalFlag;
	}

	/**
	 * Set value of attribute reversalFlag
	 * 
	 * @param reversalFlag
	 *            : the new value of reversalFlag
	 */
	public void setReversalFlag(final boolean reversalFlag) {
		this.reversalFlag = reversalFlag;
	}

	/**
	 * 
	 * @return <code>boolean</code> :
	 */
	public boolean isRemoveable() {
		return true;
	}

	/**
	 * HashCode method for Transaction class
	 * 
	 * @return <code>int</code> :
	 */
	public int hashCode() {
		return (int) (this.id ^ (this.id >>> 32));
	}

	/**
	 * Equals method for Transaction class
	 * 
	 * @param obj
	 *            :
	 * 
	 * @return <code>boolean</code> :
	 */
	public boolean equals(final Object obj) {
		if ((obj == null) || (!(obj instanceof Transaction))) {
			return false;
		}

		final Transaction __obj = (Transaction) obj;

		return (this.id == __obj.id);
	}

	/**
	 * Set value of attribute processingDate
	 * 
	 * @param processingDate
	 *            : the new value of processingDate
	 */
	public void setProcessingDate(final java.util.Date processingDate) {
		this.processingDate = processingDate;
	}

	/**
	 * Return value of attribute processingDate
	 * 
	 * @return <code>java.util.Date</code> :
	 */
	public java.util.Date getProcessingDate() {
		return this.processingDate;
	}

	/**
	 * Set value of attribute processorId
	 * 
	 * @param processorId
	 *            : the new value of processorId
	 */
	public void setProcessorId(final long processorId) {
		this.processorId = processorId;
	}

	/**
	 * Return value of attribute processorId
	 * 
	 * @return <code>long</code> :
	 */
	public long getProcessorId() {
		return this.processorId;
	}

	/**
	 * Set value of attribute terminalCategory
	 * 
	 * @param terminalCategory
	 *            : the new value of terminalCategory
	 */
	public void setTerminalCategory(final TerminalCategory terminalCategory) {
		this.terminalCategory = terminalCategory;
	}

	/**
	 * Set value of attribute transmissionDateAndTime
	 * 
	 * @param transmissionDateAndTime
	 *            : the new value of transmissionDateAndTime
	 */
	public void setTransmissionDateAndTime(final java.util.Date transmissionDateAndTime) {
		this.transmissionDateAndTime = transmissionDateAndTime;
	}

	/**
	 * Return value of attribute transmissionDateAndTime
	 * 
	 * @return <code>java.util.Date</code> :
	 */
	public java.util.Date getTransmissionDateAndTime() {
		return this.transmissionDateAndTime;
	}

	/**
	 * Set value of attribute transactionStatus
	 * 
	 * @param transactionStatus
	 *            : the new value of transactionStatus
	 */
	public void setTransactionStatus(final TransactionStatus transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	/**
	 * Set value of attribute transactionCategory
	 * 
	 * @param transactionCategory
	 *            : the new value of transactionCategory
	 */
	public void setTransactionType(final TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	/**
	 * Return the enum value of the class type, e.g. FIRST_PRESENTMENT,
	 * SECOND_PRESENTMENT
	 */
	public abstract String getClassType();

	/**
	 * Relation hasForOriginal Set value of attribute original
	 * 
	 * @param original
	 *            : the new value of original
	 */
	public void setOriginal(final com.wanxg.ibo.itp.transaction.Transaction original) {
		this.original = original;
	}

	/**
	 * Relation hasForOriginal Return value of attribute original
	 * 
	 * @return <code>Transaction</code> :
	 */
	public com.wanxg.ibo.itp.transaction.Transaction getOriginal() {
		return this.original;
	}

	/**
	 * Set value of attribute reversedFlag
	 * 
	 * @param reversedFlag
	 *            : the new value of reversedFlag
	 */
	public void setReversedFlag(final boolean reversedFlag) {
		this.reversedFlag = reversedFlag;
	}

	/**
	 * Return value of attribute reversedFlag
	 * 
	 * @return <code>boolean</code> :
	 */
	public boolean isReversedFlag() {
		return this.reversedFlag;
	}

	/**
	 * Set value of attribute cardId
	 * 
	 * @param cardId
	 *            : the new value of cardId
	 */
	public void setCard(final Card card) {
		this.card = card;
	}

	/**
	 * Return value of attribute cardId
	 * 
	 * @return <code>long</code> :
	 */
	public Card getCard() {
		return this.card;
	}

	/**
	 * Remove method for hasForOriginal association
	 * 
	 * @param reversal
	 *            :
	 * @return <code>com.wanxg.ibo.itp.transaction.Transaction</code> :
	 */
	public com.wanxg.ibo.itp.transaction.Transaction removeReversal(
			final com.wanxg.ibo.itp.transaction.Transaction reversal) {
		reversal.setOriginal(null);
		reversals.remove(reversal);
		return this;
	}

	/**
	 * Get method concerning hasForOriginal association
	 * 
	 * @return <code>java.util.Set<com.wanxg.ibo.itp.transaction.Transaction></code>
	 *         :
	 */
	public java.util.Set<com.wanxg.ibo.itp.transaction.Transaction> getReversals() {
		return java.util.Collections.unmodifiableSet(reversals);
	}

	/**
	 * Add method concerning hasForOriginal association
	 * 
	 * @param reversal
	 *            :
	 * @return <code>Transaction</code> :
	 */
	public Transaction addReversal(final com.wanxg.ibo.itp.transaction.Transaction reversal) {
		this.reversals.add(reversal);
		reversal.setOriginal(this);
		return this;
	}

	/**
	 * Add collection method concerning hasForOriginal association
	 * 
	 * @param reversals
	 *            :
	 * @return <code>Transaction</code> :
	 */
	public Transaction addReversals(final java.util.Set<com.wanxg.ibo.itp.transaction.Transaction> reversals) {
		for (final com.wanxg.ibo.itp.transaction.Transaction reversal : reversals) {
			reversal.setOriginal(this);
		}
		return this;
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

	public java.util.Date getExtractedTimestamp() {
		return extractedTimestamp;
	}

	public void setExtractedTimestamp(java.util.Date extractedTimestamp) {
		this.extractedTimestamp = extractedTimestamp;
	}

	
	/**
	 * Remove method for userActionTransaction association
	 * 
	 * @param userActions
	 *            (<code>UserAction</code>) :
	 * @return <code>Transaction</code> :
	 * @generated XA
	 */
	@Generated(value = "XA", comments = "-613506721,ASSO-REMOVEALL-_BPFlsUjREeKPjM_s320q2A")
	public Transaction removeUserActions(final Set<UserAction> userActions) {
		for (UserAction _userAction : userActions) {
			if (this.equals(_userAction.getTransaction())) {
				_userAction.setTransaction(null);
			}
		}
		this.userActions.removeAll(userActions);
		return this;
	}

	/**
	 * Remove method for userActionTransaction association
	 * 
	 * @param userAction
	 *            (<code>UserAction</code>) :
	 * @return <code>Transaction</code> :
	 * @generated XA
	 */
	public Transaction removeUserAction(final UserAction userAction) {
		userAction.setTransaction(null);
		this.userActions.remove(userAction);
		return this;
	}

	/**
	 * Add collection method concerning userActionTransaction association(Owner
	 * side for this association)
	 * 
	 * @param userActions
	 *            (<code>UserAction</code>) :
	 * @return <code>Transaction</code> :
	 * @generated XA
	 */
	public Transaction addUserActions(final Set<UserAction> userActions) {
		this.userActions.addAll(userActions);
		for (UserAction _userAction : userActions) {
			_userAction.setTransaction(this);
		}
		return this;
	}

	/**
	 * Add method concerning userActionTransaction association
	 * 
	 * @param userAction
	 *            (<code>UserAction</code>) :
	 * @return <code>Transaction</code> :
	 * @generated XA
	 */
	public Transaction addUserAction(final UserAction userAction) {
		this.userActions.add(userAction);
		userAction.setTransaction(this);
		return this;
	}

	/**
	 * Set method concerning userActionTransaction association
	 * 
	 * @param userActions
	 *            (<code>UserAction</code>) :
	 * @generated XA
	 */
	public void setUserActions(final Set<UserAction> userActions) {
		this.userActions = userActions;
		for (UserAction _userAction : userActions) {
			_userAction.setTransaction(this);
		}
	}

	/**
	 * Get method concerning userActionTransaction association
	 * 
	 * @return <code>UserAction</code> :
	 * @generated XA
	 */
	public Set<UserAction> getUserActions() {
		return java.util.Collections.unmodifiableSet(userActions);
	}

	/**
	 * Set value of attribute creditDebitIndicator
	 * 
	 * @param creditDebitIndicator
	 *            : the new value of creditDebitIndicator
	 */
	public void setCreditDebitIndicator(String creditDebitIndicator) {
		this.creditDebitIndicator = creditDebitIndicator;
	}

	/**
	 * Return value of attribute creditDebitIndicator
	 * 
	 * @return <code>String</code> :
	 */
	public String getCreditDebitIndicator() {
		return this.creditDebitIndicator;
	}

	/**
	 * Return the First original transaction with is not a reversal
	 */
	public Transaction getOriginalNotReversal() {

		if (reversalFlag == false && original == null) {
			return this;
		}

		if (original != null) {
			return original.getOriginalNotReversal();
		}

		return null;
	}
}
