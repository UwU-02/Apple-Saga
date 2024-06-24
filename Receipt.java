package com.model;

public class Receipt {
	private String receiptId;
	private double paymentAmount;
	private Product product;
	
	public Receipt() {
		this.receiptId = "";
		this.paymentAmount = 0;
	}

	public Receipt(String receiptId, double paymentAmount, Product product) {
		this.receiptId = receiptId;
		this.paymentAmount = paymentAmount;
		this.product = product;
	}
	
	public String getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(String receiptId) {
		this.receiptId = receiptId;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

}
