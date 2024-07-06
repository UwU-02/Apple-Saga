package view;

import java.awt.EventQueue;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.ProductController;
import model.Product;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ProductDetailGui extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldReview;
private static int productId;
private String customerEmail;
private String customerPassword;
    /**
     * Launch the application.
     */
public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                // Create a sample product for testing
                Product sampleProduct = new Product();
                sampleProduct.setProductId(1);
                sampleProduct.setProductName("Sample Product");
                sampleProduct.setProductPrice(999.99);
                sampleProduct.setProductColor("Black");
                sampleProduct.setProductStockQuantity(10);
                sampleProduct.setProductImageURL("path/to/sample/image.jpg");

                // Use dummy email and password for testing
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

    /**
     * Create the frame.
     */
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
                dispose(); // Close the current ProductDetailGui
                ProductController controller = new ProductController();
                List<Product> products = controller.getAllProduct();
                new ProductGui(products, null, new ProfileGui(customerEmail, customerPassword), customerEmail, customerPassword);
            }
        });
        buttonBack.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        buttonBack.setBounds(39, 70, 85, 34);
        contentPane.add(buttonBack);
        
        
     // Update labels with product details
        JLabel lblNewLabel_2 = new JLabel(product.getProductName());
        lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblNewLabel_2.setBounds(406, 141, 137, 22);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_2_1 = new JLabel("RM " + String.format("%.2f", product.getProductPrice()));
        lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNewLabel_2_1.setBounds(406, 173, 137, 22);
        contentPane.add(lblNewLabel_2_1);
        
        JLabel lblNewLabel_2_2 = new JLabel(product.getProductColor());
        lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNewLabel_2_2.setBounds(406, 194, 137, 22);
        contentPane.add(lblNewLabel_2_2);
        
        JLabel lblNewLabel_2_3 = new JLabel("Stock: " + product.getProductStockQuantity());
        lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNewLabel_2_3.setBounds(406, 215, 137, 22);
        contentPane.add(lblNewLabel_2_3);

     // Load and display the product image
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

        System.out.println("URL: " + url); // Print the URL to the console

        ImageIcon imageIcon;
        try {
            BufferedImage image = ImageIO.read(url);
            Image scaledImage = image.getScaledInstance(252, 153, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(scaledImage);
        } catch (Exception e) {
            System.err.println("Error loading image: " + e.getMessage());
            imageIcon = new ImageIcon("path/to/placeholder.png"); // Replace with actual path to a placeholder image
        }

        JButton productImage1 = new JButton(imageIcon);
        productImage1.setBounds(78, 141, 252, 153);
        contentPane.add(productImage1);
        
        JButton btnNewButton = new JButton("ADD TO CART");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Assuming you have a ShoppingOrder class and ShoppingCart accepts a List of ShoppingOrder
                // You can create a list and add the current product to the list, then pass it to the ShoppingCart
                // List<ShoppingOrder> orders = new ArrayList<>();
                // orders.add(new ShoppingOrder(product));  // Add the current product to the order list
                new ShoppingCart(null);  // Adjust this to pass the appropriate order list
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnNewButton.setBounds(428, 288, 160, 34);
        contentPane.add(btnNewButton);
        
        JButton btnBuyNow = new JButton("BUY NOW");
        btnBuyNow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 new CheckoutGui(); //go to checkout page for payment
            }
        });
        btnBuyNow.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnBuyNow.setBounds(631, 288, 160, 34);
        contentPane.add(btnBuyNow);
        
        JLabel lblNewLabel_3 = new JLabel("Review : ");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_3.setBounds(50, 368, 85, 22);
        contentPane.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Customer Id : ");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_4.setBounds(50, 400, 100, 13);
        contentPane.add(lblNewLabel_4);
        
        textFieldReview = new JTextField();
        textFieldReview.setBounds(60, 423, 710, 34);
        contentPane.add(textFieldReview);
        textFieldReview.setColumns(10);
        
        JLabel lblNewLabel_1_1 = new JLabel("Product Detail");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 32));
        lblNewLabel_1_1.setBounds(362, 38, 252, 39);
        contentPane.add(lblNewLabel_1_1);
    }
}
