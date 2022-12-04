package vendingmachine.domainTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.domain.Coins;

import static org.assertj.core.api.Assertions.*;
import static vendingmachine.Coin.*;

public class CoinsTest {

    Coins coins;

    @DisplayName("생성자로 클래스 생성시 해시맵의 키에는 Coin클래스의 모든 속성이 들어있다. ")
    @Test
    void showAvaiableCoinsTest(){
        coins = new Coins(500);
        assertThat(coins.showAvailableCoins().keySet())
                .contains(COIN_500, COIN_100, COIN_50, COIN_10);
    }

    @DisplayName("잔돈의 금액이 전체 금액보다 크면 가능한 금액을 value가 0인 키를 제외하고 해시맵으로 반환한다. ")
    @Test
    void giveAllExchangeTest(){
        coins = new Coins(70);
        assertThat(coins.giveExchange(80).keySet())
                .contains(COIN_50, COIN_10);
    }

    @DisplayName("잔돈의 금액이 전체 금액보다 작으면 잔돈만큼을 value가 0인 키를 제외하고 해시맵으로 반환한다. ")
    @Test
    void giveSomeExchangeTest(){
        coins = new Coins(90);
        assertThat(coins.giveExchange(80).keySet())
                .contains(COIN_50, COIN_10);
    }
}
