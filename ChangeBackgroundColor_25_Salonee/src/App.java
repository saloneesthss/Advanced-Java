import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame implements ItemListener {
    JRadioButton redButton, greenButton, blueButton;
    ButtonGroup bg;
    public App() {
        setTitle("Color Changer App");
        setSize(400, 300);
        setLayout(new FlowLayout());
        redButton = new JRadioButton("Red");
        greenButton = new JRadioButton("Green");
        blueButton = new JRadioButton("Blue");
        bg = new ButtonGroup();
        bg.add(redButton);
        bg.add(greenButton);
        bg.add(blueButton);
        redButton.addItemListener(this);
        greenButton.addItemListener(this);
        blueButton.addItemListener(this);
        add(redButton);
        add(greenButton);
        add(blueButton);
        setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        new App();
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (redButton.isSelected()) {
            getContentPane().setBackground(Color.RED);
        } else if (greenButton.isSelected()) {
            getContentPane().setBackground(Color.GREEN);
        } else if (blueButton.isSelected()) {
            getContentPane().setBackground(Color.BLUE);
        }
    }
}
