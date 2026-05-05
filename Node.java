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
    List<List<Node>> levels = new ArrayList<>();
    buildLevels(root, 0, levels);

    int spacing = 6; 

    for (int i = 0; i < levels.size(); i++) {
        List<Node> level = levels.get(i);

        int indent = (levels.size() - i) * spacing;

        // PRINT NODES
        printSpaces(indent);
        for (int j = 0; j < level.size(); j++) {
            Node n = level.get(j);
            System.out.print(n != null ? n.value : " ");

            printSpaces(spacing * 2 - 1);
        }
        System.out.println();

        // PRINT BRANCHES (ONLY BETWEEN LEVELS)
        if (i < levels.size() - 1) {
            printSpaces(indent);
            for (int j = 0; j < level.size(); j++) {
                Node n = level.get(j);

                if (n != null && n.left != null) System.out.print("/");
                else System.out.print(" ");

                printSpaces(spacing * 2 - 3);

                if (n != null && n.right != null) System.out.print("\\");
                else System.out.print(" ");

                printSpaces(2);
            }
            System.out.println();
        }
    }
}

private static void buildLevels(Node node, int depth, List<List<Node>> levels) {
    if (levels.size() == depth) {
        levels.add(new ArrayList<>());
    }

    levels.get(depth).add(node);

    if (node == null) {
        if (depth + 1 < 6) { // limit depth to avoid explosion
            buildLevels(null, depth + 1, levels);
            buildLevels(null, depth + 1, levels);
        }
        return;
    }

    buildLevels(node.left, depth + 1, levels);
    buildLevels(node.right, depth + 1, levels);
}

private static void printSpaces(int n) {
    for (int i = 0; i < n; i++) System.out.print(" ");
}
}
