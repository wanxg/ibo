package com.wanxg.ibo.idm.disputecycle;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;
import javax.persistence.Version;

/**
 *
 **/
@Entity
@Table(name = "IDM_DIS_FOLD")
@NamedQueries({
	
	/*
		@NamedQuery(name = "com.wanxg.ibo.idm.disputecycle.DisputeFolder.findDisputeFolderByLifeCycleId", query = "SELECT d FROM DisputeFolder d WHERE d.transactionLifeCycleId=:transactionLifeCycleId"),

		@NamedQuery(name = "com.wanxg.ibo.idm.disputecycle.DisputeFolder.findDisputeFolderByTransactionId", query = "SELECT d FROM DisputeFolder d WHERE d.id=:id"),
		@NamedQuery(name = "com.wanxg.ibo.idm.disputecycle.DisputeFolder.findDisputeFoldersByIdFull", query = "SELECT d FROM DisputeFolder d WHERE d.id=:id"),

		@NamedQuery(name = "com.wanxg.ibo.idm.disputecycle.DisputeFolder.count", query = "SELECT count(DISTINCT df) FROM DisputeFolder df WHERE (df.disputed = true)"),

		@NamedQuery(name = "com.wanxg.ibo.idm.disputecycle.DisputeFolder.findAllDisputeFoldersForStatusOpen", query = "SELECT d FROM DisputeFolder d WHERE (d.status = 'ACTIVE')"),

	*/
})

public class DisputeFolder {
	/**
	 *
	 * id: long
	 **/

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "P_IDM_DIS_FOLD")
	private long id;

	/**
	 *
	 * name: String
	 **/

	@Column(name = "NAM")
	private String name;

	/**
	 * Code of the Dispute Folder version: long
	 **/

	@Version
	@Column(name = "VER", nullable = false)
	private long version;

	/**
	 * Mandatory
	 * 
	 * Id that is maintained throughout the life cycle of transaction from
	 * Authorization, presentments, chargebacks, reversals etc.
	 * 
	 * This value is populated in each of the concrete message objects being
	 * sent to and received from ITP transactionLifeCycleId: String
	 **/

	@Column(name = "TRA_LIF_CYC_ID")
	private long transactionLifeCycleId;

	/**
	 * externalDisputeReason: String
	 */
	@Column(name = "EXT_DIS_RSN")
	private String externalDisputeReason;

	/**
	 * Relation issuerGroup
	 */

	@Column(name = "GNIC_ISS_ID")
	private long genericIssuerId;

	/**
	 *
	 * cardSchemeId: long
	 **/

	@Column(name = "CRD_SCHM_COD")
	private String cardSchemeCode;

	@Column(name = "DIS_RSN")
	@Enumerated(value = EnumType.STRING)
	private DisputeReason disputeReason;

	@Column(name = "LAST_CHANGE")
	private java.util.Date lastChange = null;

	@Column(name = "EXT")
	private boolean extract;

	@Column(name = "FRAUD")
	private boolean fraud;

	@Column(name = "DISPUTED")
	private boolean disputed;

	@Column(name = "EXT_REF")
	private String externalReference;

	// JIRA IDM-214,WLP-668
	/**
	 * DE 95 - Card Issuer Reference Data. The issuer provides DE 95 (Card
	 * Issuer Reference Data) when processing retrieval or chargeback messages.
	 * The acquirer is required to include the same data in a subsequent
	 * fulfillment of the retrieval request.
	 */
	@Column(name = "ISS_REF_DATA")
	private Long issuerReferenceData;

	/**
	 * createDate: Date
	 */
	@Column(name = "CREATN_DTE")
	private java.util.Date createDate;

	/**
	 * issuerName: String
	 */
	@Generated("XA")
	@Transient
	private String issuerName;

	/**
	 * unreconciledRep: boolean
	 */

	/**
	 * externalDisputeReason: String
	 */
	@Column(name = "EXT_FRD_RSN")
	private String externalFraudReason;

	/**
	 * disputeFolderClosingDate: Date
	 */
	@Column(name = "DIS_CLS_DTE")
	private java.util.Date disputeFolderClosingDate;

	// Change for WLPIBOREF-1071 start
	/**
	 *
	 * userName: String
	 **/

	@Column(name = "USR_NAM")
	private String userName;

	/**
	 *
	 * transactionIdentifier: long
	 **/
	@Column(name = "TRA_IND")
	private long transactionIdentifier;

	/**
	 *
	 * authorizationCharacteristicIndicator: String
	 **/
	@Column(name = "AUTH_CHAR_IND")
	private String authorizationCharacteristicIndicator;
	// Change for WLPIBOREF-1071 end

	// JIRA WLPIBOREF-1327 - START
	@Generated("XA")
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "exponent", column = @Column(name = "ISS_ACC_BAL_EXP")),
			@AttributeOverride(name = "value", column = @Column(name = "ISS_ACC_BAL_VAL")),
			@AttributeOverride(name = "isoCode", column = @Column(name = "ISS_ACC_BAL_ISO_COD")) })
	private Amount issuerAccountingBalance;
	// JIRA WLPIBOREF-1327 - END

	/**
	 * @return the externalFraudReason
	 */
	public String getExternalFraudReason() {
		return externalFraudReason;
	}

	/**
	 * @param externalFraudReason
	 *            the externalFraudReason to set
	 */
	public void setExternalFraudReason(String externalFraudReason) {
		this.externalFraudReason = externalFraudReason;
	}

	/**
	 * Return value of attribute id
	 *
	 * @return <code>long</code> :
	 **/

	public long getId() {
		return this.id;
	}

	/**
	 * Set value of attribute id
	 *
	 * @param id
	 *            : the new value of id
	 **/

	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Return value of attribute name
	 *
	 * @return <code>String</code> :
	 **/

	public String getName() {
		return this.name;
	}

	/**
	 * Set value of attribute name
	 *
	 * @param name
	 *            : the new value of name
	 **/
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Return value of attribute externalDisputeReason
	 *
	 * @return <code>String</code> :
	 **/
	public String getExternalDisputeReason() {
		return this.externalDisputeReason;
	}

	/**
	 * Set value of attribute externalDisputeReason
	 *
	 * @param externalDisputeReason
	 *            : the new value of externalDisputeReason
	 **/
	public void setExternalDisputeReason(String externalDisputeReason) {
		this.externalDisputeReason = externalDisputeReason;
	}

	/**
	 * Return value of attribute transactionLifeCycleId
	 *
	 * @return <code>String</code> :
	 **/
	public long getTransactionLifeCycleId() {
		return this.transactionLifeCycleId;
	}

	/**
	 * Set value of attribute transactionLifeCycleId
	 *
	 * @param transactionLifeCycleId
	 *            : the new value of transactionLifeCycleId
	 **/
	public void setTransactionLifeCycleId(long transactionLifeCycleId) {
		this.transactionLifeCycleId = transactionLifeCycleId;
	}

	public String getCardSchemeCode() {
		return cardSchemeCode;
	}

	public void setCardSchemeCode(String cardSchemeCode) {
		this.cardSchemeCode = cardSchemeCode;
	}

	public DisputeReason getDisputeReason() {
		return disputeReason;
	}

	public void setDisputeReason(DisputeReason disputeReason) {
		this.disputeReason = disputeReason;
	}

	/**
	 *
	 * @return <code>boolean</code> :
	 **/
	public boolean isRemovable() {
		// TODO Auto-generated method stub.
		return true;
	}

	/**
	 * HashCode method for DisputeFolder class
	 *
	 * @return <code>int</code> :
	 **/
	@Override
	public int hashCode() {
		return (int) (this.id ^ (this.id >>> 32));
	}

	/**
	 * Equals method for DisputeFolder class
	 *
	 * @param obj
	 *            :
	 *
	 * @return <code>boolean</code> :
	 **/
	@Override
	public boolean equals(Object obj) {
		if ((obj == null) || (!(obj instanceof DisputeFolder))) {
			return false;
		}

		DisputeFolder __obj = (DisputeFolder) obj;

		return (this.id == __obj.id);
	}

	/**
	 * Relation issuerGroup Set value of attribute genericIssuer
	 * 
	 * @param genericIssuer
	 *            : the new value of genericIssuer
	 */
	public void setGenericIssuerId(long genericIssuerId) {
		this.genericIssuerId = genericIssuerId;
	}

	/**
	 * Relation issuerGroup Return value of attribute genericIssuer
	 * 
	 * @return <code>GenericIssuer</code> :
	 */
	public long getGenericIssuerId() {
		return this.genericIssuerId;
	}

	/**
	 * @return <code>version</code> :
	 */
	public long getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            : the new value of version
	 */
	public void setVersion(long version) {
		this.version = version;
	}

	public void setLastChange(java.util.Date lastChange) {
		this.lastChange = lastChange;
	}

	public java.util.Date getLastChange() {
		return this.lastChange;
	}

	public void setExtract(boolean extract) {
		this.extract = extract;
	}

	public boolean getExtract() {
		return this.extract;
	}

	public boolean isDisputed() {
		return disputed;
	}

	public void setDisputed(boolean disputed) {
		this.disputed = disputed;
	}

	public boolean isFraud() {
		return fraud;
	}

	public void setFraud(boolean fraud) {
		this.fraud = fraud;
	}

	public String getExternalReference() {
		return externalReference;
	}

	public void setExternalReference(String externalReference) {
		this.externalReference = externalReference;
	}

	/**
	 * Set value of attribute createDate
	 * 
	 * @param createDate
	 *            : the new value of createDate
	 */
	@Generated(value = "XA", comments = "-890066635")
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * Return value of attribute createDate
	 * 
	 * @return <code>java.util.Date</code> :
	 */
	@Generated(value = "XA", comments = "1033822584")
	public java.util.Date getCreateDate() {
		return this.createDate;
	}

	/**
	 * @return the issuerReferenceData
	 */
	public Long getIssuerReferenceData() {
		return issuerReferenceData;
	}

	/**
	 * @param issuerReferenceData
	 *            the issuerReferenceData to set
	 */
	public void setIssuerReferenceData(Long issuerReferenceData) {
		this.issuerReferenceData = issuerReferenceData;
	}

	/**
	 * Set value of attribute issuerName
	 * 
	 * @param issuerName
	 *            : the new value of issuerName
	 */
	@Generated(value = "XA", comments = "1279476303")
	public void setIssuerName(String issuerName) {
		this.issuerName = issuerName;
	}

	/**
	 * Return value of attribute issuerName
	 * 
	 * @return <code>String</code> :
	 */
	@Generated(value = "XA", comments = "1065356600")
	public String getIssuerName() {
		return this.issuerName;
	}

	public Date purgeableAtDate(int retentionPeriod) {
		// moved to getDisputeFolderPurgebleDate method of ArchiveManagerImpl
		// due to sonar rule compliance
		return null;
	}

	public Class<DisputeFolder> retrieveObjectClass() {
		return DisputeFolder.class;
	}

	public long retrieveObjectId() {
		return this.id;
	}

	// Change for OD-IBOSUPP-6238 Start
	/**
	 * Return value of attribute disputeFolderClosingDate
	 * 
	 * @return <code>Date</code> :
	 */
	public java.util.Date getDisputeFolderClosingDate() {
		return disputeFolderClosingDate;
	}

	/**
	 * Set value of attribute disputeFolderClosingDate
	 * 
	 * @param disputeFolderClosingDate
	 *            : the new value of disputeFolderClosingDate
	 */
	public void setDisputeFolderClosingDate(java.util.Date disputeFolderClosingDate) {
		this.disputeFolderClosingDate = disputeFolderClosingDate;
	}

	// Change for OD-IBOSUPP-6238 End
	// Change for WLPIBOREF-1071 start
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the transactionIdentifier
	 */
	public long getTransactionIdentifier() {
		return transactionIdentifier;
	}

	/**
	 * @param transactionIdentifier
	 *            the transactionIdentifier to set
	 */
	public void setTransactionIdentifier(long transactionIdentifier) {
		this.transactionIdentifier = transactionIdentifier;
	}

	/**
	 * @return the authorizationCharacteristicIndicator
	 */
	public String getAuthorizationCharacteristicIndicator() {
		return authorizationCharacteristicIndicator;
	}

	/**
	 * @param authorizationCharacteristicIndicator
	 *            the authorizationCharacteristicIndicator to set
	 */
	public void setAuthorizationCharacteristicIndicator(String authorizationCharacteristicIndicator) {
		this.authorizationCharacteristicIndicator = authorizationCharacteristicIndicator;
	}

	public Amount getIssuerAccountingBalance() {
		return issuerAccountingBalance;
	}

	public void setIssuerAccountingBalance(Amount issuerAccountingBalance) {
		this.issuerAccountingBalance = issuerAccountingBalance;
	}
}