
public class BinaryTree {
    Node root;

    public void add(int value, String name) {
        root = addRecursive(root, name, value);
    }

    private Node addRecursive(Node currentNode, String name, int value) {
        if (currentNode == null) {
            return new Node(value, name);
        }

        if (value < currentNode.getPrice()) {
            currentNode.setLeft(addRecursive(currentNode.left, name, value));
        } else if (value > currentNode.getPrice()) {
            currentNode.setRight(addRecursive(currentNode.right, name, value));
        } else {
            return currentNode;
        }

        return currentNode;
    }

    public void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.getLeft());
            System.out.print("Name: " + root.getName() + ", Price: " + root.getPrice() + " | ");
            inorderTraversal(root.getRight());
        }
    }

    private Node recursiveSearch(Node root, int data) {
        if (root == null || root.getPrice() == data) {
            return root;
        }
        if (data < root.getPrice()) {
            return recursiveSearch(root.getLeft(), data);
        } else {
            return recursiveSearch(root.getRight(), data);
        }
    }

    private int getMinimumValue(Node root) {
        int temp = root.getPrice();
        while (root.getLeft() != null) {
            temp = root.getLeft().getPrice();
            root = root.getLeft();
        }
        return temp;
    }

    private Node recursiveDelete(Node root, int data) {
        if (root == null) {
            return null;
        }

        if (data < root.getPrice()) {
            root.setLeft(recursiveDelete(root.getLeft(), data));
        } else if (data > root.getPrice()) {
            root.setRight(recursiveDelete(root.getRight(), data));
        } else {
            if (root.getLeft() == null) {
                return root.getRight();
            }
            if (root.getRight() == null) {
                return root.getLeft();
            }
            root.setPrice(getMinimumValue(root.getRight()));
            root.setRight(recursiveDelete(root.getRight(), root.getPrice()));
        }
        return root;
    }

    public Node search(int data) {
        return recursiveSearch(root, data);
    }

    public void delete(int data) {
        recursiveDelete(root, data);
    }

    private void _printPreorder(Node node) {
        if (node == null)
            return;

        System.out.print("Name: " + node.getName() + ", Price: " + node.getPrice() + " | ");
        _printPreorder(node.getLeft());
        _printPreorder(node.getRight());
    }

    private void _printPostorder(Node node) {
        if (node == null)
            return;

        _printPostorder(node.getLeft());
        _printPostorder(node.getRight());
        System.out.print("Name: " + node.getName() + ", Price: " + node.getPrice() + " | ");

    }

    public void print() {
        inorderTraversal(root);
    }

    public void printPreOrder() {
        _printPreorder(root);
    }

    public void printPostOrder() {
        _printPostorder(root);
    }


    private int getHeight(Node root) {
        if (root == null)
            return 0;
        else {

            int lheight = getHeight(root.getLeft());
            int rheight = getHeight(root.getRight());

            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    private void printCurrentLevel(Node root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.print("Name: " + root.getName() + ", Price: " + root.getPrice() + " | ");
        else if (level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }

    public void printLevelOrder() {
        int h = getHeight(root);
        for (int i = 1; i <= h; i++)
            printCurrentLevel(root, i);
    }

}
