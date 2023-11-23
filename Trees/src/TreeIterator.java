import java.util.Iterator;
import java.util.NoSuchElementException;

public class TreeIterator implements Iterator<Node> {
    private DynamicStack stack = new DynamicStack(15);

    public TreeIterator(Node root) {
        traverseLeft(root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public Node next() {
        Node node = stack.pop();
        traverseLeft(node.right);
        return node;
    }

    private void traverseLeft(Node node) {
        if (node != null) {
            stack.push(node);
            traverseLeft(node.left);
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }


    /*public TreeIterator(Node current, int size) {
        next = current;
        stack = new DynamicStack(size);

        if (next == null) {
            return;
        }
        if (next.left != null) {
            next = next.left;
        }
    }


    @Override
    public Node next() {

        if (!hasNext()) throw new NoSuchElementException();

        Node current;

        try {
            current = stack.pop();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (current.right != null) {

            next = current.right;

            while (next != null) {
                stack.push(next);
                next = next.left;
            }
        }

        return current;
    }*/
}

