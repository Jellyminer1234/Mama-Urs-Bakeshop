package com.example.bakery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class EmployeesController {

    @FXML
    private TextArea employeeTextArea;

    // Method to handle "Back" button action
    @FXML
    private void handleBack(ActionEvent event) {
        // Code to close the current window or navigate to another scene
        Stage stage = (Stage) employeeTextArea.getScene().getWindow();
        stage.close();  // This will close the current window

        // Or, you can load a different scene (for example, a main menu) like so:
        // Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        // Scene scene = new Scene(root);
        // stage.setScene(scene);
        // stage.show();
    }
}
