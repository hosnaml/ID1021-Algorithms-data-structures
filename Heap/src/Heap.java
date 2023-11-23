import java.util.Random;

public class Heap {

    Node root;


    public Heap() {
        root = null;
    }

    private class Node {
        int value;
        Node left, right;

        int size;

        private Node(int value, int size) {
            this.size = size;
            this.value = value;
            this.left = this.right = null;
        }

        private void add(int value, Node current) {
            //Increment the size by one.
            size++;
            //System.out.println(current.value + " " + value);
            //If current value is less than the value of the current node then swap
            //the values.
            if (value < current.value) {
                int pr = current.value;
                current.value = value;
                value = pr;
            }

            if (current.right == null) {
                right = new Node(value, 0);
                return;
            }

            if (current.left == null) {
                left = new Node(value, 0);
                return;
            }

            if (left.size() < right.size()) {
                left.add(value, current.left);
            } else {
                right.add(value, current.right);
            }
        }

        private Node remove(Node current) {

            size--;

            //If the size of the root node is 1 then we have removed the last entry in the heap
            // so we set root to null and return the value.

            if (current == null)
                return null;

            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            if (left.value < right.value) {
                current.value = left.value;
                left = left.remove(left);
            } else {
                current.value = right.value;
                right = right.remove(right);
            }

            return current;

        }



        private int size() {
            return size;
        }


    }

    public void enqueue(int value) {

        if (root == null)
            root = new Node(value, 0);
        else {
            root.add(value, root);
        }
    }

    public Integer dequeue() {
        Integer p = root.value;
        root = root.remove(root);
        return p;

    }

    //Find the element with the highest priority, do some operation in the element.
    //give it a new priority and return it to the queue.
    /*public Integer push(Integer incr) {


        root.value = root.value + incr;
        Node current = root;
        Integer depth = 0;

        while(current.left.value < current.value || current.right.value < current.value) {

            if (current.value > current.left.value) {
                int pr = current.value;
                current.value = current.left.value;
                current.left.value = pr;
            } else if(current.value > current.right.value) {
                int pr = current.value;
                current.value = current.right.value;
                current.right.value = pr;
             }
            else{
                break;
            }
            depth++;

            if(current.left.left != null)
                current = current.left;

            else if (current.right.right != null) {
                current = current.right;
            }


        }
        return depth;
    }*/

    public Integer push(Integer incr){
        root.value = root.value + incr;
        Node current = root;
        Integer depth = 0;
        while(current.left.value < current.value || current.right.value < current.value) {

            if (root.value > root.left.value) {
                int pr = current.value;
                current.value = current.left.value;
                current.left.value = pr;
            } else if(root.value > root.right.value) {
                int pr = current.value;
                current.value = current.right.value;
                current.right.value = pr;
            }
            else{
                break;
            }
            depth++;
        }
        return depth;
    }

    public void addRemove(Heap h, int n){


        Random rd = new Random();

        for (int i = 0; i < n ; i++) {
            int t = rd.nextInt(100);
            Node root = new Node(h.dequeue(), 0);
            h.enqueue(root.value + t);
        }

    }


}


