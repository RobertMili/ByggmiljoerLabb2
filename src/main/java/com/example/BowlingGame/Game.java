package com.example.BowlingGame;

public class Game {
    int[] rolls;
    int count;

    public Game(){
        this.rolls = new int[21];
    }

    void roll(int knockedPins) {
        rolls[count++] = knockedPins;

    }

    int score() {
        int score = 0;
        int frame =0;

        for (int i = 0; i < 10; i++) {

            if (getStrike(frame)) {
                score += 10 + getBonusOfStrike(frame);
                frame++;
            }
            score += getRollsSum
                    (frame);
            frame += 2;
        }

        return score;
    }

    private int getBonusOfStrike(int frame) {
        return getRollsSum(frame +1);
    }

    private boolean getStrike(int frame) {
        return rolls[frame] == 10;
    }

    private int getRollsSum(int frame) {
        return rolls[frame] + rolls[frame + 1];
    }


}
