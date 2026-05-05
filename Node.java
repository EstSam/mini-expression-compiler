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

    // 🔥 PRINT EXACT STYLE TREE
    public static void printTree(Node root) {
        int height = getHeight(root);
        printNode(root, 0, height);
    }

    private static void printNode(Node node, int level, int height) {
        if (node == null) return;

        int indent = (int) Math.pow(2, height - level);

        // print current node
        printSpaces(indent);
        System.out.println(node.value);

        if (node.left != null || node.right != null) {

            // print connectors
            printSpaces(indent - 1);
            System.out.print("/");
            printSpaces(1);
            System.out.println("\\");

            // recursive children
            printNode(node.left, level + 1, height);
            printNode(node.right, level + 1, height);
        }
    }

    private static int getHeight(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private static void printSpaces(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" ");
        }
    }
}
