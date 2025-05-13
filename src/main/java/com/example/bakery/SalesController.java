package com.example.bakery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SalesController {

    // FXML fields linked to the FXML components
    @FXML
    private AreaChart<String, Number> salesChart;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private NumberAxis yAxis;

    // Sample sales data for demonstration purposes
    private final XYChart.Series<String, Number> salesData = new XYChart.Series<>();

    public SalesController() {
        // Initialize sales data
        salesData.getData().add(new XYChart.Data<>("May 1", 1250));
        salesData.getData().add(new XYChart.Data<>("May 2", 980));
        salesData.getData().add(new XYChart.Data<>("May 3", 1430));
        salesData.getData().add(new XYChart.Data<>("May 4", 1120));
        salesData.getData().add(new XYChart.Data<>("May 5", 1300));
    }

    // Handle the Refresh button action
    @FXML
    private void handleRefresh(ActionEvent event) {
        // Clear existing data and add new sales data to the chart
        salesChart.getData().clear();
        salesChart.getData().add(salesData);
    }

    // Handle the Export button action
    @FXML
    private void handleExport(ActionEvent event) {
        // Open a FileChooser to allow the user to save the sales data as a CSV file
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            try (FileWriter writer = new FileWriter(file)) {
                // Write the sales data to the CSV file
                writer.write("Date,Total Sales ($)\n");
                for (XYChart.Data<String, Number> data : salesData.getData()) {
                    writer.write(data.getXValue() + "," + data.getYValue() + "\n");
                }
                showAlert("Success", "Sales data exported successfully.");
            } catch (IOException e) {
                showAlert("Error", "An error occurred while exporting the data.");
            }
        }
    }

    // Handle the Back button action
    @FXML
    private void handleBack(ActionEvent event) {
        // Close the current window (you can modify this to navigate to another scene if needed)
        Stage stage = (Stage) salesChart.getScene().getWindow();
        stage.close();
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
