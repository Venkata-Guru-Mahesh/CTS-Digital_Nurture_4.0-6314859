package org.Junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AAA_CalculatorTest {
        private Calculator calculator;
        public int a = 10;
        public int b = 2;

        @Before
        public void setUp() {
            calculator = new Calculator();
            System.out.println("Setup complete");
        }

        @After
        public void tearDown() {
            System.out.println("Teardown complete");
        }

        @Test
        public void testAdd() {
            int result = calculator.add(a, b);
            assertEquals(12, result);
        }

        @Test
        public void testSubtract() {
            int result = calculator.subtract(a,b);
            assertEquals(8, result);
        }

        @Test
        public void testMultiply() {
            int result = calculator.multiply(a, b);
            assertEquals(20, result);
        }

        @Test
        public void testIsPositive() {
            assertTrue(calculator.isPositive(a));
            assertFalse(calculator.isPositive(-1));
        }

}

