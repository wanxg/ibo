
package com.wanxg.ibo.itp.transaction;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 **/

@Entity
@NamedQueries({})
public abstract class Presentment extends com.wanxg.ibo.itp.transaction.Transaction {
	/**
	 *
	 * secondaryAccountNumber: String
	 **/
	@Column(name = "SECD_ACC_NUM")
	private String secondaryAccountNumber;

	/**
	 *
	 * settlementDate: Date
	 **/
	@Column(name = "SET_DTE")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date settlementDate;

	/**
	 * highAmountCheckFlag: boolean
	 */
	@Generated("XA")
	@Column(name = "HIGH_AMT_FLG")
	private boolean highAmountCheckFlag;

	/**
	 * duplicateFlag: boolean
	 */
	@Generated("XA")
	@Column(name = "DUP_FLG")
	private boolean duplicateFlag;

	/**
	 * disputeReason: DisputeReason
	 */
	@Generated("XA")
	@Column(name = "DSP_RSN")
	private String disputeReason;

	/**
	 * Card Credit Debit Code indicates wheter card is issued as a debit or a
	 * credit card. Used in Visa interchange determination and validation as the
	 * interchange rate sometimes is different depending on the usage.
	 * Information obtained from Card service. For domestic transactions
	 * information is only informational as interchnage validation and
	 * determination is not performed for such transactions. Domain: C - Credit
	 * D - Debit Space - Unknown. For cards managed on the platform (issuing
	 * mode) the information is obtained from Card service. Also, determined for
	 * Domestic mode but only for informational reason as interchnage
	 * calculation is not done for domestic transactions. For cards not managed
	 * on the platform (acquiring mode) information is obtained from CC Card
	 * Prefix information where it for Visa cards is determined from the 'usage'
	 * field in the ARDEF file and for MasterCard from MPE table IP0040T1 - GCMS
	 * Product Id. For MasterCard: MCC = Credit MCD = Debit CIR = DEBIT MDI =
	 * Debit PVL = Unknown For Visa: C- Credit D - Debit F - Debit Space =
	 * Unknown [ Source : WLP] [ Data Type : AN1] cardCreditDebitCode: String
	 */
	@Generated("XA")
	@Column(name = "CRT_CRD_DBT_CDE", length = 1)
	private String cardCreditDebitCode;

	/**
	 * disputeStatus: String
	 */
	@Generated("XA")
	@Column(name = "DSP_STA")
	private String disputeStatus;

	/**
	 * fraudStatus: String
	 */
	@Generated("XA")
	@Column(name = "FRD_STA")
	private String fraudStatus;

	// OD-IBOSUPP-3041 changes start
	/**
	 * @generated XA
	 */
	@Generated("XA")
	@Column(name = "OFL_FLG")
	private boolean offlineFlag = false;

	/**
	 * multipleClearingSequenceCount:int
	 */
	@Generated("XA")
	@Column(name = "MUL_CLR_SEQ_CNT")
	private Integer multipleClearingSequenceCount;
	/**
	 * multipleClearingSequenceNumber: int
	 */
	@Generated("XA")
	@Column(name = "MUL_CLR_SEQ_NUM")
	private Integer multipleClearingSequenceNumber;

	@Column(name = "DCC_INDICATOR")
	private String dccIndicator;

	
	@Transient
	private String previousStringData = null;
	
	/**
	 * Return value of attribute secondaryAccountNumber
	 *
	 * @return <code>String</code> :
	 **/
	@Generated(value = "XA", comments = "150153464")
	public String getSecondaryAccountNumber() {
		return this.secondaryAccountNumber;
	}

	/**
	 * Set value of attribute secondaryAccountNumber
	 *
	 * @param secondaryAccountNumber
	 *            : the new value of secondaryAccountNumber
	 **/
	@Generated(value = "XA", comments = "1998782125")
	public void setSecondaryAccountNumber(String secondaryAccountNumber) {
		this.secondaryAccountNumber = secondaryAccountNumber;
	}

	/**
	 * Return value of attribute settlementDate
	 *
	 * @return <code>java.util.Date</code> :
	 **/
	@Generated(value = "XA", comments = "1878229336")
	public java.util.Date getSettlementDate() {
		return this.settlementDate;
	}

	/**
	 * Set value of attribute settlementDate
	 *
	 * @param settlementDate
	 *            : the new value of settlementDate
	 **/
	@Generated(value = "XA", comments = "1929385186")
	public void setSettlementDate(java.util.Date settlementDate) {
		this.settlementDate = settlementDate;
	}

	/**
	 * Set value of attribute highAmountCheckFlag
	 * 
	 * @param highAmountCheckFlag
	 *            : the new value of highAmountCheckFlag
	 */
	@Generated(value = "XA", comments = "-1350739257")
	public void setHighAmountCheckFlag(boolean highAmountCheckFlag) {
		this.highAmountCheckFlag = highAmountCheckFlag;
	}

	/**
	 * Return value of attribute highAmountCheckFlag
	 * 
	 * @return <code>boolean</code> :
	 */
	@Generated(value = "XA", comments = "-43238702")
	public boolean isHighAmountCheckFlag() {
		return this.highAmountCheckFlag;
	}

	/**
	 * Set value of attribute duplicateFlag
	 * 
	 * @param duplicateFlag
	 *            : the new value of duplicateFlag
	 */
	@Generated(value = "XA", comments = "-360378620")
	public void setDuplicateFlag(boolean duplicateFlag) {
		this.duplicateFlag = duplicateFlag;
	}

	/**
	 * Return value of attribute duplicateFlag
	 * 
	 * @return <code>boolean</code> :
	 */
	@Generated(value = "XA", comments = "982731596")
	public boolean isDuplicateFlag() {
		return this.duplicateFlag;
	}

	/**
	 * Set value of attribute disputeReason
	 * 
	 * @param disputeReason
	 *            : the new value of disputeReason
	 */
	@Generated(value = "XA", comments = "-20188267")
	public void setDisputeReason(String disputeReason) {
		this.disputeReason = disputeReason;
	}

	/**
	 * Return value of attribute disputeReason
	 * 
	 * @return <code>com.wanxg.ibo.itp.processing.openrules.DisputeReason</code>
	 *         :
	 */
	@Generated(value = "XA", comments = "-1064746322")
	public String getDisputeReason() {
		return this.disputeReason;
	}

	/**
	 * Set value of attribute cardCreditDebitCode
	 * 
	 * @param cardCreditDebitCode
	 *            : the new value of cardCreditDebitCode
	 */
	@Generated(value = "XA", comments = "-119046275")
	public void setCardCreditDebitCode(String cardCreditDebitCode) {
		this.cardCreditDebitCode = cardCreditDebitCode;
	}

	/**
	 * Return value of attribute cardCreditDebitCode
	 * 
	 * @return <code>String</code> :
	 */
	@Generated(value = "XA", comments = "780471614")
	public String getCardCreditDebitCode() {
		return this.cardCreditDebitCode;
	}

	/**
	 * Set value of attribute disputeStatus
	 * 
	 * @param disputeStatus
	 *            : the new value of disputeStatus
	 */
	@Generated(value = "XA", comments = "-1170723219")
	public void setDisputeStatus(String disputeStatus) {
		this.disputeStatus = disputeStatus;
	}

	/**
	 * Return value of attribute disputeStatus
	 * 
	 * @return <code>String</code> :
	 */
	@Generated(value = "XA", comments = "-1352035554")
	public String getDisputeStatus() {
		return this.disputeStatus;
	}

	/**
	 * Set value of attribute fraudStatus
	 * 
	 * @param fraudStatus
	 *            : the new value of fraudStatus
	 */
	@Generated(value = "XA", comments = "-1170723219")
	public void setFraudStatus(String fraudStatus) {
		this.fraudStatus = fraudStatus;
	}

	/**
	 * Return value of attribute fraudStatus
	 * 
	 * @return <code>String</code> :
	 */
	@Generated(value = "XA", comments = "-1352035554")
	public String getFraudStatus() {
		return this.fraudStatus;
	}

	/**
	 * Return value of attribute offlineFlag
	 *
	 * @return <code>boolean</code> :
	 **/
	@Generated(value = "XA", comments = "982731596")
	public boolean isOfflineFlag() {
		return this.offlineFlag;
	}

	/**
	 * Set value of attribute offlineFlag
	 *
	 * @param offlineFlag
	 *            : the new value of offlineFlag
	 **/
	@Generated(value = "XA", comments = "-360378620")
	public void setOfflineFlag(boolean offlineFlag) {
		this.offlineFlag = offlineFlag;
	}

	/**
	 * Set value of attribute multipleClearingSequenceCount
	 * 
	 * @param multipleClearingSequenceCount
	 *            : the new value of multipleClearingSequenceCount
	 * @generated XA
	 */
	@Generated(value = "XA", comments = "1773779440")
	public void setMultipleClearingSequenceCount(Integer multipleClearingSequenceCount) {
		this.multipleClearingSequenceCount = multipleClearingSequenceCount;
	}

	/**
	 * Return value of attribute multipleClearingSequenceCount
	 * 
	 * @return <code>int</code>
	 * @generated XA
	 */
	@Generated(value = "XA", comments = "-1583230442")
	public Integer getMultipleClearingSequenceCount() {
		return this.multipleClearingSequenceCount;
	}

	/**
	 * Set value of attribute multipleClearingSequenceNumber
	 * 
	 * @param multipleClearingSequenceNumber
	 *            : the new value of multipleClearingSequenceNumber
	 * @generated XA
	 */
	@Generated(value = "XA", comments = "638581336")
	public void setMultipleClearingSequenceNumber(Integer multipleClearingSequenceNumber) {
		this.multipleClearingSequenceNumber = multipleClearingSequenceNumber;
	}

	/**
	 * Return value of attribute multipleClearingSequenceNumber
	 * 
	 * @return <code>int</code>
	 * @generated XA
	 */
	@Generated(value = "XA", comments = "-1156990758")
	public Integer getMultipleClearingSequenceNumber() {
		return this.multipleClearingSequenceNumber;
	}

	public String getDccIndicator() {
		return dccIndicator;
	}

	public void setDccIndicator(String dccIndicator) {
		this.dccIndicator = dccIndicator;
	}

}
