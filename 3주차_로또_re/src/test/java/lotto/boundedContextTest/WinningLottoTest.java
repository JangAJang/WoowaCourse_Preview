package lotto.boundedContextTest;

import lotto.boundedContext.WinningLotto;
import lotto.domain.Lotto;
import lotto.enums.GameResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class WinningLottoTest {

    WinningLotto winningLotto;

    @BeforeEach
    void initializeClass(){
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        winningLotto = new WinningLotto(lotto, "7");
    }

    @DisplayName("입력으로 로또를 넣으면 결과롤 GameResult가 나온다. ")
    @Test
    void makeResultOfLottoTest(){
        assertThat(winningLotto.makeResultOfLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isEqualTo(GameResult.SIX);
    }
}
