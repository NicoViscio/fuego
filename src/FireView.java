import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

class FireView extends JPanel {
    private FireModel model;
    private BufferedImage fireImage;

    public FireView(FireModel model, int width, int height) {
        this.model = model;
        this.fireImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        setPreferredSize(new Dimension(width, height));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Aquí se actualiza la imagen
        for (int y = 0; y < fireImage.getHeight(); y++) {
            for (int x = 0; x < fireImage.getWidth(); x++) {
                fireImage.setRGB(x, y, model.getColor(x, y));
            }
        }
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(fireImage, 0, 0, getWidth(), getHeight(), null);
    }
}