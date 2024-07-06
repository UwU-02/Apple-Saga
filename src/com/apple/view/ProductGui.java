package view;

import javax.swing.*;

import com.apple.model.Product;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductGui {
    private JFrame frame;
    private JTextField txtSearch;
private String productId="1";
    public ProductGui() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1180, 690);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel storeName = new JLabel("APPLE SAGA STORE ");
        storeName.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 24));
        storeName.setBounds(71, 39, 239, 45);
        frame.getContentPane().add(storeName);

        JLabel lblProduct = new JLabel("PRODUCTS");
        lblProduct.setHorizontalAlignment(SwingConstants.LEFT);
        lblProduct.setFont(new Font("Serif", Font.PLAIN, 20));
        lblProduct.setBounds(71, 79, 254, 45);
        frame.getContentPane().add(lblProduct);

        JButton filterBttn = new JButton("FILTER");
        filterBttn.setBounds(943, 94, 85, 21);
        frame.getContentPane().add(filterBttn);

        filterBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FilterGui(); // Open the filter page
            }
        });

        txtSearch = new JTextField();
        txtSearch.setText("SEARCH");
        txtSearch.setBounds(757, 95, 150, 19);
        frame.getContentPane().add(txtSearch);
        txtSearch.setColumns(10);

        Product product = new Product();
        ImageIcon imageIcon1 = new ImageIcon(product.getProductImageURL());
        JButton productImage1 = new JButton(imageIcon1);
        productImage1.setBounds(92, 161, 149, 117);
        frame.getContentPane().add(productImage1);
        productImage1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 frame.dispose();
             ProductDetailGui frame =  new ProductDetailGui(productId); // Open the product details page 
		frame.setVisible(true);
				
            }
        });

        JLabel lblIphone13 = new JLabel("Iphone 13");
        lblIphone13.setFont(new Font("Serif", Font.PLAIN, 14));
        lblIphone13.setBounds(92, 288, 100, 21);
        frame.getContentPane().add(lblIphone13);

        ImageIcon imageIcon2 = new ImageIcon(product.getProductImageURL());
        JButton productImage2 = new JButton(imageIcon2);
        productImage2.setBounds(282, 161, 150, 117);
        frame.getContentPane().add(productImage2);
        productImage2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 frame.dispose();
                 ProductDetailGui frame =  new ProductDetailGui(productId); // Open the product details page 
    		frame.setVisible(true);
            }
        });

        
        JLabel lblIphone14 = new JLabel("Iphone 14");
        lblIphone14.setFont(new Font("Serif", Font.PLAIN, 14));
        lblIphone14.setBounds(282, 288, 100, 21);
        frame.getContentPane().add(lblIphone14);

        ImageIcon imageIcon3 = new ImageIcon(product.getProductImageURL());
        JButton productImage3 = new JButton(imageIcon3);
        productImage3.setBounds(467, 161, 150, 117);
        frame.getContentPane().add(productImage3);
        productImage3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 frame.dispose();
                 ProductDetailGui frame =  new ProductDetailGui(productId); // Open the product details page 
    		frame.setVisible(true);
            }
        });

        JLabel lblIphone15 = new JLabel("Iphone 15");
        lblIphone15.setFont(new Font("Serif", Font.PLAIN, 14));
        lblIphone15.setBounds(467, 288, 100, 21);
        frame.getContentPane().add(lblIphone15);

        ImageIcon imageIcon4 = new ImageIcon(product.getProductImageURL());
        JButton productImage4 = new JButton(imageIcon4);
        productImage4.setIcon(imageIcon4);
        productImage4.setBounds(658, 161, 150, 117);
        frame.getContentPane().add(productImage4);
        productImage4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 frame.dispose();
                 ProductDetailGui frame =  new ProductDetailGui(productId); // Open the product details page 
    		frame.setVisible(true);
            }
        });

        JLabel lblIpadAirinchi = new JLabel("Ipad Air 11-inch");
        lblIpadAirinchi.setFont(new Font("Serif", Font.PLAIN, 14));
        lblIpadAirinchi.setBounds(658, 288, 130, 21);
        frame.getContentPane().add(lblIpadAirinchi);

        ImageIcon imageIcon5 = new ImageIcon(product.getProductImageURL());
        JButton productImage5 = new JButton(imageIcon5);
        productImage5.setBounds(91, 354, 150, 117);
        frame.getContentPane().add(productImage5);
        productImage5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 frame.dispose();
                 ProductDetailGui frame =  new ProductDetailGui(productId); // Open the product details page 
    		frame.setVisible(true);
            }
        });

        JLabel lblIpadPro = new JLabel("Ipad Pro");
        lblIpadPro.setFont(new Font("Serif", Font.PLAIN, 14));
        lblIpadPro.setBounds(91, 481, 100, 21);
        frame.getContentPane().add(lblIpadPro);

        ImageIcon imageIcon6 = new ImageIcon(product.getProductImageURL());
        JButton productImage6 = new JButton(imageIcon6);
        productImage6.setBounds(282, 354, 150, 117);
        frame.getContentPane().add(productImage6);
        productImage6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 frame.dispose();
                 ProductDetailGui frame =  new ProductDetailGui(productId); // Open the product details page 
    		frame.setVisible(true);
            }
        });

        JLabel lblAirpodsPro = new JLabel("Airpods Pro");
        lblAirpodsPro.setFont(new Font("Serif", Font.PLAIN, 14));
        lblAirpodsPro.setBounds(282, 481, 100, 21);
        frame.getContentPane().add(lblAirpodsPro);

        ImageIcon imageIcon7 = new ImageIcon(product.getProductImageURL());
        JButton productImage7 = new JButton(imageIcon7);
        productImage7.setBounds(467, 354, 150, 117);
        frame.getContentPane().add(productImage7);
        productImage7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 frame.dispose();
                 ProductDetailGui frame =  new ProductDetailGui(productId); // Open the product details page 
    		frame.setVisible(true);
            }
        });

        JLabel lblAirpods = new JLabel("Airpods (3rd Gen)");
        lblAirpods.setFont(new Font("Serif", Font.PLAIN, 14));
        lblAirpods.setBounds(467, 481, 130, 21);
        frame.getContentPane().add(lblAirpods);

        ImageIcon imageIcon8 = new ImageIcon(product.getProductImageURL());
        JButton productImage8 = new JButton(imageIcon8);
        productImage8.setBounds(658, 354, 150, 117);
        frame.getContentPane().add(productImage8);
        productImage8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 frame.dispose();
                 ProductDetailGui frame =  new ProductDetailGui(productId); // Open the product details page 
    		frame.setVisible(true);
            }
        });

        JLabel lblAppleWatchSeries9 = new JLabel("Apple Watch Series 9");
        lblAppleWatchSeries9.setFont(new Font("Serif", Font.PLAIN, 14));
        lblAppleWatchSeries9.setBounds(658, 481, 180, 21);
        frame.getContentPane().add(lblAppleWatchSeries9);
        
        ImageIcon imageIcon9 = new ImageIcon(product.getProductImageURL());
        JButton productImage9 = new JButton(imageIcon9);
        productImage9.setBounds(880, 161, 150, 117);
        frame.getContentPane().add(productImage9);
        productImage9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 frame.dispose();
                 ProductDetailGui frame =  new ProductDetailGui(productId); // Open the product details page 
    		frame.setVisible(true);
            }
        });
        
        JLabel lblIpadProInch = new JLabel("Ipad Pro 12.9-inch");
        lblIpadProInch.setFont(new Font("Serif", Font.PLAIN, 14));
        lblIpadProInch.setBounds(880, 288, 130, 21);
        frame.getContentPane().add(lblIpadProInch);
        
        
        JLabel lblAppleWatchSe = new JLabel("Apple Watch SE");
        lblAppleWatchSe.setFont(new Font("Serif", Font.PLAIN, 14));
        lblAppleWatchSe.setBounds(880, 481, 180, 21);
        frame.getContentPane().add(lblAppleWatchSe);
        
        ImageIcon imageIcon10 = new ImageIcon(product.getProductImageURL());
        JButton productImage10 = new JButton(imageIcon10);
        productImage10.setBounds(880, 354, 150, 117);
        frame.getContentPane().add(productImage10);
        productImage10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 frame.dispose();
                 ProductDetailGui frame =  new ProductDetailGui(productId); // Open the product details page 
    				frame.setVisible(true);
            }
        });
        
        
        JLabel lblPrice1 = new JLabel("RM 3199");
        lblPrice1.setFont(new Font("Serif", Font.PLAIN, 12));
        lblPrice1.setBounds(92, 321, 63, 21);
        frame.getContentPane().add(lblPrice1);

        JLabel lblPrice2 = new JLabel("RM 4299");
        lblPrice2.setFont(new Font("Serif", Font.PLAIN, 12));
        lblPrice2.setBounds(282, 321, 63, 21);
        frame.getContentPane().add(lblPrice2);

        JLabel lblPrice3 = new JLabel("RM 5699");
        lblPrice3.setFont(new Font("Serif", Font.PLAIN, 12));
        lblPrice3.setBounds(467, 319, 63, 21);
        frame.getContentPane().add(lblPrice3);

        JLabel lblPrice4 = new JLabel("RM 2999");
        lblPrice4.setFont(new Font("Serif", Font.PLAIN, 12));
        lblPrice4.setBounds(658, 319, 63, 21);
        frame.getContentPane().add(lblPrice4);

        JLabel lblRm8 = new JLabel("RM 2999");
        lblRm8.setFont(new Font("Serif", Font.PLAIN, 12));
        lblRm8.setBounds(658, 512, 63, 21);
        frame.getContentPane().add(lblRm8);

        JLabel lblPrice7 = new JLabel("RM 5699");
        lblPrice7.setFont(new Font("Serif", Font.PLAIN, 12));
        lblPrice7.setBounds(467, 512, 63, 21);
        frame.getContentPane().add(lblPrice7);

        JLabel lblPrice6 = new JLabel("RM 2999");
        lblPrice6.setFont(new Font("Serif", Font.PLAIN, 12));
        lblPrice6.setBounds(282, 512, 63, 21);
        frame.getContentPane().add(lblPrice6);

        JLabel lblPrice5 = new JLabel("RM 5699");
        lblPrice5.setFont(new Font("Serif", Font.PLAIN, 12));
        lblPrice5.setBounds(91, 512, 63, 21);
        frame.getContentPane().add(lblPrice5);
        
      
        JLabel lblRm9 = new JLabel("RM 5299");
        lblRm9.setFont(new Font("Serif", Font.PLAIN, 12));
        lblRm9.setBounds(880, 319, 63, 21);
        frame.getContentPane().add(lblRm9);

        
        JLabel lblRm10 = new JLabel("RM 1199");
        lblRm10.setFont(new Font("Serif", Font.PLAIN, 12));
        lblRm10.setBounds(880, 512, 63, 21);
        frame.getContentPane().add(lblRm10);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ProductGui();  // Create and show the frame
            }
        });
    }
}
