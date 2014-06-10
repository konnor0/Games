package konnorscomputers;


/**
 * Created by konnor on 6/9/14.
 */
public class Inventory {
    int itemSlotSelected;
    int maxItemSlots;
    int itemIDSelected;
    Inventory(){
        itemSlotSelected = 1;
        maxItemSlots = 3;
    }
    int itemIDSelected(){
        if(itemSlotSelected == 1){
            itemIDSelected = 1 ;
        }
        else if(itemSlotSelected == 2){
            itemIDSelected = 2 ;
        }
        else if(itemSlotSelected == 3){
            itemIDSelected = 3;
        }
        else{
            itemIDSelected = 0;
        }
        return itemIDSelected;
    }
}
