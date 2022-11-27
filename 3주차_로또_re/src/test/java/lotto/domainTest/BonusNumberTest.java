package lotto.domainTest;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class BonusNumberTest {

    @DisplayName("보너스 넘버를 문자열로 넘길 때 BonusNumberException으로 예외처리될 수 있다. ")
    @Test
    void constructorTest_FAIL(){
        assertThatThrownBy(()-> new BonusNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), "6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("저장 후 입력 리스트에 보너스 넘버가 있으면 참을 반환한다. ")
    @Test
    void isHavingBonusNumberTest(){
        BonusNumber bonusNumber = new BonusNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), "7");
        assertThat(bonusNumber.isHavingBonusNumber(List.of(1, 3, 5, 7, 9, 2, 4)))
                .isTrue();
    }
}
