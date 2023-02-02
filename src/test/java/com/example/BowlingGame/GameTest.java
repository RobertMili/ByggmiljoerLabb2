package com.example.BowlingGame;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GameTest {

    Game game = new Game();

    private void rollGame(int rolls, int pins){
        for (int i = 0; i <rolls; i++) {
            game.roll(pins);
        }
    }
    @Order(1)
    @Test
    void addPointsExpected0(){
        rollGame(21,0);

        assertThat(game.score()).isZero();
    }
    @Order(2)
    @Test
    void addTwoPointsExpected3() {
        game.roll(1);
        game.roll(2);
        rollGame(19, 0);

        assertThat(game.score()).isEqualTo(3);
    }

    @Order(3)
    @Test
    void addThreePointsExpected6() {
        game.roll(1);
        game.roll(2);
        game.roll(3);
        rollGame(18, 0);

        assertThat(game.score()).isEqualTo(6);
    }
    @Order(4)
    @Test
    void addStrikeToGetBonusPointsExpected24(){
        game.roll(10);
        game.roll(3);
        game.roll(4);
        rollGame(16,0);

        assertThat(game.score()).isEqualTo(24);
    }
    @Order(5)
    @Test
    void addSpareToGetBonusPointsExpected16(){
        game.roll(5);
        game.roll(5);
        game.roll(3);
        rollGame(17,0);

        assertThat(game.score()).isEqualTo(16);
    }

    @Order(5)
    @Test
    void addAllStrikeExpectedResult300(){

        rollGame(12,10);

        assertThat(game.score()).isEqualTo(300);
    }

}