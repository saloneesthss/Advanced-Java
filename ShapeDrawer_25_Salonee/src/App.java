import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame implements ActionListener {
    JButton circleBtn, squareBtn, triangleBtn;
    String shape = "";
    public App() {
        setTitle("Shape Drawer");
        setSize(500, 500);
        setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        circleBtn = new JButton("Circle");
        squareBtn = new JButton("Square");
        triangleBtn = new JButton("Triangle");
        circleBtn.addActionListener(this);
        squareBtn.addActionListener(this);
        triangleBtn.addActionListener(this);
        buttonPanel.add(circleBtn);
        buttonPanel.add(squareBtn);
        buttonPanel.add(triangleBtn);
        add(buttonPanel, BorderLayout.NORTH);
        setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        new App();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == circleBtn) {
            shape = "CIRCLE";
        } else if (e.getSource() == squareBtn) {
            shape = "SQUARE";
        } else if (e.getSource() == triangleBtn) {
            shape = "TRIANGLE";
        }
        repaint(); 
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int width = getWidth();
        int height = getHeight();
        int size = 150;
        int x = (width - size) / 2;
        int y = (height - size) / 2;
        if (shape.equals("CIRCLE")) {
            g.setColor(Color.RED);
            g.fillOval(x, y, size, size);
        } else if (shape.equals("SQUARE")) {
            g.setColor(Color.BLUE);
            g.fillRect(x, y, size, size);
        } else if (shape.equals("TRIANGLE")) {
            g.setColor(Color.GREEN);
            int[] xPoints = {width / 2, x, x + size};
            int[] yPoints = {y, y + size, y + size};
            g.fillPolygon(xPoints, yPoints, 3);
        }
    }
}
