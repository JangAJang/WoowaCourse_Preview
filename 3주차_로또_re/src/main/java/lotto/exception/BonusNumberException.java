package lotto.exception;

import lotto.domain.Lotto;

import java.util.regex.Pattern;

public class BonusNumberException {

    public int validate(String bonusNumber, Lotto lotto){
        return Integer.parseInt(bonusNumber);
    }

    private boolean isNotNumber(String bonusNumber){
        return !Pattern.matches("^[0-9]*$", bonusNumber);
    }

    private boolean isAlreadyInLotto(String bonusNumber, Lotto lotto){
        return lotto.containsBonusNumber(Integer.parseInt(bonusNumber));
    }

    private boolean isOutOfRange(String bonusNumber){
        return false;
    }

    private void notRightBonusNumberException(){

    }
}
