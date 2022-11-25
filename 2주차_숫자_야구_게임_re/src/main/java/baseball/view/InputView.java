package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_REQUEST = "숫자를 입력해주세요 : ";

    private void requestNumbers(){
        System.out.print(INPUT_REQUEST);
    }

    private String scanInput(){
        return Console.readLine();
    }
}
