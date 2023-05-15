package com.example.demo;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class CipherApplication extends Application {

    private TextField keyField;
    private TextArea inputArea;
    private TextArea outputArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create the key field
        keyField = new TextField();
        keyField.setPromptText("Cipher key");
        keyField.setMaxWidth(200);

        // Create the input and output text areas
        inputArea = new TextArea();
        inputArea.setPromptText("Enter message to encode or decode");
        outputArea = new TextArea();
        outputArea.setPromptText("Output");
        outputArea.setEditable(false);

        // Create the encode and decode buttons
        Button encodeButton = new Button("Encode");
        Button decodeButton = new Button("Decode");
        Button clearButton = new Button("Clear");
        Button exitButton = new Button("Exit");
        Button saveButton = new Button("Save");


        // Set the action for the encode button
        encodeButton.setOnAction(event -> {
            String key = keyField.getText();
            String input = inputArea.getText();
            String encoded = encode(input, Integer.parseInt(key));
            outputArea.setText(encoded);
        });

        // Set the action for the decode button
        decodeButton.setOnAction(event -> {
            String key = keyField.getText();
            String input = inputArea.getText();
            String decoded = decode(input, Integer.parseInt(key));
            outputArea.setText(decoded);
        });

        // Set the action for the clear button
        clearButton.setOnAction(event -> {
            keyField.clear();
            inputArea.clear();
            outputArea.clear();
        });

        // Set the action for the exit button
        exitButton.setOnAction(event -> {
            System.exit(0);
        });

        // Set the action for the save button
        saveButton.setOnAction(event -> {
            String outputAreaText = outputArea.getText();
            String inputAreaText = inputArea.getText();
            File outputFile = new File("output.txt");
            File inputFile = new File("input.txt");
            try {
                Files.write(Paths.get(outputFile.getAbsolutePath()), outputAreaText.getBytes());
                Files.write(Paths.get(inputFile.getAbsolutePath()), inputAreaText.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });



        // Create the button box
        HBox buttonBox = new HBox(10, encodeButton, decodeButton, clearButton, exitButton,  saveButton);
        buttonBox.setAlignment(Pos.CENTER);

        // Create the root layout
        VBox root = new VBox(10, new Label("Cipher Key:"), keyField, inputArea, outputArea, buttonBox);
        root.setPadding(new Insets(10));

//         Set the scene and show the stage
        Scene scene = new Scene(root, 870, 600);
        scene.getStylesheets().add(getClass().getResource("CipherApp.css").toExternalForm());
        primaryStage.setTitle("Text");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String encode(String input, int key) {
        // Shift each character in the message by the shift amount
        StringBuilder encodedMessage = new StringBuilder();
        for (char c : input.toCharArray()) {
            encodedMessage.append((char) (c + key));
        }
        return encodedMessage.toString();
    }

    private  String decode(String input, int key) {
        // Shift each character in the message by the shift amount
        StringBuilder decodedMessage = new StringBuilder();
        for (char c : input.toCharArray()) {
            decodedMessage.append((char) (c - key));
        }
        return decodedMessage.toString();
    }
}
