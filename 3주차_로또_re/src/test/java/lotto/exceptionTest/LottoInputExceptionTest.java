package lotto.exceptionTest;
import lotto.exception.LottoInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class LottoInputExceptionTest {

    LottoInputException lottoInputException = new LottoInputException();

    @DisplayName("")
    @Test
    void isNotNumberTest(){
        assertThatThrownBy(()-> lottoInputException.validate("a, b, cv, d, e, f"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("")
    @Test
    void validateTest(){
        assertThat(lottoInputException.validate("1,2,3,4,5,6"))
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}
