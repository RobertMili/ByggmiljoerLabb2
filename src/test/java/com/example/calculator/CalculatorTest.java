package com.example.calculator;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    Calculator calculator = new Calculator();


    @Test
    void addOne() {
        var result = Calculator.Add("1");

        assertThat(result).isEqualTo(1);
    }

    @Test
    void addEmptyString() {
        var result = Calculator.Add("");

        assertThat(result).isEqualTo(0);
    }

    @Test
    void addOneCommaTwo() {
        var result = Calculator.Add("1,2");

        assertThat(result).isEqualTo(3);
    }

    @Test
    void addNumbersWithN() {
        var result = Calculator.Add("1\n2,3");

        assertThat(result).isEqualTo(6);
    }

    @Test
    void addNewLineAfterComma() {
        var result = Calculator.Add("1,\n");

        assertThat(result).isEqualTo(1);
    }

    @Test
    void addNewLineAndSemicolon() {
        var result = Calculator.Add("//;\n1;2");

        assertThat(result).isEqualTo(3);
    }

    @Test
    void addNegativeNumbers() {

      assertThatThrownBy(() -> Calculator.Add("-1"))
              .hasMessageContaining("Negatives")
              .hasMessageContaining("not")
              .hasMessageContaining("allowed");
    }
    @Test
    void numbersBiggerThan1000(){
        var result = Calculator.Add("2,1001");

        assertThat(result).isEqualTo(2);
    }
    @Test
    void testingMultiNumbers(){
        var result = Calculator.Add("2,1000002,1,1,2,10001,1,");

        assertThat(result).isEqualTo(7);
    }
    @Test
    void addMultipleDelimiters(){
        var result = Calculator.Add("//[*][%]\\n1*2%3");

        assertThat(result).isEqualTo(6);
    }
    @Test
    void multipleDelimitersWithLongerThenOneCharacter(){
        var result = Calculator.Add("//[***][%%%]\\n1***2%%%3");

        assertThat(result).isEqualTo(6);
    }
}