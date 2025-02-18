import java.awt.*;

class FireColorPalette {
    private int[] colorPalette;

    public FireColorPalette() {
        initializePalette();
    }

    private void initializePalette() {
        colorPalette = new int[1024]; // Aumentado a 1024 para coincidir con MAX_HEAT

        // Color negro para valores bajos
        addColorRange(0, 220, new Color(0, 0, 0, 0), new Color(0, 0, 0, 100));

        // Transición a rojo
        addColorRange(220, 240, new Color(0, 0, 0, 100), new Color(155, 0, 0, 110));

        // Transición a blanco
        addColorRange(240, 290, new Color(155, 0, 0, 110), new Color(200, 100, 0, 180));
        addColorRange(290, 450, new Color(200, 100, 0, 180), new Color(235, 235, 40, 250));
        addColorRange(450, 520, new Color(235, 235, 40, 250), new Color(255, 255, 200, 255));

        // Blanco puro para el máximo calor
        for (int i = 520; i < 1024; i++) {
            colorPalette[i] = new Color(255, 255, 255, 255).getRGB();
        }
    }

    private void addColorRange(int start, int end, Color c1, Color c2) {
        for (int i = start; i < end; i++) {
            float ratio = (float)(i - start) / (end - start);
            int r = (int)(c1.getRed() + ratio * (c2.getRed() - c1.getRed()));
            int g = (int)(c1.getGreen() + ratio * (c2.getGreen() - c1.getGreen()));
            int b = (int)(c1.getBlue() + ratio * (c2.getBlue() - c1.getBlue()));
            int a = (int)(c1.getAlpha() + ratio * (c2.getAlpha() - c1.getAlpha()));
            colorPalette[i] = new Color(r, g, b, a).getRGB();
        }
    }

    public int getColor(int heat) {
        return colorPalette[Math.min(heat, colorPalette.length - 1)];
    }
}