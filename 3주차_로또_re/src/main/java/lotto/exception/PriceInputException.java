package lotto.exception;

import java.util.regex.Pattern;

public class PriceInputException {

    private static final String NOT_RIGHT_PAYMENT_COMMENT = "[ERROR] 금액은 1000원단위로 등록해야 합니다. ";

    public Long validate(String input){
        if(isNotNumber(input) || isNotDividedByThousand(input)) notRightPaymentException();
        return Long.parseLong(input);
    }

    private boolean isNotNumber(String input){
        return !Pattern.matches("^[0-9]*$", input);
    }

    private boolean isNotDividedByThousand(String input){
        return Long.parseLong(input) % 1000 != 0 || Long.parseLong(input) / 1000 ==0;
    }

    private void notRightPaymentException(){
        System.out.println(NOT_RIGHT_PAYMENT_COMMENT);
        throw new IllegalArgumentException();
    }
}
