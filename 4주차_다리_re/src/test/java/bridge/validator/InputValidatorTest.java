package bridge.validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
public class InputValidatorTest {

    InputValidator inputValidator;

    @BeforeEach
    void initializeClass(){
        inputValidator = new InputValidator();
    }

    @DisplayName("입력이 숫자가 아니면 다리 길이는 예외처리한다. ")
    @Test
    void isLengthNotNumberTest(){
        assertThatThrownBy(()->inputValidator.validateLength("ab"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력이 숫자가 아니면 다리 길이는 예외처리한다. ")
    @Test
    void isLengthOutOfRangeTest(){
        assertThatThrownBy(()->inputValidator.validateLength("21"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적인 입력은 정수로 반환한다. ")
    @Test
    void validateLengthTest(){
        assertThat(inputValidator.validateLength("4"))
                .isEqualTo(4);
    }

    @DisplayName("입력이 U나 D가 아니면  예외처리한다. ")
    @Test
    void isBridgeNotUTest(){
        assertThatThrownBy(()->inputValidator.validateBridgeChoice("ab"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적인 입력U는 문자열 그대로 반환한다. ")
    @Test
    void validateBridgeChoiceUTest(){
        assertThat(inputValidator.validateBridgeChoice("U"))
                .isEqualTo("U");
    }

    @DisplayName("정상적인 입력D는 문자열 그대로 반환한다. ")
    @Test
    void validateBridgeChoiceDTest(){
        assertThat(inputValidator.validateBridgeChoice("D"))
                .isEqualTo("D");
    }

    @DisplayName("입력이 R이나 Q가 아니면 예외처리한다. ")
    @Test
    void isNotROrQTest(){
        assertThatThrownBy(()->inputValidator.validateGameRetrialChoice("ab"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적인 입력Q는 문자열로 그대로반환한다. ")
    @Test
    void validateGameRetrialChoiceQTest(){
        assertThat(inputValidator.validateGameRetrialChoice("Q"))
                .isEqualTo("Q");
    }

    @DisplayName("정상적인 입력R는 문자열로 그대로반환한다. ")
    @Test
    void validateGameRetrialChoiceRTest(){
        assertThat(inputValidator.validateGameRetrialChoice("R"))
                .isEqualTo("R");
    }
}
