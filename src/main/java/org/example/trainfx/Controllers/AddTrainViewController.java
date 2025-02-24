package org.example.trainfx.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.example.trainfx.BModels.BTrainsModel;
import org.example.trainfx.Cargo;
import org.example.trainfx.TypeWagon.Locomotive;
import org.example.trainfx.Models.TrainModel;
import org.example.trainfx.Models.TrainsModel;
import org.example.trainfx.TypeWagon.Wagon;

public class AddTrainViewController {
  TrainsModel trainsModel = BTrainsModel.build();

  @FXML
  void addTrainType() {
    if (ComboBoxWagon.getValue() == null
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
      switch (ComboBoxWagon.getValue().toString()) {
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
  ComboBox ComboBoxWagon;

  @FXML
  TextField NumbTrain;
  @FXML
  TextField Power;
  @FXML
  TextField Cargo;

  @FXML
  void initialize()
  {
    ComboBoxWagon.getItems().addAll("Locomotive", "Wagon");

    Power.setDisable(true);
    Cargo.setDisable(true);

    ComboBoxWagon.setOnAction(event -> {
      String selectedWagon = (String) ComboBoxWagon.getValue();
      Cargo.setText("");
      Power.setText("");

      Cargo.setDisable(selectedWagon.equals("Locomotive"));
      Power.setDisable(!selectedWagon.equals("Locomotive"));
    });
  }
}
