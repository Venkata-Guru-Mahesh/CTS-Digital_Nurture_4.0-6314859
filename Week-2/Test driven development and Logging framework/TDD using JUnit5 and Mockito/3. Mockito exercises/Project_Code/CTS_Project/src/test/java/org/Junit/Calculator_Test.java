package org.Junit;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Calculator_Test {
    Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        Assert.assertEquals(5, calculator.add(2, 3));
        Assert.assertEquals(22, calculator.add(25, -3));
    }

    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(5, calculator.subtract(10, 5));
        Assert.assertEquals(-2, calculator.subtract(3, 5));
    }

    @Test
    public void testMultiply() {
        Assert.assertEquals(6, calculator.multiply(2, 3));
        Assert.assertEquals(-6, calculator.multiply(-2, 3));
        Assert.assertEquals(6, calculator.multiply(-2, -3));
    }

    @Test
    public void testIsPositive() {
        assertTrue(calculator.isPositive(10));
        assertFalse(calculator.isPositive(-1));
    }
}
