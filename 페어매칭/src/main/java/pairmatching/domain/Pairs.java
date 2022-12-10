package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Pairs {

    List<Pair> pairs = new ArrayList<>();

    public Pairs(List<String> names){

    }

    public List<Pair> getPairs() {
        return pairs;
    }

    public boolean isDuplicatedPairs(Pairs other){
        return false;
    }
}
