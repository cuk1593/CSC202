public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    //function to insert data
    public void insert(int _data) {
        root = insert(root, _data);
    }

    //function to call data recursively
    private Node insert(Node node, int _data) {
        if(node == null)
            node = new Node(_data);
        else if (_data < node.data)
            node.left = insert(node.left, _data);
        else
            node.right = insert(node.right, _data);

        return node;
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node r) {
        if(r != null) {
            inOrder(r.left);
            DefaultClass.output += r.data + "  ";
            inOrder(r.right);
        }
    }

}

