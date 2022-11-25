package baseball.view;

import baseball.exception.GameStatusException;
import baseball.exception.PlayerInputException;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_REQUEST = "숫자를 입력해주세요 : ";
    private static final String GAME_STATUS_REQUEST = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String readPlayerNumber(){
        requestNumbers();
        return validateNumbers(scanInput());
    }

    public String readGameCommand(){
        requestGameStatus();
        return validateGameStatus(scanInput());
    }

    private void requestNumbers(){
        System.out.print(INPUT_REQUEST);
    }

    private String scanInput(){
        return Console.readLine();
    }

    private String validateNumbers(String input){
        PlayerInputException playerInputException = new PlayerInputException();
        return playerInputException.validate(input);
    }

    private void requestGameStatus(){
        System.out.println(GAME_STATUS_REQUEST);
    }

    private String validateGameStatus(String input){
        GameStatusException gameStatusException = new GameStatusException();
        return gameStatusException.validate(input);
    }
}
