import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    public LoginFrame() {
        setTitle("Login");
        setSize(300, 250);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel idLabel = new JLabel("User ID:");
        idLabel.setBounds(20, 20, 80, 25);
        idLabel.setForeground(Color.MAGENTA);
        JTextField idField = new JTextField();
        idField.setBounds(100, 20, 150, 25);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(20, 60, 80, 25);
        passLabel.setForeground(Color.MAGENTA);
        JPasswordField passField = new JPasswordField();
        passField.setBounds(100, 60, 150, 25);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(100, 100, 80, 30);
        loginBtn.setBackground(Color.MAGENTA);
        loginBtn.setForeground(Color.WHITE);

        loginBtn.addActionListener(e -> {
            String id = idField.getText();
            String pass = new String(passField.getPassword());
            UserManager manager = new UserManager();
            User user = manager.login(id, pass);
            if (user != null) {
                JOptionPane.showMessageDialog(this, "Welcome, " + user.getName());
                dispose();
            }
            else {
                JOptionPane.showMessageDialog(this, "Invalid credentials.");
            }
        });

        JButton deleteBtn = new JButton("Delete Account");
        deleteBtn.setBounds(100, 140, 150, 30);
        deleteBtn.setBackground(Color.MAGENTA);
        deleteBtn.setForeground(Color.WHITE);

        deleteBtn.addActionListener(e -> {
            String id = idField.getText();
            String pass = new String(passField.getPassword());
            UserManager manager = new UserManager();
            boolean success = manager.deleteAccount(id, pass);
            if (success) {
                JOptionPane.showMessageDialog(this, "Account deleted successfully.");
                dispose();
            }
            else {
                JOptionPane.showMessageDialog(this, "Invalid credentials or account not found.");
            }
        });
        add(idLabel);
        add(idField);
        add(passLabel);
        add(passField);
        add(loginBtn);
        add(deleteBtn);
        setVisible(true);
    }
    public static void main(String[] args) {
        new LoginFrame();
    }
}
