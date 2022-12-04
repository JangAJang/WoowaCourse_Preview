package vendingmachine.domainTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.domain.InsertedMoney;

import static org.assertj.core.api.Assertions.*;
public class InsertedMoneyTest {

    InsertedMoney insertedMoney;

    @BeforeEach
    void initializeClass(){
        insertedMoney = new InsertedMoney(5000);
    }

    @DisplayName("decreaseMoney하면 그 금액을 뺀 나머지만 getLeft된다. ")
    @Test
    void decreaseMoneyTest(){
        insertedMoney.decreaseMoney(1000);
        assertThat(insertedMoney.getLeftMoney()).isEqualTo(4000);
    }

    @DisplayName("isLessThanItems에 금액을 넣었을 때, 그 금액이 남은 금액보다 크면 참을 반환한다.")
    @Test
    void isLessThanItemsTestWithBiggerCheapest(){
        assertThat(insertedMoney.isLessThanItems(8000))
                .isTrue();
    }

    @DisplayName("isLessThanItems에 금액을 넣었을 때, 그 금액이 남은 금액보다 작으면 거짓을 반환한다.")
    @Test
    void isLessThanItemsTestWithSmallerCheapest(){
        assertThat(insertedMoney.isLessThanItems(4000))
                .isFalse();
    }
}
