package lotto.model;

import lotto.boundedContext.Player;
import lotto.boundedContext.WinningLotto;
import lotto.domain.Lotto;
import lotto.domain.Winning;
import lotto.enums.GameResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoGame {

    private final Player player;
    WinningLotto winningLotto;
    Winning winning;

    public LottoGame(Long payment){
        player = new Player((int)(payment/1000));
    }

    public List<List<Integer>> showPlayerNumbers(){
        return player.getPlayerLottoNumbers();
    }

    public void createWinningLotto(List<Integer> number, String bonusNumber){
        winningLotto = new WinningLotto(new Lotto(number), bonusNumber);
    }

    public HashMap<GameResult, Integer> matchLotto(){
        winning = new Winning(player.makeResultByWinningLotto(winningLotto));
        return winning.getWinningStatistics();
    }

    public String calculatePlayerProfit(){
        return winning.calculateProfit();
    }
}
