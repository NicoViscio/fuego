import javax.swing.*;

public class FireMain extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Fuego Jumi");
        frame.setLayout(null);

        FireController fire1 = new FireController(300, 400);

        JPanel view1 = fire1.getView();

        // Pos x, y ancho y alto del fuego
        view1.setBounds(100, 0, 300, 400);

        frame.add(view1);

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}