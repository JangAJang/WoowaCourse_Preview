package vendingmachine.validator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputValidator {

    private static final String NOT_RIGHT_PRICE = "[ERROR]금액은 100원부터 시작하며, 10원으로 나누어떨어져야 한다.";
    private static final int THREE_ELEMENTS = 3;

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

    private List<List<String>> validateItemsInput(String input){

    }

    private List<String> divideBySemiColon(String input){
        return Arrays.stream(input.split(";")).collect(Collectors.toList());
    }

    private List<String> validateEachItem(String inputEach){

    }

    private String deleteBracket(String inputEach){
        return inputEach.replace("[]", "");
    }

    private List<String> divideByComma(String inputEach){
        return Arrays.stream(inputEach.split(","))
                .collect(Collectors.toList());
    }

    private boolean isNotThreeElements(List<String> itemEach){
        return itemEach.size() != THREE_ELEMENTS;
    }
}
