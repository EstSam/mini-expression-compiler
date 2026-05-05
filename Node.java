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
        int height = height(root);
        int maxWidth = (int) Math.pow(2, height);

        printLevel(root, 1, height, maxWidth);
    }

    private static void printLevel(Node node, int level, int maxLevel, int width) {
        if (node == null) return;

        int spaces = width / (int)Math.pow(2, level);

        printSpaces(spaces);
        System.out.println(node.value);

        if (node.left != null || node.right != null) {
            printSpaces(spaces - 1);
            System.out.print("/");
            printSpaces(1);
            System.out.println("\\");

            printLevel(node.left, level + 1, maxLevel, width);
            printLevel(node.right, level + 1, maxLevel, width);
        }
    }

    private static int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private static void printSpaces(int n) {
        for (int i = 0; i < n; i++) System.out.print(" ");
    }
}
