public class BinaryTree {
    Node root = null;
    public void add(Node current, Integer key, Integer value) {
        Node newnode;
        if (current == null) {
            newnode = new BinaryTree.Node(key, value);
            this.root = newnode;
        } else if (current.key != key) {
            if (key < current.key) {
                if (current.left == null) {
                    newnode = new BinaryTree.Node(key, value);
                    current.left = newnode;
                    return;
                }

                this.add(current.left, key, value);
            }

            if (key > current.key) {
                if (current.right == null) {
                    newnode = new BinaryTree.Node(key, value);
                    current.right = newnode;
                    return;
                }

                this.add(current.right, key, value);
            }

        }
    }

    public void add(Integer key, Integer value) {

        this.add(this.root, key, value);
    }

    public Integer lookup(Node current, Integer key) {
        if (current == null) {
            return null;
        } else if (key == current.key) {
            return current.value;
        } else if (key < current.key) {
            return this.lookup(current.left, key);
        } else {
            return key > current.key ? this.lookup(current.right, key) : null;
        }
    }

    public Integer lookup(Integer key) {
        return this.lookup(this.root, key);
    }

}
