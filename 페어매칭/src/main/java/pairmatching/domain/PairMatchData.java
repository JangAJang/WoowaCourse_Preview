package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class PairMatchData {

    private final List<PairMatch> pairMatches = new ArrayList<>();

    public List<List<String>> createPairMatch(List<String> components){
        PairMatch pairMatch = new PairMatch(components);
        groupMembers(pairMatch);
    }

    private void groupMembers(PairMatch pairMatch){
        pairMatch.createEachPair();
    }

    private boolean containsSamePairBefore(PairMatch pairMatch){
        for(PairMatch pairMatchEach : pairMatches){
            if(pairMatchEach.hasSamePairBefore(pairMatch)) return true;
        }
        return false;
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
