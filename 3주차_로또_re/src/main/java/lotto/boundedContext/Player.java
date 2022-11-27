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
        HashMap<GameResult, Integer> statistics = initializeStatistics();
        for(Lotto lottoEach : playerLotto){
            addDataToStatistics(statistics, winningLotto.makeResultOfLotto(lottoEach));
        }
        return statistics;
    }

    private HashMap<GameResult, Integer> initializeStatistics(){
        HashMap<GameResult, Integer> winningStatistics = new HashMap<>();
        winningStatistics.put(GameResult.NOTHING, 0);
        winningStatistics.put(GameResult.THREE, 0);
        winningStatistics.put(GameResult.FOUR, 0);
        winningStatistics.put(GameResult.FIVE, 0);
        winningStatistics.put(GameResult.FIVE_WITH_BONUS, 0);
        winningStatistics.put(GameResult.SIX, 0);
        return winningStatistics;
    }

    private void addDataToStatistics(HashMap<GameResult, Integer> map, GameResult data){
        map.replace(data, map.get(data), map.get(data)+1);
    }

    public List<List<Integer>> getPlayerLottoNumbers(){
        List<List<Integer>> playerNumbers = new ArrayList<>();
        for(Lotto lottoEach: playerLotto){
            playerNumbers.add(lottoEach.getNumbers());
        }
        return playerNumbers;
    }
}
