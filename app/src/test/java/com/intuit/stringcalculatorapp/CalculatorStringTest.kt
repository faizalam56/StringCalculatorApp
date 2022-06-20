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

}