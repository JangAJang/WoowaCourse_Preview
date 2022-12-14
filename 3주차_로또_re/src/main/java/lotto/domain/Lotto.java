package lotto.domain;

import lotto.enums.GameResult;
import lotto.exception.LottoException;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = validate(numbers);
    }

    private List<Integer> validate(List<Integer> numbers) {
        LottoException lottoException = new LottoException();
        return lottoException.validate(numbers);
    }

    public boolean containsBonusNumber(int number){
        return numbers.contains(number);
    }

    public int matchWithPlayerLotto(List<Integer> playerNumbers){
        int result = 0;
        for(int numberEach : playerNumbers){
            result += countMatch(numberEach);
        }
        return result;
    }

    private int countMatch(int numberEach){
        if(numbers.contains(numberEach)) return 1;
        return 0;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
