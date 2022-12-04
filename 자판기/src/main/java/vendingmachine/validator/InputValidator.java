package vendingmachine.validator;

import java.util.regex.Pattern;

public class InputValidator {

    public int validatePrice(String input){

    }

    private boolean isNotNumber(String input){
        return !Pattern.matches("^[0-9]*$", input);
    }
}
