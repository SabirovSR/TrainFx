package org.example.trainfx.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import org.example.trainfx.*;
import org.example.trainfx.BModels.BTrainsModel;
import org.example.trainfx.Models.TrainModel;
import org.example.trainfx.Models.TrainsModel;
import org.example.trainfx.TypeWagon.TypeWagon;

import java.io.IOException;

public class TrainViewController implements IObserver {
  TrainsModel trainsModel = BTrainsModel.build();

  TrainModel trainModel;

  public void setTrain(TrainModel trainModel){
    this.trainModel = trainModel;
    this.trainModel.addObserver(this);
    NumbTrain.setText("" + trainsModel.getNumTrain(trainModel));
  }

  @FXML
  void remove(){ trainsModel.removeTrain(trainModel); }

  @FXML
  Label NumbTrain;

  @FXML
  GridPane allWagons;

  @Override
  public void event(TrainModel trainModel) {
    allWagons.getChildren().clear();
    for (TypeWagon tWagon : trainModel) {
      TrainTypeViewController pc = new TrainTypeViewController(trainModel);
      FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Views/TrainTypeView.fxml"));
      fxmlLoader.setController(pc);
      try {
        Pane pane = fxmlLoader.load();
        pc.setWagon(tWagon);
        allWagons.addRow(0, pane);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }

  @Override
  public void event(TrainsModel trainsModel) {
  }
}
