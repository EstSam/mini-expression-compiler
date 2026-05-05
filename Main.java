import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an expression:");
        String input = scanner.nextLine();

        try {
            Tokenizer tokenizer = new Tokenizer(input);
            List<Token> tokens = tokenizer.tokenize();
            System.out.println("Tokens: " + tokens);

            Parser parser = new Parser(tokens);
            Node tree = parser.parseExpression();
            System.out.println("Parse: SUCCESS");

            System.out.println("------------------");
            System.out.println("Parse Tree:");
            Node.printTree(tree);
            
            int result = Evaluator.evaluate(tree);
            System.out.println("Result: " + result);

        } catch (Exception e) {
            System.out.println("Parse: FAILED");
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
