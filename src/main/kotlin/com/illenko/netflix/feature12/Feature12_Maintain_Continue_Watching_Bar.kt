package com.illenko.netflix.feature12 // ktlint-disable filename

import java.util.*
import kotlin.collections.HashMap

internal class FreqStack {
    // Declare a FreqStack class containing frequency and group hashmaps
    // and maxFrequency integer
    private var frequency: MutableMap<String, Int> = HashMap()
    private var group: MutableMap<Int, Stack<String>> = HashMap()
    private var maxFrequency: Int = 0

    // Use push function to push the showName into the FreqStack
    fun push(showName: String) {
        // Get the frequency for the given showName and
        // increment the frequency for the given showName
        val f = frequency.getOrDefault(showName, 0) + 1
        frequency[showName] = f

        // Check if the maximum frequency is lower that the new frequency
        // of the given show
        if (f > maxFrequency) maxFrequency = f

        // Save the given showName for the new calculated frequency
        group.computeIfAbsent(f) { Stack() }.push(showName)
    }

    // Use the pop function to pop the showName from the FreqStack
    fun pop(): String {
        var show = ""
        if (maxFrequency > 0) {
            // Fetch the top of the group[maxFrequency] stack and
            // pop the top of the group[maxFrequency] stack
            show = group[maxFrequency]!!.pop()

            // Decrement the frequency after the show has been popped
            frequency[show] = frequency[show]!! - 1
            if (group[maxFrequency]!!.size == 0) maxFrequency--
        }
        return show
    }
}

fun main() {
    val obj = FreqStack()
    obj.push("Queen's Gambit")
    obj.push("Teen Wolf")
    obj.push("Queen's Gambit")
    obj.push("Teen Wolf")
    obj.push("Bigderton")
    obj.push("Queen's Gambit")
    for (i in 0..6) {
        println("...User navigates to the browser...")
        println("Continue Watching :" + obj.pop())
        println()
    }
}
