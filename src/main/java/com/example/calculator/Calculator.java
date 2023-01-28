package com.example.calculator;

import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calculator {

    public static void main(String[] args) {
        Add("2,1001");
    }

    public static int Add(String numbers) {

        List<String> numberList = new ArrayList<>();

        int result = 0;

        numberList.add(numbers);

        if (numbers.equals("")) {
            return 0;
        }

        negativeNumbers(numbers);


        List<String> list = numberList.stream()
                .flatMap(s -> Arrays.stream(s.split("//")))
                .flatMap(s -> Arrays.stream(s.split("/")))
                .flatMap(s -> Arrays.stream(s.split(",")))
                .flatMap(s -> Arrays.stream(s.split("\n")))
                .flatMap(s -> Arrays.stream(s.split(";")))
                .flatMap(s -> Arrays.stream(s.split("\\[")))
                .flatMap(s -> Arrays.stream(s.split("\\]")))
                .flatMap(s -> Arrays.stream(s.split("[*]")))
                .flatMap(s -> Arrays.stream(s.split("[%]")))
                .flatMap(s -> Arrays.stream(s.split("%")))
                .flatMap(s -> Arrays.stream(s.split("[a-z]")))
                .flatMap(s -> Arrays.stream(s.split("\\\\")))

                .toList();


        List<String> unmodifiableList = Collections.unmodifiableList(list);

        List<String> newList = new ArrayList<>(unmodifiableList);


        newList= newList.stream()
                .map(String::trim)
                .collect(Collectors.toList());

        for (String s : newList) {
            System.out.println(s);
        }
        for (int i = 0; i < newList.size(); i++) {
            if (newList.get(i).equals("")) {
                newList.remove(i);
                i--;
            }
        }



        for (int i = 0; i < newList.size(); i++) {
            if (Integer.parseInt(newList.get(i)) > 1000){
                newList.remove(i);
                i--;
            } else {
                result += Integer.parseInt(newList.get(i));
            }
        }


        return result;
    }

    public static void negativeNumbers(String number) {
        if (number.contains("-")) {
            StringBuilder negative = getNegativeNumber(number);
            throw new RuntimeException("Negatives " + negative + " not allowed");
        }
    }

    private static StringBuilder getNegativeNumber(String number) {
        StringBuilder negative = new StringBuilder();

            negative.append("( ");
            Stream.of(number.split(",|\\n"))
                    .filter(s -> s.contains("-"))
                    .forEach(s -> negative.append(s).append(" "));
            negative.append(")");

        return negative;
    }
}


