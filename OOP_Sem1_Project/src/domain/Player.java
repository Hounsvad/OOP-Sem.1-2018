/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class Player extends DisplayableUnit {

    /**
     * Game start time.
     */
    private final Date startTime = new Date();

    /**
     * The player's inventory.
     */
    public final Inventory inventory = new Inventory(new Phone());

    /**
     * Index zero is the task and index is progress in the task.
     */
    private int progress = 0;

    /**
     * The current room the player is in.
     */
    private Room currentRoom;

    /**
     * Constructs a player object with the given name and position.
     *
     * @param name The name of the player.
     * @param xInit The initial x coordinate.
     * @param yInit The initial y coordinate.
     * @param image The image location as a String.
     * @param description The player description.
     */
    public Player(String name, int xInit, int yInit, String image, String description) {
        super(name, new int[]{xInit, yInit}, name, description);
    }

    /**
     * @return The start time.
     */
    public Date getStartTime() {
        return this.startTime;
    }

    /**
     * @return The progress.
     */
    public int getProgress() {
        return this.progress;
    }

    /**
     * Set the game progress.
     *
     * @param progress The progress.
     */
    public void setProgress(int progress) {
        this.progress = progress;
    }

    /**
     * Set the players current room
     *
     * @param currentRoom The current room object;
     */
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    /**
     * Return the current room object the player is in
     *
     * @return Room The current room object
     */
    public Room getCurrentRoom() {
        return this.currentRoom;
    }
}
