package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.validator.InputValidator;

import java.util.List;

public class InputView {

    private static final String REQUEST_PRICE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String REQUEST_ITEMS = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String REQUEST_INSERT = "투입 금액을 입력해 주세요.";
    private static final String REQUEST_BUYING = "구매할 상품명을 입력해 주세요.";

    InputValidator inputValidator = new InputValidator();

    private String readInput(String request){
        System.out.println(request);
        return Console.readLine();
    }

    public int readPrice(){
        try{
            return inputValidator.validatePrice(readInput(REQUEST_PRICE));
        }catch (IllegalArgumentException e){
            return readPrice();
        }
    }

    public int readInsertMoney(){
        try{
            return inputValidator.validatePrice(readInput(REQUEST_INSERT));
        }catch (IllegalArgumentException e){
            return readInsertMoney();
        }
    }

    public List<List<String>> readItems(){
        try{
            return inputValidator.validateItemsInput(readInput(REQUEST_ITEMS));
        }catch (IllegalArgumentException e){
            return readItems();
        }
    }

    public String readBuying(){
        return readInput(REQUEST_BUYING);
    }
}
