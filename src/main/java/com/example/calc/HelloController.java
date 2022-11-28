package com.example.calc;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


    @FXML
    private Text output;
    private long num1 = 0;
    private long num2 = 0;

    private boolean start = true;

    private String operation = "";

    private Model model = new Model();

    @FXML
    private void numProcess(ActionEvent event) {
        if (start) {
            output.setText("");
            start = false;
        }
        String value = ((Button) event.getSource()).getText();
        output.setText(output.getText() + value);
    }

    @FXML
    private void operationProcess(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (!"=".equals(value)) {
            if (!operation.isEmpty()) return;
            operation = value;
            num1 = Long.parseLong(output.getText());
            output.setText("");
        } else {
            if (operation.isEmpty()) return;
            output.setText(String.valueOf(model.sum(num1, Long.parseLong(output.getText()), operation)));
            operation = "";
            start = true;
        }
    }
}