package com.wanxg.ibo.itp.transaction;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import javax.persistence.ManyToOne;

/**
 * 
 * 
 * @generated XA
 **/
@Generated(value = "XA", comments = "973518571,_vG-JwEjQEeKPjM_s320q2A")
@Entity
@Table(name = "ITP_USER_ACT")
public class UserAction {
	/**
	 * 
	 * 
	 **/
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "P_ITP_USER_ACT")
	private Long id;
	/**
	 * 
	 * 
	 **/
	@Column(name = "ACT_DATE")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date date;
	/**
	 * 
	 * 
	 **/
	@Column(name = "ACT_USER")
	private String userName;
	/**
	 * 
	 * 
	 **/
	@Column(name = "ACT")
	private String action;
	/**
	 * 
	 * 
	 **/
	@ManyToOne
	@JoinColumn(name = "FK_ITP_TRN_P_ITP_TRN")
	private Transaction transaction = null;

	/**
	 * Return value of attribute id
	 * 
	 * @return <code>long</code>
	 **/
	public long getId() {
		return this.id;
	}

	/**
	 * Set value of attribute id
	 * 
	 * @param id
	 *            : (<code>long</code>) the new value of id
	 **/
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Return value of attribute date
	 * 
	 * @return <code>Date</code>
	 **/
	public Date getDate() {
		return this.date;
	}

	/**
	 * Set value of attribute date
	 * 
	 * @param date
	 *            : (<code>Date</code>) the new value of date
	 **/
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Return value of attribute userName
	 * 
	 * @return <code>String</code>
	 **/
	public String getUserName() {
		return this.userName;
	}

	/**
	 * Set value of attribute userName
	 * 
	 * @param userName
	 *            : (<code>String</code>) the new value of userName
	 **/
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Return value of attribute action
	 * 
	 * @return <code>String</code>
	 **/
	public String getAction() {
		return this.action;
	}

	/**
	 * Set value of attribute action
	 * 
	 * @param action
	 *            : (<code>String</code>) the new value of action
	 **/
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * Equals method for UserAction class
	 * 
	 * @param obj
	 *            (<code>Object</code>) :
	 * @return <code>boolean</code> :
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if ((obj == null) || (!(obj instanceof UserAction))) {
			return false;
		}
		UserAction __obj = (UserAction) obj;
		return (this.id == __obj.id);
	}

	/**
	 * Get method concerning userActionTransaction association
	 * 
	 * @return <code>Transaction</code> :
	 * 
	 */
	public Transaction getTransaction() {
		return this.transaction;
	}

	/**
	 * Set method concerning userActionTransaction association
	 * 
	 * @param transaction
	 *            (<code>Transaction</code>) :
	 * 
	 */
	public void setTransaction(final Transaction transaction) {
		this.transaction = transaction;
	}
}
