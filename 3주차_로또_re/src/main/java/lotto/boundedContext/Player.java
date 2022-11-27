package lotto.boundedContext;

import lotto.domain.Lotto;
import lotto.enums.GameResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Player {

    private final List<Lotto> playerLotto = new ArrayList<>();

    public Player(int size){

    }

    public HashMap<GameResult, Integer> makeResultByWinningLotto(WinningLotto winningLotto){
        return new HashMap<>();
    }

    public List<List<Integer>> getPlayerLottoNumbers(){
        return new ArrayList<>();
    }
}
