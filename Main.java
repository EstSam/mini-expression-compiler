import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an expression:");
        String input = scanner.nextLine();

        try {
            // Step 1: Tokenize
            Tokenizer tokenizer = new Tokenizer(input);
            List<Token> tokens = tokenizer.tokenize();
            System.out.println("Tokens: " + tokens);

            // Step 2: Parse
            Parser parser = new Parser(tokens);
            Node tree = parser.parseExpression();
            System.out.println("Parse: SUCCESS");

            // Step 3: Evaluate
            int result = Evaluator.evaluate(tree);
            System.out.println("Result: " + result);

        } catch (Exception e) {
            System.out.println("Parse: FAILED");
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
