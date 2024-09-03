package Testing;
import adtpackage.*;

public class LinkedListTest {
    public static void main(String args[]) {
        ADTLinkedList<String> list = new ADTLinkedList<>();
        ADTQueue<Integer> queue = new ADTQueue<>();
        ADTStack<Integer> stack = new ADTStack<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        /* for (int i = 0; i < list.size(); i++) {
            System.out.println(list.contains(i + 1));
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(queue.dequeue());
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(stack.pop());
        } */

        System.out.println(list.get(4));
    }

}
