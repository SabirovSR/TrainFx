package org.example.processoremulatorfx.Models;

import org.example.processoremulatorfx.IObserver;
import org.example.processoremulatorfx.TypeWagon.Locomotive;
import org.example.processoremulatorfx.TypeWagon.TypeWagon;
import org.example.processoremulatorfx.TypeWagon.Wagon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TrainModel implements Iterable<TypeWagon> {
    private List<TypeWagon> Wagons = new ArrayList<>();
    int TotalMaxWagons = 0;

    public void addLocomotive(Locomotive locomotive) {
        Wagons.add(locomotive);
        TotalMaxWagons += locomotive.getMaxWagons() + 1; // +1 из-за того, что сам локомотив тоже в ходит в кол-во составов поезда
        eventCall();
    }

    public void addWagon(Wagon wagon) throws Exception {
        if (Wagons.size() >= TotalMaxWagons) {
            throw new Exception("Превышено максимальное количество вагонов");
        }
        Wagons.add(wagon);
        eventCall();
    }

    public void removeWagon(TypeWagon tWagon){
        if (tWagon.getType().equals("Locomotive")) {
            int power = Integer.parseInt(tWagon.getProperty());

            if (TotalMaxWagons - power < Wagons.size()) {
                System.out.println("Error: Нельзя удалить локомотив. TotalMaxWagons < TrainSize");
                return; // Нельзя удалить локомотив, если при его убирании "мощность" состава будет меньше, чем кол-во вагонов
            }

            TotalMaxWagons -= (power+1); // за вычитом самого локоматива
        }

        Wagons.remove(tWagon);
        eventCall();
    }

    @Override
    public Iterator<TypeWagon> iterator() {
        return Wagons.iterator();
    }

    // Список наблюдателей за моделькой
    ArrayList<IObserver> allObserver = new ArrayList<>();
    void eventCall(){ allObserver.forEach(action->action.event(this)); }
    public void addObserver(IObserver e){
        allObserver.add(e);
        eventCall();
    }
}
