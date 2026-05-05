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
        List<List<String>> levels = new ArrayList<>();
        buildLevels(root, 0, levels);

        int maxWidth = levels.get(levels.size() - 1).size() * 4;

        for (int i = 0; i < levels.size(); i++) {
            List<String> level = levels.get(i);

            int spaces = maxWidth / (level.size() + 1);

            // PRINT NODES
            for (String val : level) {
                printSpaces(spaces);
                System.out.print(val);
            }
            System.out.println();

            // PRINT BRANCHES
            if (i < levels.size() - 1) {
                for (int j = 0; j < level.size(); j++) {
                    printSpaces(spaces - 1);
                    System.out.print("/");
                    printSpaces(2);
                    System.out.print("\\");
                }
                System.out.println();
            }
        }
    }

    private static void buildLevels(Node node, int depth, List<List<String>> levels) {
        if (node == null) return;

        if (levels.size() == depth) {
            levels.add(new ArrayList<>());
        }

        levels.get(depth).add(node.value);

        buildLevels(node.left, depth + 1, levels);
        buildLevels(node.right, depth + 1, levels);
    }

    private static void printSpaces(int n) {
        for (int i = 0; i < n; i++) System.out.print(" ");
    }
}
