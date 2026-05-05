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

    // FORCE TRIANGLE PRINT (LEFT-ALIGNED LIKE YOUR EXAMPLE)
    public static void printTree(Node root) {
        print(root, 0);
    }

    private static void print(Node node, int level) {
        if (node == null) return;

        // PRINT CURRENT NODE WITH INDENT
        printSpaces(level * 3);
        System.out.println(node.value);

        // IF HAS CHILDREN, PRINT BRANCHES
        if (node.left != null || node.right != null) {
            printSpaces(level * 3);
            System.out.println("/ \\");
        }

        // LEFT THEN RIGHT (THIS CREATES YOUR SHAPE)
        print(node.left, level + 1);
        print(node.right, level + 1);
    }

    private static void printSpaces(int count) {
        for (int i = 0; i < count; i++) System.out.print(" ");
    }
}
