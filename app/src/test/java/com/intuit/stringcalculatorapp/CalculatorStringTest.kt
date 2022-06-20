package com.intuit.stringcalculatorapp

import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CalculatorStringTest : TestCase() {

    @Test
    fun testEmptyString() {
        assertEquals(0, CalculatorString.add(""))
    }

    @Test
    fun testOneNumber() {
        assertEquals(1, CalculatorString.add("1"))
    }

    @Test
    fun testTwoNumbers() {
        assertEquals(3, CalculatorString.add("1,2"))
    }

    @Test
    fun testThreeNumbers() {
        assertEquals(6, CalculatorString.add("1,2,3"))
    }

    @Test
    fun testNewLine() {
        assertEquals(6, CalculatorString.add("1\n2,3"))
    }

    @Test
    fun testNegativeNumver() {
        try {
            CalculatorString.add("-1,2")
        } catch (e: IllegalArgumentException) {
            assertEquals(e.message, "Negatives not allowed: -1")
        }
        try {
            CalculatorString.add("2,-4,3,-5")
        } catch (e: IllegalArgumentException) {
            assertEquals(e.message, "Negatives not allowed: -4,-5")
        }
    }

    @Test
    fun testOverThousand() {
        assertEquals(2, CalculatorString.add("1000,2"))
    }

    @Test
    fun testOtherDelimiter() {
        assertEquals(3, CalculatorString.add("//;\n1;2"))
    }


}