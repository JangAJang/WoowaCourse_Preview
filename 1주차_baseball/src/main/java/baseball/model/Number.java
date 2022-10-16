package baseball.model;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Number {
    private static int MIN_NUMBER = 1;
    private static int MAX_NUMBER = 9;
    private static int LENGTH_LIMIT = 3;

    private static String INPUT_REQUEST = "숫자를 입력해주세요 : ";
    private static final String REGAX = "^["+MIN_NUMBER+"-"+MAX_NUMBER+"]*$";



    private int[] numbers;

    public Number(){}

    public int[] getNumbers(){
        return this.numbers;
    }

    //컴퓨터용 함수
    public void createRandomNumber(){
        Set<Integer> set = new HashSet<>();
        while(set.size()<LENGTH_LIMIT){
            set.add(getRandomNumber());
        }
        this.numbers = convertHashSetToIntegerArray(set);
    }

    public int getRandomNumber(){
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    public int[] convertHashSetToIntegerArray(Set<Integer> set){
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    //사용자용 함수
    public void getNumbersFromPlayer(){
        System.out.print(INPUT_REQUEST);
        String input = Console.readLine();
        setNumbers(input);
    }

    public void setNumbers(String input){
        if(!isValidNumber(input)) throw new IllegalArgumentException();
        this.numbers = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
    }

    public boolean isValidNumber(String input){
        if(!isRightLength(input) || !isNotDuplicated(input) || !isRightRange(input)) return false;
        return true;
    }

    public boolean isRightLength(String input){
        return input.length() == LENGTH_LIMIT;
    }

    public boolean isRightRange(String input){
        Pattern numberPattern = Pattern.compile(REGAX);
        return numberPattern.matcher(input).matches();
    }

    public boolean isNotDuplicated(String input){
        Set<Character> set = new HashSet<>();
        for(char c : input.toCharArray()){
            set.add(c);
        }
        return set.size() == LENGTH_LIMIT;
    }
}
