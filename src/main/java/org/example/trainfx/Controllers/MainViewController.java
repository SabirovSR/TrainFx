package org.example.trainfx.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import org.example.trainfx.App;
import org.example.trainfx.BModels.BTrainsModel;
import org.example.trainfx.IObserver;
import org.example.trainfx.Models.TrainModel;
import org.example.trainfx.Models.TrainsModel;

import java.io.IOException;

public class MainViewController implements IObserver {
  TrainsModel trainsModel = BTrainsModel.build();

  @FXML
  void initialize()
  {
    trainsModel.addObserver(this);

    try {
      FXMLLoader fxmlLoader1 = new FXMLLoader(
              App.class.getResource("Views/AddTrainView.fxml"));

      Pane pane1 = fxmlLoader1.load();

      main.add(pane1, 0, 0);

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
  }

  @FXML
  GridPane main;

  @FXML
  GridPane allTrain;

  @Override
  public void event(TrainModel trainModel) { }

  @Override
  public void event(TrainsModel trainsModel) {
    allTrain.getChildren().clear();
    for (TrainModel trainModel : trainsModel) {
      TrainViewController pc = new TrainViewController();
      FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Views/TrainView.fxml"));
      fxmlLoader.setController(pc);
      try {
        Pane pane = fxmlLoader.load();
        pc.setTrain(trainModel);
        allTrain.addColumn(0, pane);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
