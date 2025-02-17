import javax.swing.*;

public class FireMain extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Pixel Fire");
            FireController controller = new FireController(300, 400);

            frame.add(controller.getView());
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setVisible(true);
        });
    }
}