/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project;

import java.util.ArrayList;

/**
 *
 * @author Hounsvad
 */
public class Inventory {
    
    /**
     * Database to store inventory
     */
    private ArrayList<Item> items = new ArrayList<>();
    
    /**
     * Returns an item based on the item name
     * 
     * Throws IllegalArgumentException if the item is not found
     * @param itemName as string to be retrieved
     * @return requested item
     */
    public Item getItem(String itemName){
        for(Item item: items){
            if(item.getItemName().equals(itemName)){
                return item;
            }
        }
        throw new IllegalArgumentException("The item was not found in the list");
    }
    
    /**
     * Attempts to add an item to the inventory
     * @param item to be added
     * @return true upon success
     */
    public boolean addItem(Item item){
        if(!items.contains(item)){
            return items.add(item);
        }
        return false;
    }
    
    /**
     * Check to see of the inventory contains a specified item
     * @param itemName to be checked for as string
     * @return true upon success
     */
    public boolean hasItem(String itemName){
        if(items.contains(new Item(itemName, ""))){
            return true;
        }
        return false;
    }
    
    /**
     * Removes an item based on the item name
     * @param itemName to be removed
     * @return true upon success
     */
    public boolean removeItem(String itemName){
        return items.remove(getItem(itemName));
    }
    
}
