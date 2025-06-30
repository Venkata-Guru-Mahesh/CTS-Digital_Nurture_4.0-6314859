package org.Junit;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MyTestClass {
        @Test
        public void testSetup() {
            assertTrue(true);
            System.out.println("JUnit setup successful!");
        }
    }
