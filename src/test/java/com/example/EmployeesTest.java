package com.example;

import org.assertj.core.api.AbstractBooleanAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;


import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;


class EmployeesTest {



    EmployeeRepository employeeRepository = new EmployeeRepositoryStub(List.of(
            new Employee("Robert", 500),
            new Employee("Vanja", 600)));

    BankService bankService = mock(BankService.class);
    Employees employees = new Employees(employeeRepository,bankService);
    @Test
    @DisplayName("get result 2")
    void payEmployees() {
        var expected = employees.payEmployees();

        assertEquals(2,expected);
    }

    @Test
    @DisplayName("Runtime Exception")
    void payEmployeesRuntimeException(){
        doThrow(new RuntimeException()).when(bankService).pay(anyString(),anyDouble());

        employees.payEmployees();


        verify(bankService, times(2)).pay(anyString(), anyDouble());
        assertThat(employeeRepository.findAll().get(0).isPaid()).isFalse();
    }


}