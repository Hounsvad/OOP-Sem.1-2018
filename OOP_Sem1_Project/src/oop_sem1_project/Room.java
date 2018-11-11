package oop_sem1_project;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.List;
import oop_sem1_project.items.Inventory;
import oop_sem1_project.items.Item;
import oop_sem1_project.items.SafetyPoint;

/**
 *
 *
 */
public class Room {

    /**
     * HashMap containing all its exit {@link Room rooms} referenced by their
     * direction relative to the current room. (north, east, south, west)
     */
    private final Map<String, Room> exits = new HashMap<>();

    /**
     * A description of this Room.
     */
    private final String description;

    /**
     * A value of how far the player should be to access the room.
     */
    private final int desiredProgress;

    /**
     * The messages to be displayed in the room.
     */
    private final String[] messages;

    /**
     * The message to be displayed when the player's progress is lower than the
     * desired progress.
     */
    private final String deniedMessage;

    private final String why;

    private final int progressIncrease;

    /**
     * Constructs a new Room Object.
     *
     * @param description      A short description of this Room.
     * @param desiredProgress  A value of how far the player should be to access
     *                         the room.
     * @param messages         The messages to be displayed in the room.
     * @param deniedMessage    The message to be displayed when the player's
     *                         progress is lower than the desired progress
     * @param why
     * @param progressIncrease the progress increase given by a room
     */
    public Room(String description, int desiredProgress, String[] messages, String deniedMessage, String why, int progressIncrease) {
        this.description = description;
        this.desiredProgress = desiredProgress;
        this.messages = messages;
        this.deniedMessage = deniedMessage;
        this.why = why;
        this.progressIncrease = progressIncrease;
    }

    /**
     * Add a new exit to this room.
     *
     * @param direction The relative direction in which the neighborg is
     *                  located.
     * @param neighbor  The neighborging room.
     */
    public void setExit(String direction, Room neighbor) {
        this.exits.put(direction, neighbor);
    }

    /**
     * @return The Rooms description.
     */
    public String getShortDescription() {
        return this.description;
    }

    /**
     * @return A longer version of the Rooms description.
     */
    public String getLongDescription() {
        return "You are " + this.description + ".\n" + getExitString();
    }

    /**
     * @return A message containing the available exists in this Room.
     */
    private String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = this.exits.keySet();
        for (String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Get an Exit in the given direction.
     *
     * @param direction The direction in which an exit room is to be retrieved.
     * @return A Room in the given direction or null if no Room is located in
     *         the given direction i.e. no key exists for the parameter.
     */
    public Room getExit(String direction) {
        return this.exits.get(direction);
    }

    /**
     * Get the desired progress
     *
     * @return desiredProgress
     */
    public int getDesiredProgress() {
        return this.desiredProgress;
    }

    /**
     * Get the current message
     *
     * @param p the player.
     * @return The current message to be displayed
     */
    public String getMessage(Player p) {
        int roomProgress = p.getProgress() - desiredProgress;
        if (p.getProgress() < desiredProgress) {
            return deniedMessage;
        } else if (roomProgress == 0) {
            if (this.progressIncrease > 0) {
                p.increaseProgress();
                return messages[p.getProgress() - desiredProgress - 1];
            }
        }
        return messages[roomProgress];
    }

    /**
     *
     * @return why
     */
    public String getWhy() {
        return this.why;
    }
}
