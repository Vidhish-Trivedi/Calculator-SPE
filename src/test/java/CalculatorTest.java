package org.example;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    double epsilon = 0.0001;
    // Test for Add method
    @Test
    public void testAdd() {
        assertEquals(5.0, Main.Add(2.0, 3.0), epsilon);
        assertEquals(10.0, Main.Add(-2.0, 2.0), epsilon);
        assertEquals(-5.0, Main.Add(-3.0, -2.0), epsilon);
    }

    // Test for Multiply method
    @Test
    public void testMultiply() {
        assertEquals(6.0, Main.Multiply(2.0, 3.0), epsilon);
        assertEquals(0.0, Main.Multiply(0.0, 3.0), epsilon);
        assertEquals(-6.0, Main.Multiply(-2.0, 3.0), epsilon);
    }

    // Test for Factorial method
    @Test
    public void testFactorial() {
        assertEquals(120, Main.Factorial(5));
        assertEquals(1, Main.Factorial(0));  // 0! = 1
        assertEquals(-1, Main.Factorial(-5)); // invalid input
    }

    // Test for Square_Root method
    @Test
    public void testSquareRoot() {
        assertEquals(4.0, Main.Square_Root(16.0), epsilon);
        assertEquals(0.0, Main.Square_Root(0.0), epsilon);
        assertEquals(-1.0, Main.Square_Root(-4.0), epsilon);  // invalid input
    }
}
