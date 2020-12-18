package com.example.kolkokrzyzyk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test of all possible selections of Winning Combination")
public class TestSuite {

    @Test
    void testWinningCombinationBeforeStartOfTheGameShouldReturnFalse(){
        //Given
        GameController gameController = new GameController(null, null);
        //When
       // gameController.isWinningCombinationCorret();
        //Then
        Assertions.assertFalse(gameController.isWinningCombinationXCorrect());
        Assertions.assertFalse(gameController.isWinningCombinationOCorrect());
    }

    @Test
    void testWinningCombinationHorizontalFirstLineOWin(){
        //Given
        GameController gameController = new GameController(null, null);
        gameController.markedTilesO.add(1);
        gameController.markedTilesO.add(2);
        gameController.markedTilesO.add(3);
        //When
       // gameController.isWinningCombinationCorret();
        //Then
        Assertions.assertTrue(gameController.isWinningCombinationOCorrect());
    }
    @Test
    void testWinningCombinationHorizontalSecondLineOWin(){
        //Given
        GameController gameController = new GameController(null, null);
        gameController.markedTilesO.add(4);
        gameController.markedTilesO.add(5);
        gameController.markedTilesO.add(6);
        //When
        // gameController.isWinningCombinationCorret();
        //Then
        Assertions.assertTrue(gameController.isWinningCombinationOCorrect());
    }
    @Test
    void testWinningCombinationHorizontalThirdLineOWin(){
        //Given
        GameController gameController = new GameController(null, null);
        gameController.markedTilesO.add(7);
        gameController.markedTilesO.add(8);
        gameController.markedTilesO.add(9);
        //When
        // gameController.isWinningCombinationCorret();
        //Then
        Assertions.assertTrue(gameController.isWinningCombinationOCorrect());
    }
    @Test
    void testWinningCombinationHorizontalFirstLineXWin(){
        //Given
        GameController gameController = new GameController(null, null);
        gameController.markedTilesX.add(1);
        gameController.markedTilesX.add(2);
        gameController.markedTilesX.add(3);
        //When
        // gameController.isWinningCombinationCorret();
        //Then
        Assertions.assertTrue(gameController.isWinningCombinationXCorrect());
    }
    @Test
    void testWinningCombinationHorizontalSecondLineXWin(){
        //Given
        GameController gameController = new GameController(null, null);
        gameController.markedTilesX.add(4);
        gameController.markedTilesX.add(5);
        gameController.markedTilesX.add(6);
        //When
        // gameController.isWinningCombinationCorret();
        //Then
        Assertions.assertTrue(gameController.isWinningCombinationXCorrect());
    }
    @Test
    void testWinningCombinationHorizontalThirdLineXWin(){
        //Given
        GameController gameController = new GameController(null, null);
        gameController.markedTilesX.add(7);
        gameController.markedTilesX.add(8);
        gameController.markedTilesX.add(9);
        //When
        // gameController.isWinningCombinationCorret();
        //Then
        Assertions.assertTrue(gameController.isWinningCombinationXCorrect());
    }
    @Test
    void testWinningCombinationDiagonalLeftOLineWin(){
        //Given
        GameController gameController = new GameController(null, null);
        gameController.markedTilesO.add(1);
        gameController.markedTilesO.add(5);
        gameController.markedTilesO.add(9);
        //When
        // gameController.isWinningCombinationCorret();
        //Then
        Assertions.assertTrue(gameController.isWinningCombinationOCorrect());
    }
    @Test
    void testWinningCombinationDiagonalLeftXLineWin(){
        //Given
        GameController gameController = new GameController(null, null);
        gameController.markedTilesX.add(1);
        gameController.markedTilesX.add(5);
        gameController.markedTilesX.add(9);
        //When
        // gameController.isWinningCombinationCorret();
        //Then
        Assertions.assertTrue(gameController.isWinningCombinationXCorrect());
    }
    @Test
    void testWinningCombinationDiagonalRightOLineWin(){
        //Given
        GameController gameController = new GameController(null, null);
        gameController.markedTilesO.add(3);
        gameController.markedTilesO.add(5);
        gameController.markedTilesO.add(7);
        //When
        // gameController.isWinningCombinationCorret();
        //Then
        Assertions.assertTrue(gameController.isWinningCombinationOCorrect());
    }
    @Test
    void testWinningCombinationDiagonalRightXLineWin(){
        //Given
        GameController gameController = new GameController(null, null);
        gameController.markedTilesX.add(3);
        gameController.markedTilesX.add(5);
        gameController.markedTilesX.add(7);
        //When
        // gameController.isWinningCombinationCorret();
        //Then
        Assertions.assertTrue(gameController.isWinningCombinationXCorrect());
    }
    @Test
    void testWinningCombinationVerticalFirstLineOWin(){
        //Given
        GameController gameController = new GameController(null, null);
        gameController.markedTilesO.add(1);
        gameController.markedTilesO.add(4);
        gameController.markedTilesO.add(7);
        //When
        // gameController.isWinningCombinationCorret();
        //Then
        Assertions.assertTrue(gameController.isWinningCombinationOCorrect());
    }
    @Test
    void testWinningCombinationVerticalSecondLineOWin(){
        //Given
        GameController gameController = new GameController(null, null);
        gameController.markedTilesO.add(2);
        gameController.markedTilesO.add(5);
        gameController.markedTilesO.add(8);
        //When
        // gameController.isWinningCombinationCorret();
        //Then
        Assertions.assertTrue(gameController.isWinningCombinationOCorrect());
    }
    @Test
    void testWinningCombinationVerticalThirdLineOWin(){
        //Given
        GameController gameController = new GameController(null, null);
        gameController.markedTilesO.add(3);
        gameController.markedTilesO.add(6);
        gameController.markedTilesO.add(9);
        //When
        // gameController.isWinningCombinationCorret();
        //Then
        Assertions.assertTrue(gameController.isWinningCombinationOCorrect());
    }
    @Test
    void testWinningCombinationVerticalFirstLineXWin(){
        //Given
        GameController gameController = new GameController(null, null);
        gameController.markedTilesX.add(1);
        gameController.markedTilesX.add(4);
        gameController.markedTilesX.add(7);
        //When
        // gameController.isWinningCombinationCorret();
        //Then
        Assertions.assertTrue(gameController.isWinningCombinationXCorrect());
    }
    @Test
    void testWinningCombinationVerticalSecondLineXWin(){
        //Given
        GameController gameController = new GameController(null, null);
        gameController.markedTilesX.add(2);
        gameController.markedTilesX.add(5);
        gameController.markedTilesX.add(8);
        //When
        // gameController.isWinningCombinationCorret();
        //Then
        Assertions.assertTrue(gameController.isWinningCombinationXCorrect());
    }
    @Test
    void testWinningCombinationVerticalThirdLineXWin(){
        //Given
        GameController gameController = new GameController(null, null);
        gameController.markedTilesX.add(3);
        gameController.markedTilesX.add(6);
        gameController.markedTilesX.add(9);
        //When
        // gameController.isWinningCombinationCorret();
        //Then
        Assertions.assertTrue(gameController.isWinningCombinationXCorrect());
    }
}
