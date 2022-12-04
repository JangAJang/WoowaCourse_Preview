package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class Items {

    private final List<Item> items = new ArrayList<>();

    public Items(List<List<String>> itemsComponent){
        for(List<String> componentEach : itemsComponent){
            items.add(new Item(componentEach));
        }
    }

    public int takeSpecificItem(String name){
        validateItem(name);
        for(Item itemEach : items){
            if(nameMatches(itemEach, name)) return itemEach.getPrice();
        }
        System.out.println("[ERROR]");
        throw new IllegalArgumentException();
    }

    private boolean nameMatches(Item itemEach, String name){
        return itemEach.isRequestedItem(name);
    }

    private void validateItem(String name){
        ItemValidator validator = new ItemValidator();
        return validator.validateBuyingProduct(name, items);
    }

    public int getCheapestItem(){
        return 0;
    }
}
