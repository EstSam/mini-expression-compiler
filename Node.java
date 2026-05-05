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

    // HARD-FORCED TRIANGLE PRINT (LEVEL ORDER)
public static void printTree(Node root) {
    int h = height(root);
    int maxWidth = (int) Math.pow(2, h) * 2;

    List<Node> current = new ArrayList<>();
    current.add(root);

    for (int level = 0; level < h; level++) {
        int spaces = maxWidth / (int) Math.pow(2, level + 1);

        List<Node> next = new ArrayList<>();

        // PRINT VALUES
        for (Node node : current) {
            printSpaces(spaces);

            if (node != null) {
                System.out.print(node.value);
                next.add(node.left);
                next.add(node.right);
            } else {
                System.out.print(" ");
                next.add(null);
                next.add(null);
            }

            printSpaces(spaces);
        }
        System.out.println();

        // PRINT CONNECTIONS (ONLY ONCE PER NODE)
        if (level < h - 1) {
            for (Node node : current) {
                printSpaces(spaces - 1);

                if (node != null && node.left != null)
                    System.out.print("/");
                else
                    System.out.print(" ");

                printSpaces(2);

                if (node != null && node.right != null)
                    System.out.print("\\");
                else
                    System.out.print(" ");

                printSpaces(spaces - 1);
            }
            System.out.println();
        }

        current = next;
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
