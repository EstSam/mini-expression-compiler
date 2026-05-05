import java.util.*;

public class Parser {

    private List<Token> tokens;
    private int pos = 0;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    private Token current() {
        return pos < tokens.size() ? tokens.get(pos) : null;
    }

    private void eat() {
        pos++;
    }

    public Node parseExpression() {
        Node node = parseTerm();

        while (current() != null &&
               current().getType() == Token.Type.OPERATOR &&
               (current().getValue().equals("+") || current().getValue().equals("-"))) {

            String op = current().getValue();
            eat();

            Node right = parseTerm();
            node = new Node(op, node, right);
        }

        return node;
    }

    private Node parseTerm() {
        Node node = parseFactor();

        while (current() != null &&
               current().getType() == Token.Type.OPERATOR &&
               (current().getValue().equals("*") || current().getValue().equals("/"))) {

            String op = current().getValue();
            eat();

            Node right = parseFactor();
            node = new Node(op, node, right);
        }

        return node;
    }

   private Node parseFactor() {
        Token token = current();

        if (token == null) {
        throw new RuntimeException("Unexpected end of input");
    }

        if (token.getType() == Token.Type.OPERATOR &&
        (token.getValue().equals("+") || token.getValue().equals("-"))) {

        String op = token.getValue();
        eat();

        Node factor = parseFactor(); // recursive

        // treat -x as (0 - x)
        if (op.equals("-")) {
            return new Node("-", new Node("0"), factor);
        }

        // +x just returns x
        return factor;
    }

    // NUMBER
    if (token.getType() == Token.Type.NUMBER) {
        eat();
        return new Node(token.getValue());
    }

    // (E)
    if (token.getType() == Token.Type.LPAREN) {
        eat();
        Node node = parseExpression();

        if (current() == null || current().getType() != Token.Type.RPAREN) {
            throw new RuntimeException("Missing closing parenthesis");
        }

        eat();
        return node;
    }

    throw new RuntimeException("Unexpected token: " + token.getValue());
}
}
