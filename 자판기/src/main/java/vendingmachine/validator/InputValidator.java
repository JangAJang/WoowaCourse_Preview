package vendingmachine.validator;

import java.util.regex.Pattern;

public class InputValidator {

    public int validatePrice(String input){

    }

    private boolean isNotNumber(String input){
        return !Pattern.matches("^[0-9]*$", input);
    }

    private boolean isNotDividedByTen(String input){
        return Integer.parseInt(input)%10 !=0;
    }

    private boolean isLessThanHundred(String input){
        return Integer.parseInt(input) < 100;
    }
}
