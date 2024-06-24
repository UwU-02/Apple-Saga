package com.model;

public class Payment {
	private int paymentId;
	private double paymentAmount;
	private String paymentMethod;
	
	public Payment() {
		this.paymentId = 0;
		this.paymentAmount = 0;
		this.paymentMethod = "";
	}
	
	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
}
