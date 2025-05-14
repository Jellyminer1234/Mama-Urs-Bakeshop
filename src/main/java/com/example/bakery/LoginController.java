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
import java.net.URL;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    protected void onLoginButtonClick(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (validateLogin(username, password)) {
            try {
                // Load OPTIONS.fxml from the proper path
                URL fxmlURL = getClass().getResource("/com/example/bakery/OPTIONS.fxml");
                if (fxmlURL == null) {
                    throw new IOException("FXML file not found at /com/example/bakery/OPTIONS.fxml");
                }

                FXMLLoader loader = new FXMLLoader(fxmlURL);
                Parent root = loader.load();

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
                showError("Navigation Error", "Could not load the options screen.\n" + e.getMessage());
            }
        } else {
            showError("Login Failed", "Invalid username or password.");
        }
    }

    @FXML
    protected void onSignUpClick(ActionEvent event) {
        showInfo("Sign Up", "Sign up functionality will be implemented soon.");
    }

    @FXML
    protected void onForgotPasswordClick(ActionEvent event) {
        showInfo("Password Recovery", "Password recovery functionality will be implemented soon.");
    }

    private boolean validateLogin(String username, String password) {
        return !username.isEmpty() && !password.isEmpty() &&
                ((username.equals("admin") && password.equals("admin")) ||
                        (username.equals("customer") && password.equals("customer")));
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
