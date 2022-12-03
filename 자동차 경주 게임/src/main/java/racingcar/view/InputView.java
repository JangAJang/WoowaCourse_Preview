package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputValidator;

import java.util.List;

public class InputView {

    private static final String REQUEST_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private InputValidator inputValidator = new InputValidator();

    private String readInput(String request){
        System.out.println(request);
        return Console.readLine();
    }

    public List<String> readNames(){
        return inputValidator.validateNames(readInput(REQUEST_NAMES));
    }
}
