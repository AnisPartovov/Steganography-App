package com.example.demo;

import com.example.demo.Contact.Github;
import com.example.demo.Contact.WhatsApp;
import com.example.demo.PictureSteganography.Steganography;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class SteganographyApp extends Application {

    public void start(Stage primaryStage) {
        // Setting the title of the stage
        primaryStage.setTitle("Steganography App");

        // Creating a label for the title
        Label titleLabel = new Label("Steganography App");
        titleLabel.setFont(new Font("TVerdana", 30));
        titleLabel.setPadding(new Insets(-90, 10, 0, 270));



        // Adding an image to the Whatsapp button
        Image whatsImage = new Image("file:src/main/resources/com/example/demo/images/whatsapp.png");
        ImageView whatsAppImage = new ImageView(whatsImage);
        whatsAppImage.setFitHeight(20);
        whatsAppImage.setFitWidth(20);

        // Creating a button for the whatsapp
        Button whatsAppButton = new Button("", whatsAppImage);
        whatsAppButton.setPrefSize(200, 10);
        whatsAppButton.setStyle(
                        "-fx-background-color: none;" +
                        "-fx-cursor: hand;"
        );
        whatsAppButton.setOnAction(e -> {
            try {
                new WhatsApp().start(new Stage());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        // Creating a button for the login
        Button loginButton = new Button("");
        loginButton.setPadding(new Insets(0, 0, 0, 830));

        // Adding an image to the github button
        Image gitImage = new Image("file:src/main/resources/com/example/demo/images/github.png");
        ImageView githubImage = new ImageView(gitImage);
        githubImage.setFitHeight(20);
        githubImage.setFitWidth(20);


        // Creating a button for the github
        Button githubButton = new Button("", githubImage);
        githubButton.setPrefSize(200, 10);
        githubButton.setStyle(
                        "-fx-background-color: none;" +
                        "-fx-cursor: hand;"
        );
        githubButton.setOnAction(e -> {
            try {
                new Github().start(new Stage());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });





        // Create buttons for the main actions
        Button cipherButton = new Button("Text ");
        cipherButton.setOnAction(e -> {
            try {
                new CipherApplication().start(primaryStage);
                cipherButton.setStyle(
                        "-fx-background-color: black"
                );
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        // Creating button for the Picture Steganography App
        Button picButton = new Button("Picture ");
        picButton.getStyleClass().add("picButton");
        picButton.setOnAction(e -> {
            try {
                new Steganography().start(primaryStage);
            } catch (Exception ex) {
                throw new RuntimeException("Error");
            }
        });

        // Add some padding to the buttons
        cipherButton.setPadding(new Insets(10));
        picButton.setPadding(new Insets(10));

        // Create a horizontal box to hold the buttons
        HBox buttonBox = new HBox(20, cipherButton, picButton);
        buttonBox.setAlignment(Pos.CENTER);


        // Create a horizontal box to hold the contact buttons
        HBox contactBox = new HBox(20,

                whatsAppImage,
                whatsAppButton,
                githubImage,
                githubButton
        );
        contactBox.setPadding(new Insets(10));
        contactBox.setAlignment(Pos.CENTER);


        // Create a vertical box to hold the title and buttons
        VBox mainBox = new VBox(20, buttonBox);
        mainBox.setPadding(new Insets(20));
        mainBox.setAlignment(Pos.CENTER);

        // Create a border pane to hold the main box
        BorderPane root = new BorderPane();
        root.setCenter(mainBox);
        root.setBottom(contactBox);
//        root.setTop(projectBox);
;

        // Set the scene and show the stage
        Scene scene = new Scene(root, 870, 450);
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
