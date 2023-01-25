package com.example;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    Employee employee = new Employee("Robert Milicevic", 1000);

    @AfterEach
    public void tearDown() {
        this.employee = null;
    }

    @Test
    @DisplayName("Get ID should return Robert Milicevic")
    void getIdShouldReturnOne() {
        var expected = employee.getId();

        assertEquals("Robert Milicevic", expected);
    }

    @Test
    @DisplayName("employ renamed")
    void employRenamed() {
        var expected = "Vanja Maric";

        employee.setId(expected);

        assertEquals("Vanja Maric", employee.getId());
    }

    @Test
    @DisplayName("Get Salary should return 1000")
    void getSalaryShouldReturn1000() {
        var expected = employee.getSalary();

        assertEquals(1000, expected);
    }

    @Test
    @DisplayName("employ set new salary")
    void employSetNewSalary() {
        var expected = 1500.0;

        employee.setSalary(expected);

        assertEquals(1500.0, expected);
    }

    @Test
    @DisplayName("Salary should change from 1000 to 2000")
    void setSalaryShouldChangeFrom1000To2000() {
        employee.setSalary(2000);
        var expected = employee.getSalary();

        assertEquals(2000, expected);
    }

    @Test
    @DisplayName("Check if is employ paid")
    void checkPaid() {

        var expected = employee.isPaid();

        employee.setPaid(expected);

        assertFalse(expected);
    }

    @Test
    @DisplayName("Set Paid from False to True")
    void setPaidFromFalseToTrue() {
        employee.setPaid(true);
        var expected = employee.isPaid();

        assertTrue(expected);
    }

    @Test
    @DisplayName("Test To String method")
    void testToStringMethod() {
        var result = employee.toString();

        assertEquals("Employee [id=Robert Milicevic, salary=1000.0]",result);
    }

}