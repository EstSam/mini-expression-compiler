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

    // 🔥 Proper binary tree display
    public static void printTree(Node node, String indent, boolean isRight) {
        if (node == null) return;

        printTree(node.right, indent + (isRight ? "        " : "│       "), true);

        System.out.println(indent + (isRight ? "└── " : "┌── ") + node.value);

        printTree(node.left, indent + (isRight ? "│       " : "        "), false);
    }
}
