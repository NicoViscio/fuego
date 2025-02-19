class FireHeatMap {
    private final int width;
    private final int height;
    private final int[][] heatMap;
    private static final int MAX_HEAT = 1023;
    private static final double percentage = 0.40;

    public FireHeatMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.heatMap = new int[height][width];
    }

    public void updateFire() {
        generateBase();
        temperatureEvolve();
    }

    private void generateBase() {
        int y = height - 1;
        for (int x = 0; x < width; x++) {
            if (Math.random() < percentage) {
                heatMap[y][x] = MAX_HEAT;
            } else {
                heatMap[y][x] = 0;
            }
        }
    }

    private void temperatureEvolve() {
        for (int actualRow = height - 2; actualRow > 4; actualRow--) {
            int iniRow = width * actualRow;
            int iniBelowRow = iniRow + width;

            for (int actualCol = 2; actualCol < width - 2; actualCol++) {
                int y = iniRow / width;
                int temperature = getTemperature(iniBelowRow, actualCol, y);

                if (temperature < 0) {
                    temperature = 0;
                } else if (temperature > MAX_HEAT) {
                    temperature = MAX_HEAT;
                }

                heatMap[y][actualCol] = temperature;
            }
        }
    }

    private int getTemperature(int iniBelowRow, int x, int y) {
        int yBelow = iniBelowRow / width;

        double newTemp = (
                (getPixelTemp(x - 1, y) * 1.2D) +
                        (getPixelTemp(x, y) * 1.5D) +
                        (getPixelTemp(x + 1, y) * 1.2D) +
                        (getPixelTemp(x - 1, yBelow) * 0.7D) +
                        (getPixelTemp(x, yBelow) * 0.7D) +
                        (getPixelTemp(x + 1, yBelow) * 0.7D)
        ) / 5.98569;

        return (int) (newTemp - 1.8D);
    }

    private int getPixelTemp(int x, int y) {
        // Aseguramos que no nos salimos de los límites del array
        if (x < 0 || x >= width || y < 0 || y >= height) {
            return 0;
        }
        return heatMap[y][x];
    }

    public int getMap(int x, int y) {
        return heatMap[y][x];
    }
}