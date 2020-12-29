package com.example.kolkokrzyzyk;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

import javax.swing.*;

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
        FlowPane flowpane = new FlowPane();
        Button button;
        Button button1;
        Button button2;
        TextField nameInput = new TextField();
        button = new Button("Fill in number of rounds would you like to play");
        button1 = new Button("Basic Game level");
        button2 = new Button("Advanced Game level");
        flowpane.getChildren().add(button1);
        flowpane.getChildren().add(button2);
        VBox layout = new VBox(10);
//        setLayout (new BoxLayout(button1, button2, BoxLayout.Y_AXIS));
        layout.setPadding(new Insets(40, 40, 40, 40));
        layout.getChildren().addAll(nameInput, button, flowpane);
        sceneWithButton = new Scene(layout, 400, 400);
        button.setOnAction(e -> {
            controller.requestedNumberOfGames = Integer.valueOf(nameInput.getText());
            System.out.println(nameInput.getText());
            primaryStage.close();
            primaryStage.setScene(appScene);
            primaryStage.show();
        });
        button1.setOnMouseClicked(e -> {
            controller.makeComputerMove();
            primaryStage.close();
            primaryStage.setScene(appScene);
            primaryStage.show();
        });
        button2.setOnMouseClicked(e -> {
           controller.makeComputerMoveAdvanced();
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

