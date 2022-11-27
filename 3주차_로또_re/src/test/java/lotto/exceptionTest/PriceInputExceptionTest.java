package lotto.exceptionTest;

import lotto.exception.PriceInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
public class PriceInputExceptionTest {

    PriceInputException priceInputException = new PriceInputException();

    @DisplayName("입력이 숫자가 아니면 예외처리")
    @Test
    void isNOtNumberTest(){
        assertThatThrownBy(()->priceInputException.validate("10000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("1,000으로 나눈 몫이 0일 때 예외처리한다. ")
    @Test
    void isNotDividedByThousand1(){
        assertThatThrownBy(()->priceInputException.validate("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("1,000으로 나눈 나머지가 0이 아닐 때 예외처리한다. ")
    @Test
    void isNotDividedByThousand2(){
        assertThatThrownBy(()->priceInputException.validate("1900"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외처리가 될게 없다면 Long 타입으로 반환된다. ")
    @Test
    void validateTest(){
        assertThat(priceInputException.validate("2000")).isEqualTo(2000L);
    }
}
