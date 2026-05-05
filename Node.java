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
    int width = (int) Math.pow(2, height) * 2;

    printLevel(Collections.singletonList(root), 1, height, width);
    }

    private static void printLevel(List<Node> nodes, int level, int maxLevel, int width) {
        if (nodes.isEmpty() || allNull(nodes)) return;

    int floor = maxLevel - level;
    int edgeSpace = (int) Math.pow(2, floor);
    int firstSpace = width / (nodes.size() + 1);

    List<Node> next = new ArrayList<>();

    // print node values
    for (int i = 0; i < nodes.size(); i++) {
        printSpaces(firstSpace / 2);

        Node n = nodes.get(i);
        if (n != null) {
            System.out.print(n.value);
            next.add(n.left);
            next.add(n.right);
        } else {
            System.out.print(" ");
            next.add(null);
            next.add(null);
        }

        printSpaces(firstSpace / 2);
    }
    System.out.println();

    // print connectors
    for (int i = 0; i < nodes.size(); i++) {
        Node n = nodes.get(i);

        printSpaces(firstSpace / 2);

        if (n != null && n.left != null) System.out.print("/");
        else System.out.print(" ");

        printSpaces(firstSpace - 1);

        if (n != null && n.right != null) System.out.print("\\");
        else System.out.print(" ");

        printSpaces(firstSpace / 2);
    }
    System.out.println();

    printLevel(next, level + 1, maxLevel, width);
}

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
