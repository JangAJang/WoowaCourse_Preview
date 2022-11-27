package lotto.boundedContext;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.enums.GameResult;

import static lotto.enums.GameResult.*;


public class WinningLotto {

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, String input){
        this.lotto = lotto;
        bonusNumber = new BonusNumber(lotto, input);
    }

    public GameResult makeResultOfLotto(Lotto lotto){
        int resultCount = countMatches(lotto);
        if(resultCount == SIX.getCount()) return SIX;
        if(isFive(resultCount)) return makeFromFive(lotto);
        if(resultCount == FOUR.getCount()) return FOUR;
        if(resultCount == THREE.getCount()) return THREE;
        return NOTHING;
    }

    private int countMatches(Lotto lotto){
        return this.lotto.matchWithPlayerLotto(lotto.getNumbers());
    }

    private boolean isFive(int count){
        return count == 5;
    }

    private GameResult makeFromFive(Lotto lotto){
        if(containsBonusNumber(lotto)) return GameResult.FIVE_WITH_BONUS;
        return FIVE;
    }

    private boolean containsBonusNumber(Lotto lotto){
        return bonusNumber.isHavingBonusNumber(lotto.getNumbers());
    }
}
