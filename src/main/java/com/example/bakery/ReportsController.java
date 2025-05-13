package com.example.bakery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReportsController {

    // FXML fields linked to the FXML components
    @FXML
    private TextArea reportTextArea;

    // Sales report data (you can modify this with actual dynamic data later)
    private final String reportData = "Date\t\tTotal Sales\n" +
            "--------------------------\n" +
            "May 1\t\t$1,250\n" +
            "May 2\t\t$980\n" +
            "May 3\t\t$1,430\n" +
            "May 4\t\t$1,120\n" +
            "May 5\t\t$1,300";

    // Handle the Generate button action
    @FXML
    private void handleGenerate(ActionEvent event) {
        // For now, it just sets the report data in the TextArea
        reportTextArea.setText(reportData);
    }

    // Handle the Export button action
    @FXML
    private void handleExport(ActionEvent event) {
        // Use FileChooser to allow user to save the report as a text file
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(reportTextArea.getText());  // Save report data to the selected file
                showAlert("Success", "Report exported successfully.");
            } catch (IOException e) {
                showAlert("Error", "An error occurred while exporting the report.");
            }
        }
    }

    // Handle the Back button action
    @FXML
    private void handleBack(ActionEvent event) {
        // Close the current window or go back to the previous scene (for now, just close it)
        Stage stage = (Stage) reportTextArea.getScene().getWindow();
        stage.close();  // This will close the current window

        // Optionally, you can load a different scene here, like a menu
        // Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        // Scene scene = new Scene(root);
        // stage.setScene(scene);
        // stage.show();
    }

    // Display an alert with a given title and message
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
