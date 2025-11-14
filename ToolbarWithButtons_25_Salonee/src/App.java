import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame implements ActionListener {
    JButton btnNew, btnLogin, btnLogout;
    public App() {
        setTitle("Toolbar with buttons");
        setSize(400, 300);
        JToolBar toolbar = new JToolBar();
        btnNew = new JButton("New");
        btnLogin = new JButton("Login");
        btnLogout = new JButton("Logout");
        btnNew.setToolTipText("New File");
        btnLogin.setToolTipText("Login");
        btnLogout.setToolTipText("Logout");
        btnNew.addActionListener(this);
        btnLogin.addActionListener(this);
        btnLogout.addActionListener(this);
        toolbar.add(btnNew);
        toolbar.add(btnLogin);
        toolbar.add(btnLogout);
        add(toolbar, BorderLayout.NORTH);
        setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        new App();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNew) {
            JOptionPane.showMessageDialog(this, "New File Created");
        } else if (e.getSource() == btnLogin) {
            JOptionPane.showConfirmDialog(this, "Login Successful");
        } else if (e.getSource() == btnLogout) {
            JOptionPane.showMessageDialog(this, "Logged Out");
        }
    }
}
