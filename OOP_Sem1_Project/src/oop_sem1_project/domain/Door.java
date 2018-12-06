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

    public Door(String name, int[] position, int[] size, int range, String rangeType, String requiredItemName, Room destination, boolean vertical) {
        super(name, position, size, range, rangeType, requiredItemName);
        this.destination = destination;
        this.vertical = vertical;
    }

    public Room getDestination() {
        return destination;
    }

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
