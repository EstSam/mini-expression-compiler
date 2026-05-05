import java.util.*;

public class Tokenizer {

    private int position = 0;
    private char current;
    private String input;

    public Tokenizer(String input) {
        this.input = input;
        current = input.length() > 0 ? input.charAt(0) : '\0';
    }

    private void advance() {
        position++;
        current = position < input.length() ? input.charAt(position) : '\0';
    }

    private String readNumber() {
        StringBuilder sb = new StringBuilder();

        while (current != '\0' && (Character.isDigit(current))) {
            sb.append(current);
            advance();
        }

        return sb.toString();
    }

    public List<Token> tokenize() {
        List<Token> tokens = new ArrayList<>();

        while (current != '\0') {

            if (Character.isWhitespace(current)) {
                advance();
            }
            else if (Character.isDigit(current)) {
                tokens.add(new Token(Token.Type.NUMBER, readNumber()));
            }
            else if (current == '+' || current == '-' || current == '*' || current == '/') {
                tokens.add(new Token(Token.Type.OPERATOR, String.valueOf(current)));
                advance();
            }
            else if (current == '(') {
                tokens.add(new Token(Token.Type.LPAREN, "("));
                advance();
            }
            else if (current == ')') {
                tokens.add(new Token(Token.Type.RPAREN, ")"));
                advance();
            }
            else {
                throw new RuntimeException("Invalid character: " + current);
            }
        }

        return tokens;
    }
}


    


