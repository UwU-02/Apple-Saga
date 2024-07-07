
package com.apple.view;

import java.awt.EventQueue;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.apple.controller.ProductController;
import com.apple.controller.ReviewController;
import com.apple.model.Product;
import com.apple.model.Review;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ProductDetailGui extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private static int productId;
    private String customerEmail;
    private String customerPassword;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Product sampleProduct = new Product();
                    sampleProduct.setProductId(1);
                    sampleProduct.setProductName("Sample Product");
                    sampleProduct.setProductPrice(999.99);
                    sampleProduct.setProductColor("Black");
                    sampleProduct.setProductStockQuantity(10);
                    sampleProduct.setProductImageURL("path/to/sample/image.jpg");

                    String dummyEmail = "test@example.com";
                    String dummyPassword = "testpassword";

                    ProductDetailGui frame = new ProductDetailGui(sampleProduct, dummyEmail, dummyPassword);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ProductDetailGui(Product product, String customerEmail, String customerPassword) {
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("APPLE SAGA STORE ");
        lblNewLabel.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
        lblNewLabel.setBounds(39, 38, 185, 22);
        contentPane.add(lblNewLabel);

        JButton buttonBack = new JButton("Back");
        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                ProductController controller = new ProductController();
                List<Product> products = controller.getAllProduct();
                new ProductGui(products, null, new ProfileGui(customerEmail, customerPassword), customerEmail, customerPassword);
            }
        });
        buttonBack.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        buttonBack.setBounds(39, 70, 85, 34);
        contentPane.add(buttonBack);

        JLabel lblNewLabel_2 = new JLabel(product.getProductName());
        lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblNewLabel_2.setBounds(406, 141, 203, 22);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_2_1 = new JLabel("RM " + String.format("%.2f", product.getProductPrice()));
        lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNewLabel_2_1.setBounds(406, 173, 137, 22);
        contentPane.add(lblNewLabel_2_1);

        JLabel lblNewLabel_2_2 = new JLabel(product.getProductColor());
        lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNewLabel_2_2.setBounds(406, 194, 182, 22);
        contentPane.add(lblNewLabel_2_2);

        JLabel lblNewLabel_2_3 = new JLabel("Stock: " + product.getProductStockQuantity());
        lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNewLabel_2_3.setBounds(406, 215, 137, 22);
        contentPane.add(lblNewLabel_2_3);

        String imageUrl = "/resource/product_images/" + product.getProductImageURL();
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
            Image scaledImage = image.getScaledInstance(252, 153, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(scaledImage);
        } catch (Exception e) {
            System.err.println("Error loading image: " + e.getMessage());
            imageIcon = new ImageIcon("path/to/placeholder.png");
        }

        JButton productImage1 = new JButton(imageIcon);
        productImage1.setBounds(78, 141, 252, 153);
        contentPane.add(productImage1);

        JButton btnNewButton = new JButton("ADD TO CART");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ShoppingCart(null);
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnNewButton.setBounds(428, 288, 160, 34);
        contentPane.add(btnNewButton);

        JButton btnBuyNow = new JButton("BUY NOW");
        btnBuyNow.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnBuyNow.setBounds(616, 288, 145, 34);
        contentPane.add(btnBuyNow);

        List<Review> reviews = fetchProductReviews(product.getProductId());
        displayProductReviews(reviews);
    }

    private List<Review> fetchProductReviews(int productId) {
        ReviewController reviewController = new ReviewController();
        reviewController.connectToDatabase();
        return reviewController.getAllReview(productId);
    }

    private void displayProductReviews(List<Review> reviews) {
        int yOffset = 350;
        for (Review review : reviews) {
            JLabel reviewLabel = new JLabel("Customer ID: " + review.getReviewCustomerId() + " - " + review.getReviewDescription());
            reviewLabel.setBounds(60, yOffset, 710, 34);
            contentPane.add(reviewLabel);
            yOffset += 40;
        }
        contentPane.revalidate();
        contentPane.repaint();
    }
}
