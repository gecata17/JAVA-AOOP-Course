package com.example.problem1registration;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnRegister;

    @FXML
    private Label lblConfirmPassword;

    @FXML
    private Label lblConfirmPasswordError;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblEmailError;

    @FXML
    private Label lblPassword;

    @FXML
    private Label lblPasswordError;

    @FXML
    private Label lblPhoneNumber;

    @FXML
    private Label lblPhoneNumberError;

    @FXML
    private Label lblUserName;

    @FXML
    private Label lblUserNameError;

    @FXML
    private PasswordField pwdConfirmPassword;

    @FXML
    private PasswordField pwdPassword;

    @FXML
    private Tooltip tltEmail;

    @FXML
    private Tooltip tltPhoneNumber;

    @FXML
    private Tooltip tltUserName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private TextField txtUserName;

    @FXML
    void btnRegisterOnActionHandler(ActionEvent event) {
        boolean isFormValid = validateForm();
        if (isFormValid) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setContentText("You have registered successfully");
            alert.showAndWait();
            Platform.exit();
        }
    }

    @FXML
    void initialize() {
        assert btnRegister != null : "fx:id=\"btnRegister\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblConfirmPassword != null : "fx:id=\"lblConfirmPassword\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblConfirmPasswordError != null : "fx:id=\"lblConfirmPasswordError\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblEmail != null : "fx:id=\"lblEmail\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblEmailError != null : "fx:id=\"lblEmailError\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblPassword != null : "fx:id=\"lblPassword\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblPasswordError != null : "fx:id=\"lblPasswordError\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblPhoneNumber != null : "fx:id=\"lblPhoneNumber\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblPhoneNumberError != null : "fx:id=\"lblPhoneNumberError\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblUserName != null : "fx:id=\"lblUserName\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblUserNameError != null : "fx:id=\"lblUserNameError\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert pwdConfirmPassword != null : "fx:id=\"pwdConfirmPassword\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert pwdPassword != null : "fx:id=\"pwdPassword\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert tltEmail != null : "fx:id=\"tltEmail\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert tltPhoneNumber != null : "fx:id=\"tltPhoneNumber\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert tltUserName != null : "fx:id=\"tltUserName\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtEmail != null : "fx:id=\"txtEmail\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtPhoneNumber != null : "fx:id=\"txtPhoneNumber\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtUserName != null : "fx:id=\"txtUserName\" was not injected: check your FXML file 'hello-view.fxml'.";

    }

    private boolean validateForm() {
        boolean userNameRequired = validateRequired(txtUserName, lblUserNameError);
        boolean phoneNumberRequired = validateRequired(txtPhoneNumber, lblPhoneNumberError);
        boolean emailRequired = validateRequired(txtEmail, lblEmailError);
        boolean passwordRequired = validateRequired(pwdPassword, lblPasswordError);
        boolean confirmPasswordRequired = validateRequired(pwdConfirmPassword, lblConfirmPasswordError);
        boolean userNamePattern = validateUserNamePattern();
        boolean phoneNumberPattern = validatePhoneNumberPattern();
        boolean emailPattern = validateEmailPattern();
        boolean passwordsMatch = validatePasswordsMatch();
        return userNameRequired && phoneNumberRequired && emailRequired && passwordRequired
                && confirmPasswordRequired && userNamePattern && phoneNumberPattern && emailPattern && passwordsMatch;
    }

    private boolean validateRequired(TextField textfield, Label errorLabel) {
        String textFieldValue = textfield.getText();

        if (textFieldValue.equals("")) {
            errorLabel.setText("Required");
            return false;
        }

        errorLabel.setText("");
        return true;
    }

    private boolean validateUserNamePattern() {
        if (lblUserNameError.getText().length() > 0) {
            return false;
        }
        String userNameValue = txtUserName.getText();

        if (userNameValue.matches("[a-zA-Z]{2,}")) {
            return true;
        }
        lblUserNameError.setText("Invalid username");
        return false;
    }

    private boolean validatePhoneNumberPattern() {
        if (lblPhoneNumberError.getText().length() > 0) {
            return false;
        }

        String phoneNumberValue = tltPhoneNumber.getText();

        if (phoneNumberValue.matches("\\(\\d{4}\\) \\(\\d{7}\\)")) {
            return true;
        }
        lblPhoneNumberError.setText("Invalid phone number");
        return false;
    }

    private boolean validateEmailPattern() {
        if (lblEmailError.getText().length() > 0) {
            return false;
        }
        String emailValue = txtEmail.getText();
        if (emailValue.matches("(\\w+[.]?-?)+@(\\w+-?)+[.][a-zA-Z]{2,4}")) {
            return true;
        }
        lblEmailError.setText("Invalid email");
        return false;
    }

    private boolean validatePasswordsMatch() {
        if (lblPasswordError.getText().length() > 0 || lblConfirmPasswordError.getText().length() > 0) {
            return false;
        }
        String passwordValue = pwdPassword.getText();
        String confirmPasswordValue = pwdConfirmPassword.getText();

        if (passwordValue.equals(confirmPasswordValue)) {
            return true;
        }
        lblConfirmPasswordError.setText("Passwords must match");
        return false;
    }
}
