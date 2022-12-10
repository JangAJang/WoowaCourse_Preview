package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class PairMatchData {

    private static final String THREE_DUP_SAME_PAIR = "[ERROR] 페어 매칭을 3회 시도해도 같은 페어가 존재해 정지합니다.";
    private static final int MAXIMUM_TRIAL_COUNT = 3;
    private static final String NOT_EXISTING_DATA = "[ERROR] 해당 페어매칭에 대한 데이터가 존재하지 않습니다.";

    private final List<PairMatch> pairMatches = new ArrayList<>();

    public List<List<String>> createPairMatch(List<String> components){
        PairMatch pairMatch = new PairMatch(components);
        pairMatch = tryMakingPairMatch(pairMatch, 0);
        pairMatches.add(pairMatch);
        return pairMatch.getPairsMembers();
    }

    private void groupMembers(PairMatch pairMatch){
        pairMatch.createEachPair();
    }

    private PairMatch tryMakingPairMatch(PairMatch pairMatch, int count){
        if(MAXIMUM_TRIAL_COUNT == 3) threeDuplicatedException();
        groupMembers(pairMatch);
        if(containsSamePairBefore(pairMatch)) return tryMakingPairMatch(pairMatch, count+1);
        return pairMatch;
    }

    private boolean containsSamePairBefore(PairMatch pairMatch){
        for(PairMatch pairMatchEach : pairMatches){
            if(pairMatchEach.hasSamePairBefore(pairMatch)) return true;
        }
        return false;
    }

    private void threeDuplicatedException(){
        System.out.println(THREE_DUP_SAME_PAIR);
        throw new IllegalArgumentException();
    }

    public boolean containsExistingDataAlready(List<String> components){
        for(PairMatch pairMatchEach : pairMatches){
            if(pairMatchEach.isSame(components)) return true;
        }
        return false;
    }

    public List<List<String>> readPairMatch(List<String> components){
        for(PairMatch pairMatchEach : pairMatches){
            if(pairMatchEach.isSame(components)) return pairMatchEach.getPairsMembers();
        }
        System.out.println(NOT_EXISTING_DATA);
        throw new IllegalArgumentException();
    }

    public void resetData(){

    }

    public List<List<String>> recreatePairMatch(List<String> components){
        return new ArrayList<>();
    }
}
