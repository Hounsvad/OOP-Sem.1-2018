/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hounsvad
 */
public class Inventory {
    
    /**
     * Database to store inventory
     */
    private List<Item> items = new ArrayList<>();
    
    /**
     * Returns an item based on the item name
     *
     * @param itemName as string to be retrieved
     * @return requested item or null
     */
    public Item getItem(String itemName){
        for(Item item : this.items){
            if(item.getItemName().equalsIgnoreCase(itemName)){
                return item;
            }
        }
        return null;
    }
    
    /**
     * Attempts to add an item to the inventory
     *
     * @param item to be added
     * @return true upon success
     */
    public boolean addItem(Item item){
        if(!this.items.contains(item)){
            return this.items.add(item);
        }
        return false;
    }
    
    /**
     * Check to see of the inventory contains a specified item
     *
     * @param itemName to be checked for as string
     * @return true upon success
     */
    public boolean hasItem(String itemName){
        return getItem(itemName) != null;
    }
    
    /**
     * Removes an item based on the item name
     *
     * @param itemName to be removed
     * @return true upon success
     */
    public boolean removeItem(String itemName){
        return this.items.remove(getItem(itemName));
    }
    
}
