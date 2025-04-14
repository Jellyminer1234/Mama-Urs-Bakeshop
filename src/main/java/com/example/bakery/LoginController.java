package com.example.bakery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    protected void onLoginButtonClick(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (validateLogin(username, password)) {
            try {
                if (username.equals("admin")) {
                    switchToEmployees(event);
                } else {
                    switchToCustomers(event);
                }
            } catch (IOException e) {
                showError("Navigation Error", "Could not load the next screen.");
            }
        } else {
            showError("Login Failed", "Invalid username or password.");
        }
    }

    @FXML
    protected void onSignUpClick() {
        // TODO: Implement sign up functionality
        showInfo("Sign Up", "Sign up functionality will be implemented soon.");
    }

    @FXML
    protected void onForgotPasswordClick() {
        // TODO: Implement password recovery
        showInfo("Password Recovery", "Password recovery functionality will be implemented soon.");
    }

    private boolean validateLogin(String username, String password) {
        // TODO: Implement proper authentication
        return !username.isEmpty() && !password.isEmpty() &&
               (username.equals("admin") && password.equals("admin") ||
                username.equals("customer") && password.equals("customer"));
    }

    private void switchToEmployees(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("EMPLOYEES.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void switchToCustomers(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("CUSTOMERS.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void showError(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void showInfo(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}