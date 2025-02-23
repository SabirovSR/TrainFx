package org.example.processoremulatorfx.BModels;

import org.example.processoremulatorfx.Models.TrainsModel;

public class BTrainsModel {
    static TrainsModel trains = new TrainsModel();

    public static TrainsModel build()  { return trains; }
}
