package org.tormozzg.sorts

import kotlin.random.Random

class SelectionSort : Sort() {

    override fun doSort(input: IntArray): IntArray {
        for (i in (input.lastIndex downTo 1)) {
            swapMax(input, i)
        }
        return input
    }

    private fun swapMax(array: IntArray, right: Int) {
        var maxPos = right
        for (i in (0..right)) {
            if (array[i] > array[maxPos])
                maxPos = i
        }
        if (maxPos != right) {
            val tmp = array[right]
            array[right] = array[maxPos]
            array[maxPos] = tmp
        }
    }
}

fun main(args: Array<String>) {
    val size = (if (args.isNotEmpty()) args[0].toIntOrNull() else null) ?: 10
    val array = IntArray(size) {
        Random.nextInt(0, 101)
    }

    val sort = SelectionSort()
    println("Array: ${array.joinToString()}")
    val (sorted, time) = sort.sort(array)
    println("Time: $time")
    println("Sorted: ${sorted.joinToString()}")
}