package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class PairMatchData {

    List<PairMatch> pairMatches;

    public List<List<String>> createPairMatch(List<String> components){
        return new ArrayList<>();
    }

    public boolean containsExistingDataAlready(List<String> components){
        return false;
    }

    public List<List<String>> readPairMatch(List<String> components){
        return new ArrayList<>();
    }

    public void resetData(){

    }

    public List<List<String>> recreatePairMatch(List<String> components){
        return new ArrayList<>();
    }
}
