package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import controller.ShoppingCartController;
import model.CartItem;
import model.Product;
import model.UserSession;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ShoppingCart {
    private JFrame frame;
    private String email;
    private String password;

    public ShoppingCart(String email, String password) {
    	this.email = email;
        this.password = password;
        
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
                ProfileGui profileFrame = new ProfileGui(email, password);
                profileFrame.setVisible(true);
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

        JLabel shoppingCartLabel = new JLabel("Shopping Cart");
        shoppingCartLabel.setHorizontalAlignment(SwingConstants.CENTER);
        shoppingCartLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        shoppingCartLabel.setBounds(317, 78, 254, 45);
        frame.getContentPane().add(shoppingCartLabel);

        // Fetch and display the cart items
        displayCartItems();

        frame.setVisible(true);  // Make the frame visible
    }

    private void displayCartItems() {
        ShoppingCartController cartController = new ShoppingCartController();
        int customerId = UserSession.getInstance().getCurrentUserId();
        int cartId = cartController.getCartIdbyCustomerId(customerId);
        List<CartItem> cartItems = cartController.getAllCartItembyCartId(cartId);
        
        System.out.println("Displaying items for cart ID " + cartId + ": " + cartItems);

        if (cartItems != null && !cartItems.isEmpty()) {
            int yOffset = 162;
            double total = 0.0;
            for (CartItem cartItem : cartItems) {
                Product product = cartItem.getCartItemProduct();
                String imageUrl = "/com/apple/resources/product_images/" + product.getProductImageURL();
                URL url = getClass().getResource(imageUrl);

                if (url == null) {
                    String filePath = System.getProperty("user.dir") + "/src" + imageUrl;
                    File file = new File(filePath);
                    try {
                        url = file.toURI().toURL();
                    } catch (MalformedURLException e) {
                        System.err.println("Error converting file path to URL: " + e.getMessage());
                    }
                }

                System.out.println("URL: " + url);

                ImageIcon imageIcon;
                try {
                    BufferedImage image = ImageIO.read(url);
                    Image scaledImage = image.getScaledInstance(139, 91, Image.SCALE_SMOOTH);
                    imageIcon = new ImageIcon(scaledImage);
                } catch (Exception e) {
                    System.err.println("Error loading image: " + e.getMessage());
                    imageIcon = new ImageIcon("path/to/placeholder.png");
                }

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
                total += product.getProductPrice() * cartItem.getCartItemQuantity(); // Add the product price to the total
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
    }

    public static void main(String[] args) {
    	 new ShoppingCart("example@email.com", "password");  // Create and show the frame
    }

    public void setVisible(boolean b) {
        frame.setVisible(b);
    }
}
