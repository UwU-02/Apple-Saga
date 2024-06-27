package view;

import javax.swing.*;

import Controller.ProductCategoryController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import model.ProductCategory;

public class FilterGui extends JFrame {
    private JTextField txtCategoryName;
    private JButton btnSearch;
    private JList<String> listCategories;
    private DefaultListModel<String> listModel;

    private ProductCategoryController controller;

    public FilterGui() {
        // Initialize the controller and connect to the database
        controller = new ProductCategoryController();
        controller.connectToDatabase();

        // Setup the frame
        setTitle("Product Category Filter");
        setSize(900, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        // Create the top panel with input and button
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        JLabel lblCategoryName = new JLabel("Category Name:");
        txtCategoryName = new JTextField(15);
        btnSearch = new JButton("Search");

        topPanel.add(lblCategoryName);
        topPanel.add(txtCategoryName);
        topPanel.add(btnSearch);

        // Create the list to display categories
        listModel = new DefaultListModel<>();
        listCategories = new JList<>(listModel);

        // Add components to the frame
        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(new JScrollPane(listCategories), BorderLayout.CENTER);

        // Add button action listener
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String categoryName = txtCategoryName.getText();
             //   List<ProductCategory> categories = controller.getProductCategoryById(categoryName);
         //       updateCategoryList(categories);
            }
        });

        setVisible(true);
    }

    // Update the JList with new category data
    private void updateCategoryList(List<ProductCategory> categories) {
        listModel.clear();
        for (ProductCategory category : categories) {
            listModel.addElement(category.getCategoryName());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FilterGui();
            }
        });
    }
}