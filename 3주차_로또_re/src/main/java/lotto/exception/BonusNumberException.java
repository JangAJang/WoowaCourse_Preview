package lotto.exception;

import lotto.domain.Lotto;

public class BonusNumberException {

    public int validate(String bonusNumber, Lotto lotto){
        return Integer.parseInt(bonusNumber);
    }

    private boolean isNotNumber(String bonusNumber){
        return false;
    }

    private boolean isAlreadyInLotto(String bonusNumber, Lotto lotto){
        return false;
    }

    private boolean isOutOfRange(String bonusNumber){
        return false;
    }

    private void notRightBonusNumberException(){

    }
}
