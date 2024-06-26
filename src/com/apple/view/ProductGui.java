package view;

import javax.swing.*;

import model.Product;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductGui {
    private JFrame frame;
    private JTextField txtSearch;

    public ProductGui() {
        frame = new JFrame();
        frame.setBounds(100, 100, 960, 600);
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
        filterBttn.setBounds(712, 95, 85, 21);
        frame.getContentPane().add(filterBttn);

        filterBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the current frame
                new FilterGui(); // Open the filter page
            }
        });

        txtSearch = new JTextField();
        txtSearch.setText("SEARCH");
        txtSearch.setBounds(526, 96, 150, 19);
        frame.getContentPane().add(txtSearch);
        txtSearch.setColumns(10);

        Product product = new Product();
        ImageIcon imageIcon1 = new ImageIcon(product.getProductImageURL());
        JLabel productImage1 = new JLabel(imageIcon1);
        productImage1.setBounds(92, 161, 150, 117);
        frame.getContentPane().add(productImage1);

        JLabel lblIphone13 = new JLabel("Iphone 13");
        lblIphone13.setFont(new Font("Serif", Font.PLAIN, 14));
        lblIphone13.setBounds(92, 288, 100, 21);
        frame.getContentPane().add(lblIphone13);

        ImageIcon imageIcon2 = new ImageIcon(product.getProductImageURL());
        JLabel productImage2 = new JLabel(imageIcon2);
        productImage2.setBounds(282, 161, 150, 117);
        frame.getContentPane().add(productImage2);

        JLabel lblIphone14 = new JLabel("Iphone 14");
        lblIphone14.setFont(new Font("Serif", Font.PLAIN, 14));
        lblIphone14.setBounds(282, 288, 100, 21);
        frame.getContentPane().add(lblIphone14);

        ImageIcon imageIcon3 = new ImageIcon(product.getProductImageURL());
        JLabel productImage3 = new JLabel(imageIcon3);
        productImage3.setBounds(467, 161, 150, 117);
        frame.getContentPane().add(productImage3);

        JLabel lblIphone15 = new JLabel("Iphone 15");
        lblIphone15.setFont(new Font("Serif", Font.PLAIN, 14));
        lblIphone15.setBounds(467, 288, 100, 21);
        frame.getContentPane().add(lblIphone15);

        ImageIcon imageIcon4 = new ImageIcon(product.getProductImageURL());
        JLabel productImage4 = new JLabel(imageIcon4);
        productImage4.setIcon(imageIcon4);
        productImage4.setBounds(658, 161, 150, 117);
        frame.getContentPane().add(productImage4);

        JLabel lblIpadAirinchi = new JLabel("Ipad Air 11-inch");
        lblIpadAirinchi.setFont(new Font("Serif", Font.PLAIN, 14));
        lblIpadAirinchi.setBounds(658, 288, 130, 21);
        frame.getContentPane().add(lblIpadAirinchi);

        ImageIcon imageIcon5 = new ImageIcon(product.getProductImageURL());
        JLabel productImage5 = new JLabel(imageIcon5);
        productImage5.setBounds(91, 354, 150, 117);
        frame.getContentPane().add(productImage5);

        JLabel lblIpadPro = new JLabel("Ipad Pro");
        lblIpadPro.setFont(new Font("Serif", Font.PLAIN, 14));
        lblIpadPro.setBounds(91, 481, 100, 21);
        frame.getContentPane().add(lblIpadPro);

        ImageIcon imageIcon6 = new ImageIcon(product.getProductImageURL());
        JLabel productImage6 = new JLabel(imageIcon6);
        productImage6.setBounds(282, 354, 150, 117);
        frame.getContentPane().add(productImage6);

        JLabel lblAirpodsPro = new JLabel("Airpods Pro");
        lblAirpodsPro.setFont(new Font("Serif", Font.PLAIN, 14));
        lblAirpodsPro.setBounds(282, 481, 100, 21);
        frame.getContentPane().add(lblAirpodsPro);

        ImageIcon imageIcon7 = new ImageIcon(product.getProductImageURL());
        JLabel productImage7 = new JLabel(imageIcon7);
        productImage7.setBounds(467, 354, 150, 117);
        frame.getContentPane().add(productImage7);

        JLabel lblAirpods = new JLabel("Airpods (3rd Gen)");
        lblAirpods.setFont(new Font("Serif", Font.PLAIN, 14));
        lblAirpods.setBounds(467, 481, 130, 21);
        frame.getContentPane().add(lblAirpods);

        ImageIcon imageIcon8 = new ImageIcon(product.getProductImageURL());
        JLabel productImage8 = new JLabel(imageIcon8);
        productImage8.setBounds(658, 354, 150, 117);
        frame.getContentPane().add(productImage8);

        JLabel lblAppleWatchSeries9 = new JLabel("Apple Watch Series 9");
        lblAppleWatchSeries9.setFont(new Font("Serif", Font.PLAIN, 14));
        lblAppleWatchSeries9.setBounds(658, 481, 180, 21);
        frame.getContentPane().add(lblAppleWatchSeries9);

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

