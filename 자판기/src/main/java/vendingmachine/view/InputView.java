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
        return inputValidator.validatePrice(readInput(REQUEST_PRICE));
    }

    public int readInsertMoney(){
        return inputValidator.validatePrice(readInput(REQUEST_INSERT));
    }

    public List<List<String>> readItems(){
        return inputValidator.validateItemsInput(readInput(REQUEST_ITEMS));
    }

    public String readBuying(){
        return readInput(REQUEST_BUYING);
    }
}
