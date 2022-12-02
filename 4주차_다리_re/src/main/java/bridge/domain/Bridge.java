package bridge.domain;

import java.util.List;

public class Bridge {

    private List<String> bridges;

    public Bridge(List<String> bridges){
        this.bridges = bridges;
    }

    public int getBridgesLength(){
        return bridges.size();
    }

    public List<String> getBridges(){
        return bridges;
    }

    public boolean isCorrectAnswer(int index, String answer){
        return bridges.get(index).equals(answer);
    }
}
