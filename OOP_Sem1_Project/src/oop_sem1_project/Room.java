package oop_sem1_project;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

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
     * 
     */
    private final String why;
    /**
     * Constructs a new Room Object.
     *
     * @param description A short description of this Room.
     * @param why A brief description of how or why there is an accident or incident in a room
     */
    public Room(String description, String why) {
        this.description = description;
        this.why = why;
    }
    
    /**
     * Constructs a new Room Object.
     * @param description 
     */
    public Room(String description){
        this(description, "Who knows");
    }

    /**
     * Add a new exit to this room.
     * @param direction The relative direction in which the neighbour is located.
     * @param neighbor  The neighbour room.
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
}
