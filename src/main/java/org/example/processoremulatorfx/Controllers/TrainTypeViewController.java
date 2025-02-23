package org.example.processoremulatorfx.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.processoremulatorfx.Models.TrainModel;
import org.example.processoremulatorfx.TypeWagon.TypeWagon;

public class TrainTypeViewController {
  TrainModel trainModel;
  TypeWagon TWagon;

  TrainTypeViewController(TrainModel trainModel){
    this.trainModel = trainModel;
  }

  public void setWagon(TypeWagon tWagon){
    TWagon = tWagon;

    TypeTrain.setText(tWagon.getType().substring(0, 1));
    PorC.setText(tWagon.getProperty());
  }

  @FXML
  void remove() { trainModel.removeWagon(TWagon); }

  @FXML
  Label TypeTrain;
  @FXML
  Label PorC;
}
