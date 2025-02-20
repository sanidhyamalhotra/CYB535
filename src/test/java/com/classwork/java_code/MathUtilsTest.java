package com.classwork.java_code;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MathUtilsTest {

	private MathUtils mathUtils;
	@BeforeEach
	void setUp() {
		mathUtils = new MathUtils();
	}
    @Test
    void testAdd() {
        
        assertEquals(7, mathUtils.add(3, 4), "3 + 4 should equal 7");
        assertEquals(-1, mathUtils.add(-3, 2), "-3 + 2 should equal -1");
        assertEquals(0, mathUtils.add(0, 0), "0 + 0 should equal 0");
    }

    @Test
    void testSubtract() {
        
        assertEquals(1, mathUtils.subtract(5, 4), "5 - 4 should equal 1");
        assertEquals(-5, mathUtils.subtract(-3, 2), "-3 - 2 should equal -5");
        assertEquals(0, mathUtils.subtract(0, 0), "0 - 0 should equal 0");
    }

    @Test
    void testMultiply() {
        assertEquals(15, mathUtils.multiply(3, 5), "3 * 5 should equal 15");
        assertEquals(-6, mathUtils.multiply(-3, 2), "-3 * 2 should equal -6");
        assertEquals(0, mathUtils.multiply(0, 5), "0 * 5 should equal 0");
    }

    @Test
    void testDivide() {
        assertEquals(2.5, mathUtils.divide(5, 2), "5 / 2 should equal 2.5");
        assertEquals(-2.0, mathUtils.divide(-4, 2), "-4 / 2 should equal -2.0");
        assertEquals(-1.0, mathUtils.divide(5, 0), "Division by 0 should return -1.0");
    }
}
