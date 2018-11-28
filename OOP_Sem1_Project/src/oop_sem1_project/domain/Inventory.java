/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.domain;

/**
 *
 * @author Patrick
 */
public class Inventory {

    private final Phone phone;
    private Item item;

    /**
     * Creates an empty inventory with a Phone object
     *
     * @param phone the phone for the player
     */
    public Inventory(Phone phone) {
        this.phone = phone;
    }

    /**
     * Returns the phone
     *
     * @return the phone being used
     */
    public Phone getPhone() {
        return this.phone;
    }

    /**
     * Returns the item currently in the inventory
     *
     * @return the item in the inventory
     */
    public Item getItem() {
        return this.item;
    }

    /**
     * Sets the current item
     *
     * @param item the item that is going to be in the inventory
     */
    public void setItem(Item item) {
        this.item = item;
    }
}
