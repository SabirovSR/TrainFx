package org.example.processoremulatorfx.Models;

import org.example.processoremulatorfx.Cargo;
import org.example.processoremulatorfx.IObserver;
import org.example.processoremulatorfx.TypeWagon.Locomotive;
import org.example.processoremulatorfx.TypeWagon.Wagon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TrainsModel implements Iterable<TrainModel> {
    private List<TrainModel> trains = new ArrayList<>();

    public TrainsModel() {
        TrainModel trainModel = new TrainModel();

        try {
            trainModel.addLocomotive(new Locomotive(5));
            trainModel.addWagon(new Wagon(new Cargo("уголь")));
            trainModel.addWagon(new Wagon(new Cargo("уголь")));
            trainModel.addWagon(new Wagon(new Cargo("уголь")));
            trainModel.addWagon(new Wagon(new Cargo("уголь")));
            trainModel.addWagon(new Wagon(new Cargo("уголь")));
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        trains.add(trainModel);
    }

    public void addTrain(TrainModel trainModel) {
        trains.add(trainModel);
        eventCall();
    }

    public TrainModel getTrainByIndex(int indx) throws Exception {
        if (indx < 0 || indx >= trains.size()) {
             throw new Exception("Index out of range");
        }
        return trains.get(indx);
    }

    public int getNumTrain(TrainModel t){
        return trains.indexOf(t) + 1;
    }

    public void removeTrain(TrainModel t){
        trains.remove(t);
        eventCall();
    }

    @Override
    public Iterator<TrainModel> iterator() { return trains.iterator(); }

    // Список наблюдателей за моделькой
    ArrayList<IObserver> allObserver = new ArrayList<>();
    void eventCall(){ allObserver.forEach(action->action.event(this)); }
    public void addObserver(IObserver e){
        allObserver.add(e);
        eventCall();
    }
}
