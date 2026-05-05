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

    // CLEAN, STABLE TREE (sideways)
    public static void printTree(Node root) {
        print(root, "", true);
    }

    private static void print(Node node, String prefix, boolean isTail) {
        if (node == null) return;

        // print right subtree first (so it appears on top)
        if (node.right != null) {
            print(node.right, prefix + (isTail ? "│   " : "    "), false);
        }

        // print current node
        System.out.println(prefix + (isTail ? "└── " : "┌── ") + node.value);

        // print left subtree
        if (node.left != null) {
            print(node.left, prefix + (isTail ? "    " : "│   "), true);
        }
    }
}
