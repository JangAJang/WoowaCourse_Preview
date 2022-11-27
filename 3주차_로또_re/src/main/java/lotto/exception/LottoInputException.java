package lotto.exception;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LottoInputException {

    private static final String NOT_NUMBER_LOTTO_COMMENT = "[ERROR] 로또는 숫자로 이루어져야 합니다. ";

    public List<Integer> validate(String input){
        for(String inputEach : input.split(",")) validateEach(inputEach);
        return convertToLottoNumbers(input);
    }

    private void validateEach(String inputEach){
        if(isNotNumber(inputEach)) inputNotNumberException();
    }

    private boolean isNotNumber(String input){
        return !Pattern.matches("^[0-9]*$", input);
    }

    private void inputNotNumberException(){
        System.out.println(NOT_NUMBER_LOTTO_COMMENT);
        throw new IllegalArgumentException();
    }

    private List<Integer> convertToLottoNumbers(String input){
        return Arrays.stream(input.split(",")).map(Integer::parseInt).sorted().collect(Collectors.toList());
    }
}
