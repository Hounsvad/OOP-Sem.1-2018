/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.domain;

import java.util.Date;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class Player {

    /**
     * Game start time.
     */
    private final Date startTime = new Date();

    /**
     * Index zero is the task and index is progress in the task.
     */
    private final int[] progress = {0, 0};
    
    /**
     * The name of the Player.
     */
    private final String name;

    /**
     * The players position on the game canvas.
     */
    private final int[] pos;
    
    /**
     * The current room the player is in.
     */
    private Room currentRoom;
    
    /**
     * The player's inventory.
     */
    public final Inventory inventory = new Inventory();

    /**
     * Constructs a player object with the given name and position.
     *
     * @param name The name of the player.
     * @param xInit The initial x coordinate.
     * @param yInit The initial y coordinate.
     */
    public Player(String name, int xInit, int yInit) {
        this.name = name;
        this.pos = new int[]{xInit, yInit};   
    }

    /**
     * @return The start time.
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @return The progress array.
     */
    public int[] getProgress() {
        return progress;
    }

    /**
     * Set the game progress.
     *
     * @param task The task.
     * @param taskProgress The progress of the task.
     */
    public void setProgress(int task, int taskProgress) {
        this.progress[0] = task;
        this.progress[1] = taskProgress;
    }

    /**
     * @return The name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * @return The players current position.
     */
    public int[] getPos() {
        return pos;
    }

    /**
     * Set the position of the player.
     *
     * @param x The new x position.
     * @param y The new y position.
     */
    public void setPos(int x, int y) {
        this.pos[0] = x;
        this.pos[1] = y;
    }  
        /**
     * Set the players current room
     * @param Room The current room object 
     */
    public void setCurrentRoom(Room currentRoom){
        this.currentRoom = currentRoom;
    }
        /**
     * Return the current room object the player is in
     * @return Room The current room object
     */
    public Room getCurrentRoom(){
        return currentRoom;
    }
}   
