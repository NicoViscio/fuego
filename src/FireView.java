import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


class FireView extends JPanel {
    private final FireModel model;
    private final BufferedImage fireImage;
    private final int width;
    private final int height;

    public FireView(FireModel model, int width, int height) {
        this.model = model;
        this.width = width;
        this.height = height;
        this.fireImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        setOpaque(false);
        setPreferredSize(new Dimension(width, height));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        updateFireImage();
        g.drawImage(fireImage, 0, 0, getWidth(), getHeight(), null);
    }

    private void updateFireImage() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                fireImage.setRGB(x, y, model.getColor(x, y));
            }
        }
    }
}