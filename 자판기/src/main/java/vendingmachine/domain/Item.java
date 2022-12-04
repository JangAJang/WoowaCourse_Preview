package vendingmachine.domain;

import java.util.List;

import static vendingmachine.ItemIndexing.*;

public class Item {

    int price;
    int quantity;
    String name;

    public Item(List<String> components) {
        this.name = components.get(NAME.getIndex());
        this.quantity = Integer.parseInt(components.get(QUANTITY.getIndex()));
        this.price = Integer.parseInt(components.get(PRICE.getIndex()));
    }

    public void decreaseQuantity(){

    }

    public int getPrice(){
        return this.price;
    }

    public boolean isRequestedItem(String name){
        return false;
    }

    public boolean isSoldOut(){
        return false;
    }
}
