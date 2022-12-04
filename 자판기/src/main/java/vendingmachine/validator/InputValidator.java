package vendingmachine.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static vendingmachine.ItemIndexing.*;

public class InputValidator {

    private static final String NOT_RIGHT_PRICE = "[ERROR]금액은 100원부터 시작하며, 10원으로 나누어떨어져야 한다.";
    private static final String NOT_THREE_ELEMENTS = "[ERROR] 품목은 ','로 이름, 가격, 수량 순서로 3가지를 작성해야합니다.";
    private static final String NOT_RIGHT_QUANTITY = "[ERROR] 수량은 숫자로 입력하셔야 합니다.";
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

    public List<List<String>> validateItemsInput(String input){
        List<List<String>> items = new ArrayList<>();
        for(String eachItem : divideBySemiColon(input)){
            items.add(validateEachItem(eachItem));
        }
        return items;
    }

    private List<String> divideBySemiColon(String input){
        return Arrays.stream(input.split(";")).collect(Collectors.toList());
    }

    private List<String> validateEachItem(String inputEach){
        List<String> elements = divideByComma(deleteBracket(inputEach));
        if(isNotThreeElements(elements)) notThreeElementsException(elements);
        if(isNotNumber(elements.get(PRICE.getIndex())) || isNotDividedByTen(elements.get(PRICE.getIndex()))
                || isLessThanHundred(elements.get(PRICE.getIndex()))) {
            notRightPriceException(elements);
        }
        if(isNotNumber(elements.get(QUANTITY.getIndex()))) {
            notRightQuantityException(elements);
        }
        return elements;
    }

    private String deleteBracket(String inputEach){
        String replaced = inputEach.replace("[", "");
        return replaced.replace("]", "");
    }

    private List<String> divideByComma(String inputEach){
        return Arrays.stream(inputEach.split(","))
                .collect(Collectors.toList());
    }

    private boolean isNotThreeElements(List<String> itemEach){
        return itemEach.size() != THREE_ELEMENTS;
    }

    private void notThreeElementsException(List<String> itemEach){
        System.out.println(NOT_THREE_ELEMENTS);
        System.out.println(itemEach.toString());
        throw new IllegalArgumentException();
    }

    private void notRightPriceException(List<String> itemEach){
        System.out.println(NOT_RIGHT_PRICE );
        throw new IllegalArgumentException();
    }

    private void notRightQuantityException(List<String> itemEach){
        System.out.println(NOT_RIGHT_QUANTITY);
        throw new IllegalArgumentException();
    }
}
