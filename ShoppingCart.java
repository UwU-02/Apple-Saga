package model;

public class ShoppingCart {
	
	private int productQuantity;
	private Product productId;
	private ShoppingOrder orderId;
	
	public ShoppingCart() {
		// TODO Auto-generated constructor stub
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public ShoppingOrder getOrderId() {
		return orderId;
	}

	public void setOrderId(ShoppingOrder orderId) {
		this.orderId = orderId;
	}

}
