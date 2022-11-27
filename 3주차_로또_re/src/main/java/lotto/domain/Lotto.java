package lotto.domain;

import lotto.enums.GameResult;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
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
