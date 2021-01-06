package com.example.kolkokrzyzyk;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameController {
    Integer countX = 0;
    Integer countO = 0;
    Integer draw = 0;
    Integer requestedNumberOfGames;
    boolean isAdvanced;
    GridPane root;
    Set<Integer> markedTilesX = new HashSet<>();
    Set<Integer> markedTilesO = new HashSet<>();
    List<HashSet<Integer>> winningCombinations = new ArrayList<>();
    Stage appPrimaryStage;


    public GameController(GridPane root) {
        this.root = root;
        HashSet<Integer> hashSet = new HashSet();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        winningCombinations.add(hashSet);
        HashSet<Integer> hashSet1 = new HashSet();
        hashSet1.add(4);
        hashSet1.add(5);
        hashSet1.add(6);
        winningCombinations.add(hashSet1);
        HashSet<Integer> hashSet2 = new HashSet();
        hashSet2.add(7);
        hashSet2.add(8);
        hashSet2.add(9);
        winningCombinations.add(hashSet2);
        HashSet<Integer> hashSet3 = new HashSet();
        hashSet3.add(1);
        hashSet3.add(4);
        hashSet3.add(7);
        winningCombinations.add(hashSet3);
        HashSet<Integer> hashSet4 = new HashSet();
        hashSet4.add(2);
        hashSet4.add(5);
        hashSet4.add(8);
        winningCombinations.add(hashSet4);
        HashSet<Integer> hashSet5 = new HashSet();
        hashSet5.add(3);
        hashSet5.add(6);
        hashSet5.add(9);
        winningCombinations.add(hashSet5);
        HashSet<Integer> hashSet6 = new HashSet();
        hashSet6.add(3);
        hashSet6.add(5);
        hashSet6.add(7);
        winningCombinations.add(hashSet6);
        HashSet<Integer> hashSet7 = new HashSet();
        hashSet7.add(1);
        hashSet7.add(5);
        hashSet7.add(9);
        winningCombinations.add(hashSet7);
    }

    public void makeComputerMove() {
        List<Tile> tiles = root.getChildren().stream()
                .filter(node -> node instanceof Tile)
                .map(node -> ((Tile) node))
                .filter(tile -> tile.text.getText().equals(""))
                .collect(Collectors.toList());
        Random randomGenerator = new Random();
        int computerTileIndex = randomGenerator.nextInt(tiles.size());
        Tile tile = tiles.get(computerTileIndex);
        tile.text.setText("O");
        markedTilesO.add(tile.idNumber);
        verifyResult(markedTilesO);
    }


    public void makeComputerMoveAdvanced() {

        List<Tile> tiles = root.getChildren().stream()
                .filter(node -> node instanceof Tile)
                .map(node -> ((Tile) node))
                .filter(tile -> tile.text.getText().equals(""))
                .collect(Collectors.toList());

        HashSet<Integer> integers = new HashSet<>();
        integers.addAll(markedTilesO);
        integers.addAll(markedTilesX);
        List<HashSet<Integer>> collect = winningCombinations.stream()
                .filter(s -> !integers.containsAll(s))
                .collect(Collectors.toList());
        Optional<HashSet<Integer>> first = collect.stream()
                .filter(combination -> combination.containsAll(markedTilesX))
                .findFirst();
        if (first.isPresent()) {
            Optional<Integer> tileToSet = first.get().stream()
                    .filter(tileNo -> !markedTilesX.contains(tileNo) && !markedTilesO.contains(tileNo))
                    .findFirst();

            Tile tile = tiles.stream()
                    .filter(tile1 -> tile1.idNumber == tileToSet.get())
                    .findFirst().get();
            tile.text.setText("O");
            markedTilesO.add(tile.idNumber);
        } else {
            HashSet<Integer> combination = new HashSet<>();
            for (HashSet<Integer> win : collect) {
                int count = 0;
                for (Integer mark : markedTilesX) {
                    if (win.contains(mark)) {
                        count++;
                    }
                    if (count == 2) {
                        combination = win;
                    }
                }
                if (!combination.isEmpty()) {
                    Integer missing = combination.stream()
                            .filter(x -> !markedTilesX.contains(x))
                            .findFirst().get();

                    Tile tile = root.getChildren().stream()
                            .filter(node -> node instanceof Tile)
                            .map(node -> ((Tile) node))
                            .filter(t -> t.idNumber == missing)
                            .findFirst().get();
                    tile.text.setText("O");
                    markedTilesO.add(tile.idNumber);
                    verifyResult(markedTilesO);
                    break;
                }
            }
            if (combination.isEmpty()) {
                List<Tile> tiles2 = root.getChildren().stream()
                        .filter(node -> node instanceof Tile)
                        .map(node -> ((Tile) node))
                        .filter(tile -> tile.text.getText().equals(""))
                        .collect(Collectors.toList());
                Random randomGenerator = new Random();
                int computerTileIndexAdvanced = randomGenerator.nextInt(tiles2.size());
                Tile tile = tiles2.get(computerTileIndexAdvanced);
                tile.text.setText("O");
                markedTilesO.add(tile.idNumber);

                verifyResult(markedTilesO);

            }

        }

    }







           /* List<Tile> tiles2 = root.getChildren().stream()
                    .filter(node -> node instanceof Tile)
                    .map(node -> ((Tile) node))
                    .filter(tile -> tile.text.getText().equals(""))
                    .collect(Collectors.toList());

            HashSet<Integer> integers2 = new HashSet<>();
            integers2.addAll(markedTilesO);
            integers2.addAll(markedTilesX);
            List<HashSet<Integer>> collect2 = winningCombinations.stream()
                    .filter(s -> !integers2.containsAll(s))
                    .collect(Collectors.toList());
            Optional<HashSet<Integer>> first2 = collect2.stream()
                    .filter(combination -> !combination.containsAll(markedTilesX))
                    .findFirst();
            if (first2.isPresent()) {
                Optional<Integer> tileToSet2 = first2.get().stream()
                        .filter(tileNo -> !markedTilesX.contains(tileNo))
                        .findFirst();

                Tile tile = tiles2.stream()
                        .filter(tile2 -> tile2.idNumber == tileToSet2.get())
                        .findFirst().get();*/

//   }


    public boolean ifFieldWasUsedBefore(Tile tile) {
        boolean result = markedTilesO.contains(tile.idNumber) || markedTilesX.contains(tile.idNumber);
        return result;
    }

    public void runAGame(Tile tile) {
        if (!ifFieldWasUsedBefore(tile)) {
            tile.text.setText("X");
            markedTilesX.add(tile.idNumber);
            verifyResult(markedTilesX);
        }
    }

    public boolean isDraw() {
        if ((markedTilesO.size() == 5 && markedTilesX.size() == 4) || (markedTilesO.size() == 4 && markedTilesX.size() == 5)) {
            return true;
        }
        return false;
    }

    public void verifyResult(Set<Integer> hashSet) {
        if (isWinningCombinationXCorrect() || isWinningCombinationOCorrect() || isDraw()) {
            endOfRound();
        }
    }

    public boolean isWinningCombinationOCorrect() {
        return winningCombinations.stream()
                .anyMatch(combination -> markedTilesO.containsAll(combination));
    }

    public boolean isWinningCombinationXCorrect() {
        return winningCombinations.stream()
                .anyMatch(combination -> markedTilesX.containsAll(combination));

    }


    public void endOfRound() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("End of Round");
        String message = "";
        alert.setHeaderText("Thank you for playing Tic Tac Toe");
        if (isWinningCombinationXCorrect()) {
            countX++;
            message = "X won this round. Total win for X is: " + countX;
        } else if (isWinningCombinationOCorrect()) {
            countO++;
            message = "O won this round. Total win for O is: " + countO;
        } else {
            draw++;
            message = "Draw. Total draw in this game is: " + draw;
        }
        alert.setContentText(message);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            this.markedTilesX = new HashSet<>();
            this.markedTilesO = new HashSet<>();
            for (int i = 0; i < root.getChildren().size(); i++) {
                ((Tile) root.getChildren().get(i)).text.setText("");
            }
        } else {
            appPrimaryStage.close();
        }
        if (requestedNumberOfGames <= (countX + countO + draw)) {
            endOfGame();
        }

    }


    public void endOfGame() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("End of Game");
        String message = "";
        alert.setHeaderText("Thank you for playing Tic Tac Toe");
        if (countX > countO) {
            message = "Won X, Would you like to play new game?";
        } else if (countO > countX) {
            message = "Won O, Would you like to play new game?";
        } else {
            message = "Draw. Would you like to play again?";
        }
        alert.setContentText(message);
        Optional<ButtonType> result = alert.showAndWait();
        countX = 0;
        countO = 0;
        draw = 0;
        if (result.get() == ButtonType.OK) {
            this.markedTilesX = new HashSet<>();
            this.markedTilesO = new HashSet<>();
            for (int i = 0; i < root.getChildren().size(); i++) {
                ((Tile) root.getChildren().get(i)).text.setText("");
            }
            appPrimaryStage.setScene(KolkoKrzyzykApplication.createAppScene(appPrimaryStage));
        } else {
            appPrimaryStage.close();
        }
    }
}



