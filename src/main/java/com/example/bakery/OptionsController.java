package com.example.bakery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class OptionsController {

    private Stage stage;
    private Scene scene;

    // Handle Sales button action
    @FXML
    protected void handleSales(ActionEvent event) throws IOException {
        loadScene(event, "SALES.fxml");
    }

    // Handle Stocks button action
    @FXML
    protected void handleStocks(ActionEvent event) throws IOException {
        loadScene(event, "STOCKS.fxml");
    }

    // Handle Suppliers button action
    @FXML
    protected void handleSuppliers(ActionEvent event) throws IOException {
        loadScene(event, "SUPPLIERS.fxml");
    }

    // Handle Reports button action
    @FXML
    protected void handleReports(ActionEvent event) throws IOException {
        loadScene(event, "REPORTS.fxml");
    }

    // Handle Employees button action
    @FXML
    protected void handleEmployees(ActionEvent event) throws IOException {
        loadScene(event, "EMPLOYEES.fxml");
    }

    // Handle Logout button action
    @FXML
    protected void handleLogout(ActionEvent event) {
        System.exit(0); // Close the application
    }

    // Handle Back button action
    @FXML
    protected void handleBack(ActionEvent event) throws IOException {
        loadScene(event, "LOGIN.fxml"); // Assuming LOGIN.fxml is the previous screen
    }

    /**
     * General method to load any FXML screen.
     */
    private void loadScene(ActionEvent event, String fxmlFile) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
