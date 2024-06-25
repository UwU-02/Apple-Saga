package model;

public class ShoppingOrder {
    private String orderId;
    private String orderDate;
    private Customer customerId;
    
    public ShoppingOrder() {
        this.orderId = "";
        this.orderDate = "";
        this.customerId = new Customer();
    }
    
    
    public ShoppingOrder(String orderId, String orderDate, Customer customer) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
    }
    
    
    public String getOrderId() {
        return orderId;
    }
    
   
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    

    public String getOrderDate() {
        return orderDate;
    }
    
   
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    
    
    public Customer getCustomer() {
        return customerId;
    }
    
  
    public void setCustomer(Customer customer) {
        this.customerId = customerId;
    }
    
   
}
