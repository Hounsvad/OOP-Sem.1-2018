/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.domain;

import java.util.ArrayList;
import java.util.List;
import oop_sem1_project.domain.popups.PhoneMainScreenPopup;
import oop_sem1_project.domain.popups.Popup;

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
                if (interactableObject.isAtBoundary(newPos)) {
                    break;
                }
                if (interactableObject.isWithinRange(newPos)) {
                    if (interactableObject.getRangeType().equalsIgnoreCase("safetypoint")) {
                        this.gameContainer.setPopup(null); //NEW SAFETY POINT. NULL ER PLACEHOLDER.
                    } else {
                        interactableObject.doStuff();
                    }
                    break;
                }
            }
            Room currentRoom = this.gameContainer.getPlayer().getCurrentRoom();
            this.dataPacket.setBackground(currentRoom.getImage());
            this.dataPacket.setDisplayableUnits(currentRoom.getInteractableObjects().values());
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
                if (!interactableObject.getRangeType().equalsIgnoreCase("none") && interactableObject.isWithinRange(this.gameContainer.getPlayer()) && interactableObject.isRequiredItem(this.gameContainer.getPlayer().getItem())) {
                    interactableObject.doStuff();
                    break;
                }
            }
        }
        this.dataPacket.setDisplayableUnits(this.gameContainer.getPlayer().getCurrentRoom().getInteractableObjects().values());
        return this.dataPacket.constructPacket();
    }

    @Override
    public List<String[]> start(String playerName) {
        this.gameContainer.inititalize(playerName);
        return this.dataPacket.constructPacket();
    }

    @Override
    public List<String> getStoredHighscores() {
        return new ArrayList<>(); //Request stored data.
    }
}
