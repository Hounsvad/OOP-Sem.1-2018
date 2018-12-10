/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.domain;

/**
 *
 * @author Pinnacle F
 */
public class InteractableArea {

    private final int[] size;
    private final int range;
    private final String rangeType;
    private final int[] position;
    private final String requiredItemName;
    
    /**
     * 
     * @param position the position of the area
     * @param size the size of the area
     * @param range the range the area is detectable in
     * @param rangeType the type of range
     * @param requiredItemName the item that is required for that area
     */
    public InteractableArea(int[] position, int[] size, int range, String rangeType, String requiredItemName) {
        this.position = position;
        this.size = size;
        this.range = range;
        this.rangeType = rangeType;
        this.requiredItemName = requiredItemName;
    }
    
    /**
     * 
     * @param playerPosition the position of the player
     * @return true if the player is within the range of the area
     */
    public boolean isWithinRange(int[] playerPosition) {
        return (playerPosition[0] > this.position[0] - this.range && playerPosition[0] < this.position[0] + this.size[0] + this.range //within x-limit
                && playerPosition[1] > this.position[1] - this.range && playerPosition[1] < this.position[1] + this.size[1] + this.range);  //within y-limit
    }
    
    /**
     * 
     * @param playerPosition the position of the player
     * @return true if the player is at the boundary of an area
     */
    public boolean isAtboundary(int[] playerPosition) {
        return playerPosition[0] >= this.position[0] && playerPosition[0] < this.position[0] + this.size[0] //within x-limit
                && playerPosition[1] >= this.position[1] && playerPosition[1] < this.position[1] + this.size[1];  //within y-limit
    }

    /**
     * 
     * @return the type of the range 
     */
    public String getRangeType() {
        return rangeType;
    }
    
    /**
     * 
     * @param item the item that the area requires
     * @return true if the item being used is the item the area requires
     */
    public boolean isRequiredItem(Item item) {
        return item != null && item.getName().equalsIgnoreCase(requiredItemName);
    }
}
