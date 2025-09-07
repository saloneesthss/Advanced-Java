import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App implements ActionListener {
    JButton redButton;
    JButton blueButton;
    JButton greenButton;
    public App() {
        JFrame f = new JFrame("Color Button Changer");
        redButton = new JButton("RED");
        blueButton = new JButton("BLUE");
        greenButton = new JButton("GREEN");
        redButton.addActionListener(this);
        blueButton.addActionListener(this);
        greenButton.addActionListener(this);
        f.add(redButton);
        f.add(blueButton);
        f.add(greenButton);
        f.setSize(300, 200);
        f.setLayout(new FlowLayout());
        f.setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        new App();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == redButton) {
            redButton.setBackground(Color.RED);
            redButton.setOpaque(true);
            redButton.setForeground(Color.WHITE);
        } else if (e.getSource() == blueButton) {
            blueButton.setBackground(Color.BLUE);
            blueButton.setOpaque(true);
            blueButton.setForeground(Color.WHITE);
        } else if (e.getSource() == greenButton) {
            greenButton.setBackground(Color.GREEN);
            greenButton.setOpaque(true);
            greenButton.setForeground(Color.WHITE);
        } 
    }
}
