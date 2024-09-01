package graphpackage;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

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
     *  GOAL: 1 2 4 5 7 6 8 3 9
     */
    public LinkedList<T> breadthFirstSearch(T startingPoint) {
        LinkedList<T> breadthFirstList = new LinkedList<>();
        Queue<T> nodesVisited = new LinkedList<>();

        breadthFirstList.add(startingPoint);
        nodesVisited.add(startingPoint);
        while (!nodesVisited.isEmpty()) {
            LinkedList<T> neighbors = getNeighbors(startingPoint);
            for (T neighbor : neighbors) {
                if (!breadthFirstList.contains(neighbor)) {
                    breadthFirstList.add(neighbor);
                    nodesVisited.add(neighbor);
                }
            }
            nodesVisited.remove();
            startingPoint = nodesVisited.peek();
        }
        return breadthFirstList;
    }
    
    //searches full depth of children, then moves on to the next
    //column by column
    /*  Start at the startingPoint node
     *  Find the first child of the node and then keep finding the first child until you cannot anymore
     *  Then go to the next child of the lowest parent, then work your way back up to the top
     *  Then you can move on down to the next child
     *  Goal: 1 2 5 6 3 8 9 4 7
     */
    public void depthFirstSearch(T startingPoint) {
        LinkedList<T> breadthFirstList = new LinkedList<>();
        Stack<T> nodesVisited = new Stack<>();

        breadthFirstList.add(startingPoint);
        nodesVisited.add(startingPoint);
        while (!nodesVisited.isEmpty()) {
            LinkedList<T> neighbors = getNeighbors(startingPoint);

        }
    }
}
 