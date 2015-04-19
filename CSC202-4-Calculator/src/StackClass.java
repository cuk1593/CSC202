import java.util.NoSuchElementException;

/**
 * Created by admin on 3/19/15.
 */

public class StackClass {
    private class Node {//33
        public Object data;
        public Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    //Initialization of top Node
    private static Node top = null;

    //returns size of the stack
    public int returnSize() {
        int count = 0;
        for (Node node = top; node != null; node = node.next) {
            count++;
        }
        return count;
    }

    //Pushes an item to the top of the stack.
    public void push(Object item) {
        top = new Node(item, top);
    }

    //Pops an item from the top of the stack.
    public Object pop() {
        Object item = peek();
        top = top.next;
        return item;
    }

    //Peeks at the top of the stack.
    public Object peek() {
        if (top == null) {
            throw new NoSuchElementException();
        }
        return top.data;
    }

    //Returns whether the stack is empty or not.
    public boolean isEmpty() {
        return top == null;
    }
}
