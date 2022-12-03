package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Cars cars;

    public RacingCarController(){
        cars = new Cars(inputView.readNames());
    }

    private int readCarsMovingTime(){
        return inputView.readTrials();
    }

    private void startMakingResult(){
        outputView.printStartOfResult();
    }

    private void moveCars(int count){
        while(count-- > 0){
            cars.moveCars();
            outputView.printCarsPositions(cars.getCarsResult());
        }
    }

    private void showFinalWinners(){
        outputView.printFinalWinners(cars.getFinalWinners());
    }
}
