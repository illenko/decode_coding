package com.illenko.netflix.diys.diy11 // ktlint-disable filename

import java.util.*

internal object Solution {
    fun permute(nums: IntArray): List<List<Int>> = backTrack(size = nums.size, numbers = nums.toMutableList())

    private fun backTrack(first: Int = 0, size: Int, numbers: List<Int>): List<List<Int>> =
        if (first == size) listOf(ArrayList(numbers))
        else (first until size).map { index ->
            Collections.swap(numbers, first, index)
            backTrack(first + 1, size, numbers)
                .also { Collections.swap(numbers, first, index) }
        }.flatten().toList()
}

fun main() {
    println(Solution.permute(intArrayOf(1, 2, 3)))
}
