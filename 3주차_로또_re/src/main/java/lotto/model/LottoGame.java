package lotto.model;

import lotto.boundedContext.Player;
import lotto.boundedContext.WinningLotto;
import lotto.domain.Winning;
import lotto.enums.GameResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoGame {

    Player player;
    WinningLotto winningLotto;
    Winning winning;

    public LottoGame(Long payment){

    }

    public List<List<Integer>> showPlayerNumbers(){
        return new ArrayList<>();
    }

    public void createWinningLotto(List<Integer> number, String bonusNumber){

    }

    public HashMap<GameResult, Integer> matchLotto(){
        return new HashMap<>();
    }

    public String calculatePlayerProfit(){
        return null;
    }
}
