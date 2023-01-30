package com.example.BowlingGame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final int bonus = 10;
    private static int savingScore = 0;
    private static int[] rolling = new int[0];

    static List<Integer> scoreList = new ArrayList<>();

    public static void main(String[] args) {

    }

    static void roll(int knockedPins){

            scoreList.add(knockedPins);

            scoreList = scoreList.stream()
                    .limit(2)
                    .collect(Collectors.toList());

            savingScore = scoreList.stream().mapToInt(Integer::intValue).sum();

            score();

            if (scoreList.size() == 2){
                scoreList.clear();
            }



    }
    static int score(){
        return savingScore;
    }
}
