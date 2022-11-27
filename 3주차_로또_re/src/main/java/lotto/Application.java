package lotto;

import lotto.controller.LottoGameController;

public class Application {
    public static void main(String[] args) {
        try{
            LottoGameController lottoGameController = new LottoGameController();
            lottoGameController.run();
        }catch (IllegalArgumentException e){
            return;
        }
    }
}
