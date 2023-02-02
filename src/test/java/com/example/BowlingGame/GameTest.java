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
    void addPointsExpected0(){
        fullGame(21,0);

        assertThat(game.score()).isZero();
    }
    @Order(2)
    @Test
    void addTwoPointsExpected3() {
        game.roll(1);
        game.roll(2);
        fullGame(19, 0);

        assertThat(game.score()).isEqualTo(3);
    }

    @Order(3)
    @Test
    void addThreePointsExpected6() {
        game.roll(1);
        game.roll(2);
        game.roll(3);
        fullGame(18, 0);

        assertThat(game.score()).isEqualTo(6);
    }

}