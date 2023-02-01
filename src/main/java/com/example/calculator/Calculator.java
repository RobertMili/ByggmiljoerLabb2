package com.example.calculator;


import java.util.*;
import java.util.stream.Stream;

public class Calculator {

    

    int Add(String numbers) {
        List<String> numberList = new ArrayList<>();
        List<String> newList;
        List<String> list;
        int result;

            numberList.add(numbers);
            negativeNumbers(numbers);

                list = cleaningToNumbers(numberList);

                    newList = getStringsAvoidImmutableString(list);

                removingEmptyCharAfterRegexCleaning(newList);

            result = getNumbersUnder1000AndSum(newList);

        return result;
    }

    private  List<String> getStringsAvoidImmutableString(List<String> list) {
        List<String> newList;
        newList = new ArrayList<>(list);
        return newList;
    }

    private int getNumbersUnder1000AndSum(List<String> newList) {
        int result;
        result = newList.stream()
                .filter(s -> Integer.parseInt(s) <= 1000)
                .mapToInt(Integer::parseInt)
                .sum();
        return result;
    }

    private void removingEmptyCharAfterRegexCleaning(List<String> newList) {
        newList.removeIf(element -> element.equals(""));
    }

    private List<String> cleaningToNumbers(List<String> numberList) {
        return numberList.stream()
                .flatMap(s -> Arrays.stream(s.split("//")))
                .flatMap(s -> Arrays.stream(s.split("/")))
                .flatMap(s -> Arrays.stream(s.split(",")))
                .flatMap(s -> Arrays.stream(s.split("\n")))
                .flatMap(s -> Arrays.stream(s.split(";")))
                .flatMap(s -> Arrays.stream(s.split("\\[")))
                .flatMap(s -> Arrays.stream(s.split("]")))
                .flatMap(s -> Arrays.stream(s.split("[*]")))
                .flatMap(s -> Arrays.stream(s.split("%")))
                .flatMap(s -> Arrays.stream(s.split("[a-z]")))
                .flatMap(s -> Arrays.stream(s.split("\\\\")))
                .toList();

    }

    public void negativeNumbers(String number) {
        if (number.contains("-")) {
            StringBuilder negative = getNegativeNumber(number);
            throw new RuntimeException("Negatives " + negative + " not allowed"); //Throwing customer exception, not original!
        }
    }


    private StringBuilder getNegativeNumber(String number) {
        StringBuilder negative = new StringBuilder();

        negative.append("( ");
        Stream.of(number.split("[,\\n]"))
                .filter(s -> s.contains("-"))
                .forEach(s -> negative.append(s).append(" "));
        negative.append(")");

        return negative;
    }
}


