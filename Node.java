import java.util.*;

public class Node {
    String value;
    Node left, right;

    public Node(String value) {
        this.value = value;
    }

    public Node(String value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public static void printTree(Node root) {
        print(root, 0);
    }

    private static void print(Node node, int space) {
        if (node == null) return;

        int COUNT = 6; // spacing (adjust if needed)
        space += COUNT;

        // RIGHT CHILD
        print(node.right, space);

        // CURRENT NODE
        System.out.println();
        for (int i = COUNT; i < space; i++) {
            System.out.print(" ");
        }
        System.out.println(node.value);

        // LEFT CHILD
        print(node.left, space);
    }
}
