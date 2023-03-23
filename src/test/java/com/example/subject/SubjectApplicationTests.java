package com.example.subject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SubjectApplicationTests {

    Calculator c = new Calculator();

    @Test
    void contextLoads() {
    }

    @Test
    void checkSum() {
        int actualSum = c.doSum(4, 6);
        int expectedSum = 10;
        assertThat(actualSum).isEqualTo(expectedSum);
    }

}
