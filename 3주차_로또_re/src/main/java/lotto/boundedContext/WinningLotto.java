package lotto.boundedContext;
import lotto.domain.Lotto;
import lotto.enums.GameResult;


public class WinningLotto {

    public WinningLotto(Lotto lotto, String input){

    }

    public GameResult makeResultOfLotto(Lotto lotto){
        return GameResult.SIX;
    }

    private int countMatches(Lotto lotto){
        return 0;
    }

    private boolean isFive(int count){
        return false;
    }

    private boolean containsBonusNumber(Lotto lotto){
        return false;
    }
}
