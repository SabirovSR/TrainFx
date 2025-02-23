package org.example.processoremulatorfx;

// Класс описывающий товары
public class Cargo {
    private String name; // Название товара

    public Cargo(String name) throws Exception {
        if (name.isEmpty()) throw new Exception("The cargo cannot be empty");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
