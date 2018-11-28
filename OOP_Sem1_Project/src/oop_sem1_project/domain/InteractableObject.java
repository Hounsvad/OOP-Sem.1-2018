/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.domain;

import oop_sem1_project.domain.DisplayableUnit;

/**
 *
 * @author Pinnacle F
 */
public abstract class InteractableObject extends DisplayableUnit {

    private final int[] size;
    private final int range;
    private final String rangeType;
    private String requiredItemName;

    public InteractableObject(String name, String image, String description, int[] position, int[] size, int range, String rangeType, String requiredItemName) {
        super(name, position, image, description);
        this.size = size;
        this.range = range;
        this.rangeType = rangeType;
        this.requiredItemName = requiredItemName;
    }

    /**
     * Checks to see if the coordinates are within the clickable area
     *
     *
     * @param x as an int to signify the x coordinate of the clicked point
     * @param y as an int to signify the y coordinate of the clicked point
     * @return true if the input is within the clickable area
     */
    public abstract void onClick();

    public boolean isWithinRange(int[] playerPosition) {
        return (playerPosition[0] > this.getPosition()[0] - this.range && playerPosition[0] < this.getPosition()[0] + this.size[0] + this.range    //within x-limit
                && 
                playerPosition[1] > this.getPosition()[1] - this.range && playerPosition[1] < this.getPosition()[1] + this.size[1] + this.range);  //within y-limit
    }

    public boolean isAtboundary(int[] playerPosition) {
        return (playerPosition[0] > this.getPosition()[0] && playerPosition[0] < this.getPosition()[0] + this.size[0]    //within x-limit
                &&
                playerPosition[1] > this.getPosition()[1] && playerPosition[1] < this.getPosition()[1] + this.size[1]);  //within y-limit
    }

    public String getRangeType() {
        return rangeType;
    }
    
    public boolean isRequiredItem(Item item) {
        return item != null && item.getName().equalsIgnoreCase(requiredItemName);
    }

}
