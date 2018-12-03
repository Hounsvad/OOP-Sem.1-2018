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
    private final String name;

    public Room(String name, String[] image, int desiredProgress, boolean increasesProgress) {
        this.name = name;
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
    public void addInteractableObject(String key, InteractableArea object) {
        if (this.interactableObjects.put(key, object) != null) {
            throw new IllegalArgumentException("Messeage index already exists");
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

        if (roomProgress == 0) {
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
        return null;
    }

    public Map<String, InteractableArea> getInteractableObjects() {
        return this.interactableObjects;
    }

    public int getDesiredProgress() {
        return this.desiredProgress;
    }

    public String getImage(Player player) {
        int roomProgress = player.getProgress() - this.desiredProgress;
        if (roomProgress <= 2 && roomProgress >= 0) {
            return image[roomProgress];
        } else if (roomProgress < 0) {
            return image[0];
        } else {
            return image[2];
        }
    }
}
