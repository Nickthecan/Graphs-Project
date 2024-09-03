package adtpackage;

public class ADTQueue<T> extends ADTLinkedList<T> {
    public void enqueue(T entry) {
        Node newNode = new Node(entry);

        if (isEmpty()) {
            node = newNode;
        }
        else {
            Node currentnode = node;
            while (currentnode.getNext() != null) {
                currentnode = currentnode.getNext();
            }
            currentnode.next = newNode;
        } 
        numberOfEntries++;
    }

    public T dequeue() {
        return remove();
    }

    public T peek() {
        if (node != null)
            return node.getData();
        else
            return null;
    } 
} //end ADTQueue
