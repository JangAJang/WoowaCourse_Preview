package lotto.exceptionTest;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoExceptionTest {

    LottoException lottoException = new LottoException();

    @DisplayName("리스트의 원소중 1부터 45가 아닌 원소가 있으면 예외처리")
    @Test
    void isNumberOutOfRangeTest(){
        assertThatThrownBy(()->lottoException.validate(List.of(1, 2, 3, 4, 5, 5, 45)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("리스트의 길이가 6이 아니면 예외처리")
    @Test
    void isNotSixNumbersTest(){
        assertThatThrownBy(()->lottoException.validate(List.of(1, 2, 3, 4, 5, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("리스트의 원소중 같은 게 있으면 예외처리")
    @Test
    void containsSameNumberTest(){
        assertThatThrownBy(()->lottoException.validate(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("서로 다른 6개의 수가 1부터 45사이면 리스트 그대로 반환한다. ")
    @Test
    void validateTest(){
        assertThat(lottoException.validate(List.of(1, 2, 3, 4, 5, 6)))
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

}
