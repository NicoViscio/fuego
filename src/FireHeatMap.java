class FireHeatMap {
    private int width;
    private int height;
    private int[][] heatMap;
    private static final int maxHeat = 255;
    private double porcentaje = 0.15;

    public FireHeatMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.heatMap = new int[height][width];
    }

    public void updateFire() {
        generateBase();
        propagateFire();
    }

    private void generateBase() {
        int y = height -1;
        for (int x = 0; x < width; x++) {
            if (Math.random() < porcentaje) {
                heatMap[y][x] = 255 - (int)(Math.random() * 30);
            } else {
                heatMap[y][x] = 0;
            }
        }
    }

    private void propagateFire() {
        for (int y = 0; y < height-1; y++) {
            for (int x = 0; x < width; x++) {
                int heat = calculateAverageHeat(x, y + 1);
                heat = Math.max(0, heat - (int)(Math.random() * 2));
                heatMap[y][x] = Math.min(maxHeat, heat);
            }
        }
    }

    private int calculateAverageHeat(int x, int y) {
        int sum = 0;
        int count = 0;

        // 3 pixeles para calcular la media y propagar
        for (int dx = -1; dx <= 1; dx++) {
            int newX = x + dx;
            if (newX >= 0 && newX < width) {
                sum += heatMap[y][newX];
                count++;
            }
        }

        if (count > 0) {
            return sum / count;
        } else {
            return 0;
        }

    }

    public int getMap(int x, int y) {
        return heatMap[y][x];
    }
}