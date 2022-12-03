package racingcar.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {

    private static final int LENGTH_LIMIT = 5;

    public List<String> validateNames(String input){
        List<String> names = separateNames(input);
    }

    private List<String> separateNames(String input){
        return Arrays.stream(input.split(",")).collect(Collectors.toList());
    }

    private boolean isEachNameTooLong(String name){
        return name.length() > LENGTH_LIMIT;
    }
}
