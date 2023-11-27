package org.guardevour.kGraphs


data class Edge(val predecessor: String, val successor: String, val weight: Int = 1): Comparable<Edge>{
    override fun compareTo(other: Edge): Int = weight.compareTo(other.weight) //метод который настраивает сравнение по весу

    override fun toString(): String = "(${predecessor}-${successor}: ${weight})"
}