package baseball.domainTest;

import baseball.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    @Test
    @DisplayName("플레이어를 생성할 때 입력 문자열을 정수형 리스트로 전환해 저장한다. ")
    void constructorTest(){
        Player player = new Player("123");
        assertThat(player.getNumbers()).isEqualTo(List.of(1, 2, 3));
    }
}
