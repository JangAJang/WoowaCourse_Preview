package lotto.exception;

import java.util.regex.Pattern;

public class PriceInputException {

    public Long validate(String input){
        return 0L;
    }

    private boolean isNotNumber(String input){
        return !Pattern.matches("^[0-9]*$", input);
    }

    private boolean isNotDividedByThousand(String input){
        return Long.parseLong(input) % 1000 != 0 || Long.parseLong(input) / 1000 ==0;
    }
}
