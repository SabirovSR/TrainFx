package org.example.processoremulatorfx.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.example.processoremulatorfx.BModels.BTrainsModel;
import org.example.processoremulatorfx.Cargo;
import org.example.processoremulatorfx.TypeWagon.Locomotive;
import org.example.processoremulatorfx.Models.TrainModel;
import org.example.processoremulatorfx.Models.TrainsModel;
import org.example.processoremulatorfx.TypeWagon.Wagon;

public class AddTrainViewController {
  TrainsModel trainsModel = BTrainsModel.build();

  @FXML
  void addTrainType() {
    if (ComboBoxTrain.getValue() == null
            || NumbTrain.getText() == null) {
      System.out.println("Error: Choose train type");
      return;
    }

    if (!Power.isDisable()
            && Power.getText().isEmpty()) {
      System.out.println("Error: Введите мощность локомотива");
      return;
    }

    try {
      switch (ComboBoxTrain.getValue().toString()) {
        case "Locomotive":
          trainsModel.getTrainByIndex(Integer.parseInt(NumbTrain.getText())-1).addLocomotive(new Locomotive(Integer.parseInt(Power.getText())));
          break;
        case "Wagon":
          trainsModel.getTrainByIndex(Integer.parseInt(NumbTrain.getText())-1).addWagon(new Wagon(new Cargo(Cargo.getText())));
          break;
      }
    }

    catch (Exception e){
      System.out.println("Error: " + e.getMessage());
    }
  }

  @FXML
  void addTrain(){
    trainsModel.addTrain(new TrainModel());
  }

  @FXML
  ComboBox ComboBoxTrain;

  @FXML
  TextField NumbTrain;
  @FXML
  TextField Power;
  @FXML
  TextField Cargo;

  @FXML
  void initialize()
  {
    ComboBoxTrain.getItems().addAll("Locomotive", "Wagon");

    Power.setDisable(true);
    Cargo.setDisable(true);

    ComboBoxTrain.setOnAction(event -> {
      String selectedTrain = (String) ComboBoxTrain.getValue();
      Cargo.setText("");
      Power.setText("");

      Cargo.setDisable(selectedTrain.equals("Locomotive"));
      Power.setDisable(!selectedTrain.equals("Locomotive"));
    });
  }
}
