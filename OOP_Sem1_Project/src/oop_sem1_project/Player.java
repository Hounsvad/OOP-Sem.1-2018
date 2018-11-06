/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project;

import Items.Inventory;
import Items.Item;

/**
 *
 * @author Oliver
 */
public class Player {
    
    /**
     * Player name.
     */
    private final String name;
    
    /**
     * The player's inventory.
     */
    private final Inventory inventory = new Inventory();
    
    /**
     * Constructs a new Player Object. 
     *
     * @param name of the player.
     */
    public Player(String name) {
        this.name = name;
    }
    
    /**
     * @return the name of the player.
     */
    public String getName(){
        return name;
    }
    
    /**
     * Adds an {@link Item item}.
     *
     * @param item to be added.
     */
    public void addItem(Item item){
        this.inventory.addItem(item);
    }
    
    /**
     * Removes an {@link Item item}.
     *
     * @param itemName is the name of the Item.
     */
    public void removeItem(String itemName){
        this.inventory.removeItem(itemName);
    }
    
    /**
     * @param itemName the name of the item to be retrieved.
     * @return the item with name passed as the argument or null if it does not not exist. 
     */
    public Item getItem(String itemName){
        return this.inventory.getItem(itemName);
    }
    
    /**
     * Checks if the item with the given name exist in the {@link Inventory inventory}.
     *
     * @param itemName the item name being checked for.
     * @return whether it has that item.
     */
    public boolean hasItem(String itemName){
        return this.inventory.hasItem(itemName);
    }
    
}
