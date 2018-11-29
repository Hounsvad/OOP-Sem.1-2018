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
public class Item extends DisplayableUnit {

    private final int desiredProgress;

    /**
     * Creates a new Item
     *
     * @param name The name of the item
     * @param position Its position on screen
     * @param image The path to its image
     * @param description The items description
     * @param desiredProgress The items desired progress.
     */
    public Item(String name, int[] position, String image, String description, int desiredProgress) {
        super(name, position, image, description);
        this.desiredProgress = desiredProgress;
    }

    public boolean isDesiredProgress(int progress) {
        return this.desiredProgress == progress;
    }
}
