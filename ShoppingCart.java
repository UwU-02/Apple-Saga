package com.apple.view;
import javax.swing.*;

import com.apple.model.Product;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ShoppingCart {
    private JFrame frame;

    public ShoppingCart(List<Product> products) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Make sure to close the application
        frame.setSize(900, 600);  // Set the frame size
        frame.getContentPane().setLayout(null);

        JLabel storeName = new JLabel("APPLE SAGA STORE ");
        storeName.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 24));
        storeName.setBounds(85, 37, 239, 45);
        frame.getContentPane().add(storeName);

        JButton backBttn = new JButton("BACK");
        backBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose(); 
               new ProductGui();
            }
        });
        backBttn.setFont(new Font("SansSerif", Font.PLAIN, 15));
        backBttn.setBounds(85, 92, 85, 21);
        frame.getContentPane().add(backBttn);

        JButton checkoutBttn = new JButton("Checkout");
        checkoutBttn.setFont(new Font("Times New Roman", Font.BOLD, 15));
        checkoutBttn.setBounds(740, 510, 117, 43);
        frame.getContentPane().add(checkoutBttn);
        checkoutBttn.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
        		 frame.dispose(); 
                 new CheckoutGui();
              }
          });
        JLabel shoppingCart = new JLabel("Shopping Cart");
        shoppingCart.setHorizontalAlignment(SwingConstants.CENTER);
        shoppingCart.setFont(new Font("Serif", Font.PLAIN, 20));
        shoppingCart.setBounds(317, 78, 254, 45);
        frame.getContentPane().add(shoppingCart);

        if (products != null && !products.isEmpty()) {
            int yOffset = 162;
            double total = 0.0;
            for (Product product : products) {
            	ImageIcon imageIcon = new ImageIcon(product.getProductImageURL());
                JLabel productImage = new JLabel(imageIcon);
                productImage.setBounds(85, yOffset, 139, 91);
                frame.getContentPane().add(productImage);

                JLabel productName = new JLabel(product.getProductName());
                productName.setFont(new Font("Times New Roman", Font.BOLD, 14));
                productName.setBounds(269, yOffset, 139, 13);
                frame.getContentPane().add(productName);

                JLabel productPrice = new JLabel(String.format("RM %.2f", product.getProductPrice()));
                productPrice.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 12));
                productPrice.setBounds(686, yOffset + 46, 100, 13);
                frame.getContentPane().add(productPrice);

                yOffset += 154; // Adjust the offset for the next product
                total += product.getProductPrice(); // Add the product price to the total
            }
            JLabel lblTotalSstIncluded = new JLabel("Total(6% sst included) :");
            lblTotalSstIncluded.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 12));
            lblTotalSstIncluded.setBounds(510, 462, 167, 13);
            frame.getContentPane().add(lblTotalSstIncluded);

            double sst = total * 0.06; // Calculate SST (6%)
            JLabel TotalPrice = new JLabel(String.format("RM %.2f", total + sst));
            TotalPrice.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 12));
            TotalPrice.setBounds(686, 462, 100, 13);
            frame.getContentPane().add(TotalPrice);
        } else {
            JLabel emptyCartLabel = new JLabel("Your shopping cart is empty");
            emptyCartLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
            emptyCartLabel.setBounds(300, 200, 300, 30);
            frame.getContentPane().add(emptyCartLabel);
        }

        frame.setVisible(true);  // Make the frame visible
    }

    public static void main(String[] args) {
        // Create sample products
     List<Product> products = List.of(
        //    new Product("Iphone 13", "path/to/image1.jpg", 3199.00),
       //     new Product("Iphone 14", "path/to/image2.jpg", 4299.00),
       //     new Product("Iphone 15", "path/to/image3.jpg", 5699.00),
       //     new Product("Ipad Air 11-inch", "path/to/image4.jpg", 2999.00)
        );

        new ShoppingCart(products);  // Create and show the frame
    }

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
