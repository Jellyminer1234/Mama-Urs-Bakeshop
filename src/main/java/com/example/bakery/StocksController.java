package com.example.bakery;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class StocksController {

    @FXML
    private TableView<StockItem> stockTable;
    @FXML
    private TableColumn<StockItem, String> itemColumn;
    @FXML
    private TableColumn<StockItem, Integer> quantityColumn;
    @FXML
    private TableColumn<StockItem, String> categoryColumn;
    @FXML
    private TableColumn<StockItem, String> dateColumn;

    private final ObservableList<StockItem> stockData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        itemColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateAdded"));

        stockData.addAll(
                new StockItem("Flour", 100, "Baking", "2025-05-01"),
                new StockItem("Sugar", 50, "Baking", "2025-05-02")
        );

        stockTable.setItems(stockData);
    }

    @FXML
    private void handleAdd(ActionEvent event) {
        stockData.add(new StockItem("Butter", 30, "Dairy", "2025-05-13"));
    }

    @FXML
    private void handleUpdate(ActionEvent event) {
        StockItem selected = stockTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setQuantity(selected.getQuantity() + 10);
            stockTable.refresh();
        } else {
            showAlert("No selection", "Please select an item to update.");
        }
    }

    @FXML
    private void handleDelete(ActionEvent event) {
        StockItem selected = stockTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            stockData.remove(selected);
        } else {
            showAlert("No selection", "Please select an item to delete.");
        }
    }

    @FXML
    private void handleBack(ActionEvent event) {
        Stage stage = (Stage) stockTable.getScene().getWindow();
        stage.close();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
