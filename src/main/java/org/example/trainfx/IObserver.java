package org.example.trainfx;

import org.example.trainfx.Models.*;

public interface IObserver {
    void event(TrainModel e);
    void event(TrainsModel e);
}
