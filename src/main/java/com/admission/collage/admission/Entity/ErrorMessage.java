package com.admission.collage.admission.Entity;

public class ErrorMessage {

	private int errorCode;
	private String errorMessage;
	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public ErrorMessage(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}
	public ErrorMessage(int errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	
	
}
