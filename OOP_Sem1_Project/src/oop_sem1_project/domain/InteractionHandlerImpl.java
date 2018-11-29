/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oop_sem1_project.data_access.Storage;
import oop_sem1_project.data_access.StorageImpl;
import oop_sem1_project.domain.popups.PhoneMainScreenPopup;
import oop_sem1_project.domain.popups.SafetyPointClosedPopup;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class InteractionHandlerImpl implements InteractionHandler {

    private final GameContainer gameContainer;
    private final DataPacket dataPacket;

    public InteractionHandlerImpl() {
        this.gameContainer = new GameContainer();
        this.dataPacket = new DataPacket("FIRST BACKGROUND", this.gameContainer.getPlayer());
    }

    @Override
    public List<String[]> update(String keyPressed) {
        if (this.gameContainer.getPopup() == null) {
            int movePixels = 5;
            int[] newPos = {this.gameContainer.getPlayer().getPosition()[0] + movePixels, this.gameContainer.getPlayer().getPosition()[1] + movePixels};
            for (InteractableObject interactableObject : this.gameContainer.getPlayer().getCurrentRoom().getInteractableObjects().values()) {
                if (interactableObject.isAtboundary(newPos)) {
                    break;
                }
                if (interactableObject.isWithinRange(newPos)) {
                    if (interactableObject.getRangeType().equalsIgnoreCase("safetypoint")) {
                        this.gameContainer.setPopup(new SafetyPointClosedPopup(this, "Safety Point", "SafetyPointClosed"));
                    }
                    break;
                }
            }
            Room currentRoom = this.gameContainer.getPlayer().getCurrentRoom();
            this.dataPacket.setBackground(currentRoom.getImage());
            this.dataPacket.setDisplayableUnits(new ArrayList<>(currentRoom.getInteractableObjects().values()));
        }
        return this.dataPacket.constructPacket();
    }

    @Override
    public List<String[]> update(String clickedNode, int[] position) {
        if (clickedNode.equals("GAME_CANVAS") && this.gameContainer.getPopup() != null) {
            this.gameContainer.getPopup().onClick(position);
        } else if (clickedNode.equals("PHONE_CANVAS")) {
            this.gameContainer.setPopup(new PhoneMainScreenPopup(this, "Phone", "PhoneMainScreen"));
        } else if (clickedNode.equals("ITEM_CANVAS")) {
            for (InteractableObject interactableObject : this.gameContainer.getPlayer().getCurrentRoom().getInteractableObjects().values()) {
                if (!interactableObject.getRangeType().equalsIgnoreCase("none") && interactableObject.isWithinRange(this.gameContainer.getPlayer().getPosition()) && interactableObject.isRequiredItem(this.gameContainer.getPlayer().getItem())) {
                    this.gameContainer.getPlayer().setProgress(this.gameContainer.getPlayer().getProgress() + 1);
                    this.gameContainer.getPlayer().setItem(null);
                    break;
                }
            }
        }
        this.dataPacket.setDisplayableUnits(new ArrayList<>(this.gameContainer.getPlayer().getCurrentRoom().getInteractableObjects().values()));
        return this.dataPacket.constructPacket();
    }

    @Override
    public List<String[]> start(String playerName) {
        this.gameContainer.inititalize(playerName);
        return this.dataPacket.constructPacket();
    }

    @Override
    public List<String> getStoredHighscores() {
        List<String> scores = new ArrayList<>();
        try {
            scores = new StorageImpl(System.getProperty("user.home") + "/Desktop", "storage").load(); //Temp Dir.
        } catch (IOException ex) {
            return scores;
        }
        Collections.sort(scores, new ScoreSorter());
        return scores;
    }

    public GameContainer getGameContainer() {
        return this.gameContainer;
    }
}
