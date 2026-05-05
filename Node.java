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

    // PRINT TREE CLEANLY (LEVEL BY LEVEL)
    public static void printTree(Node root) {
        int height = height(root);
        int maxWidth = (int) Math.pow(2, height);

        List<Node> currentLevel = new ArrayList<>();
        currentLevel.add(root);

        for (int level = 0; level < height; level++) {
            int spaces = (int) Math.pow(2, height - level - 1);

            List<Node> nextLevel = new ArrayList<>();

            // PRINT NODES
            for (Node node : currentLevel) {
                printSpaces(spaces);

                if (node != null) {
                    System.out.print(node.value);
                    nextLevel.add(node.left);
                    nextLevel.add(node.right);
                } else {
                    System.out.print(" ");
                    nextLevel.add(null);
                    nextLevel.add(null);
                }

                printSpaces(spaces);
            }
            System.out.println();

            // PRINT EDGES
            if (level < height - 1) {
                for (Node node : currentLevel) {
                    printSpaces(spaces - 1);

                    if (node != null && node.left != null)
                        System.out.print("/");
                    else
                        System.out.print(" ");

                    printSpaces(1);

                    if (node != null && node.right != null)
                        System.out.print("\\");
                    else
                        System.out.print(" ");

                    printSpaces(spaces - 1);
                }
                System.out.println();
            }

            currentLevel = nextLevel;
        }
    }

    private static int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private static void printSpaces(int count) {
        for (int i = 0; i < count; i++) System.out.print(" ");
    }
}
