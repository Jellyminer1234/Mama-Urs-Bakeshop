package com.example.bakery;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class SuppliersController {

    @FXML
    private TextField supplierNameField;

    @FXML
    private TextField supplierAddressField;

    @FXML
    public void initialize() {
        // Optional: initialization logic
    }

    @FXML
    private void handleAddSupplier() {
        String name = supplierNameField.getText();
        String address = supplierAddressField.getText();

        if (name.isEmpty() || address.isEmpty()) {
            showAlert("Missing Information", "Please enter both name and address.");
            return;
        }

        // You can later add saving to database or list here
        showAlert("Supplier Added", "Name: " + name + "\nAddress: " + address);

        // Clear the fields
        supplierNameField.clear();
        supplierAddressField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
