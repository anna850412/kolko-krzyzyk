package com.example.kolkokrzyzyk;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.*;
import java.util.stream.Collectors;

public class GameController {
    int countX = 0;
    int countO = 0;
    Integer requestedNumberOfGames;
    Tile tile;
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
        Random randomGenerator = new Random();
        int computerTileIndexAdvanced = randomGenerator.nextInt(tiles.size());

        if (markedTilesO.contains(1) && markedTilesO.contains(2) ||
                markedTilesO.contains(7) && markedTilesO.contains(5) ||
                markedTilesO.contains(6) && markedTilesO.contains(9)) {
            root.getChildren().stream()
                    .filter(node -> node instanceof Tile && ((Tile) node).idNumber==3)
                    .findFirst();

            markedTilesO.add(3);
        } else if (markedTilesO.contains(2) && markedTilesO.contains(3) ||
                markedTilesO.contains(7) && markedTilesO.contains(4) ||
                markedTilesO.contains(5) && markedTilesO.contains(9)) {
            markedTilesO.add(1);
        } else if (markedTilesO.contains(1) && markedTilesO.contains(4) ||
                markedTilesO.contains(3) && markedTilesO.contains(5) ||
                markedTilesO.contains(8) && markedTilesO.contains(9)) {
            markedTilesO.add(7);
        } else if (markedTilesO.contains(1) && markedTilesO.contains(5) ||
                markedTilesO.contains(7) && markedTilesO.contains(8) ||
                markedTilesO.contains(6) && markedTilesO.contains(3)) {
            markedTilesO.add(9);
        } else if (markedTilesO.contains(1) && markedTilesO.contains(3)) {
            markedTilesO.add(2);
        } else if (markedTilesO.contains(4) && markedTilesO.contains(6)) {
            markedTilesO.add(5);
        } else if (markedTilesO.contains(7) && markedTilesO.contains(9)) {
            markedTilesO.add(8);
        } else if (markedTilesO.contains(7) && markedTilesO.contains(1)) {
            markedTilesO.add(4);
        } else if (markedTilesO.contains(2) && markedTilesO.contains(8)) {
            markedTilesO.add(5);
        } else if (markedTilesO.contains(3) && markedTilesO.contains(9)) {
            markedTilesO.add(6);
        } else if (markedTilesX.contains(1) && markedTilesX.contains(2) ||
                markedTilesX.contains(7) && markedTilesX.contains(5) ||
                markedTilesX.contains(6) && markedTilesX.contains(9)) {
            markedTilesO.add(3);
        } else if (markedTilesX.contains(2) && markedTilesX.contains(3) ||
                markedTilesX.contains(7) && markedTilesX.contains(4) ||
                markedTilesX.contains(5) && markedTilesX.contains(9)) {
            markedTilesO.add(1);
        } else if (markedTilesX.contains(1) && markedTilesX.contains(4) ||
                markedTilesX.contains(3) && markedTilesX.contains(5) ||
                markedTilesX.contains(8) && markedTilesX.contains(9)) {
            markedTilesO.add(7);
        } else if (markedTilesX.contains(1) && markedTilesX.contains(5) ||
                markedTilesX.contains(7) && markedTilesX.contains(8) ||
                markedTilesX.contains(6) && markedTilesX.contains(3)) {
            markedTilesO.add(9);
        } else if (markedTilesX.contains(1) && markedTilesX.contains(3)) {
            markedTilesO.add(2);
        } else if (markedTilesX.contains(4) && markedTilesX.contains(6)) {
            markedTilesO.add(5);
        } else if (markedTilesX.contains(7) && markedTilesX.contains(9)) {
            markedTilesO.add(8);
        } else if (markedTilesX.contains(7) && markedTilesX.contains(1)) {
            markedTilesO.add(4);
        } else if (markedTilesX.contains(2) && markedTilesX.contains(8)) {
            markedTilesO.add(5);
        } else if (markedTilesX.contains(3) && markedTilesX.contains(9)) {
            markedTilesO.add(6);
        }
        Tile tile = tiles.get(computerTileIndexAdvanced);
        tile.text.setText("O");
        markedTilesO.add(tile.idNumber);
        verifyResult(markedTilesO);
    }

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
//                endOfGame();
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
    public void endOfRound(){
        if(requestedNumberOfGames<(countX+countO)){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("End of Round");
            String message = "";
            alert.setHeaderText("Thank you for playing Tic Tac Toe");
            if (isWinningCombinationXCorrect()) {
                countX++;
                message = "Won X this round.\"Total win for X is: \" + countX";
            } else if (isWinningCombinationOCorrect()) {
                countO++;
                message = "Won O this round.\"Total win for O is: \" + countO";
            } else {
                message = "Draw, Would you like to play again?";
            }
            alert.setContentText(message);

        } else {
            endOfGame();
        }
    }
    public void endOfGame() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("End of Game");
        String message = "";
        alert.setHeaderText("Thank you for playing Tic Tac Toe");
        if (isWinningCombinationXCorrect()) {
            message = "Won X, Would you like to play new game?";
            countX++;
            System.out.println("Total win for X is: " + countX);
        } else if (isWinningCombinationOCorrect()) {
            message = "Won O, Would you like to play new game?";
            countO++;
            System.out.println("Total win for O is: " + countO);
        } else {
            message = "Remis,  Would you like to play new game?";
        }
        alert.setContentText(message);

        Optional<ButtonType> result = alert.showAndWait();
 //       if((countO+countX)< requestedNumberOfGames) {
            if (result.get() == ButtonType.OK) {
                this.markedTilesX = new HashSet<>();
                this.markedTilesO = new HashSet<>();
                for (int i = 0; i < root.getChildren().size(); i++) {
                    ((Tile) root.getChildren().get(i)).text.setText("");
                }
            } else {

                appPrimaryStage.close();
            }
 //       }
    }
}



