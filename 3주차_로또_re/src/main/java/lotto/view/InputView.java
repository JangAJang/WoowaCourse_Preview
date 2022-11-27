package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String REQUEST_PAYMENT = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS = "보너스 번호를 입력해 주세요.";

    private String readInput(String comment){
        System.out.println(comment);
        return Console.readLine();
    }

    public String readPayment(){
        return null;
    }

    public String readWinningNumbers(){
        return null;
    }

    public String readBonusNumber(){
        return null;
    }
}
