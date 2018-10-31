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
    
    /**
     * Player name.
     */
    private final String name;
    
    /**
     * The player's inventory.
     */
    private final Inventory inventory = new Inventory();
    
    /**
     * The progress of a player
     */
    private int progress = 0;
    
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
        return this.name;
    }
    
    /**
     * @param itemName the name of the item to be retrieved.
     * @return the item with name passed as the argument or null if it does not not exist. 
     */
    public Inventory getInventory(){
        return this.inventory;
    }
    
    /**
     * Increases the progress
     */
    public void increaseProgress()
    {
        this.progress++;
    }
    
    /**
     * Change the progress to i
     * 
     * @param i The new progress
     */
    public void changeProgress(int i)
    {
        this.progress = i;
    }
    
    /**
     * Get the progress of a player
     * 
     * @return The progress
     */
    public int getProgress()
    {
        return this.progress;
    }
}
