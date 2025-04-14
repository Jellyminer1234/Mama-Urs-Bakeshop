package com.example.bakery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EMPLOYEES {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    protected void initialize() {
        // TODO: Initialize employee management components
    }

    @FXML
    protected void backToLogin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void addEmployee() {
        // TODO: Implement add employee functionality
    }

    @FXML
    protected void removeEmployee() {
        // TODO: Implement remove employee functionality
    }

    @FXML
    protected void updateEmployee() {
        // TODO: Implement update employee functionality
    }
}