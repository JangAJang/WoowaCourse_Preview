package racingcar.validator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputValidator {

    private static final int LENGTH_LIMIT = 5;
    private static final String NAME_TOO_LONG_EXCEPTION = "[ERROR] 이름은 5글자 이내여야 합니다.";
    private static final String TRIAL_NOT_NUMBER_EXCEPTION = "[ERROR] 시도 횟수는 숫자로 입력해야 합니다.";

    public List<String> validateNames(String input){
        List<String> names = separateNames(input);
        for(String nameEach : names){
            if(isEachNameTooLong(nameEach)) nameTooLongException();
        }
        return names;
    }

    public int validateTrialCounts(String input){
        return 0;
    }

    private List<String> separateNames(String input){
        return Arrays.stream(input.split(",")).collect(Collectors.toList());
    }

    private boolean isEachNameTooLong(String name){
        return name.length() > LENGTH_LIMIT;
    }

    private void nameTooLongException(){
        System.out.println(NAME_TOO_LONG_EXCEPTION);
        throw new IllegalArgumentException();
    }

    private boolean isNotNumber(String input){
        return !Pattern.matches("^[0-9]*$", input);
    }

    private void notNumberException(){
        System.out.println(TRIAL_NOT_NUMBER_EXCEPTION);
        throw new IllegalArgumentException();
    }
}
