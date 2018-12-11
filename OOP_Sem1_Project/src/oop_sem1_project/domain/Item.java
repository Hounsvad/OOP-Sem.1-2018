/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.domain;

/**
 *
 * 
 */
public class Item {

    private final int desiredProgress;
    private final String name;
    private final String image;
    private final String useMessage;
    private final String sound;

    /**
     * Creates a new Item
     *
     * @param name            The name of the item
     * @param image           The path to its image
     * @param desiredProgress The items desired progress.
     * @param useMessage      The message displayed when the item gets used
     * @param sound
     */
    public Item(String name, String image, int desiredProgress, String useMessage, String sound) {
        this.name = name;
        this.desiredProgress = desiredProgress;
        this.image = image;
        this.useMessage = useMessage;
        this.sound = sound;
    }

    /**
     *
     * @param progress
     * @return true if the desiredProgress equals the parameter
     */
    public boolean isDesiredProgress(int progress) {
        return this.desiredProgress == progress;
    }

    /**
     *
     * @return The items name
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @return The items image name
     */
    public String getImage() {
        return this.image;
    }

    /**
     *
     * @return The message that gets displayed
     */
    public String getUseMessage() {
        return this.useMessage;
    }

    /**
     * 
     * @return 
     */
    public String getSound() {
        return this.sound;
    }

}
