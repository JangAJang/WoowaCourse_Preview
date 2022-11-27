package lotto.exception;

import lotto.domain.Lotto;

import java.util.regex.Pattern;

public class BonusNumberException {

    private static final int MAXIMUM_NUMBER = 45;
    private static final int MINIMUM_NUMBER = 1;
    private static final String NOT_RIGHT_BONUS_NUMBER_COMMENT = "[ERROR] 보너스 넘버는 1부터 45중 당첨번호에 등록되지 않은 번호여야 합니다. ";

    public int validate(String bonusNumber, Lotto lotto){
        if(isNotNumber(bonusNumber) || isOutOfRange(bonusNumber) || isAlreadyInLotto(bonusNumber, lotto))
            notRightBonusNumberException();
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
        System.out.println(NOT_RIGHT_BONUS_NUMBER_COMMENT);
        throw new IllegalArgumentException();
    }
}
