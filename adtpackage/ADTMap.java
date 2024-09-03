package adtpackage;

public class ADTMap<T> {
    private Node key;
    private Node value;
    private int numberOfEntries;

    //constructor
    public ADTMap() {
        key = null;
        value = null;
        numberOfEntries = 0;
    }

    //add a key value pair into the map
    public void put(T key, T value) {
        
    }

    //return the value associated to the key
    public T get(T key) {

    }

    //returns the list of keys in the map
    public ADTLinkedList<T> keySet() {

    }

    public int size() {
        return numberOfEntries;
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
}
