package baseball.exceptionTest;
import baseball.exception.PlayerInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerInputExceptionTest {

    PlayerInputException playerInputException = new PlayerInputException();

    @DisplayName("입력이 숫자가 아니면 예외처리")
    @Test
    void isNotNumberText(){
        assertThatThrownBy(()->playerInputException.validate("1230j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력이 3자리가 아니면 예외처리")
    @Test
    void isNotThreeDigitText(){
        assertThatThrownBy(()->playerInputException.validate("1230"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력이 0이 있으면 예외처리")
    @Test
    void containsZeroText(){
        assertThatThrownBy(()->playerInputException.validate("230"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 입력이면 문자열 그대로 반환")
    @Test
    void validateTest(){
        assertThat(playerInputException.validate("123"))
                .isEqualTo("123");
    }
}
