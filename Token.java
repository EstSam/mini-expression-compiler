//Defines token objects
public class Token{

    
    private final String value;
    private final Tokens type;

    public Token(String value, Tokens type) {
        this.value = value;
        this.type = type;
    }
    
    public String getValue() {
        return value;
    }

    public Tokens getType() {
        return type;
    }
    

    public enum Tokens{
        Symbol,
        Keywords,
        Identifier,
        Constants,
        Operators
        ,Seperators

    }
    
    }