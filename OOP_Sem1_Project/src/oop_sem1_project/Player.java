/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project;

/**
 *
 * @author Oliver
 */
public class Player {
    
    private String name;
    private final Inventory inventory = new Inventory();
    
    /**
     *
     * @param name
     */
    public Player(String name) {
        this.name = name;
    }
    
    /**
     *
     * @return The name of the player
     */
    public String getName(){
        return name;
    }
    
    /**
     *
     * @param item
     * Adds said item
     */
    public void addItem(Item item){
        inventory.addItem(item);
    }
    
    /**
     *
     * @param itemName
     * Removes said item
     */
    public void removeItem(String itemName){
        inventory.removeItem(itemName);
    }
    
    /**
     *
     * @param itemName
     * @return Item with that name
     */
    public Item getItem(String itemName){
        return inventory.getItem(itemName);
    }
    
    /**
     *
     * @param itemName
     * @return Whether it has that item as a boolean
     */
    public boolean hasItem(String itemName){
        return inventory.hasItem(itemName);
    }
    
}
