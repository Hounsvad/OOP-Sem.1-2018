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
public class interactableObject extends DisplayableUnit {

    private int[] clickableArea;

    public interactableObject(int[] clickableArea) {
        /*Insert super call and fix signature*/
        this.clickableArea = clickableArea;
    }

    /**
     * Checks to see if the coordinates are withing the clickable area
     *
     * @param x as an int to signify the x coordinate of the clicked point
     * @param y as an int to signify the y coordinate of the clicked point
     * @return true if the input is within the clickable area
     */
    public boolean isInArea(int x, int y) {
        if (x > 0 && y > 0 && x >= clickableArea[0] && x <= clickableArea[2] && y > clickableArea[1] && y <= clickableArea[3]) {
            return true;
        }
        return false;
    }
}
