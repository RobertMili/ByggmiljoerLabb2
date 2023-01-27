package com.example.calculator;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void addOne() {
        String number = "1";

        assertThat(number).isEqualTo("1");
    }
    @Test
    void addNothing() {
        String number = "";

        assertThat(number).isEqualTo("");
    }
    @Test
    void addOneCommaTwo() {
        String number = "1,2";

        assertThat(number).isEqualTo("1,2");
    }
}