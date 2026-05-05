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

    // 🔥 CLEAN TOP-DOWN TREE
    public static void printTree(Node root) {
        int height = getHeight(root);
        int maxWidth = (int) Math.pow(2, height) - 1;

        List<Node> level = new ArrayList<>();
        level.add(root);

        for (int i = 1; i <= height; i++) {

            int spaces = (int) Math.pow(2, height - i) - 1;
            int between = (int) Math.pow(2, height - i + 1) - 1;

            printSpaces(spaces);

            List<Node> next = new ArrayList<>();

            for (Node node : level) {

                if (node != null) {
                    System.out.print(node.value);
                    next.add(node.left);
                    next.add(node.right);
                } else {
                    System.out.print(" ");
                    next.add(null);
                    next.add(null);
                }

                printSpaces(between);
            }

            System.out.println();

            if (i < height) {
                printSpaces(spaces - 1);

                for (Node node : level) {
                    if (node == null) {
                        System.out.print("  ");
                    } else {
                        System.out.print((node.left != null ? "/" : " "));
                        System.out.print((node.right != null ? "\\" : " "));
                    }
                    printSpaces(between - 1);
                }
                System.out.println();
            }

            level = next;
        }
    }

    private static int getHeight(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private static void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }
}
