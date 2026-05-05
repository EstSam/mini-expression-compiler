//Converts input into tokens
//Breaks the input string into tokens such as numbers, operators, and parentheses.

import java.util.ArrayList;
import java.util.List;

public class Tokenizer{ 


    int position = 0;
    char Char;
    String input;


public Tokenizer(String input) {
        this.input = input;

        if(input.length()>0){
            Char = input.charAt(0);
        }else{
            Char = '\0';
        }
    }


private void Move(){
    position++;
    if(position<input.length()){
        Char = input.charAt(position);
    }else{
        Char = '\0';
    }

}

private String Read() {
    StringBuilder build = new StringBuilder();
    int count = 0;

    while (Char != '\0' && (Character.isDigit(Char) || Char == '.')) {
        if (Char == '.') {
            count++;
        }
        build.append(Char);
        Move();
    }
    return build.toString();
}








public List<Token> tokenize(){
    List<Token> tokens = new ArrayList<>();

    while(Char != '\0'){

        if(Character.isWhitespace(Char)){
            Move();
            continue;
        }
        else if(Character.isDigit(Char)){
            tokens.add(new Token(Token.Tokens.NUMBER, Read()));
            continue;
        }
        else if(Char=='+' || Char=='-' || Char=='*' || Char=='/'){
            tokens.add(new Token(Token.Tokens.OPERATOR, String.valueOf(Char)));
            Move();
            continue;
        }
        else if(Char=='('){
            tokens.add(new Token(Token.Tokens.LPAREN, "("));
            Move();
            continue;
        }
        else if(Char==')'){
            tokens.add(new Token(Token.Tokens.RPAREN, ")"));
            Move();
            continue;
        }
        else {
            throw new RuntimeException("Invalid character: " + Char);
        }
    }

    return tokens;
}

}

    


