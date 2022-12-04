package vendingmachine.controller;

import vendingmachine.domainModel.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final VendingMachine vendingMachine;

    public VendingMachineController(){
        vendingMachine = new VendingMachine(inputView.readPrice());
    }

    private void printAvailableCoins(){
        outputView.printCoins(vendingMachine.showAllCoins());
    }
}
