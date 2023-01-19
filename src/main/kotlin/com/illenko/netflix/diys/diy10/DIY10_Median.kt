package com.illenko.netflix.diys.diy10 // ktlint-disable filename

internal object Solution {
    fun medianSlidingWindow(nums: IntArray, k: Int): DoubleArray {
        val medians = mutableListOf<Double>()

        var i = 0

        while (i + k <= nums.size) {
            val newNums = nums.copyOfRange(i, i + k).sorted()

            medians.add(
                if (k % 2 == 0) (newNums[k / 2] + newNums[k / 2 - 1]) / 2.0
                else newNums[k / 2].toDouble()
            )

            i++
        }

        return medians.toDoubleArray()
    }
}
