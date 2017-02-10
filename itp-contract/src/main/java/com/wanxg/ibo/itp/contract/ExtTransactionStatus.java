package com.wanxg.ibo.itp.contract;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum(String.class)
public enum ExtTransactionStatus {
	/**
	 *
	 **/
	PROCESSED,
	/**
	 *
	 **/
	IN_ERROR,
	/**
	 *
	 **/
	REPROCESS,
	/**
	 *
	 **/
	CREATED,
	/**
	 *
	 **/
	ABANDON;
}
