package com.example.BowlingGame;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final int STRIKE = 10;
    private final int SPARE = 10;
    private int extraRoll = 0;
    private static int cleaningScore = 0;
    private static int total = 0;
    static List<Integer> scoreList = new ArrayList<>();

    static  int count = 0;

    public static void main(String[] args) {

        roll(1);
        roll(1);
    }

    static void roll(int knockedPins) {
        int savingScore = 0;
        scoreList.add(knockedPins);
        count++;
        cleaningScore = scoreList.stream().mapToInt(Integer::intValue).sum();


        if (count < 19) {
            if (scoreList.size() == 2) {

                scoreList.clear();


            }
        } else if (count >= 19 && count <= 21){
            if (scoreList.size() == 3) {
                scoreList.clear();
            }
        } else if (count > 21){
            checkOver21PrintOutGameOver();
        }


        score();
    }

    private static void checkOver21PrintOutGameOver() {
        System.out.println("Game is Over");
        scoreList.clear();
        cleaningScore = 0;
    }

    static int score() {
        System.out.println(cleaningScore);
        return cleaningScore;
    }
}
