package com.example.kolkokrzyzyk;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class KolkoKrzyzykApplication extends Application {

    GridPane root;
    GameController controller;


    public Parent createContent() {
        root = new GridPane();
        controller = new GameController(root);
        root.setPrefSize(600, 600);

        int tileCounter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Tile tile = new Tile(controller);
                tile.setTranslateX(j * 200);
                tile.setTranslateY(i * 200);
                tileCounter++;
                tile.idNumber = tileCounter;
                root.getChildren().add(tile);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene appScene = new Scene(createContent());

        Scene sceneWithButton;
        Button button;
        TextField nameInput = new TextField();
        button = new Button("Fill in number of rounds would you like to play");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(nameInput, button);
        sceneWithButton = new Scene(layout, 400, 400);
        button.setOnAction(e -> {
            controller.requestedNumberOfGames = Integer.valueOf(nameInput.getText());
            System.out.println(nameInput.getText());
            primaryStage.close();
            primaryStage.setScene(appScene);
            primaryStage.show();
        });

        primaryStage.setScene(sceneWithButton);
        primaryStage.setTitle("TicTacToe");
        controller.appPrimaryStage = primaryStage;
        primaryStage.show();


    }
}

