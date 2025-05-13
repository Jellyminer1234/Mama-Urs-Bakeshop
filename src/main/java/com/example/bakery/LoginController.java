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

    @FXML
    protected void onLoginButtonClick(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (validateLogin(username, password)) {
            try {
                loadScene(event, "OPTIONS.fxml"); // Redirect to the options screen
            } catch (IOException e) {
                showError("Navigation Error", "Could not load the options screen.");
            }
        } else {
            showError("Login Failed", "Invalid username or password.");
        }
    }

    @FXML
    protected void onSignUpClick(ActionEvent event) {
        // Sign Up logic will be implemented later
        showInfo("Sign Up", "Sign up functionality will be implemented soon.");
    }

    @FXML
    protected void onForgotPasswordClick(ActionEvent event) {
        // Forgot password logic will be implemented later
        showInfo("Password Recovery", "Password recovery functionality will be implemented soon.");
    }

    private boolean validateLogin(String username, String password) {
        // This is just an example. You can implement a real authentication mechanism.
        return !username.isEmpty() && !password.isEmpty() &&
                ((username.equals("admin") && password.equals("admin")) ||
                        (username.equals("customer") && password.equals("customer")));
    }

    private void loadScene(ActionEvent event, String fxmlFile) throws IOException {
        // Load the specified FXML file (for example, the OPTIONS.fxml screen)
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();

        // Get the current stage and set the new scene
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void showError(String title, String content) {
        // Show an error alert with the given title and content
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void showInfo(String title, String content) {
        // Show an info alert with the given title and content
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
