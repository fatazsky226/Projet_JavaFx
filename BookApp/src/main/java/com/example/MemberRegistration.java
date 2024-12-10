package com.example;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MemberRegistration {

    public void display() {
        // New Stage for member registration
        Stage memberStage = new Stage();
        memberStage.setTitle("Member Registration");

        // Labels and text fields for member details
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();

        // Result label
        Label resultLabel = new Label();
        resultLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Submit button
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();

            if (name.isEmpty() || email.isEmpty()) {
                resultLabel.setText("Error: All fields must be filled!");
                resultLabel.setStyle("-fx-text-fill: red;");
            } else {
                resultLabel.setText("Member Registered Successfully!");
                resultLabel.setStyle("-fx-text-fill: green;");
                
                // Print the registration details to the console
                System.out.println("New Member Registered:");
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);

                // Clear input fields (optional)
                nameField.clear();
                emailField.clear();
            }
        });

        // Layout for the member registration form
        VBox memberLayout = new VBox(10, nameLabel, nameField, emailLabel, emailField, submitButton, resultLabel);
        memberLayout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene memberScene = new Scene(memberLayout, 400, 300);
        memberStage.setScene(memberScene);
        memberStage.show();
    }
}
