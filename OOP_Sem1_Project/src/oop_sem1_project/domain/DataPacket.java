/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class DataPacket {

    private final Player player;

    private List<String[]> packet = new ArrayList<>();
    private String background;
    private List<InteractableObject> interactableObjects = new ArrayList<>();
    private String playerDirection = "Up";

    public DataPacket(String background, Player player) {
        this.background = background;
        this.player = player;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public void resetDisplayableUnits() {
        this.interactableObjects = new ArrayList<>();
    }

    public void setDisplayableUnits(List<InteractableObject> interactableObjects) {
        this.interactableObjects = interactableObjects;
    }

    public void setPlayerDirection(String keyPressed) {
        this.playerDirection = keyPressed;
    }

    public List<String[]> constructPacket() {
        this.packet = new ArrayList<>();
        this.packet.add(new String[]{"bg", this.background});
        this.packet.add(new String[]{"pl", this.playerDirection, String.valueOf(this.player.getPosition()[0]), String.valueOf(this.player.getPosition()[1])});
        this.packet.add(new String[]{"ci", this.player.getItem() == null ? "" : this.player.getItem().getImage()});
        for (InteractableObject interactableObject : this.interactableObjects) {
            this.packet.add(new String[]{"go", interactableObject.getImage(), String.valueOf(interactableObject.getPosition()[0]), String.valueOf(interactableObject.getPosition()[1])});
        }
        return this.packet;
    }

}
