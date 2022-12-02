package bridge.domain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
public class GameResultTest {

    GameResult gameResult;

    @BeforeEach
    void initializeClass(){
        gameResult = new GameResult();
    }

    @DisplayName("리셋을 하면 게임 시도횟수가 1 증가한다. ")
    @Test
    void resetGameTest(){
        int formerCount = gameResult.getTrialCount();
        gameResult.resetGame();
        assertThat(gameResult.getTrialCount())
                .isEqualTo(formerCount+1);
    }

    @DisplayName("초기화된 상태에서 gameStatus는 GOING이다. ")
    @Test
    void isQuitTest1(){
        assertThat(gameResult.isQuit()).isFalse();
    }

    @DisplayName("failGame해주면 isQuit이 참을 반환한다. ")
    @Test
    void isQuitTest2(){
        gameResult.failGame();
        assertThat(gameResult.isQuit()).isTrue();
    }
}
