package org.example.trainfx.TypeWagon;

import org.example.trainfx.Cargo;

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
