package oop_sem1_project;

import java.util.Set;
import java.util.HashMap;
import java.util.Map;

public class Room {

    private final Map<String, Room> exits = new HashMap<>();
    private final String description;

    public Room(String description) {
        this.description = description;
    }

    public void setExit(String direction, Room neighbor) {
        this.exits.put(direction, neighbor);
    }

    public String getShortDescription() {
        return this.description;
    }

    public String getLongDescription() {
        return "You are " + this.description + ".\n" + getExitString();
    }

    private String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = this.exits.keySet();
        for (String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction) {
        return this.exits.get(direction);
    }
}
