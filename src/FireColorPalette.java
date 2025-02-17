class FireColorPalette {
    private int[] colorPalette;

    public FireColorPalette() {
        ColorPalette();
    }

    private void ColorPalette() {
        colorPalette = new int[256];
        for (int i = 0; i < 256; i++) {

            int alpha;
            if (i < 32) {  // Muy poca intensidad se verá completamente transparente
                alpha = 0;
            } else if (i < 64) {  // Esto es intensidad intermedia
                alpha = (i - 32) * 4;
            } else {  // Mas intensidad, mas color
                alpha = Math.min(255, i * 2);
            }

            // Esto añade más brillo a los colores.
            int red = Math.min(255, i * 3);
            int green = Math.min(255, (int)(i * 1.5));
            int blue = i / 4;

            colorPalette[i] = (alpha << 24) | (red << 16) | (green << 8) | blue;
        }
    }

    public int getColor(int heat) {
        return colorPalette[heat];
    }
}