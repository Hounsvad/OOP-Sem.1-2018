/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.domain;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Pinnacle F
 */
public class Room {

    private final Map<String, InteractableArea> interactableObjects = new HashMap<>();
    private final int desiredProgress;
    private final Map<Integer, String> messages = new HashMap<>();
    private final boolean increasesProgress;
    private final String[] image;
    
    /**
     * 
     * @param image A String array of images being used to display the room
     * @param desiredProgress The progress the room desires
     * @param increasesProgress true if the progress should be increased inside the room
     */
    public Room(String[] image, int desiredProgress, boolean increasesProgress) {
        this.image = image;
        this.desiredProgress = desiredProgress;
        this.increasesProgress = increasesProgress;
    }

    /**
     * Adds a message to the message list
     *
     * @param index minimum progress for the message
     * @param message the message
     */
    public void addMessage(int index, String message) {
        if (this.messages.put(index, message) != null) {
            throw new IllegalArgumentException("Message index already exists");
        }
    }

    /**
     * Adds an object to the object list
     *
     * @param key a as a string to identify the object
     * @param object as an interactableObject in the room
     */
    public void addInteractableArea(String key, InteractableArea object) {
        if (this.interactableObjects.put(key, object) != null) {
            throw new IllegalArgumentException("Message index already exists");
        }
    }

    /**
     * removes an InteractableObject from the room
     *
     * @param key
     */
    public void removeInteractableObject(String key) {
        this.interactableObjects.remove(key);
    }

    /**
     * Returns the relevant message
     *
     * @param player
     * @return the relevant message
     */
    public String getMessage(Player player) {
        int roomProgress = player.getProgress() - this.desiredProgress;

        if (roomProgress == 0 && this.increasesProgress == true) {
            player.setProgress(player.getProgress() + 1);

        }

        return getMessageSmaller(roomProgress);
    }

    /**
     * Gets the matching message or the first message smaller than the wished
     * message. In the event that the input is smaller than the smallest index
     * then it returns null
     *
     * @param input index to be searched for
     * @return null or desired message
     */
    private String getMessageSmaller(int input) {
        int firstSmaller = -1000;
        for (Map.Entry<Integer, String> e : messages.entrySet()) {
            int key = e.getKey();
            if (key == input) {
                return e.getValue();
            }
            if (key < input && key > firstSmaller) {
                firstSmaller = key;
            }
        }
        if (firstSmaller != -1000) {
            return this.messages.get(firstSmaller);
        }
        return this.messages.get(firstSmaller);
    }
    
    /**
     * 
     * @return a map of all interactableAreas in the room
     */
    public Map<String, InteractableArea> getInteractableObjects() {
        return this.interactableObjects;
    }
    
    /**
     * 
     * @return the desired progress the room expects you to have
     */
    public int getDesiredProgress() {
        return this.desiredProgress;
    }
    
    /**
     * Returns the image of the room, depending on if your progress is equal, 
     * higher or lower than the desired progress. 
     * 
     * @param player
     * @return the image used to display the current room
     */
    public String getImage(Player player) {
        int roomProgress = player.getProgress() - this.desiredProgress;
        if (roomProgress < 0) {
            return image[0];
        } else if (roomProgress == 0 || roomProgress == 1) {
            return image[1];
        } else if (player.getProgress() >= 8) {
            return image[3];
        }
        return image[2];

    }
}
