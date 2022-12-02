package bridge.domain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
public class PlayerTest {

    Player player ;

    @BeforeEach
    void initializeClass(){
        player = new Player();
    }

    @DisplayName("답을 추가하면 리스트 반환시 추가되어있다. ")
    @Test
    void addPlayerAnswerTest(){
        player.clearAnswers();
        player.addPlayerAnswer(false);
        assertThat(player.getPlayerAnswers().size()).isEqualTo(1);
    }

    @DisplayName("답에 false를 추가하고 isFailedGame을 하면 참이 반환된다. ")
    @Test
    void isFailedGameTest1(){
        player.clearAnswers();
        player.addPlayerAnswer(false);
        assertThat(player.isFailedGame()).isTrue();
    }

    @DisplayName("답에 true를 추가하고 isFailedGame을 하면 거짓이 반환된다. ")
    @Test
    void isFailedGameTest2(){
        player.clearAnswers();
        player.addPlayerAnswer(true);
        assertThat(player.isFailedGame()).isFalse();
    }

    @DisplayName("답에 true를 추가하고 추가한 개수만큼 개수를 입력하면 게임이 끝났다고 인식된다.")
    @Test
    void isFinishedTest(){
        player.clearAnswers();
        player.addPlayerAnswer(true);
        player.addPlayerAnswer(true);
        player.addPlayerAnswer(true);
        assertThat(player.isFinished(3)).isTrue();
    }

    @DisplayName("플레이어리스트와 입력 길이가 다르면 거짓을 반환한다. ")
    @Test
    void isFinishedFailingTest1(){
        player.clearAnswers();
        player.addPlayerAnswer(true);
        player.addPlayerAnswer(true);
        player.addPlayerAnswer(true);
        assertThat(player.isFinished(10)).isFalse();
    }

    @DisplayName("false가 있으면 게임은 끝나지 않았다고 인식된다.  ")
    @Test
    void isFinishedFailingTest2(){
        player.clearAnswers();
        player.addPlayerAnswer(true);
        player.addPlayerAnswer(true);
        player.addPlayerAnswer(false);
        assertThat(player.isFinished(3)).isFalse();
    }
}
