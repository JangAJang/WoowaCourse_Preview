package vendingmachine.validator;

import java.util.regex.Pattern;

public class InputValidator {

    private static final String NOT_RIGHT_PRICE = "[ERROR]금액은 100원부터 시작하며, 10원으로 나누어떨어져야 한다.";

    public int validatePrice(String input){
        if(isNotNumber(input) || isNotDividedByTen(input) || isLessThanHundred(input))
            notRightPriceException();
        return Integer.parseInt(input);
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

    private void notRightPriceException(){
        System.out.println(NOT_RIGHT_PRICE);
        throw new IllegalArgumentException();
    }
}
