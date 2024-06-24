package com.apple.model;

public class Product {
	
	private String productId;
	private String productName;
	private int productQuantity;
	private double productPrice;
	private ProductCategory productCategory;
	
	public Product() {
		this.productId = "";
		this.productName = "";
		this.productQuantity = 0;
		this.productPrice = 0.0;
		this.productCategory = new ProductCategory();
	}

	public Product(String productId, String productName, int productQuantity,double productPrice,ProductCategory productCategory ) {
		this.productId = productId;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

}
