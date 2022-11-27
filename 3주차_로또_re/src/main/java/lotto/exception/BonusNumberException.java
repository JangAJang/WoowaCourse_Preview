package lotto.exception;

import lotto.domain.Lotto;

import java.util.regex.Pattern;

public class BonusNumberException {

    private static final int MAXIMUM_NUMBER = 45;
    private static final int MINIMUM_NUMBER = 1;

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
        return Integer.parseInt(bonusNumber) < MINIMUM_NUMBER || Integer.parseInt(bonusNumber) > MAXIMUM_NUMBER;
    }

    private void notRightBonusNumberException(){

    }
}
