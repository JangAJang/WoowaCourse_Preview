package lotto.exception;

import java.util.List;

public class LottoException {

    public List<Integer> validate(List<Integer> numbers){
        return numbers;
    }

    private boolean isNumberOutOfRange(List<Integer> numbers){
        return false;
    }

    private boolean isNotSixNumbers(List<Integer> numbers){
        return false;
    }

    private boolean containsSameNumber(List<Integer> numbers){
        return false;
    }

    private void notRightNumbersException(){

    }
}
