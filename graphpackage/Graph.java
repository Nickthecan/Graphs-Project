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
        for (int i = 0; i < getVertexCount(); i++) {
            edges += map.get(i).size();
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

    public List<>hasNeighbors(T vertex) {
        if (map.containsKey(vertex)) {
            return 
        }
    }

    public void breadthFirstSearch(Map<T, LinkedList<T>> map) {
        
    }
    
    public void depthFirstSearch(Map<T, LinkedList<T>> map) {

    }
}
 