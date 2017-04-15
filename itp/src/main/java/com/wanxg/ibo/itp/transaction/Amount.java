package com.wanxg.ibo.itp.transaction;

import javax.persistence.Embeddable;

@Embeddable
public class Amount {
	
	private String isoCode;
	/**
	 * The (long) value stored for this instance: long
	 */
	private long value;
	/**
	 * The number of decimals to apply to the value: int.<BR/>
	 */
	private int exponent;
	
	public Amount() {
		setExponent(0);
		setValue(0l);
		setIsoCode(null);
	}
	
	public Amount(Long value, Integer exponent, String isoCode) {
		setExponent(exponent);
		setValue(value);
		setIsoCode(isoCode);
	}
	
	
	public String getIsoCode() {
		return isoCode;
	}
	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}
	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}
	public Integer getExponent() {
		return exponent;
	}
	public void setExponent(Integer exponent) {
		this.exponent = exponent;
	}
	
	public String toString() {
		StringBuffer instance = new StringBuffer();
		instance.append(returnNumber() + " " + getIsoCode());
		return instance.toString();
	}
	
	public Double returnNumber() {
		double result = 0;
		result = getValue() / java.lang.Math.pow(10, getExponent());
		return result;
	}


}
