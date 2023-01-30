package com.example.BowlingGame;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GameTest {

    Game game = new Game();

    private void fullGame(int rolls, int pins){
        for (int i = 0; i <rolls; i++) {
            game.roll(pins);
        }
    }


    @Order(1)
    @Test
    void addFirstTestExpected7(){

        game.roll(1);
        game.roll(2);

        assertThat(game.score()).isEqualTo(3);
    }

    @Order(2)
    @Test
    void addSecondTestExpected10(){

        game.roll(7);
        game.roll(3);

        assertThat(game.score()).isEqualTo(10);
    }

    @Order(3)
    @Test
    void addThirdTestExpected3(){

        game.roll(1);
        game.roll(2);

        assertThat(game.score()).isEqualTo(3);
    }
    @Order(4)
    @Test
    void addThatTheLastRollShouldBeThreeTimesRollExpected15(){

        game.roll(1);
        game.roll(2);
        game.roll(1);
        game.roll(2);
        game.roll(1);
        game.roll(2);
        game.roll(1);
        game.roll(2);
        game.roll(1);
        game.roll(2);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);

    assertThat(game.score()).isEqualTo(15);
    }
    @Order(5)
    @Test
    void checkIfIsGameOver(){

        game.roll(1);
        game.roll(2);

        assertThat(game.score()).isEqualTo(0);
    }


}