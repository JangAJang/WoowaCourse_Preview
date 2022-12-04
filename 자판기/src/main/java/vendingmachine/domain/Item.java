package vendingmachine.domain;

import java.util.List;

public class Item {

    int price;
    int quantity;
    String name;

    public Item(List<String> components) {
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
