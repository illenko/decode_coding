package com.illenko.netflix.features.feature10 // ktlint-disable filename

import java.util.Collections
import java.util.PriorityQueue

internal object Solution {
    fun medianSlidingWindow(values: List<Int>, k: Int): List<Double> {
        val medians: MutableList<Double> = mutableListOf()
        val hashMap = hashMapOf<Int, Int>()
        val smallQueue = PriorityQueue<Int>(Collections.reverseOrder())
        val largeQueue = PriorityQueue<Int>()

        (0 until k).forEach { smallQueue.add(values[it]) }
        var currentLastElementIndex = smallQueue.size
        (0 until k / 2).forEach { _ -> largeQueue.add(smallQueue.poll()) }

        while (true) {
            medians.add(
                if (k % 2 == 0) {
                    (smallQueue.peek().toDouble() + largeQueue.peek().toDouble()) / 2.0
                } else smallQueue.peek().toDouble()
            )

            if (currentLastElementIndex >= values.size) break

            val outNum = values[currentLastElementIndex - k]
            val inNum = values[currentLastElementIndex++]
            var balance = 0

            // Number `outNum` exits window
            balance += if (outNum <= smallQueue.peek()) -1 else 1

            /* If the outgoing element is not present in the hash-map
                store the `outNum` in the hash-map with value 1,
            otherwise increment the count of `outNum` in the hash-map.*/
            hashMap[outNum] = hashMap[outNum]?.let { it + 1 } ?: 1

            // number `inNum` enters window
            if (!smallQueue.isEmpty() && inNum <= smallQueue.peek()) {
                balance++
                smallQueue.add(inNum)
            } else {
                balance--
                largeQueue.add(inNum)
            }

            // Re-balance smallQueue
            if (balance < 0) {
                smallQueue.add(largeQueue.peek())
                largeQueue.poll()
                balance++
            }

            // Re-balance largeQueue
            if (balance > 0) {
                largeQueue.add(smallQueue.peek())
                smallQueue.poll()
            }

            // Remove invalid numbers that should be discarded from smallQueue heap tops
            while (hashMap.contains(smallQueue.peek()) && hashMap[smallQueue.peek()]!! > 0) {
                hashMap[smallQueue.peek()] = hashMap[smallQueue.peek()]!! - 1
                smallQueue.poll()
            }

            // Remove invalid numbers that should be discarded from largeQueue heap tops
            while (!largeQueue.isEmpty() && hashMap.contains(largeQueue.peek()) && hashMap[largeQueue.peek()]!! > 0) {
                hashMap[largeQueue.peek()] = hashMap[largeQueue.peek()]!! - 1
                largeQueue.poll()
            }
        }

        // Return medians
        return medians
    }
}

fun main() {
    println("Example - 1")
    val arr = listOf(1, 3, -1, -3, 5, 3, 6, 7)
    var k = 3
    println("Input: array = $arr, k = $k")
    println("Output: Medians = ${Solution.medianSlidingWindow(arr, k)}")

    println("\nExample - 2")
    val arr2 = listOf(1, 2)
    k = 1
    println("Input: array = $arr2, k = $k")
    println("Output: Medians = " + Solution.medianSlidingWindow(arr2, k))
}
