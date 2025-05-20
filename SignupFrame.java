import javax.swing.*;
import java.awt.*;

public class SignupFrame extends JFrame {
    public SignupFrame() {
        setTitle("Sign Up");
        setSize(300, 250);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 40, 80, 25);
        nameLabel.setForeground(Color.MAGENTA);

        JTextField nameField = new JTextField();
        nameField.setBounds(100, 40, 150, 25);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(20, 80, 80, 25);
        passLabel.setForeground(Color.MAGENTA);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(100, 80, 150, 25);

        JButton signupBtn = new JButton("Sign Up");
        signupBtn.setBounds(100, 130, 100, 30);
        signupBtn.setBackground(Color.MAGENTA);
        signupBtn.setForeground(Color.WHITE);
        signupBtn.addActionListener(e -> {
            String name = nameField.getText();
            String pass = new String(passField.getPassword());
            UserManager manager = new UserManager();
            int newUserId = manager.generateNewUserId();
            boolean success = manager.signUp(name, pass);

            if (success) {
                JOptionPane.showMessageDialog(this, "Signup successful! Your ID is: " + newUserId);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Signup failed.");
            }
        });
        add(nameLabel); add(nameField);
        add(passLabel); add(passField);
        add(signupBtn);

        setVisible(true);
    }
}
