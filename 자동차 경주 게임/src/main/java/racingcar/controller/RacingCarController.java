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
}
