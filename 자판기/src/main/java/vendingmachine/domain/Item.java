package vendingmachine.domain;

import java.util.List;

import static vendingmachine.ItemIndexing.*;

public class Item {

    private static final int EMPTY = 0;

    private int price;
    private int quantity;
    private String name;

    public Item(List<String> components) {
        this.name = components.get(NAME.getIndex());
        this.quantity = Integer.parseInt(components.get(QUANTITY.getIndex()));
        this.price = Integer.parseInt(components.get(PRICE.getIndex()));
    }

    public void decreaseQuantity(){
        quantity--;
    }

    public int getPrice(){
        return this.price;
    }

    public boolean isRequestedItem(String name){
        return this.name.equals(name);
    }

    public boolean isSoldOut(){
        return quantity == EMPTY;
    }
}
