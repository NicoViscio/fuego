class FireColorPalette {
    private int[] colorPalette;

    public FireColorPalette() {
        initializePalette();
    }

    private void initializePalette() {

        int paletteSize = 256;

        colorPalette = new int[paletteSize];
        for (int i = 0; i < paletteSize; i++) {

            int alpha;
            if (i < 32) {
                alpha = 0;
            } else {
                alpha = Math.min(255, i * 4);
            }

            int red = Math.min(255, i * 3);
            int blue = i / 3;

            colorPalette[i] = (alpha << 24) | (red << 16) | (i << 8) | blue;
        }
    }

    public int getColor(int heat) {
        return colorPalette[heat];
    }
}