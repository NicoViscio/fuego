class FireHeatMap {
    private int width;
    private int height;
    private int[][] heatMap;

    public FireHeatMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.heatMap = new int[height][width];
    }

    public void updateFire() {
        // Generar base del fuego
        for (int x = 0; x < width; x++) {
            if (Math.random() < 0.4) {
                heatMap[height-1][x] = 255 - (int)(Math.random() * 30);
            } else {
                heatMap[height-1][x] = 0;
            }
        }

        // Propagar el fuego hacia arriba
        for (int y = 0; y < height-1; y++) {
            for (int x = 0; x < width; x++) {
                int sum = 0;
                int count = 0;

                for (int dx = -2; dx <= 2; dx++) {
                    int newX = x + dx;
                    if (newX >= 0 && newX < width) {
                        int weight = 3 - Math.abs(dx);
                        sum += heatMap[y+1][newX] * weight;
                        count += weight;
                    }
                }

                int newHeat = sum / count;
                newHeat = Math.max(0, newHeat - (int)(Math.random() * 3));
                heatMap[y][x] = Math.min(255, newHeat);
            }
        }
    }

    public int getHeatAt(int x, int y) {
        return heatMap[y][x];
    }
}