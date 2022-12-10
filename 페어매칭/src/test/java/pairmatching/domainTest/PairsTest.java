package pairmatching.domainTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.domain.Pairs;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class PairsTest {

    Pairs pairs;

    @BeforeEach
    void initializeClass(){
        pairs = new Pairs(makeNames());
    }

    @DisplayName("생성하면 총 Pairs 인스턴스의 사이즈는 2이다. ")
    @Test
    void constructorSizeTest(){
        assertThat(pairs.getPairs().size()).isEqualTo(2);
    }

    @DisplayName("마지막 리스트는 3일 수 있지만나머지는 전부 2이다. ")
    @Test
    void pairSizeTest(){
        boolean isNotTwoOrThree = false;
        for(int index = 0; index < pairs.getPairs().size()-1; index++){
            if (pairs.getPairs().get(index).getNames().size() != 2) {
                isNotTwoOrThree = true;
                break;
            }
        }
        if(pairs.getPairs().get(pairs.getPairs().size()-1).getNames().size() != 2 &&
                pairs.getPairs().get(pairs.getPairs().size()-1).getNames().size() != 3
        ) isNotTwoOrThree = true;
        assertThat(isNotTwoOrThree).isFalse();
    }

    @DisplayName("동일한 페어가 있는지 비교하고 하나라도 있으면 참을 반환한다. ")
    @Test
    void isDuplicatedPairTest(){
        assertThat(pairs.isDuplicatedPairs(makeComparator()))
                .isTrue();
    }

    private Pairs makeComparator(){
        List<String> names = new ArrayList<>();
        names.add("lee");
        names.add("jang");
        names.add("hee");
        return new Pairs(names);
    }

    private List<String> makeNames(){
        List<String> names = new ArrayList<>();
        names.add("lee");
        names.add("jang");
        names.add("hee");
        names.add("janghee");
        names.add("kim");
        return names;
    }
}
