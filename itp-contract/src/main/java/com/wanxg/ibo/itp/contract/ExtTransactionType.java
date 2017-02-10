package com.wanxg.ibo.itp.contract;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum(String.class)
public enum ExtTransactionType {
	   
	/**
	 *
	 **/
	CASH_WITHDRAWAL,
	/**
	 *
	 **/
	CASH,
	/**
	 *
	 **/
	SALES,
	/**
	 *
	 **/
	SALES_CASHBACK,
	/**
	 *
	 **/
	CREDIT,
	/**
	 *
	 **/
	BILL_PAYMENT, 
	/**
	 *
	 **/
	CREDIT_ADJUSTMENT, 
	/**
	 *
	 **/
	CREDIT_FEE, 
	/**
	 *
	 **/
	@Deprecated
	CREDIT_PAYMENT, 
	/**
	 *
	 **/
	DEBIT_ADJUSTMENT, 
	/**
	 *
	 **/
	DEBIT_FEE, 
	/**
	 *
	 **/
	@Deprecated
	DEBIT_PAYMENT, 
	/**
	 * 
	 */
	//POS, 
	/**
	 * 
	 */
	//DISPUTED, 
	/**
	 * 
	 */
	//ORIGINAL,
	/**
	 * 
	 */
	LOAD,
	/**
	 *
	 **/
	FUND_TRANSFER,
	/**
	 *
	 **/
	REFUND_PURCHASE;
	
}