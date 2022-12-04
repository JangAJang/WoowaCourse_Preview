package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class Items {

    List<Item> items = new ArrayList<>();

    public Items(List<List<String>> itemsComponent){
        for(List<String> componentEach : itemsComponent){
            items.add(new Item(componentEach));
        }
    }

    public int takeSpecificItem(String name){
        return 0;
    }

    public int getCheapestItem(){
        return 0;
    }
}
