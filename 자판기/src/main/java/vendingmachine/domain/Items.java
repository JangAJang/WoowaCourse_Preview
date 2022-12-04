package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Items {

    private final List<Item> items = new ArrayList<>();

    public Items(List<List<String>> itemsComponent){
        for(List<String> componentEach : itemsComponent){
            items.add(new Item(componentEach));
        }
    }

    public int takeSpecificItem(String name){
        for(Item itemEach : items){
            if(itemEach.isRequestedItem(name)){
                itemEach.decreaseQuantity();
                return itemEach.getPrice();
            }
        }
        noNameException();
        return 0;
    }

    private void noNameException(){
        System.out.println("[ERROR] 해당 품목이 존재하지 않습니다");
        throw new IllegalArgumentException();
    }

    public int getCheapestItem(){
        return items.stream().mapToInt(Item::getPrice).min().orElse(0);
    }

    public boolean isAllSoldOut(){
        for(Item itemEach: items){
            if(!itemEach.isSoldOut())return false;
        }
        return true;
    }
}
