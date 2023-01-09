package com.illenko.netflix.diys.diy2 // ktlint-disable filename

internal object Solution {

    fun mergeKLists(lists: List<LinkedListNode?>?): LinkedListNode =
        if (lists.isNullOrEmpty()) LinkedListNode(-1)
        else {
            val initialList = lists.first()
            (1 until lists.size).forEach {
                lists[it]?.let { list -> merge2Lists(initialList!!, list) }
            }

            initialList ?: LinkedListNode(-1)
        }

    private fun merge2Lists(list1: LinkedListNode, list2: LinkedListNode): LinkedListNode {
        var left: LinkedListNode? = list1
        var right: LinkedListNode? = list2
        val dummy = LinkedListNode(-1)
        var prev = dummy

        while (left != null && right != null) {
            if (left.data <= right.data) {
                prev.next = left
                left = left.next
            } else {
                prev.next = right
                right = right.next
            }
            prev = prev.next!!
        }

        while (left != null) {
            prev.next = left
            left = left.next
            prev = prev.next!!
        }

        while (right != null) {
            prev.next = right
            right = right.next
            prev = prev.next!!
        }

        return dummy.next!!
    }
}
