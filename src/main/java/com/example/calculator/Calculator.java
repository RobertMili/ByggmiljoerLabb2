package com.example.calculator;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Calculator {

    public static void main(String[] args) {
        Add("\\n1,2");
    }

    public static int Add(String numbers) {
        String[] test = numbers.split(";\\n");
        List<String> numberList = new ArrayList<>();
        String test1 = "";
        String resultString = "";


       String[] stringNumbers =
               numbers.split("//|/|,|;|\\n|\\*|%|]|\\[|\\\\|[a-z]");
        numberList.add(numbers);


        if (numbers.equals("")) {
            return 0;
        }


        List<String> list = numberList.stream()
                .flatMap(s -> Arrays.stream(s.split("//")))
                .flatMap(s -> Arrays.stream(s.split("/")))
                .flatMap(s -> Arrays.stream(s.split(",")))
                .flatMap(s -> Arrays.stream(s.split(";")))
                .flatMap(s -> Arrays.stream(s.split("\\*")))
                .flatMap(s -> Arrays.stream(s.split("[a-z]")))
                .toList();

        for (int i = 0; i < list.size(); i++) {
            System.out.println("Resultat " +list.get(i));
            resultString += Integer.parseInt(list.get(i));

        }

        return result;


    }
}
