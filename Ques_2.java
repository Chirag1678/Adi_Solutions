import java.util.Scanner;

public class Ques_2 {

    public class Node {
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public Ques_2() {}

    public void insert(int value) {
        root = insert(value, root);
        balance(root);
    }

    public void preorderTraversal() {
        preorderTraversal(root);
    }
    private void preorderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }
    private Node insert(int value, Node node) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insert(value, node.left);
        } else if (value > node.value) {
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node);
    }

    private void balance(Node node) {
        if (node != null) {
            balance(node.left);
            balance(node.right);
            node.height = Math.max(height(node.left), height(node.right)) + 1;
            rotate(node);
        }
    }

    private Node rotate(Node node) {
        if (height(node.left) - height(node.right) > 1) {
            // left heavy
            if (height(node.left.left) - height(node.left.right) > 0) {
                // left left case
                return rightRotate(node);
            } else {
                // left right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        } else if (height(node.left) - height(node.right) < -1) {
            // right heavy
            if (height(node.right.left) - height(node.right.right) < 0) {
                // right right case
                return leftRotate(node);
            } else {
                // left right case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    private Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        return c;
    }

    private Node leftRotate(Node c) {
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        return p;
    }

    private int height(Node node) {
        return (node == null) ? -1 : node.height;
    }

    public static void main(String[] args) {
        Ques_2 tree = new Ques_2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            tree.insert(sc.nextInt());
        }
        sc.close();
        System.out.println("Preorder Traversal:");
        tree.preorderTraversal();
    }
}
