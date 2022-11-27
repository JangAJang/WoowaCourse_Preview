package lotto.controller;

import lotto.model.LottoGame;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private final LottoGame lottoGame;
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public LottoGameController(){
        lottoGame = new LottoGame(Long.parseLong(inputView.readPayment()));
    }

    public void run(){

    }

    private void showPlayerNumbers(){

    }

    private void generateWinningLotto(){

    }

    private void showResultOfGame(){

    }
}
