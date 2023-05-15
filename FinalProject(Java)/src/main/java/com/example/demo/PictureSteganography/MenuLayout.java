package com.example.demo.PictureSteganography;

import com.example.demo.SteganographyApp;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MenuLayout {

  public static Pane layout(Stage window) {
    HBox layout = new HBox(6);
    layout.setStyle(
            "-fx-background-color: white;"
            + "-fx-border-color: white;"
            + "-fx-border-width: 15;"
            + "-fx-border-style: solid;"
    );
    layout.setPrefSize(Steganography.WIDTH * 0.25, Steganography.HEIGHT * 0.15);

    Font font = new Font("Arial", Steganography.HEIGHT / 50);

    Button hideButton = new Button("Hide Image");
    hideButton.setStyle(
            "-fx-background-color: black;" +
            "-fx-text-fill: white;" +
            "-fx-font-size: 18px;" +
            "-fx-font-weight: bold;" +
            "-fx-cursor: hand;"
    );
    hideButton.setFont(font);
    hideButton.setMinWidth(layout.getPrefWidth() / 2);
    hideButton.setMaxHeight(Double.MAX_VALUE);
    hideButton.setOnAction(e -> window.setScene(new Scene(HiderLayout.layout(window))));

    Button revealButton = new Button("Reveal Image");
    revealButton.setStyle(
            "-fx-background-color: black;" +
                    "-fx-text-fill: white;" +
                    "-fx-font-size: 18px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-cursor: hand;"
    );
    revealButton.setFont(font);
    revealButton.setMinWidth(layout.getPrefWidth() / 2);
    revealButton.setMaxHeight(Double.MAX_VALUE);
    revealButton.setOnAction(e -> window.setScene(new Scene(RevealerLayout.layout(window))));

//
//    // Adding an image to the exit button
//    Image exImage = new Image("file:src/home/anis/demo/src/main/resources/com/example/demo/images/exit.png");
//    ImageView exitImage = new ImageView(exImage);
//    exitImage.setFitHeight(20);
//    exitImage.setFitWidth(20);
//
//    // Creating a button for exit
//    Button exitButton = new Button("", exitImage);
//    exitButton.setPrefSize(200, 10);
//    exitButton.setStyle(
//                    "-fx-background-color: none;" +
//                    "-fx-cursor: hand;"
//
//    );
//    exitButton.setOnAction(e -> {
//      System.exit(0);
//    });
//
//    // Adding an image to the exit button
//    Image arrImage = new Image("file:src/main/resources/project/steganography/images/double-arrow.png");
//    ImageView arrowImage = new ImageView(arrImage);
//    arrowImage.setFitHeight(20);
//    arrowImage.setFitWidth(20);
//
//    // Creating a button for exit
//    Button arrowButton = new Button("", arrowImage);
//    arrowButton.setPrefSize(200, 10);
//    arrowButton.setStyle(
//                    "-fx-background-color: none;" +
//                    "-fx-cursor: hand;"
//    );
//    arrowButton.setPadding(new Insets(50, 0, 0, -50));
//    arrowButton.setOnAction(e -> {
//      try {
//        new SteganographyApp().start(window);
//      } catch (Exception ex) {
//        throw new RuntimeException(ex);
//      }
//    });

    layout.getChildren().addAll(hideButton, revealButton);

    return layout;
  }

}
