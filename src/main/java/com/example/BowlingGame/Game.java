package com.example.BowlingGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Game {
    private final int bonus = 10;
    private static int savingScore = 0;
    private static int[] rolling = new int[0];

    static List<Integer> scoreList = new ArrayList<>();
    static HashMap<Integer,Integer> counter = new HashMap<>();
    static  int count = 0;

    public static void main(String[] args) {


    }

    static void roll(int knockedPins) {


        scoreList.add(knockedPins);
        count++;


        savingScore = scoreList.stream().mapToInt(Integer::intValue).sum();



        if (count < 19) {
            if (scoreList.size() == 2) {
                scoreList.clear();
            }
        } else if (count >= 19 && count <= 21){
            if (scoreList.size() == 3) {
                scoreList.clear();
            }
        } else if (count > 21){
            System.out.println("Game is Over");
            scoreList.clear();
            savingScore = 0;
        }


        score();
    }

    static int score() {
        return savingScore;
    }
}
