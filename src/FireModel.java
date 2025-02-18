class FireModel {
    private final FireHeatMap heatMap;
    private final FireColorPalette colorPalette;

    public FireModel(int width, int height) {
        this.heatMap = new FireHeatMap(width, height);
        this.colorPalette = new FireColorPalette();
    }

    public void updateFire() {
        heatMap.updateFire();
    }

    public int getColor(int x, int y) {
        int heat = heatMap.getMap(x, y);
        return colorPalette.getColor(heat);
    }
}

