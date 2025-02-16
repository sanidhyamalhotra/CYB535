package com.classwork.java_code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AddTwoNumberTest {

    @Test
    public void testAddition() {
        // Test cases
        assertEquals(5.0, AddTwoNumber.add(2.0, 3.0));
        assertEquals(-1.0, AddTwoNumber.add(-2.0, 1.0));
        assertEquals(0.0, AddTwoNumber.add(0.0, 0.0));
        assertEquals(100.5, AddTwoNumber.add(50.5, 50.0));
    }
}
