package baseball.exceptionTest;

import baseball.exception.GameStatusException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GameStatusExceptionTest {

    GameStatusException gameStatusException = new GameStatusException();

    @DisplayName("입력이 '1'이나 '2'가 아니면 예외처리")
    @Test
    void isNotOneTest(){
        assertThatThrownBy(()->gameStatusException.validate("3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("입력이 '1'이면 문자열로 반환")
    @Test
    void validateOneTest(){
        assertThat(gameStatusException.validate("1")).isEqualTo("1");
    }
    @DisplayName("입력이 '2'면 문자열로 반환")
    @Test
    void validateTwoTest(){
        assertThat(gameStatusException.validate("2")).isEqualTo("2");
    }

}
