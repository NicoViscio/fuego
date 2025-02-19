import javax.swing.*;
import java.awt.*;

public class FireMain extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Fuego Jumi");
        frame.setLayout(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 500, 500);

        BackgroundPanel backgroundPanel = new BackgroundPanel("foto1.jpg");
        backgroundPanel.setBounds(0, 0, 500, 500);

        FireController fire1 = new FireController(300, 400);
        JPanel firePanel = fire1.getView();

        // Pos Fuego
        firePanel.setBounds(145, -107, 205, 400);

        layeredPane.add(backgroundPanel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(firePanel, JLayeredPane.PALETTE_LAYER);

        frame.add(layeredPane);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}