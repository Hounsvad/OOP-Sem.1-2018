/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import oop_sem1_project.data_access.StorageImpl;
import oop_sem1_project.domain.popups.PhoneMainScreenPopup;
import oop_sem1_project.domain.popups.SafetyPointClosedPopup;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class InteractionHandlerImpl implements InteractionHandler {

    private final int interactionRate = 100; //Miliseconds
    private final GameContainer gameContainer = new GameContainer();
    private long lastInteraction = System.currentTimeMillis();
    private DataPacket dataPacket;

    @Override
    public List<String[]> update(String keyPressed) {
        if (System.currentTimeMillis() > this.lastInteraction + this.interactionRate && this.gameContainer.getPopup() == null) {
            this.lastInteraction = System.currentTimeMillis();
            int movePixels = 50;
            int vertical = Arrays.asList("Up", "W").contains(keyPressed) ? -movePixels : Arrays.asList("Down", "S").contains(keyPressed) ? movePixels : 0;
            int horizontal = Arrays.asList("Left", "A").contains(keyPressed) ? -movePixels : Arrays.asList("Right", "D").contains(keyPressed) ? movePixels : 0;
            int[] newPos = {this.gameContainer.getPlayer().getPosition()[0] + horizontal, this.gameContainer.getPlayer().getPosition()[1] + vertical};
            boolean canMove = newPos[0] > -1 && newPos[0] < 851 && newPos[1] > -1 && newPos[1] < 451;
            if (!canMove) {
                return this.dataPacket.constructPacket();
            }
            for (InteractableArea interactableArea : this.gameContainer.getPlayer().getCurrentRoom().getInteractableObjects().values()) {
                if (interactableArea.isWithinRange(newPos)) {
                    if (interactableArea.getRangeType().equalsIgnoreCase("safetypoint")) {
                        canMove = false;
                        this.gameContainer.setPopup(new SafetyPointClosedPopup(this, "Safety Point", "SafetyPointClosed"));
                        break;
                    } else if (interactableArea.getRangeType().equalsIgnoreCase("door")) {
                        Door destination = (Door) interactableArea;
                        newPos = destination.recalculatePlayerPosition(this.gameContainer.getPlayer());
                        this.dataPacket.setMessage(destination.getDestination().getMessage(this.gameContainer.getPlayer()));
                        this.dataPacket.setSound("Footstep");
                        this.gameContainer.getPlayer().setCurrentRoom(destination.getDestination());
                        break;
                    } else if (interactableArea.getRangeType().equalsIgnoreCase("quiz")) {
                        if (this.gameContainer.getPlayer().getProgress() == 11) {
                            canMove = false;
                            this.dataPacket.openQuiz(true);
                        }
                        break;
                    }
                }
                if (interactableArea.isAtboundary(newPos)) {
                    return this.dataPacket.constructPacket();
                }
            }
            if (canMove) {
                this.dataPacket.setSound("Footstep");
                this.getGameContainer().getPlayer().setPosition(newPos);
            }
            Room currentRoom = this.gameContainer.getPlayer().getCurrentRoom();
            this.dataPacket.setBackground(currentRoom.getImage(gameContainer.getPlayer()));
            this.dataPacket.setPopup(gameContainer.getPopup());
            this.dataPacket.setPlayerDirection(keyPressed);

        }
        return this.dataPacket.constructPacket();
    }

    @Override
    public List<String[]> update(String clickedNode, int[] position) {
        if (clickedNode.equals("GAME_CANVAS") && this.gameContainer.getPopup() != null) {
            this.gameContainer.getPopup().onClick(position);
        } else if (clickedNode.equals("PHONE_CANVAS")) {
            this.gameContainer.setPopup(new PhoneMainScreenPopup(this, "Phone", "PhoneHomeScreen"));
        } else if (clickedNode.equals("ITEM_CANVAS")) {
            for (InteractableArea interactableArea : this.gameContainer.getPlayer().getCurrentRoom().getInteractableObjects().values()) {
                if (!interactableArea.getRangeType().equalsIgnoreCase("none") && interactableArea.isWithinRange(this.gameContainer.getPlayer().getPosition())) {
                    if (interactableArea.isRequiredItem(this.gameContainer.getPlayer().getItem())) {
                    this.gameContainer.getPlayer().setProgress(this.gameContainer.getPlayer().getProgress() + 1);
                    this.dataPacket.setMessage(this.gameContainer.getPlayer().getItem().getUseMessage());
                    this.gameContainer.getPlayer().setItem(null);
                    this.dataPacket.setBackground(this.gameContainer.getPlayer().getCurrentRoom().getImage(gameContainer.getPlayer()));
                    break;
                    } else {
                            this.dataPacket.setMessage("This doesn't help at all");
                           }
                }
            }
        }
        this.dataPacket.setPopup(gameContainer.getPopup());
        return this.dataPacket.constructPacket();
    }

    @Override
    public List<String[]> start(String playerName) {
        this.gameContainer.inititalize(playerName);
        this.dataPacket = new DataPacket("Entrance", this.gameContainer.getPlayer());
        return this.dataPacket.constructPacket();
    }

    @Override
    public List<String> getStoredHighscores() {
        List<String> scores = new ArrayList<>();
        try {
            scores = new StorageImpl("storage").load(); //Temp Dir.
        } catch (IOException ex) {
            return scores;
        }
        Collections.sort(scores, new ScoreSorter());
        return scores;
    }

    public GameContainer getGameContainer() {
        return this.gameContainer;
    }

    public DataPacket getDataPacket() {
        return dataPacket;
    }

}
