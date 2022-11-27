package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.LottoInputException;
import lotto.exception.PriceInputException;

import java.util.List;

public class InputView {

    private static final String REQUEST_PAYMENT = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS = "보너스 번호를 입력해 주세요.";

    private String readInput(String comment){
        System.out.println(comment);
        return Console.readLine();
    }

    public long readPayment(){
        PriceInputException priceInputException = new PriceInputException();
        return priceInputException.validate(readInput(REQUEST_PAYMENT));
    }

    public List<Integer> readWinningNumbers(){
        LottoInputException lottoInputException = new LottoInputException();
        return lottoInputException.validate(readInput(REQUEST_WINNING));
    }

    public String readBonusNumber(){
       return (readInput(REQUEST_BONUS));
    }
}
