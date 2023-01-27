package com.example.calculator;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Calculator {

    public static void main(String[] args) {
        Add("//;\n1;2");
    }

    public static int Add(String numbers) {
        String[] test = numbers.split(";\\n");
        List<String> numberList = new ArrayList<>();

        int result = 0;

        numberList.add(numbers);

        if (numbers.equals("")) {
            return 0;
        }
        List<String> list = numberList.stream()
                .flatMap(s -> Arrays.stream(s.split("//")))
                .flatMap(s -> Arrays.stream(s.split("/")))
                .flatMap(s -> Arrays.stream(s.split(",")))
                .flatMap(s -> Arrays.stream(s.split("\n")))
                .flatMap(s -> Arrays.stream(s.split(";")))
                .toList();


        List<String> unmodifiableList = Collections.unmodifiableList(list);

        List<String> newList = new ArrayList<>(unmodifiableList);

        for (int i = 0; i < newList.size(); i++) {
            if (newList.get(i).equals("")) {
                newList.remove(i);
                i--;
            }
        }

        for (String s : newList) {
            System.out.println(s);
        }

        for (int i = 0; i < newList.size(); i++) {
            result+= Integer.parseInt(newList.get(i));
        }

        return result;


    }
}
