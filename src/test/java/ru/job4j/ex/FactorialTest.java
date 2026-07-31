package ru.job4j.ex;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialTest {

    @Test
    void whenException() {
        Factorial f = new Factorial();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> f.calc(-1)
        );
        assertThat(exception.getMessage()).isEqualTo("Number could not be less than 0");
    }

    @Test
    void whenFactorial3Then6() {
        Factorial f = new Factorial();
        int expected = 6;
        int result = f.calc(3);
        assertThat(expected).isEqualTo(result);
    }
}