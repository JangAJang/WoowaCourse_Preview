package lotto.boundedContext;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.enums.GameResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Player {

    private final List<Lotto> playerLotto = new ArrayList<>();
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    public Player(int size){
        while(playerLotto.size() < size){
            playerLotto.add(new Lotto(Randoms
                    .pickUniqueNumbersInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER, LOTTO_SIZE)));
        }
    }

    public HashMap<GameResult, Integer> makeResultByWinningLotto(WinningLotto winningLotto){
        return new HashMap<>();
    }

    public List<List<Integer>> getPlayerLottoNumbers(){
        return new ArrayList<>();
    }
}
