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
        int height = getHeight(root);

        List<Node> current = new ArrayList<>();
        current.add(root);

        int spacing = (int) Math.pow(2, height);

        while (!allNull(current)) {

            // print node values
            List<Node> next = new ArrayList<>();

            for (Node node : current) {
                printSpaces(spacing / 2);

                if (node != null) {
                    System.out.print(node.value);
                    next.add(node.left);
                    next.add(node.right);
                } else {
                    System.out.print(" ");
                    next.add(null);
                    next.add(null);
                }

                printSpaces(spacing / 2);
            }
            System.out.println();

            // print connectors
            for (Node node : current) {
                printSpaces(spacing / 2);

                if (node != null && node.left != null) System.out.print("/");
                else System.out.print(" ");

                printSpaces(spacing - 1);

                if (node != null && node.right != null) System.out.print("\\");
                else System.out.print(" ");

                printSpaces(spacing / 2);
            }
            System.out.println();

            spacing /= 2;
            current = next;
        }
    }

    // helpers
    private static int getHeight(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private static boolean allNull(List<Node> list) {
        for (Node n : list) if (n != null) return false;
        return true;
    }

    private static void printSpaces(int n) {
        for (int i = 0; i < n; i++) System.out.print(" ");
    }
}
