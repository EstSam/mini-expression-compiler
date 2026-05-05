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

    // 🔥 CLEAN TRIANGLE PRINT (FIXED ALIGNMENT)
    public static void printTree(Node root) {
        int height = height(root);
        int width = (int) Math.pow(2, height) * 2;

        List<List<String>> canvas = new ArrayList<>();

        for (int i = 0; i < height * 2; i++) {
            List<String> row = new ArrayList<>(Collections.nCopies(width, " "));
            canvas.add(row);
        }

        fill(canvas, root, 0, width / 2, height);

        for (List<String> row : canvas) {
            String line = String.join("", row).replaceAll("\\s+$", "");
            if (!line.trim().isEmpty()) {
                System.out.println(line);
            }
        }
    }

    private static void fill(List<List<String>> canvas, Node node, int row, int col, int height) {
        if (node == null) return;

        canvas.get(row).set(col, node.value);

        int gap = (int) Math.pow(2, height - row / 2 - 2);

        if (node.left != null) {
            canvas.get(row + 1).set(col - gap / 2, "/");
            fill(canvas, node.left, row + 2, col - gap, height);
        }

        if (node.right != null) {
            canvas.get(row + 1).set(col + gap / 2, "\\");
            fill(canvas, node.right, row + 2, col + gap, height);
        }
    }

    private static int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
