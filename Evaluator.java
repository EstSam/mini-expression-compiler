public class Evaluator {

    public static int evaluate(Node node) {
        if (node.left == null && node.right == null) {
            return Integer.parseInt(node.value);
        }

        int left = evaluate(node.left);
        int right = evaluate(node.right);

        switch (node.value) {
            case "+": return left + right;
            case "-": return left - right;
            case "*": return left * right;
            case "/": return left / right;
        }

        throw new RuntimeException("Invalid operator: " + node.value);
    }
}
