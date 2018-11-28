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
public class InteractableObject extends DisplayableUnit {

    private final int[] clickableArea;

    public InteractableObject(String name, int[] clickableArea, String image, String description) {
        super(name, clickableArea, image, description);
        this.clickableArea = clickableArea;
    }

    /**
     * Checks to see if the coordinates are within the clickable area
     *
     * @param x as an int to signify the x coordinate of the clicked point
     * @param y as an int to signify the y coordinate of the clicked point
     * @return true if the input is within the clickable area
     */
    public boolean isInArea(int x, int y) {
        return x > 0 && y > 0 && x >= this.clickableArea[0] && x <= this.clickableArea[2] && y > this.clickableArea[1] && y <= this.clickableArea[3];
    }
}
