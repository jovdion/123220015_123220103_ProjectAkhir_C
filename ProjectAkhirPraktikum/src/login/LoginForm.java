/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/**
 *
 * @author Nathaleon
 */
import Koneksi.connector;
import View.MainView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginForm extends JFrame {
    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginForm() {
        setTitle("Login Form");
        setSize(300, 170);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(10, 10, 80, 25);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(100, 10, 160, 25);
        add(usernameField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 40, 80, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 40, 160, 25);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(100, 80, 80, 25);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (validateLogin(username, password)) {
                    dispose(); // Close login form
                    MainView v = new MainView();
                    v.setVisible(true);
                    v.setLocationRelativeTo(null);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            }
        });
        add(loginButton);
    }

    private boolean validateLogin(String username, String password) {
        Connection con = connector.connection();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = con.prepareStatement("SELECT * FROM employees WHERE FirstName=? AND Extension=?");
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            return rs.next(); // If there is a result, login is valid
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

   
}

