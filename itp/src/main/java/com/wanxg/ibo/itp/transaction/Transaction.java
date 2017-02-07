package com.wanxg.ibo.itp.transaction;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
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
		@NamedQuery(name = "com.wanxg.ibo.itp.transaction.Transaction.findByTrnStatusIssuingBankId", query = "SELECT t FROM Transaction t WHERE t.transactionStatus='REPROCESS' AND t.issuingBankId=:issuerId"),
		@NamedQuery(name = "com.wanxg.ibo.itp.transaction.Transaction.findTransactionFromPurgesetDtl", query = " SELECT t.id FROM Transaction t where t.id in(:objIdList)"),
		@NamedQuery(name = "com.wanxg.ibo.itp.transaction.Transaction.findInvalidTransactions", query = "SELECT t FROM Transaction t WHERE"
				+ "(t.issuingBankId= :issuerId)"
				+ "AND (t.transactionStatus='CREATED' or t.transactionStatus='DELETED')"
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
	@Generated(value = "XA", comments = "-1497012567")
	@Column(name = "TRN_CAT", length = 25)
	private String transactionCategory;

	/**
	 * 
	 * transactionStatus: TransactionStatus
	 */
	@Generated(value = "XA", comments = "-1497012567")
	@Column(name = "TRN_STA", length = 25)
	private String transactionStatus;

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

	@Column(name = "CRT_SCHM_CDE", length = 10)
	private String cardSchemeCode;

	/**
	 * 
	 * acquiringBankCode: String
	 */

	@Column(name = "ACQG_BNK_CDE")
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

	@Column(name = "ACQG_REF_DTA", length = 23)
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
	@Generated(value = "XA", comments = "-239927816")
	@Column(name = "TRM_CAT", length = 25)
	private String terminalCategory;

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

	@Column(name = "REVERSED")
	private boolean reversedFlag;

	/**
	 * The id of the card from CMS cardId: long
	 */

	@Column(name = "CRD_ID")
	private String cardId;

	/**
	 * Relation hasForOriginal
	 */

	@OneToMany(mappedBy = "original", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private java.util.Set<com.wanxg.ibo.itp.transaction.Transaction> reversals = new java.util.HashSet<com.wanxg.ibo.itp.transaction.Transaction>();

	/**
	 * brandId: long
	 */

	@Column(name = "BRD_ID")
	private long brandId;

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

	@Column(name = "CREDIT_DEBIT_INDI")
	private String creditDebitIndicator;

	@Column(name = "PAN_TKN")
	private String panToken;

	@Generated(value = "XA", comments = "0,_BPFlsUjREeKPjM_s320q2A")
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
	@Generated(value = "XA", comments = "-342555432")
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
	@Generated(value = "XA", comments = "-1087925033")
	public void setMessageTypeIdentifier(final long messageTypeIdentifier) {
		this.messageTypeIdentifier = messageTypeIdentifier;
	}

	/**
	 * Return value of attribute functionCode
	 * 
	 * @return <code>long</code> :
	 */
	@Generated(value = "XA", comments = "1194106136")
	public String getFunctionCode() {
		return this.functionCode;
	}

	/**
	 * Set value of attribute functionCode
	 * 
	 * @param functionCode
	 *            : the new value of functionCode
	 */
	@Generated(value = "XA", comments = "-1238798576")
	public void setFunctionCode(final String functionCode) {
		this.functionCode = functionCode;
	}

	/**
	 * Return value of attribute transactionCategory
	 * 
	 * @return <code>net.atos.wlp.tp.transaction.TransactionCategory</code> :
	 */
	@Generated(value = "XA", comments = "697404822")
	public String getTransactionCategory() {
		return this.transactionCategory;
	}

	/**
	 * Return value of attribute transactionStatus
	 * 
	 * @return <code>net.atos.wlp.tp.transaction.TransactionStatus</code> :
	 */
	@Generated(value = "XA", comments = "1187781822")
	public String getTransactionStatus() {
		return this.transactionStatus;
	}

	/**
	 * Return value of attribute suspendDescription
	 * 
	 * @return <code>String</code> :
	 */
	@Generated(value = "XA", comments = "712320184")
	public String getSuspendDescription() {
		return this.suspendDescription;
	}

	/**
	 * Set value of attribute suspendDescription
	 * 
	 * @param suspendDescription
	 *            : the new value of suspendDescription
	 */
	@Generated(value = "XA", comments = "966063755")
	public void setSuspendDescription(final String suspendDescription) {
		this.suspendDescription = suspendDescription;
	}

	/**
	 * Return value of attribute cardSchemeCode
	 * 
	 * @return <code>String</code> :
	 */
	@Generated(value = "XA", comments = "-239927816")
	public String getCardSchemeCode() {
		return this.cardSchemeCode;
	}

	/**
	 * Set value of attribute cardSchemeCode
	 * 
	 * @param cardSchemeCode
	 *            : the new value of cardSchemeCode
	 */
	@Generated(value = "XA", comments = "827701069")
	public void setCardSchemeCode(final String cardSchemeCode) {
		this.cardSchemeCode = cardSchemeCode;
	}

	/**
	 * Return value of attribute acquiringBankCode
	 * 
	 * @return <code>String</code> :
	 */
	@Generated(value = "XA", comments = "386243542")
	public String getAcquiringBankCode() {
		return this.acquiringBankCode;
	}

	/**
	 * Set value of attribute acquiringBankCode
	 * 
	 * @param acquiringBankCode
	 *            : the new value of acquiringBankCode
	 */
	@Generated(value = "XA", comments = "-185239")
	public void setAcquiringBankCode(final String acquiringBankCode) {
		this.acquiringBankCode = acquiringBankCode;
	}

	/**
	 * Return value of attribute issuingBankId
	 * 
	 * @return <code>long</code> :
	 */
	@Generated(value = "XA", comments = "-1344376968")
	public long getIssuingBankId() {
		return this.issuingBankId;
	}

	/**
	 * Set value of attribute issuingBankId
	 * 
	 * @param issuingBankId
	 *            : the new value of issuingBankId
	 */
	@Generated(value = "XA", comments = "1624221786")
	public void setIssuingBankId(final long issuingBankId) {
		this.issuingBankId = issuingBankId;
	}

	/**
	 * Return value of attribute cardType
	 * 
	 * @return <code>String</code> :
	 */
	// JIRA ITP-425 Replaced getBrandType to getCardType
	@Generated(value = "XA", comments = "-1085675168")
	public String getCardType() {
		return this.cardType;
	}

	/**
	 * Set value of attribute cardType
	 * 
	 * @param cardType
	 *            : the new value of cardType
	 */
	// JIRA ITP-425 Replaced setBrandType to setCardType
	@Generated(value = "XA", comments = "378788558")
	public void setCardType(final String cardType) {
		this.cardType = cardType;
	}

	/**
	 * Return value of attribute brand
	 * 
	 * @return <code>String</code> :
	 */
	@Generated(value = "XA", comments = "503697452")
	public String getBrand() {
		return this.brand;
	}

	/**
	 * Set value of attribute brand
	 * 
	 * @param brand
	 *            : the new value of brand
	 */
	@Generated(value = "XA", comments = "-1957576588")
	public void setBrand(final String brand) {
		this.brand = brand;
	}

	/**
	 * Return value of attribute acquiringReferenceData
	 * 
	 * @return <code>String</code> :
	 */
	@Generated(value = "XA", comments = "-702875400")
	public String getAcquiringReferenceData() {
		return this.acquiringReferenceData;
	}

	/**
	 * Set value of attribute acquiringReferenceData
	 * 
	 * @param acquiringReferenceData
	 *            : the new value of acquiringReferenceData
	 */
	@Generated(value = "XA", comments = "-398470099")
	public void setAcquiringReferenceData(final String acquiringReferenceData) {
		this.acquiringReferenceData = acquiringReferenceData;
	}

	/**
	 * Return value of attribute transactionLocalDateAndTime
	 * 
	 * @return <code>java.util.Date</code> :
	 */
	@Generated(value = "XA", comments = "-2010422608")
	public java.util.Date getTransactionLocalDateAndTime() {
		return this.transactionLocalDateAndTime;
	}

	/**
	 * Set value of attribute transactionLocalDateAndTime
	 * 
	 * @param transactionLocalDateAndTime
	 *            : the new value of transactionLocalDateAndTime
	 */
	@Generated(value = "XA", comments = "-1970239114")
	public void setTransactionLocalDateAndTime(final java.util.Date transactionLocalDateAndTime) {
		this.transactionLocalDateAndTime = transactionLocalDateAndTime;
	}

	/**
	 * Return value of attribute terminalCategory
	 * 
	 * @return <code>net.atos.wlp.tp.transaction.TerminalCategory</code> :
	 */
	@Generated(value = "XA", comments = "1679229624")
	public String getTerminalCategory() {
		return this.terminalCategory;
	}

	/**
	 * Return value of attribute exchangeRateDate
	 * 
	 * @return <code>java.util.Date</code> :
	 */
	@Generated(value = "XA", comments = "-2109707368")
	public java.util.Date getExchangeRateDate() {
		return this.exchangeRateDate;
	}

	/**
	 * Set value of attribute exchangeRateDate
	 * 
	 * @param exchangeRateDate
	 *            : the new value of exchangeRateDate
	 */
	@Generated(value = "XA", comments = "-176562276")
	public void setExchangeRateDate(final java.util.Date exchangeRateDate) {
		this.exchangeRateDate = exchangeRateDate;
	}

	/**
	 * Return value of attribute rejectedFlag
	 * 
	 * @return <code>boolean</code> :
	 */
	@Generated(value = "XA", comments = "689967416")
	public boolean isRejectedFlag() {
		return this.rejectedFlag;
	}

	/**
	 * Set value of attribute rejectedFlag
	 * 
	 * @param rejectedFlag
	 *            : the new value of rejectedFlag
	 */
	@Generated(value = "XA", comments = "574849973")
	public void setRejectedFlag(final boolean rejectedFlag) {
		this.rejectedFlag = rejectedFlag;
	}

	/**
	 * Return value of attribute reversalFlag
	 * 
	 * @return <code>boolean</code> :
	 */
	@Generated(value = "XA", comments = "-317824200")
	public boolean isReversalFlag() {
		return this.reversalFlag;
	}

	/**
	 * Set value of attribute reversalFlag
	 * 
	 * @param reversalFlag
	 *            : the new value of reversalFlag
	 */
	@Generated(value = "XA", comments = "1747626117")
	public void setReversalFlag(final boolean reversalFlag) {
		this.reversalFlag = reversalFlag;
	}

	/**
	 * 
	 * @return <code>boolean</code> :
	 */
	@Generated(value = "XA", comments = "-1180645621")
	public boolean isRemoveable() {
		return true;
	}

	/**
	 * HashCode method for Transaction class
	 * 
	 * @return <code>int</code> :
	 */
	@Generated(value = "XA", comments = "-153113124")
	@Override
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
	@Generated(value = "XA", comments = "-1788158989")
	@Override
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
	@Generated(value = "XA", comments = "-1227083572")
	public void setProcessingDate(final java.util.Date processingDate) {
		this.processingDate = processingDate;
	}

	/**
	 * Return value of attribute processingDate
	 * 
	 * @return <code>java.util.Date</code> :
	 */
	@Generated(value = "XA", comments = "1311698968")
	public java.util.Date getProcessingDate() {
		return this.processingDate;
	}

	/**
	 * Set value of attribute processorId
	 * 
	 * @param processorId
	 *            : the new value of processorId
	 */
	@Generated(value = "XA", comments = "1984510586")
	public void setProcessorId(final long processorId) {
		this.processorId = processorId;
	}

	/**
	 * Return value of attribute processorId
	 * 
	 * @return <code>long</code> :
	 */
	@Generated(value = "XA", comments = "1693675192")
	public long getProcessorId() {
		return this.processorId;
	}

	/**
	 * Set value of attribute terminalCategory
	 * 
	 * @param terminalCategory
	 *            : the new value of terminalCategory
	 */
	@Generated(value = "XA", comments = "1170668229")
	public void setTerminalCategory(final String terminalCategory) {
		this.terminalCategory = terminalCategory;
	}

	/**
	 * Set value of attribute transmissionDateAndTime
	 * 
	 * @param transmissionDateAndTime
	 *            : the new value of transmissionDateAndTime
	 */
	@Generated(value = "XA", comments = "-1544910241")
	public void setTransmissionDateAndTime(final java.util.Date transmissionDateAndTime) {
		this.transmissionDateAndTime = transmissionDateAndTime;
	}

	/**
	 * Return value of attribute transmissionDateAndTime
	 * 
	 * @return <code>java.util.Date</code> :
	 */
	@Generated(value = "XA", comments = "453705090")
	public java.util.Date getTransmissionDateAndTime() {
		return this.transmissionDateAndTime;
	}

	/**
	 * Set value of attribute transactionStatus
	 * 
	 * @param transactionStatus
	 *            : the new value of transactionStatus
	 */
	@Generated(value = "XA", comments = "794892125")
	public void setTransactionStatus(final String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	/**
	 * Set value of attribute transactionCategory
	 * 
	 * @param transactionCategory
	 *            : the new value of transactionCategory
	 */
	@Generated(value = "XA", comments = "-1497012567")
	public void setTransactionCategory(final String transactionCategory) {
		this.transactionCategory = transactionCategory;
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
	@Generated(value = "XA", comments = "-606267268")
	public void setOriginal(final com.wanxg.ibo.itp.transaction.Transaction original) {
		this.original = original;
	}

	/**
	 * Relation hasForOriginal Return value of attribute original
	 * 
	 * @return <code>Transaction</code> :
	 */
	@Generated(value = "XA", comments = "1443156376")
	public com.wanxg.ibo.itp.transaction.Transaction getOriginal() {
		return this.original;
	}

	/**
	 * Set value of attribute reversedFlag
	 * 
	 * @param reversedFlag
	 *            : the new value of reversedFlag
	 */
	@Generated(value = "XA", comments = "-1758661383")
	public void setReversedFlag(final boolean reversedFlag) {
		this.reversedFlag = reversedFlag;
	}

	/**
	 * Return value of attribute reversedFlag
	 * 
	 * @return <code>boolean</code> :
	 */
	@Generated(value = "XA", comments = "279527352")
	public boolean isReversedFlag() {
		return this.reversedFlag;
	}

	/**
	 * Set value of attribute cardId
	 * 
	 * @param cardId
	 *            : the new value of cardId
	 */
	@Generated(value = "XA", comments = "-1545758282")
	public void setCardId(final String cardId) {
		this.cardId = cardId;
	}

	/**
	 * Return value of attribute cardId
	 * 
	 * @return <code>long</code> :
	 */
	@Generated(value = "XA", comments = "433499864")
	public String getCardId() {
		return this.cardId;
	}

	/**
	 * Remove method for hasForOriginal association
	 * 
	 * @param reversal
	 *            :
	 * @return <code>com.wanxg.ibo.itp.transaction.Transaction</code> :
	 */
	@Generated(value = "XA", comments = "-1861713616")
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
	@Generated(value = "XA", comments = "-607454499")
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
	@Generated(value = "XA", comments = "1599552460")
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
	@Generated(value = "XA", comments = "429507027")
	public Transaction addReversals(final java.util.Set<com.wanxg.ibo.itp.transaction.Transaction> reversals) {
		for (final com.wanxg.ibo.itp.transaction.Transaction reversal : reversals) {
			reversal.setOriginal(this);
		}
		return this;
	}

	/**
	 * Set value of attribute brandId
	 * 
	 * @param brandId
	 *            : the new value of brandId
	 */
	@Generated(value = "XA", comments = "446537263")
	public void setBrandId(final long brandId) {
		this.brandId = brandId;
	}

	/**
	 * Return value of attribute brandId
	 * 
	 * @return <code>long</code> :
	 */
	@Generated(value = "XA", comments = "-2062854366")
	public long getBrandId() {
		return this.brandId;
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
	@Generated(value = "XA", comments = "11631246,ASSO-REMOVE-_BPFlsUjREeKPjM_s320q2A")
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
	@Generated(value = "XA", comments = "-2125083954,ASSO-ADDALL-_BPFlsUjREeKPjM_s320q2A")
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
	@Generated(value = "XA", comments = "741250018,ASSO-ADD-_BPFlsUjREeKPjM_s320q2A")
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
	@Generated(value = "XA", comments = "-810862619,ASSO-SET-_BPFlsUjREeKPjM_s320q2A")
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
	@Generated(value = "XA", comments = "1638131184,ASSO-GET-_BPFlsUjREeKPjM_s320q2A")
	public Set<UserAction> getUserActions() {
		return java.util.Collections.unmodifiableSet(userActions);
	}

	/**
	 * Set value of attribute creditDebitIndicator
	 * 
	 * @param creditDebitIndicator
	 *            : the new value of creditDebitIndicator
	 */
	@Generated(value = "XA", comments = "-648287600")
	public void setCreditDebitIndicator(String creditDebitIndicator) {
		this.creditDebitIndicator = creditDebitIndicator;
	}

	/**
	 * Return value of attribute creditDebitIndicator
	 * 
	 * @return <code>String</code> :
	 */
	@Generated(value = "XA", comments = "-420241768")
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
