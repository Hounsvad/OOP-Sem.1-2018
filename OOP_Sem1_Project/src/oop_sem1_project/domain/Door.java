/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.domain;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class Door extends InteractableArea {

    private final Room destination;
    private final boolean vertical;
    private final String name;
    
    /**
     * 
     * @param name the name of the door
     * @param position the postion of the door
     * @param size the size of the door
     * @param range the range of the door
     * @param rangeType the type of range
     * @param requiredItemName the item the door requires
     * @param destination the destination the door leads to 
     * @param vertical true if the door is located on a vertical wall
     */
    public Door(String name, int[] position, int[] size, int range, String rangeType, String requiredItemName, Room destination, boolean vertical) {
        super(position, size, range, rangeType, requiredItemName);
        this.name = name;
        this.destination = destination;
        this.vertical = vertical;
    }
    
    /**
     * 
     * @return the destination  
     */
    public Room getDestination() {
        return this.destination;
    }
    
    /**
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * 
     * @param player the player
     * @return the postion the player is going to be after entering the door
     */
    public int[] recalculatePlayerPosition(Player player) {
        int[] location = player.getPosition();
        if (vertical) {
            location[1] = location[1] < 250 ? 400 : 50;
        } else {
            location[0] = location[0] < 450 ? 800 : 50;
        }
        return location;
    }
}
