import graphpackage.Graph;
import java.util.LinkedList;

class Driver {
    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addVertex(7);
        graph.addVertex(8);
        graph.addVertex(9);

        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);
        graph.addEdge(2, 5);
        graph.addEdge(4, 7);
        graph.addEdge(5, 6);
        graph.addEdge(5, 8);
        graph.addEdge(7, 8);
        graph.addEdge(6, 3);
        graph.addEdge(6, 8);
        graph.addEdge(8, 9);
        graph.addEdge(3, 2);
        graph.addEdge(9, 6);


        System.out.println("1 -> 4 -> 7");
        System.out.println("| \\       |");
        System.out.println("v  /      v");
        System.out.println("2 -> 5 -> 8");
        System.out.println("^    |  \\ |");
        System.out.println("|    v  / v");
        System.out.println("3 <- 6 <- 9\n");
        
        System.out.print("Breadth First Search: ");
        LinkedList<Integer> breadthFirst = graph.breadthFirstSearch(1);
        for (int number : breadthFirst) {
            System.out.print(number + " ");
        }
        System.out.print("\nDepth First Search: ");
        LinkedList<Integer> depthFirst = graph.depthFirstSearch(1);
        for (int number : depthFirst) {
            System.out.print(number + " ");
        }
    }
}