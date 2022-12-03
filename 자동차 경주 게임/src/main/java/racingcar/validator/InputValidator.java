package racingcar.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {

    public List<String> validateNames(String input){
        List<String> names = separateNames(input);
    }

    private List<String> separateNames(String input){
        return Arrays.stream(input.split(",")).collect(Collectors.toList());
    }
}
