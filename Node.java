public class Node {
    String value;
    Node left;
    Node right;

    public Node(String value) {
        this.value = value;
    }

    public static void printTree(Node node, String indent) {
        if (node == null) return;

        printTree(node.right, indent + "   ");
        System.out.println(indent + node.value);
        printTree(node.left, indent + "   ");
    }
}
