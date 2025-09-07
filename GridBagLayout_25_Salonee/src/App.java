import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App implements ActionListener {
    JTextField userField;
    JPasswordField pwdField;
    JLabel msgLabel;
    public App() {
        JFrame f = new JFrame("Login Form");
        f.setSize(400, 300);
        f.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        JLabel userLabel = new JLabel("Username:");
        f.add(userLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        userField = new JTextField(15);
        f.add(userField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        JLabel pwdLabel = new JLabel("Password:");
        f.add(pwdLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        pwdField = new JPasswordField(15);
        f.add(pwdField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton loginBtn = new JButton("Login");
        f.add(loginBtn, gbc);
        loginBtn.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 3;
        msgLabel = new JLabel("");
        f.add(msgLabel, gbc);
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
