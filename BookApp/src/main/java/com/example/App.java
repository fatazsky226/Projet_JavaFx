// Code d'enregistrement d'un livre 
// Bouton de soumission et bouton pour ouvrir un autre formulaire

package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Labels and text fields for book details
        Label titleLabel = new Label("Book Title:");
        TextField titleField = new TextField();

        Label authorLabel = new Label("Author:");
        TextField authorField = new TextField();

        // Result label
        Label resultLabel = new Label();
        resultLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Submit button
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            String title = titleField.getText().trim();
            String author = authorField.getText().trim();

            if (title.isEmpty() || author.isEmpty()) {
                resultLabel.setText("Error: All fields must be filled!");
                resultLabel.setStyle("-fx-text-fill: red;");
            } else {
                // Display the result in the UI
                resultLabel.setText("Book Registered Successfully!");
                resultLabel.setStyle("-fx-text-fill: green;");

                // Print the result to the console
                System.out.println("Book Registered: ");
                System.out.println("Title: " + title);
                System.out.println("Author: " + author);

                // Clear the input fields
                titleField.clear();
                authorField.clear();
            }
        });

        // Button to open Member Registration window
        Button registerMemberButton = new Button("Register Member");
        registerMemberButton.setOnAction(e -> {
            MemberRegistration memberRegistration = new MemberRegistration();
            memberRegistration.display();
        });

        // Layout for the main application
        VBox root = new VBox(10, titleLabel, titleField, authorLabel, authorField, submitButton, resultLabel, registerMemberButton);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(root, 400, 400);

        primaryStage.setTitle("Book Registration");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
