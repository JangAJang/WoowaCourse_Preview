package lotto.exception;

import java.util.List;

public class LottoException {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;

    public List<Integer> validate(List<Integer> numbers){
        return numbers;
    }

    private boolean isNumbersOutOfRange(List<Integer> numbers){
        for(int number: numbers){
            if(isNumberEachOutOfRange(number)) return true;
        }
        return false;
    }

    private boolean isNumberEachOutOfRange(int number){
        return number <MINIMUM_NUMBER || number > MAXIMUM_NUMBER;
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
