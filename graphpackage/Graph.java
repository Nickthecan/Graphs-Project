package graphpackage;
import java.util.Map;
import java.util.HashMap;
import adtpackage.*;

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
    private Map<T, ADTLinkedList<T>> map = new HashMap<>();

    //adds a vertex to the map
    public void addVertex(T key) {
        map.put(key, new ADTLinkedList<T>());
    }

    //adds an edge to the map
    public void addEdge(T src, T dst) {
        //if the source and destination on the map doesn't exist, make one
        if (!hasVertex(src)) {
            addVertex(src);
        }
        if (!hasVertex(dst)) {
            addVertex(dst);
        }
        map.get(src).add(dst);
    }

    //return the edge count
    public int getEdgeCount() {
        int edges = 0;
        for (T vertex : map.keySet()) {
            edges += map.get(vertex).size();
        } 
        return edges;
    }

    //return the vertex count
    public int getVertexCount() {
        return map.size();
    }

    //checks to see if the source and destination has an edge
    public boolean hasEdge(T src, T dst) {
        if (map.get(src).contains(dst)) {
            return true;
        }
        return false;
    }

    //checks to see if the map has the vertex
    public boolean hasVertex(T vertex) {
        if (map.containsKey(vertex)) {
            return true;
        }
        return false;
    }

    //returns a list of neighbors the vertex borders
    public ADTLinkedList<T> getNeighbors(T vertex) {
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
    public ADTLinkedList<T> breadthFirstSearch(T startingPoint) {
        ADTLinkedList<T> breadthFirstList = new ADTLinkedList<>();
        ADTQueue<T> nodesVisited = new ADTQueue<>();

        breadthFirstList.add(startingPoint);
        nodesVisited.add(startingPoint);
        while (!nodesVisited.isEmpty()) {
            ADTLinkedList<T> neighbors = getNeighbors(startingPoint);
            for (int i = 0; i < neighbors.size(); i++) {
                if (!breadthFirstList.contains(neighbors.get(i))) {
                    breadthFirstList.add(neighbors.get(i));
                    nodesVisited.add(neighbors.get(i));
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
    public ADTLinkedList<T> depthFirstSearch(T startingPoint) {
        ADTLinkedList<T> depthFirstList = new ADTLinkedList<>();
        ADTStack<T> nodesVisited = new ADTStack<>();

        depthFirstList.add(startingPoint);
        nodesVisited.push(startingPoint);
        while (!nodesVisited.isEmpty()) {
            ADTLinkedList<T> neighbors = getNeighbors(startingPoint);
            for (int i = 0; i < neighbors.size(); i++) {
                T neighbor = neighbors.get(i);

                if (!depthFirstList.contains(neighbor)) {
                    depthFirstList.add(neighbor);
                    nodesVisited.push(neighbor);
                    break;
                }

                if (i == neighbors.size() - 1)
                    nodesVisited.pop();
            }
            if (!nodesVisited.isEmpty())
                startingPoint = nodesVisited.peek();
        }
        return depthFirstList;
    }
}
 