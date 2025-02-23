package org.example.processoremulatorfx.TypeWagon;

import org.example.processoremulatorfx.Cargo;

public class Wagon implements TypeWagon{
    private Cargo cargo; // Товар в вагоне

    public Wagon(Cargo cargo) {
        this.cargo = cargo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    @Override
    public String getType() {
        return "Wagon";
    }

    @Override
    public String getProperty() {
        return cargo.toString();
    }
}
