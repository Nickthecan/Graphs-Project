package adtpackage;
import java.util.EmptyStackException;

public class ADTStack<T> {
    //top of the stack
    private Node topNode;

    //constructor
    public ADTStack() {
        topNode = null;
    }

    //pushes an entry to the top of the stack
    public void push(T entry) {
        Node newNode = new Node(entry, topNode);
        topNode = newNode;
    }

    //removes an entry from the top of the stack
    public T pop() {
        T top = peek();
        topNode = topNode.getNext();
        return top;
    }

    //takes a look at the top of the stack
    //will return an error if the stack is empty
    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();
        else
            return topNode.getData();
    }

    //checks to see if the stack is empty
    public boolean isEmpty() {
        return topNode == null;
    }

    //private Node class
    private class Node {
        private T data;
        private Node next;

        private Node(T data) {
            this(data, null);
        }

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        private T getData() {
            return data;
        }

        private Node getNext() {
            return next;
        }
    } //end Node
} //end ADTStack
