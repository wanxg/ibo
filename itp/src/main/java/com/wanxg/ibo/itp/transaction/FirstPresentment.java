
package com.wanxg.ibo.itp.transaction;


import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 **/

@Entity
//@DiscriminatorValue(value = "FirstPresentment")
@NamedQueries({
	
		@NamedQuery(name = "com.wanxg.ibo.itp.transaction.FirstPresentment.findByCriteria", query = "SELECT f FROM FirstPresentment f"),
		@NamedQuery(name = "com.wanxg.ibo.itp.transaction.FirstPresentment.findById", query = "SELECT f FROM FirstPresentment f where f.id=:id"),
})
public class FirstPresentment extends com.wanxg.ibo.itp.transaction.Presentment {

	/**
	 * Flag indicating if transaction has been authorized or not.
	 * authorizedFlag: boolean
	 */
	@Generated("XA")
	@Column(name = "AUT_FLG")
	private boolean authorizedFlag;

	/**
	 * Account identifier received from CMS for the provided PAN, SequencNumber,
	 * ExpiryDate and first Presentment. [ Source : WLP] [ Data Type : N11]
	 * accountId: long
	 */
	@Generated("XA")
	@Column(name = "ACC_REF")
	private String accountReference;

	
	@Column(name = "DUAL_MSG_FLG")
	private boolean dualMessageFlag = true;

	public boolean isDualMessageFlag() {
		return dualMessageFlag;
	}

	public void setDualMessageFlag(boolean dualMessageFlag) {
		this.dualMessageFlag = dualMessageFlag;
	}


	/**
	 * Equals method for FirstPresentment class
	 *
	 * @param obj
	 *            :
	 *
	 * @return <code>boolean</code> :
	 **/
	@Generated(value = "XA", comments = "-1434029826")
	public boolean equals(Object obj) {
		if ((obj == null) || (!(obj instanceof FirstPresentment))) {
			return false;
		}

		FirstPresentment __obj = (FirstPresentment) obj;

		return super.equals(__obj);
	}

	/**
	 * Set value of attribute authorizedFlag
	 * 
	 * @param authorizedFlag
	 *            : the new value of authorizedFlag
	 */
	@Generated(value = "XA", comments = "1774907410")
	public void setAuthorizedFlag(boolean authorizedFlag) {
		this.authorizedFlag = authorizedFlag;
	}

	/**
	 * Return value of attribute authorizedFlag
	 * 
	 * @return <code>boolean</code> :
	 */
	@Generated(value = "XA", comments = "-690242728")
	public boolean isAuthorizedFlag() {
		return this.authorizedFlag;
	}

	/**
	 * Set value of attribute accountId
	 * 
	 * @param accountId
	 *            : the new value of accountId
	 */
	@Generated(value = "XA", comments = "-318068715")
	public void setAccountReference(String accountReference) {
		this.accountReference = accountReference;
	}

	/**
	 * Return value of attribute accountId
	 * 
	 * @return <code>long</code> :
	 */
	@Generated(value = "XA", comments = "-1085745362")
	public String getAccountReference() {
		return this.accountReference;
	}

	@Generated(value = "XA", comments = "3677788")
	public String getClassType() {
		return "FIRST_PRESENTMENT";
	}
	
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.getId()).append(":").append(this.getBrand()).append(":").append(this.getCardSchemeCode());
		
		return sb.toString();
	}
}
