import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class FanForm extends JFrame {

    // GUI Components
    private JTextField idField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField favoriteTeamField;

    private JButton displayButton;
    private JButton updateButton;

    // Database information
    private final String URL =
            "jdbc:mysql://localhost:3306/databasedb";

    private final String USER = "student1";
    private final String PASSWORD = "pass";

    public FanForm() {

        setTitle("Fan Database");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        // Labels and text fields
        add(new JLabel("ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        add(firstNameField);

        add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        add(lastNameField);

        add(new JLabel("Favorite Team:"));
        favoriteTeamField = new JTextField();
        add(favoriteTeamField);

        // Buttons
        displayButton = new JButton("Display");
        updateButton = new JButton("Update");

        add(displayButton);
        add(updateButton);

        // Button actions
        displayButton.addActionListener(e -> displayRecord());

        updateButton.addActionListener(e -> updateRecord());

        setVisible(true);
    }

    // Display record method
    private void displayRecord() {

        try {
            Connection conn = DriverManager.getConnection(
                    URL, USER, PASSWORD);

            String sql = "SELECT * FROM fans WHERE ID = ?";

            PreparedStatement pstmt =
                    conn.prepareStatement(sql);

            pstmt.setInt(1,
                    Integer.parseInt(idField.getText()));

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                firstNameField.setText(
                        rs.getString("firstname"));

                lastNameField.setText(
                        rs.getString("lastname"));

                favoriteTeamField.setText(
                        rs.getString("favoriteteam"));

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Record not found."
                );
            }

            conn.close();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error: " + ex.getMessage()
            );
        }
    }

    // Update record method
    private void updateRecord() {

        try {

            Connection conn = DriverManager.getConnection(
                    URL, USER, PASSWORD);

            String sql =
                    "UPDATE fans SET firstname=?, lastname=?, favoriteteam=? WHERE ID=?";

            PreparedStatement pstmt =
                    conn.prepareStatement(sql);

            pstmt.setString(1,
                    firstNameField.getText());

            pstmt.setString(2,
                    lastNameField.getText());

            pstmt.setString(3,
                    favoriteTeamField.getText());

            pstmt.setInt(4,
                    Integer.parseInt(idField.getText()));

            int rows = pstmt.executeUpdate();

            if (rows > 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Record updated successfully."
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Update failed."
                );
            }

            conn.close();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error: " + ex.getMessage()
            );
        }
    }

    // Main method
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new FanForm();
        });
    }
}