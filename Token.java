public class Token {

    public enum Type {
        NUMBER, OPERATOR, LPAREN, RPAREN
    }

    private final String value;
    private final Type type;

    public Token(Type type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Type getType() {
        return type;
    }

    public String toString() {
        return value;
    }
}
