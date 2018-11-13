/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project;

import oop_sem1_project.items.Inventory;

/**
 *
 * @author Oliver
 */
public class Player {

    /**
     * Player name.
     */
    private final String name;

    /**
     * The player's inventory.
     */
    private final Inventory inventory = new Inventory();

    /**
     * Player score
     */
    private int score;

    /**
     * The progress of a player
     */
    private int progress = 10;

    /**
     * Constructs a new Player Object.
     *
     * @param name of the player.
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * @return the name of the player.
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the item with name passed as the argument or null if it does not
     *         not exist.
     */
    public Inventory getInventory() {
        return this.inventory;
    }

    /**
     * Increases the progress
     */
    public void increaseProgress() {
        this.progress++;
    }

    /**
     *
     *
     * @return the player's score
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Sets the score
     *
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     *
     * Change the progress to i
     *
     * @param i The new progress
     */
    public void changeProgress(int i) {
        this.progress = i;
    }

    /**
     * Get the progress of a player
     *
     * @return The progress
     */
    public int getProgress() {
        return this.progress;
    }
}
