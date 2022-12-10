package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Pairs {

    List<Pair> pairs = new ArrayList<>();

    public Pairs(List<String> names){
        for(int index = 0; index < names.size()/2-1; index+=2){
            pairs.add(new Pair(names.subList(index, index+2)));
        }
        pairs.add(new Pair(names.subList((names.size()/2-1)*2, names.size())));
    }

    public List<Pair> getPairs() {
        return pairs;
    }

    public boolean isDuplicatedPairs(Pairs other){
        return false;
    }
}
