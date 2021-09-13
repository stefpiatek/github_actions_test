package test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig
@SpringBootTest
@ActiveProfiles("test")
class TestAdder {
    @Autowired
    private Adder adder;

    @Test
    void testAdder() {
        assertEquals(2, adder.add(1, 1));
    }

}


