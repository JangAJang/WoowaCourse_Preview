package lotto.exception;

import java.util.ArrayList;
import java.util.List;

public class LottoInputException {

    public List<Integer> validate(String input){
        return new ArrayList<>();
    }

    private boolean isNotNumber(String input){
        return false;
    }

    private void inputNotNumberException(){

    }

    private List<Integer> convertToLottoNumbers(String input){
        return new ArrayList<>();
    }
}
