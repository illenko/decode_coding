package com.illenko.netflix.diys.diy4 // ktlint-disable filename

internal object Solution {
    fun isMonotonic(arr: IntArray): Boolean {
        var increasing = true
        var decreasing = true
        var lastElement = arr.first()

        for (i in 1 until arr.size) {
            if (lastElement < arr[i]) decreasing = false
            if (lastElement > arr[i]) increasing = false
            lastElement = arr[i]
        }
        return increasing || decreasing
    }
}
