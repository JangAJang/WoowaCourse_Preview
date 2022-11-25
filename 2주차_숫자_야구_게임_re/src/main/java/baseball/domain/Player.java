package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    private List<Integer> numbers;

    public Player(String input){
        numbers = Arrays.stream(input.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public List<Integer> getNumbers(){
        return numbers;
    }


}
