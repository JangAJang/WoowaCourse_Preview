package pairmatching.controller;

import pairmatching.domain.PairMatchData;
import pairmatching.enums.OperationCommand;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.List;

import static pairmatching.enums.OperationCommand.*;

public class PairMatchController {

    private final PairMatchData pairMatchData = new PairMatchData();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void runPairMatching(){
        OperationCommand command;
        command = getCommand();
        while(!command.equals(QUIT)){
            runEachRound(command);
            command = getCommand();
        }
    }

    private OperationCommand getCommand(){
        try{
            return inputView.readOperation();
        }catch (IllegalArgumentException e){
            return getCommand();
        }
    }

    private void runEachRound(OperationCommand command){
        if(isPairMatching(command)) matchPair();
        if(isReadPair(command)) readPair();
        if(isResetPairs(command)) resetPair();
    }

    private boolean isPairMatching(OperationCommand command){
        return command.equals(MATCH_PAIR);
    }

    private void matchPair(){
        try{
            List<String> component = readPairMatchingMission();
            if(isAlreadyExistingMission(component)){
                rematchPair(component);
                return;
            }
            printResult(createPairs(component));
        }catch (IllegalArgumentException e){
            matchPair();
        }
    }

    private void rematchPair(List<String> component){
        if(isRequiringRematch()) printResult(recreatePairs(component));
    }

    private List<String> readPairMatchingMission(){
        try{
            return inputView.readMissionChoice();
        }catch (IllegalArgumentException e){
            return readPairMatchingMission();
        }
    }

    private boolean isAlreadyExistingMission(List<String> component){
        return pairMatchData.containsExistingDataAlready(component);
    }

    private boolean isRequiringRematch(){
        try{
            return inputView.readRematch();
        }catch (IllegalArgumentException e){
            return isRequiringRematch();
        }
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
        try{
            outputView.printMatchingResult(
                    pairMatchData.readPairMatch(
                            inputView.readMissionChoice()));
        }catch (IllegalArgumentException e){
            readPair();
        }
    }

    private boolean isResetPairs(OperationCommand operationCommand){
        return operationCommand.equals(CLEAR);
    }

    private void resetPair(){
        pairMatchData.resetData();
        outputView.printResetSuccess();
    }
}
