package graphpackage;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

/*  Adjacency List
 * 
 *  k1 , [v1, v2, v3, vi...]
 *  k2 , [v1, v2, v3, vi...]
 *  k3 , [v1, v2, v3, vi...]
 *  ki , [v1, v2, v3, vi...]
 * 
 *  Each key value pair is a vertex on the graph, and the Linked list is a list of 
 *  all the other vertices that the vertex is attached to (Edge). 
 */

public class Graph<T> {
    private Map<T, LinkedList<T>> map = new HashMap<>();

    public void addVertex(T key) {
        map.put(key, new LinkedList<T>());
    }

    public void addEdge(T src, T dst) {
        if (!hasVertex(src)) {
            addVertex(src);
        }
        if (!hasVertex(dst)) {
            addVertex(dst);
        }
        map.get(src).add(dst);
    }

    public int getEdgeCount() {
        int edges = 0;
        for (T vertex : map.keySet()) {
            edges += map.get(vertex).size();
        } 
        return edges;
    }

    public int getVertexCount() {
        return map.size();
    }

    public boolean hasEdge(T src, T dst) {
        if (map.get(src).contains(dst)) {
            return true;
        }
        return false;
    }

    public boolean hasVertex(T vertex) {
        if (map.containsKey(vertex)) {
            return true;
        }
        return false;
    }

    public LinkedList<T> getNeighbors(T vertex) {
        if (map.containsKey(vertex)) {
            return map.get(vertex);
        }
        return null;
    }

    //searches depth by depth
    //row by row
    /*  Start at the startingPoint node
     *  Find the neighbors of the node
     *  Add to a list of visitedNodes
     *  Once all the nodes are visited, check child node of the starting node and then do the same process
     *  Continue until all nodes are visited
     *  1 2 4 5 6 8 3 9 7
     */
    public LinkedList<T> breadthFirstSearch(T startingPoint) {
        LinkedList<T> breadthFirstList = new LinkedList<>();
        LinkedList<T> nodesVisited = new LinkedList<>();
        T backtrackedSpot = startingPoint;

        breadthFirstList.add(startingPoint);
        nodesVisited.add(startingPoint);
        while (nodesVisited.size() != getVertexCount()) {
            LinkedList<T> neighbors = getNeighbors(startingPoint);
            boolean doesThisNodeHaveAnyNeighborsAtAll = false;
            for (T neighbor : neighbors) {
                if (!nodesVisited.contains(neighbor)) {
                    breadthFirstList.add(neighbor);
                    nodesVisited.add(neighbor);
                    doesThisNodeHaveAnyNeighborsAtAll = true;
                }
            }
            if (doesThisNodeHaveAnyNeighborsAtAll) {
                backtrackedSpot = startingPoint;
                startingPoint = neighbors.getFirst();
            }
            else {
                startingPoint = backtrackedSpot;
            }
        }
        return breadthFirstList;
    }
    
    //searches full depth of children, then moves on to the next
    //column by column
    public void depthFirstSearch(T startingPoint) {

    }
}
 