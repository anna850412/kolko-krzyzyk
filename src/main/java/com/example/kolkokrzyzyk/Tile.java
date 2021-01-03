package com.example.kolkokrzyzyk;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Tile extends StackPane {
    int idNumber;
    Text text = new Text();

    public Tile(GameController controller) {
        Rectangle border = new Rectangle(200, 200);
        border.setFill(null);
        border.setStroke(Color.BLACK);
        setAlignment(Pos.CENTER);
        getChildren().addAll(border, text);
        text.setFont(Font.font(100));

        setOnMouseClicked(event ->
        {
            Tile source = (Tile) event.getSource();
            controller.runAGame(source);
            if (controller.isAdvanced) {

            controller.makeComputerMoveAdvanced();
        } else {
           controller.makeComputerMove();
            }

        });
    }

}
