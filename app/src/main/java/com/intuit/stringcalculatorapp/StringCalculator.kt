package com.intuit.stringcalculatorapp


class StringCalculator {

    fun isValidInput(text: String):Boolean{
        var text = text
        return if (text == "") {
            false
        } else {
            var delimiter = ","
            if (text.matches("//(.*)\n(.*)".toRegex())) {
                delimiter = text[2].toString()
                text = text.substring(4)
            }
            val numList = splitNumbers(text, "$delimiter|\n")
           return true
        }
    }

    fun add(text: String): Int {
        var text = text
        return if (text == "") {
            0
        } else {
            var delimiter = ","
            if (text.matches("//(.*)\n(.*)".toRegex())) {
                delimiter = text[2].toString()
                text = text.substring(4)
            }
            val numList = splitNumbers(text, "$delimiter|\n")
            sum(numList)
        }
    }

    private fun toIntCast(number: String): Int {
        return number.toInt()
    }

    private fun splitNumbers(numbers: String, divider: String): Array<String> {
        return numbers.split(divider).toTypedArray()
    }

    private fun sum(numbers: Array<String>): Int {
        var total = 0
        var negString = ""
        for (number in numbers) {
            if (toIntCast(number) < 0) {
                if (negString == "") negString = number else negString += ",$number"
            }
            if (toIntCast(number) < 1000) total += toIntCast(number)
        }
        require(negString == "") { "Negatives not allowed: $negString" }
        return total
    }
}