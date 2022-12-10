package pairmatching.controller;

import pairmatching.domain.PairMatchData;
import pairmatching.enums.OperationCommand;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.List;

import static pairmatching.enums.OperationCommand.MATCH_PAIR;
import static pairmatching.enums.OperationCommand.READ_PAIR;

public class PairMatchController {

    private final PairMatchData pairMatchData = new PairMatchData();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private boolean isPairMatching(OperationCommand command){
        return command.equals(MATCH_PAIR);
    }

    private void matchPair(){
        List<String> component = readPairMatchingMission();
        if(isAlreadyExistingMission(component)){
            rematchPair(component);
            return;
        }
        printResult(createPairs(component));
    }

    private void rematchPair(List<String> component){
        if(isRequiringRematch()) printResult(recreatePairs(component));
    }

    private List<String> readPairMatchingMission(){
        return inputView.readMissionChoice();
    }

    private boolean isAlreadyExistingMission(List<String> component){
        return pairMatchData.containsExistingDataAlready(component);
    }

    private boolean isRequiringRematch(){
        return inputView.readRematch();
    }

    private List<List<String>> createPairs(List<String> component){
        return pairMatchData.createPairMatch(component);
    }

    private void printResult(List<List<String>> members){
        outputView.printMatchingResult(members);
    }

    private List<List<String>> recreatePairs(List<String> component){
        return pairMatchData.recreatePairMatch(component);
    }

    private boolean isReadPair(OperationCommand operationCommand){
        return operationCommand.equals(READ_PAIR);
    }

    private void readPair(){
        outputView.printMatchingResult(
                pairMatchData.readPairMatch(
                        inputView.readMissionChoice()));
    }
}
