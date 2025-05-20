import javax.swing.*;
import java.awt.Color;

public class AuthFrame extends JFrame {
    private JButton loginBtn, signupBtn;
    public AuthFrame() {
        setTitle("Login / Sign Up");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(50, 30, 80, 30);
        loginBtn.addActionListener(e -> new LoginFrame());
        loginBtn.setBackground(Color.MAGENTA);
        loginBtn.setForeground(Color.WHITE);

        signupBtn = new JButton("Sign Up");
        signupBtn.setBounds(150, 30, 80, 30);
        signupBtn.addActionListener(e -> new SignupFrame());
        signupBtn.setBackground(Color.MAGENTA);
        signupBtn.setForeground(Color.WHITE);
        add(loginBtn);
        add(signupBtn);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AuthFrame();
    }
}
