import javax.swing.*;

public class FireMain extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Fuego Jumi");
        FireController controller = new FireController(300, 400);

        frame.add(controller.getView());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}