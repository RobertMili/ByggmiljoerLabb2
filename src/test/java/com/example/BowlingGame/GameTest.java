package com.example.BowlingGame;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

import static org.assertj.core.api.Assertions.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class GameTest {

    Game game = new Game();
    @Order(1)
    @Test
    void A(){

        game.roll(2);
        game.roll(5);

        assertThat(game.score()).isEqualTo(7);
    }


    @Order(2)
    @Test
    void B(){

        game.roll(1);
        game.roll(2);

        assertThat(game.score()).isEqualTo(3);
    }

    @Order(3)
    @Test
    void C(){

        game.roll(1);
        game.roll(2);

        assertThat(game.score()).isEqualTo(3);
    }

}