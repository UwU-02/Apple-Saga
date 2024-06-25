package view;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

import database.MyDatabase;

public class ReviewGui {

    private JFrame frame;
    private JTable reviewTable;
    private Connection connection;

    public ReviewGui(Connection connection) {
        this.connection = connection;
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel reviewTableLabel = new JLabel("Review Table");
        reviewTableLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        reviewTableLabel.setHorizontalAlignment(SwingConstants.CENTER);
        reviewTableLabel.setBounds(327, 72, 122, 13);
        frame.getContentPane().add(reviewTableLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(76, 112, 627, 244);
        frame.getContentPane().add(scrollPane);

        reviewTable = new JTable();
        scrollPane.setViewportView(reviewTable);

        JButton reviewBtn = new JButton("View");
        reviewBtn.setBounds(595, 384, 85, 21);
        frame.getContentPane().add(reviewBtn);

        reviewBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewReviews();
            }
        });

        frame.setVisible(true);
    }

    private void viewReviews() {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM review"; // Adjust the table name and columns as needed
            ResultSet rs = stmt.executeQuery(query);

            // Use metadata to dynamically set column names
            DefaultTableModel model = new DefaultTableModel();
            int columnCount = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(rs.getMetaData().getColumnName(i));
            }

            // Add rows to the table model
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                model.addRow(row);
            }

            reviewTable.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Connection connection = MyDatabase.doConnection();
            new ReviewGui(connection);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
