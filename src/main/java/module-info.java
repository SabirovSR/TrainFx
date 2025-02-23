module org.example.trainfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
  requires jdk.jfr;

  opens org.example.trainfx to javafx.fxml;
    exports org.example.trainfx;
    exports org.example.trainfx.Controllers;
    opens org.example.trainfx.Controllers to javafx.fxml;
  exports org.example.trainfx.Models;
  opens org.example.trainfx.Models to javafx.fxml;
  exports org.example.trainfx.BModels;
  opens org.example.trainfx.BModels to javafx.fxml;
    exports org.example.trainfx.TypeWagon;
    opens org.example.trainfx.TypeWagon to javafx.fxml;
}