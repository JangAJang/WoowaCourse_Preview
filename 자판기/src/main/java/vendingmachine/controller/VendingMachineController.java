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

    private void createItems(){
        vendingMachine.makeItems(inputView.readItems());
    }

    private void insertMoney(){
        vendingMachine.insertMoney(inputView.readInsertMoney());
    }

    private boolean isAvailableToBuy(){
        return !vendingMachine.isUnableToBuyMore();
    }

    private void buyProduct(){
        printLeftMoney();
        pickProduct();
    }

    private void printLeftMoney(){
        outputView.printLeftMoney(vendingMachine.getLeftInsertedMoney());
    }

    private void pickProduct(){
        vendingMachine.takeProduct(inputView.readBuying());
    }

    private void printExchange(){
        printLeftMoney();
        printLeftCoins();
    }

    private void printLeftCoins(){
        outputView.printLeftOver();
        outputView.printCoins(vendingMachine.showExchange());
    }
}
