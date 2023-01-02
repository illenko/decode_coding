package com.illenko.netflix.feature3 // ktlint-disable filename

import java.util.*

internal class Solution {
    // maxHeap contains first half of numbers
    private var maxHeap: PriorityQueue<Int> = PriorityQueue { a: Int, b: Int -> b - a }

    // minHeap contains second half of numbers
    private var minHeap: PriorityQueue<Int> = PriorityQueue { a: Int, b: Int -> a - b }

    fun insertNum(num: Int) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) maxHeap.add(num) else minHeap.add(num)
        // either both the heaps will have equal number of elements or max-heap will have one
        // more element than the min-heap
        if (maxHeap.size > minHeap.size + 1) minHeap.add(maxHeap.poll())
        else if (maxHeap.size < minHeap.size) maxHeap.add(minHeap.poll())
    }

    fun findMedian(): Double {
        return if (maxHeap.size == minHeap.size) {
            // we have even number of elements, take the average of middle two elements
            maxHeap.peek() / 2.0 + minHeap.peek() / 2.0
        } else maxHeap.peek().toDouble()
        // because max-heap will have one more element than the min-heap
    }
}

fun main() {
    // Driver code
    val medianOfAges = Solution()
    medianOfAges.insertNum(22)
    medianOfAges.insertNum(35)
    println("The recommended content will be for ages under: " + medianOfAges.findMedian())
    medianOfAges.insertNum(30)
    println("The recommended content will be for ages under: " + medianOfAges.findMedian())
    medianOfAges.insertNum(25)
    println("The recommended content will be for ages under: " + medianOfAges.findMedian())
}
