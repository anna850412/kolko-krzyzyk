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
    GridPane root;
    Set<Integer> markedTilesX = new HashSet<>();
    Set<Integer> markedTilesO = new HashSet<>();
    List<HashSet<Integer>> winningCombinations = new ArrayList<>();
    Stage appPrimaryStage;
    Stage primaryStage;
    Scene sceneWithButton;


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
        Tile tile = tiles.get(computerTileIndexAdvanced);
        tile.text.setText("O");
        markedTilesO.add(tile.idNumber);
        verifyResult(markedTilesO);
        if (!ifFieldWasUsedBefore(tile)) {
            if ((markedTilesO.contains(1) && markedTilesO.contains(2)) ||
                    (markedTilesO.contains(7) && markedTilesO.contains(5)) ||
                    (markedTilesO.contains(6) && markedTilesO.contains(9))) {
//                root.getChildren().stream()
//                        .filter(node -> node instanceof Tile && ((Tile) node).idNumber == 3)
//                        .findAny();
                markedTilesO.add(3);
                markedTilesO.add(tile.idNumber);
                tile.text.setText("O");
                verifyResult(markedTilesO);
            } else if ((markedTilesO.contains(2) && markedTilesO.contains(3)) ||
                    (markedTilesO.contains(7) && markedTilesO.contains(4)) ||
                    (markedTilesO.contains(5) && markedTilesO.contains(9))) {
                markedTilesO.add(1);
                tile.text.setText("O");
                verifyResult(markedTilesO);
            } else if ((markedTilesO.contains(1) && markedTilesO.contains(4)) ||
                    (markedTilesO.contains(3) && markedTilesO.contains(5)) ||
                    (markedTilesO.contains(8) && markedTilesO.contains(9))) {
                markedTilesO.add(7);
                tile.text.setText("O");
                verifyResult(markedTilesO);
            } else if ((markedTilesO.contains(1) && markedTilesO.contains(5)) ||
                    (markedTilesO.contains(7) && markedTilesO.contains(8)) ||
                    (markedTilesO.contains(6) && markedTilesO.contains(3))) {
                markedTilesO.add(9);
                tile.text.setText("O");
                verifyResult(markedTilesO);
            } else if (markedTilesO.contains(1) && markedTilesO.contains(3)) {
                markedTilesO.add(2);
                tile.text.setText("O");
                verifyResult(markedTilesO);
            } else if (markedTilesO.contains(4) && markedTilesO.contains(6)) {
                markedTilesO.add(5);
                tile.text.setText("O");
                verifyResult(markedTilesO);
            } else if (markedTilesO.contains(7) && markedTilesO.contains(9)) {
                markedTilesO.add(8);
                tile.text.setText("O");
                verifyResult(markedTilesO);
            } else if (markedTilesO.contains(7) && markedTilesO.contains(1)) {
                markedTilesO.add(4);
                tile.text.setText("O");
                verifyResult(markedTilesO);
            } else if (markedTilesO.contains(2) && markedTilesO.contains(8)) {
                markedTilesO.add(5);
                tile.text.setText("O");
                verifyResult(markedTilesO);
            } else if (markedTilesO.contains(3) && markedTilesO.contains(9)) {
                markedTilesO.add(6);
                tile.text.setText("O");
                verifyResult(markedTilesO);
            } else if ((markedTilesX.contains(1) && markedTilesX.contains(2)) ||
                    (markedTilesX.contains(7) && markedTilesX.contains(5)) ||
                    (markedTilesX.contains(6) && markedTilesX.contains(9))) {
                markedTilesO.add(3);
                tile.text.setText("O");
                verifyResult(markedTilesO);
            } else if ((markedTilesX.contains(2) && markedTilesX.contains(3)) ||
                    (markedTilesX.contains(7) && markedTilesX.contains(4)) ||
                    (markedTilesX.contains(5) && markedTilesX.contains(9))) {
                markedTilesO.add(1);
                tile.text.setText("O");
                verifyResult(markedTilesO);
            } else if ((markedTilesX.contains(1) && markedTilesX.contains(4)) ||
                    (markedTilesX.contains(3) && markedTilesX.contains(5)) ||
                    (markedTilesX.contains(8) && markedTilesX.contains(9))) {
                markedTilesO.add(7);
                tile.text.setText("O");
                verifyResult(markedTilesO);
            } else if ((markedTilesX.contains(1) && markedTilesX.contains(5)) ||
                    (markedTilesX.contains(7) && markedTilesX.contains(8)) ||
                    (markedTilesX.contains(6) && markedTilesX.contains(3))) {
                markedTilesO.add(9);
                tile.text.setText("O");
                verifyResult(markedTilesO);
            } else if (markedTilesX.contains(1) && markedTilesX.contains(3)) {
                markedTilesO.add(2);
                tile.text.setText("O");
                verifyResult(markedTilesO);
            } else if (markedTilesX.contains(4) && markedTilesX.contains(6)) {
                markedTilesO.add(5);
                tile.text.setText("O");
                verifyResult(markedTilesO);
            } else if (markedTilesX.contains(7) && markedTilesX.contains(9)) {
                markedTilesO.add(8);
                tile.text.setText("O");
                verifyResult(markedTilesO);
            } else if (markedTilesX.contains(7) && markedTilesX.contains(1)) {
                markedTilesO.add(4);
                tile.text.setText("O");
                verifyResult(markedTilesO);
            } else if (markedTilesX.contains(2) && markedTilesX.contains(8)) {
                markedTilesO.add(5);
                tile.text.setText("O");
                verifyResult(markedTilesO);
            } else if (markedTilesX.contains(3) && markedTilesX.contains(9)) {
                markedTilesO.add(6);
                tile.text.setText("O");
                verifyResult(markedTilesO);
            } else if (markedTilesX.contains(2) && markedTilesX.contains(5)) {
                root.getChildren().stream()
                        .filter(node -> node instanceof Tile && ((Tile) node).idNumber == 8)
                        .findFirst();
                markedTilesO.add(8);
                tile.text.setText("O");
                verifyResult(markedTilesO);
            }

        }
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
        if (requestedNumberOfGames > (countX + countO + draw)) {
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
        } else if (isWinningCombinationOCorrect()) {
            message = "Won O, Would you like to play new game?";
        } else {
            message = "Draw. Would you like to play again?";
        }
        alert.setContentText(message);
        Optional<ButtonType> result = alert.showAndWait();
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

    public void writeResult() {
        Path path = Paths.get("c://output.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write("Zapisuje wynik");
        } catch (IOException e) {
            System.out.println("wystąpił błąd: " + e);
        }
    }

    public void readResult() {
        Path file = Paths.get("c://output.txt");
        try (Stream<String> stream = Files.lines(file)) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("wystąpił błąd: " + e);
        }
    }
    File savedHashMaps = new File("ranking.list");
    Map<String, Long> map = new HashMap<>();

    public void saveMap () {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(savedHashMaps));
            oos.writeObject(map);
            oos.close();
        } catch (Exception e) {
            // obsługa błędów
        }
    }

    public void loadMap () {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(savedHashMaps));
            Object readMap = ois.readObject();
            if (readMap instanceof HashMap) {
                map.putAll((HashMap) readMap);
            }
            ois.close();
        } catch (Exception e) {
            // obsługa błędów
        }
    }
}



