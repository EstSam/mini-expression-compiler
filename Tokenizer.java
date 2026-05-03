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
    }


private void Move(){
    position++;
    if(position<input.length()){
        Char = input.charAt(position);
    }else{
        Char = '\0';
    }

}


private String Read(){
    StringBuilder build = new StringBuilder();
    int count = 0;

    while(Char!='\0'&&Character.isDigit(Char)||Char =='.'){
        if(Char == '.'){
            count++;
        }
        build.append(Char);
        Move();
    }
    return build.toString();
}


public List<Token> tokenize(){
        List<Token> tokens = new ArrayList<>();
    }



    



if(Char=='+'){

}

}