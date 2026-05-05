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
        int h = height(root);
        int maxWidth = (int) Math.pow(2, h) - 1;

        List<Node> level = new ArrayList<>();
        level.add(root);

        for (int i = 0; i < h; i++) {
            int floor = h - i - 1;
            int edgeLines = (int) Math.pow(2, Math.max(floor - 1, 0));
            int firstSpaces = (int) Math.pow(2, floor) - 1;
            int betweenSpaces = (int) Math.pow(2, floor + 1) - 1;

            printSpaces(firstSpaces);

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
                printSpaces(betweenSpaces);
            }
            System.out.println();

            for (int j = 1; j <= edgeLines; j++) {
                for (int k = 0; k < level.size(); k++) {
                    printSpaces(firstSpaces - j);

                    if (level.get(k) == null) {
                        printSpaces(edgeLines * 2 + j + 1);
                        continue;
                    }

                    if (level.get(k).left != null) System.out.print("/");
                    else printSpaces(1);

                    printSpaces(j * 2 - 1);

                    if (level.get(k).right != null) System.out.print("\\");
                    else printSpaces(1);

                    printSpaces(edgeLines * 2 - j);
                }
                System.out.println();
            }

            level = next;
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
