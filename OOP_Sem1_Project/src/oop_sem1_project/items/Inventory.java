/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.items;

/**
 *
 * @author Hounsvad
 */
public class Inventory {
    
    /**
     * The inventory
     */
    private Item item;

    /**
     * Creates an inventory based on a {@link java.util.List List} of {@link Item Item}
     * @param item the item to be added 
     */
    public Inventory(Item item) {
        this.item = item;
    }
    
    /**
     * Creates an empty inventory
     */
    public Inventory(){
        this.item = null;
    }
    
    /**
     * Returns an item based on the item name
     *
     * @return requested item or null
     */
    public Item getItem(){
        return item;
    }
    
    /**
     * Attempts to add an item to the inventory
     *
     * @param item to be added
     */
    public void addItem(Item item){
        this.item = item == null ? this.item : item;
    }
    
    /**
     * Check to see of the inventory contains a specified item
     *
     * @param itemName to be checked for as string
     * @return true upon success
     */
    public boolean hasItem(String itemName){
        return this.item != null && this.item.getItemName().equalsIgnoreCase(itemName);
    }
    
    /**
     * Removes the item from the inventory
     */
    public void removeItem(){
        this.item = null;
    }
}
