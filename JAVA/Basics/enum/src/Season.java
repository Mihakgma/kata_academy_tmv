public enum Season {
    WINTER(-30), SPRING(5), SUMMER(25), AUTUMN(10);

    private int temperature;

    Season(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }
}
