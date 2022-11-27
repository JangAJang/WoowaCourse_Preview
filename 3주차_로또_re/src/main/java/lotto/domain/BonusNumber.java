package lotto.domain;

import lotto.exception.BonusNumberException;

import java.util.List;

public class BonusNumber {

    private int bonusNumber;

    public BonusNumber(Lotto winningLotto, String input){
        BonusNumberException bonusNumberException = new BonusNumberException();
        bonusNumber = bonusNumberException.validate(input, winningLotto);
    }

    public boolean isHavingBonusNumber(List<Integer> numbers){
        return numbers.contains(bonusNumber);
    }
}
