package mpdev.aoc2023.utils

import java.util.*

/**
 * Dijkstra implementation
 * T is the type of the Node ID in the Graph
 */
class Dijkstra<T>(private var costMap: Map<Pair<T,T>,Int>? = null) {

    class PathNode<T>(
        val node: Vertex<T>?,
        var costFromStart: Int,
        var updatedBy: T? = null): Comparable<PathNode<T>> {
        override fun compareTo(other: PathNode<T>): Int {
            // in Dijkstra min cost criteria is based on cost from start to this node
            return costFromStart.compareTo(other.costFromStart)
        }
        override fun toString(): String {
            return " node: $node cost from start $costFromStart updated by $updatedBy"
        }
    }

    class DijkstraException(override var message: String): Exception()

    private fun getCost(from: T, to: T) =
        if (costMap == null) 1      // default cost is 1 for all moves if no cost map given
        else costMap!![Pair(from, to)] ?: throw DijkstraException("cost from $from to $to not defined")

    /**
     * The Dijkstra algorithm implementation
     */
    fun runIt(startState: Vertex<T>, endState: Vertex<T>, maxPath: Int = Int.MAX_VALUE): MinCostPath<T> {

        // setup priority queue, visited set and minimum total costs for each node
        val toVisitQueue = PriorityQueue<PathNode<T>>().apply { add(PathNode(startState,0)) }
        val visitedNodes = mutableSetOf<PathNode<T>>()
        val dijkstraCost =  mutableMapOf<T,PathNode<T>>(). withDefault { PathNode(null, Int.MAX_VALUE) }

        var iterations = 0
        // while the priority Q has elements, get the top one (least cost as per Comparator)
        while (toVisitQueue.isNotEmpty()) {
            val currentNode = toVisitQueue.poll()
            // if this is the endNode ID, we are done
            if (currentNode.node?.getId()!! == endState.getId()) {
                val minCostPath = MinCostPath<T>()
                minCostPath.minCost = currentNode.costFromStart
                minCostPath.numberOfIterations = iterations
                minCostPath.path = getMinCostPath(currentNode.node.getId(), startState.getId(), dijkstraCost)
                if (minCostPath.path.size > maxPath)
                    throw DijkstraException("Calculated Path exceeded max size ($maxPath)")
                return minCostPath
            }
            // else for each connected node
            currentNode.node.getConnectedNodes().forEach { connectedNode ->
                ++iterations
                val nextPathNode = PathNode(connectedNode, getCost(currentNode.node.getId(),connectedNode.getId()))
                if (visitedNodes.contains(nextPathNode))
                    return@forEach
                visitedNodes.add(nextPathNode)
                // calculate the new cost to that node and the new *estimated* total cost to the end node
                val newCost = currentNode.costFromStart + getCost(currentNode.node.getId(),connectedNode.getId())
                // if the new cost is less than what we have already recorded in the map of nodes/costs
                // update the map with the new costs and "updatedBy" (to be able to back-track the min.cost path)
                if (newCost < dijkstraCost.getValue(connectedNode.getId()).costFromStart) {
                    nextPathNode.updatedBy = currentNode.node.getId()
                    nextPathNode.costFromStart = newCost
                    dijkstraCost[connectedNode.getId()] = nextPathNode
                    // and put the updated new node back into the priority queue
                    toVisitQueue.add(nextPathNode)
                }
            }
        }
        throw DijkstraException("no path found from ${startState.getId()} to ${endState.getId()}")
    }

    fun getMinCostPath(minCostKey: T, startKey: T, dijkstraCost: Map<T, PathNode<T>>): List<T> {
        var key = minCostKey
        val path = mutableListOf<T>()
        do {
            path.add(key)
            key = dijkstraCost.getValue(key).updatedBy ?: startKey
        } while (key != startKey)
        path.add(key)
        return path.reversed()
    }
}