package com.wanxg.ibo.itp.contract;

public class ServiceException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceException(String message){
		super(message);
	}

	public ServiceException(String message, Throwable ex){
		super(message,ex);
	}
}
