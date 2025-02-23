package org.example.processoremulatorfx.TypeWagon;

public class Locomotive implements TypeWagon{
    private int maxWagons; // Максимальное количество вагонов, которые может сдвинуть тягач

    public Locomotive(int maxWagons) {
        this.maxWagons = maxWagons;
    }

    public int getMaxWagons() {
        return maxWagons;
    }

    @Override
    public String getType() {
        return "Locomotive";
    }

    @Override
    public String getProperty() {
        return "" + maxWagons;
    }
}
