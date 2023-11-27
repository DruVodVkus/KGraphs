package org.guardevour.kGraphs

fun ArrayList<Edge>.getPathWeight(): Int{
    var pathLength = 0
    for (edge in this){
        pathLength += edge.weight
    }

    return pathLength
}

fun ArrayList<Edge>.getLastNode(): String = this[this.lastIndex].successor


fun ArrayList<ArrayList<Edge>>.getMinPath(): List<Edge>{
    var minimalPath = this[0]

    for (path in this){
        if (path.getPathWeight() < minimalPath.getPathWeight()){
            minimalPath = path
        }
    }

    return minimalPath
}

fun ArrayList<Edge>.addToSpanningTree(edge: Edge, successors: ArrayList<String>, predecessors: ArrayList<String>){
    if (!(edge.successor in successors && edge.predecessor in predecessors)){ // Проверяет на доступность вершины
        this.add(edge)
        predecessors.add(edge.predecessor)
        successors.add(edge.successor)
    }
}