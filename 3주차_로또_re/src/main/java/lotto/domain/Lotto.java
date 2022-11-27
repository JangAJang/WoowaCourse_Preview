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
        return false;
    }

    public int matchWithPlayerLotto(List<Integer> playerNumbers){
        return 0;
    }

    private int countMatch(List<Integer> playerNumbers){
        return 0;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
