package org.guardevour.kGraphs

class GraphCalculator{
    companion object{
        fun getMinimumPath(edges: ArrayList<Edge>, startNode: String, endNode: String, allNodes: List<String>): List<Edge> {
            val paths = ArrayList<ArrayList<Edge>>()

            var currentNode = allNodes[allNodes.indexOf(startNode)+1]


            edges.filter { edge -> edge.predecessor == startNode }.forEach{
                paths.add(arrayListOf(it))
            }

            while (currentNode != endNode){
                val nextEdges = edges.filter { edge -> edge.predecessor == currentNode } as ArrayList<Edge>
                nextEdges.sort()
                for (path in paths){
                    val finalEdge = nextEdges.filter{
                        it.successor == endNode
                    }

                    if (finalEdge.isNotEmpty()){
                        for (edge in finalEdge){
                            if (path.getLastNode() == edge.predecessor) path.add(edge)
                        }
                    }
                    for (nextEdge in nextEdges){
                        if (path.getLastNode() == nextEdge.predecessor) path.add(nextEdge)
                    }
                }
                currentNode = allNodes[allNodes.indexOf(currentNode)+1]
            }
            return paths.getMinPath()
        }


        fun getSpanningPath(edges: ArrayList<Edge>, pathLength: Int): List<Edge>{
            edges.sort() /* благодаря наследованию Comparable,
                класс Edge легко сортируется по возрастанию веса ребра*/
            val spinningTree = arrayListOf<Edge>()

            val predecessors = arrayListOf<String>()
            val successors = arrayListOf<String>()

            for (edge in edges){
                spinningTree.addToSpanningTree(edge, successors, predecessors)
                if (spinningTree.count() == pathLength) break
            }

            return spinningTree
        }
    }

}