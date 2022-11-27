package lotto.controller;

import lotto.exception.LottoInputException;
import lotto.model.LottoGame;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private final LottoGame lottoGame;
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public LottoGameController(){
        lottoGame = new LottoGame(inputView.readPayment());
    }

    public void run(){
        showPlayerNumbers();
        generateWinningLotto();
        showResultOfGame();
    }

    private void showPlayerNumbers(){
        outputView.printPlayerNumber(lottoGame.showPlayerNumbers());
    }

    private void generateWinningLotto(){
        lottoGame.createWinningLotto(inputView.readWinningNumbers(), inputView.readBonusNumber());
    }

    private void showResultOfGame(){
        outputView.printStart();
        outputView.printResult(lottoGame.matchLotto());
        outputView.printProfit(lottoGame.calculatePlayerProfit());
    }
}
