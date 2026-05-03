import java.util.List;

public class Parser {

    private List<Token> tokens;

    private int position = 0;

    public Parser(List<Token> tokens) {

        this.tokens = tokens;

    }

    private Token current() {

        if (position < tokens.size()) {

            return tokens.get(position);

        }

        return null;

    }

    private void eat() {

        position++;

    }

    // E → T ((+ | -) T)*

    public Node parseExpression() {

        Node node = parseTerm();

        while (current() != null &&

               current().getType() == Token.Tokens.OPERATOR &&

               (current().getValue().equals("+") ||

                current().getValue().equals("-"))) {

            String op = current().getValue();

            eat();

            Node newNode = new Node(op);

            newNode.left = node;

            newNode.right = parseTerm();

            node = newNode;

        }

        return node;

    }

    // T → F ((* | /) F)*

    private Node parseTerm() {

        Node node = parseFactor();

        while (current() != null &&

               current().getType() == Token.Tokens.OPERATOR &&

               (current().getValue().equals("*") ||

                current().getValue().equals("/"))) {

            String op = current().getValue();

            eat();

            Node newNode = new Node(op);

            newNode.left = node;

            newNode.right = parseFactor();

            node = newNode;

        }

        return node;

    }

    // F → (E) | number

    private Node parseFactor() {

        Token token = current();

        if (token == null) {

            throw new RuntimeException("Unexpected end of input");

        }

        // NUMBER

        if (token.getType() == Token.Tokens.NUMBER) {

            eat();

            return new Node(token.getValue());

        }

        // (E)

        if (token.getType() == Token.Tokens.LPAREN) {

            eat();

            Node node = parseExpression();

            if (current() == null ||

                current().getType() != Token.Tokens.RPAREN) {

                throw new RuntimeException("Missing closing parenthesis");

            }

            eat();

            return node;

        }

        throw new RuntimeException("Unexpected token: " + token.getValue());

    }

}