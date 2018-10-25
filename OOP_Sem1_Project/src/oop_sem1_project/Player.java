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
    
    public Player(String name) {
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void addItem(Item item){
        inventory.addItem(item);
    }
    
    public void removeItem(String itemName){
        inventory.removeItem(itemName);
    }
    
    public Item getItem(String itemName){
        return inventory.getItem(itemName);
    }
    
    public boolean hasItem(String itemName){
        return inventory.hasItem(itemName);
    }
    
}
