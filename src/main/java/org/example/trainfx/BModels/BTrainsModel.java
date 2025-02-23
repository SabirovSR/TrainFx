package org.example.trainfx.BModels;

import org.example.trainfx.Models.TrainsModel;

public class BTrainsModel {
    static TrainsModel trains = new TrainsModel();

    public static TrainsModel build()  { return trains; }
}
