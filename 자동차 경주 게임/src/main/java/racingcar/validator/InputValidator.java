package racingcar.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {

    private static final int LENGTH_LIMIT = 5;
    private static final String NAME_TOO_LONG_EXCEPTION = "[ERROR] 이름은 5글자 이내여야 합니다.";

    public List<String> validateNames(String input){
        List<String> names = separateNames(input);
        for(String nameEach : names){
            if(isEachNameTooLong(nameEach)) nameTooLongException();
        }
        return names;
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
}
