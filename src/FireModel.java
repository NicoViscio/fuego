class FireModel {
    private FireHeatMap heatMap;
    private FireColorPalette colorPalette;

    public FireModel(int width, int height) {
        this.heatMap = new FireHeatMap(width, height);
        this.colorPalette = new FireColorPalette();
    }

    public void updateFire() {
        heatMap.updateFire();
    }

    public int getColorAt(int x, int y) {
        int heat = heatMap.getHeatAt(x, y);
        return colorPalette.getColor(heat);
    }
}

