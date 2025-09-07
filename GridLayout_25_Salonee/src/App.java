import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App implements ActionListener {
    JTextField userField;
    JPasswordField pwdField;
    JLabel msgLabel;
    public App() {
        JFrame f = new JFrame("Login Form");
        JLabel userLabel = new JLabel("Username:");
        userField = new JTextField();
        f.add(userLabel);
        f.add(userField);
        JLabel pwdLabel = new JLabel("Password:");
        pwdField = new JPasswordField();
        f.add(pwdLabel);
        f.add(pwdField);
        JButton loginBtn = new JButton("Login");
        f.add(loginBtn);
        loginBtn.addActionListener(this);
        msgLabel = new JLabel("");
        f.add(msgLabel);

        f.setSize(300, 200);
        f.setLayout(new GridLayout(4, 2, 10, 10));
        f.setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        new App();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = userField.getText();
        String password = new String(pwdField.getPassword());
        if (username.equals("admin") && password.equals("1234")) {
            msgLabel.setText("Login Successful!");
        } else {
            msgLabel.setText("Invalid Credintials!");
        }
    }
}
