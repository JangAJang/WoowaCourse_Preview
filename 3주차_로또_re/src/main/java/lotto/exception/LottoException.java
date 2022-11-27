package lotto.exception;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoException {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private static final int NUMBERS_COUNT = 6;

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
        return numbers.size() != NUMBERS_COUNT;
    }

    private boolean containsSameNumber(List<Integer> numbers){
        return new HashSet<>(numbers).size()!=NUMBERS_COUNT;
    }

    private void notRightNumbersException(){

    }
}
