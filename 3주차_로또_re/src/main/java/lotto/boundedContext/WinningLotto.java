package lotto.boundedContext;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.enums.GameResult;


public class WinningLotto {

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, String input){
        this.lotto = lotto;
        bonusNumber = new BonusNumber(lotto, input);
    }

    public GameResult makeResultOfLotto(Lotto lotto){
        return GameResult.SIX;
    }

    private int countMatches(Lotto lotto){
        return this.lotto.matchWithPlayerLotto(lotto.getNumbers());
    }

    private boolean isFive(int count){
        return false;
    }

    private boolean containsBonusNumber(Lotto lotto){
        return false;
    }
}
