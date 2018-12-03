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
public class Item {

    private final int desiredProgress;
    private final String name;

    /**
     * Creates a new Item
     *
     * @param name The name of the item
     * @param image The path to its image
     * @param description The items description
     * @param desiredProgress The items desired progress.
     */
    public Item(String name, String image, String description, int desiredProgress) {
        this.name = name;
        this.desiredProgress = desiredProgress;
    }

    public boolean isDesiredProgress(int progress) {
        return this.desiredProgress == progress;
    }

    public String getName() {
        return name;
    }

}
