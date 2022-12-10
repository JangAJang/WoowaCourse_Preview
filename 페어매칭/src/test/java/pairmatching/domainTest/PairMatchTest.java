package pairmatching.domainTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.domain.PairMatch;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class PairMatchTest {

    PairMatch pairMatch;

    @BeforeEach
    void initializeClass(){
        pairMatch = new PairMatch(testComponent());
    }

    @DisplayName("페어를 생성하면 모든 리스트를 2개씩 나누고, 마지막은 홀수면 3개로 만들어 List<List<String>>으로 반환한다. ")
    @Test
    void createEachPairTest(){
        assertThat(pairMatch.createEachPair(newList()))
                .isEqualTo(resultList());
    }

    @DisplayName("이전에 같은 성분을 포함하는 리스트가 있으면 참을 반환한다. ")
    @Test
    void hasSamePairBeforeTest(){
        pairMatch.createEachPair(newList());
        List<String> names = componentFirst();
        names.add("hee");
        assertThat(pairMatch.isSame(names)).isTrue();
    }

    private List<String> testComponent(){
        List<String> components = new ArrayList<>();
        components.add("백엔드");
        components.add("레벨1");
        components.add("자동차경주");
        return components;
    }

    private List<String> newList(){
        List<String> names = new ArrayList<>();
        names.add("lee");
        names.add("jang");
        names.add("hee");
        names.add("이");
        names.add("장");
        names.add("희");
        names.add("이장희");
        return names;
    }

    private List<List<String>> resultList(){
        List<List<String>> result = new ArrayList<>();
        result.add(componentFirst());
        result.add(componentSecond());
        result.add(componentThird());
        return result;
    }

    private List<String> componentFirst(){
        List<String> names = new ArrayList<>();
        names.add("lee");
        names.add("jang");
        return names;
    }

    private List<String> componentSecond(){
        List<String> names = new ArrayList<>();
        names.add("hee");
        names.add("이");
        return names;
    }

    private List<String> componentThird(){
        List<String> names = new ArrayList<>();
        names.add("이장희");
        names.add("장");
        names.add("희");
        return names;
    }
}
