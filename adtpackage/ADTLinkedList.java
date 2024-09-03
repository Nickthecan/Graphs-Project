package adtpackage;

public class ADTLinkedList<T> {
    //head
    protected Node node;
    protected int numberOfEntries;

    //constructor
    public ADTLinkedList() {
        node = null;
        numberOfEntries = 0;
    }

    //checks the size of the list
    public int size() {
        return numberOfEntries;
    }

    //checks to see if list is empty
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    //adds to the head of the list
    public void add(T newEntry) {
        Node newNode = new Node(newEntry);
        newNode.next = node;
        node = newNode;
        numberOfEntries++;
    }

    //removes the head of the list
    public T remove() {
        T result = null;
        if (node != null) {
            result = node.getData();
            node = node.getNext();
            numberOfEntries--;
        }
        return result;
    }

    public T get(int position) {
        Node currentNode = node;
        for (int i = 0; i < size() - position; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getData();
    }

    //checks to see if the list contains an entry
    public boolean contains(T entry) {
        boolean found = false;
        Node currentNode = node;
        while (!found && (currentNode != null)) {
            if (entry.equals(currentNode.getData()))
                found = true;
            else
                currentNode = currentNode.getNext();
        }
        return found;
    }

    //protected Node class
    protected class Node {
        protected T data;
        protected Node next;

        protected Node(T data) {
            this(data, null);
        }

        protected Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        protected T getData() {
            return data;
        }

        protected Node getNext() {
            return next;
        }
    } //end Node 
} //end ADTLinkedList
