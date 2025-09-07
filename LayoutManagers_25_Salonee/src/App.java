import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame implements ActionListener {
    JTextField userField;
    JPasswordField pwdField;
    JCheckBox rememberMe;
    JButton loginBtn, resetBtn, exitBtn;
    public App() {
        JFrame f = new JFrame("Layout Manager");
        f.setSize(400, 300);
        f.setLayout(new BorderLayout(10, 10));
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        northPanel.add(new JLabel("Name"));
        northPanel.add(new JLabel("Roll No"));
        northPanel.add(new JLabel("Class"));
        f.add(northPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        centerPanel.add(new JLabel("Username:"));
        userField = new JTextField();
        centerPanel.add(userField);
        centerPanel.add(new JLabel("Password:"));
        pwdField = new JPasswordField();
        centerPanel.add(pwdField);
        rememberMe = new JCheckBox("Remember Me");
        centerPanel.add(rememberMe);
        loginBtn = new JButton("Login");
        loginBtn.addActionListener(this);
        centerPanel.add(loginBtn);
        f.add(centerPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        resetBtn = new JButton("Reset");
        exitBtn = new JButton("Exit");
        resetBtn.addActionListener(this);
        exitBtn.addActionListener(this);
        southPanel.add(resetBtn);
        southPanel.add(exitBtn);
        f.add(southPanel, BorderLayout.SOUTH);
        f.setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        new App();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginBtn) {
            String username = userField.getText();
            JOptionPane.showMessageDialog(this, "Username entered: " + username);
        } else if (e.getSource() == resetBtn) {
            userField.setText("");
            pwdField.setText("");
            rememberMe.setSelected(false);
        } else if (e.getSource() == exitBtn) {
            System.exit(0);
        }
    }
}
