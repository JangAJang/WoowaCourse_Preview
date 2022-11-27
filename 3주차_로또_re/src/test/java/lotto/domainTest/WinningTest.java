package lotto.domainTest;
import lotto.domain.Winning;
import lotto.enums.GameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.*;
public class WinningTest {

    @DisplayName("수익을 구할 땐 소수점 첫째자리까지 구한다. ")
    @Test
    void calculateProfitTest(){
        Winning winning = new Winning(makeMap());
        assertThat(winning.calculateProfit())
                .isEqualTo("50.0");
    }

    private HashMap<GameResult, Integer> makeMap(){
        HashMap<GameResult, Integer> temporaryMap = new HashMap<>();
        temporaryMap.put(GameResult.THREE, 1);
        temporaryMap.put(GameResult.NOTHING, 9);
        return temporaryMap;
    }
}
