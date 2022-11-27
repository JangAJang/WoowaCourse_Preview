package lotto.exceptionTest;
import lotto.domain.Lotto;
import lotto.exception.BonusNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class BonusNumberExceptionTest {

    BonusNumberException bonusNumberException = new BonusNumberException();
    Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @DisplayName("숫자가 아니면 예외처리")
    @Test
    void isNotNumberTest(){
        assertThatThrownBy(()-> bonusNumberException.validate("1000j", lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또에 이미 있는 숫자면 예외처리")
    @Test
    void isAlreadyInLottoTest(){
        assertThatThrownBy(()-> bonusNumberException.validate("6", lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1부터 45가 아니면 예외처리")
    @Test
    void isOutOfRangeTest(){
        assertThatThrownBy(()-> bonusNumberException.validate("50", lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외문제 없을 시 정수형으로 반환")
    @Test
    void validateTest(){
        assertThat(bonusNumberException.validate("7", lotto))
                .isEqualTo(7);
    }
}
