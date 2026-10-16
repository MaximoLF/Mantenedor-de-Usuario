module com.lorca.maximo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.lorca.maximo to javafx.fxml;

    // AGREGA ESTA LÍNEA:
    opens com.lorca.maximo.controller to javafx.fxml;
    opens com.lorca.maximo.model to javafx.fxml;
    opens com.lorca.maximo.dto to javafx.fxml;

    exports com.lorca.maximo;
    exports com.lorca.maximo.dto;

}