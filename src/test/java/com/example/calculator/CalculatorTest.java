package com.example.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    Calculator calculator = new Calculator();


    @Test
    void addOne() {
        var result =calculator.Add("1");

        assertThat(result).isEqualTo(1);
    }
    @Test
    void addEmptyString() {
        var result = calculator.Add("");

        assertThat(result).isEqualTo(0);
    }
    @Test
    void addOneCommaTwo() {
        var result = calculator.Add("1,2");

        assertThat(result).isEqualTo(3);
    }

    @Test
    void addNumbersWithN(){
        var result = calculator.Add("1\n2,3");

        assertThat(result).isEqualTo(6);
    }
    @Test
    void addNewLineAfterComma(){
        var result = calculator.Add("1,\n");

        assertThat(result).isEqualTo(1);
    }
    @Test
    void addNewLineAndSemicolon(){
        var result = calculator.Add("-1");

        assertThat(result).isEqualTo(3);
    }

}