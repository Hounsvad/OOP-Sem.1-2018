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
public class Player {

    /**
     * Game start time.
     */
    private final long startTime = System.currentTimeMillis();

    /**
     * Index zero is the task and index is progress in the task.
     */
    private int progress = 0;

    /**
     * The current room the player is in.
     */
    private Room currentRoom;

    /**
     * The players current item.
     */
    private Item item;

    private final String name;
    private int[] position;

    /**
     * Constructs a player object with the given name and position.
     *
     * @param name         The name of the player.
     * @param initPosition The initial position of the Player.
     */
    public Player(String name, int[] initPosition) {
        this.name = name;
        this.position = initPosition;
    }

    /**
     *
     * @return player name
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @return the players position
     */
    public int[] getPosition() {
        return this.position;
    }

    /**
     * Sets the players position
     *
     * @param position player position as x,y
     */
    public void setPosition(int[] position) {
        this.position = position;
    }

    /**
     * @return The start time.
     */
    public long getStartTime() {
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

    /**
     *
     * @return the current item of the player
     */
    public Item getItem() {
        return this.item;
    }

    /**
     * Sets the item the player is currently holding
     *
     * @param item
     */
    public void setItem(Item item) {
        this.item = item;
    }
}
