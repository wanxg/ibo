package com.wanxg.ibo.itp.contract;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum(String.class)
public enum ExtTerminalCategory {
	/**
	 *
	 **/
	ATM,
	/**
	 *
	 **/
	POS,
	/**
	 *
	 **/
	MANUAL,
	/**
	 *
	 **/
	UNKNOWN,
	/**
	 *
	 **/
	MAIL_PHONE,
	/**
	 *
	 **/
	INTERNET,
	/**
	 *
	 **/
	UNATTENDED,	
	/**
	 *
	 **/
	MOBILE;
}
