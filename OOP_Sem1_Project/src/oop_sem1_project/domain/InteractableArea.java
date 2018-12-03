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
    private final String name;

    public InteractableArea(String name, String image, String description, int[] position, int[] size, int range, String rangeType, String requiredItemName) {
        this.name = name;
        this.position = position;
        this.size = size;
        this.range = range;
        this.rangeType = rangeType;
        this.requiredItemName = requiredItemName;
    }

    public boolean isWithinRange(int[] playerPosition) {
        return (playerPosition[0] > this.position[0] - this.range && playerPosition[0] < this.position[0] + this.size[0] + this.range //within x-limit
                && playerPosition[1] > this.position[1] - this.range && playerPosition[1] < this.position[1] + this.size[1] + this.range);  //within y-limit
    }

    public boolean isAtboundary(int[] playerPosition) {
        return (playerPosition[0] > this.position[0] && playerPosition[0] < this.position[0] + this.size[0] //within x-limit
                && playerPosition[1] > this.position[1] && playerPosition[1] < this.position[1] + this.size[1]);  //within y-limit
    }

    public String getRangeType() {
        return rangeType;
    }

    public boolean isRequiredItem(Item item) {
        return item != null && item.getName().equalsIgnoreCase(requiredItemName);
    }

    public String getName() {
        return name;
    }
}
