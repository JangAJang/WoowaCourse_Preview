package baseball;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.model.Number;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class NumberTest {

    private static final int LENGTH = 3;
    private static final int MIN = 1;
    private static final int MAX = 9;

    private static Number number;

    @BeforeEach
    private void createNumber(){
        number = new Number();
    }

    @Test
    void 컴퓨터_숫자_체크(){
        number.createRandomNumber();
        assertTrue(isValidNumber());
    }

    @Test
    void 올바른_숫자_입력(){
        number.setNumbers("123");
        assertTrue(isValidNumber());
    }

    @Test
    void 문자_입력(){
        assertThrows(IllegalArgumentException.class, ()->number.setNumbers("abc"));
    }

    @Test
    void 숫자_길이_입력_오류(){
        assertThrows(IllegalArgumentException.class, ()->number.setNumbers("1234"));
    }

    @Test
    void 중복_숫자_입력(){
        assertThrows(IllegalArgumentException.class, ()->number.setNumbers("111"));
    }

    @Test
    void 숫자_범위_초과(){
        assertThrows(IllegalArgumentException.class, ()->number.setNumbers("000"));
    }

    private boolean isValidNumber(){
        return isNotDuplicated() && isInRange() && isInLength();
    }

    private boolean isNotDuplicated(){
        int[] numbers = number.getNumbers();
        Set<Integer> set = convertArrayToSet(numbers);
        return set.size() == numbers.length;
    }

    private boolean isInRange(){
        for(int each : number.getNumbers()){
            if(each < MIN || each > MAX) return false;
        }
        return true;
    }

    private boolean isInLength(){
        return number.getNumbers().length == LENGTH;
    }

    private Set<Integer> convertArrayToSet(int[] arr){
        Set<Integer> set = new HashSet<>();
        for(int x : arr){
            set.add(x);
        }
        return set;
    }
}
