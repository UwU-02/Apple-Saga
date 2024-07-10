package com.apple.model;

public class CartItem {
    private int quantity;
    private static Product product;

    public CartItem(int quantity, Product product) {
        this.quantity = quantity;
        CartItem.product = product;
    }

    public CartItem()
    {
        this.quantity = 0;
        CartItem.product = null;
    }

    public int getCartItemQuantity() {
        return quantity;
    }

    public void setCartItemQuantity(int quantity) 
    {
        this.quantity = quantity;
    }

    public static Product getCartItemProduct() {
        return product;
    }

    public void setCartItemProduct(Product product) 
    {
        CartItem.product = product;
    }
}
