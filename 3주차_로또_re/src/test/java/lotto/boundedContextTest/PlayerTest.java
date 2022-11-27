package lotto.boundedContextTest;
import lotto.boundedContext.Player;
import lotto.boundedContext.WinningLotto;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static lotto.enums.GameResult.*;
import static org.assertj.core.api.Assertions.*;
public class PlayerTest {

    Player player = new Player(3);

    @DisplayName("생성이 3개 일 때 로또는 3개이다. ")
    @Test
    void getPlayersLottoNumbersTest(){
        assertThat(player.getPlayerLottoNumbers().size()).isEqualTo(3);
    }

    @DisplayName("생성된 로또는 한개당 6개의 숫자가 있다")
    @Test
    void getPlayersLottoNumbersTest2(){
        for(List<Integer> numbersEach : player.getPlayerLottoNumbers()) {
            assertThat(numbersEach.size() == 6).isTrue();
        }
    }

    @DisplayName("해시맵으로 결과가 나올 때 key는 모든 GameResult이다. ")
    @Test
    void matchResultByWinningLottoTest(){
        Lotto lottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(lottoNumbers, "7");
        assertThat(player.makeResultByWinningLotto(winningLotto).keySet())
                .isEqualTo(Set.of(NOTHING, THREE, FOUR, FIVE, FIVE_WITH_BONUS, SIX));
    }
}
