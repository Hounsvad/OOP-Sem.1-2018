/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.domain;

import java.util.List;
import oop_sem1_project.domain.popups.PhoneMainScreenPopup;
import oop_sem1_project.domain.popups.Popup;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class InteractionHandlerImpl implements InteractionHandler {

    private final GameContainer gameContainer;
    private DataPacket dataPacket = new DataPacket();
    private Popup popup;

    public InteractionHandlerImpl() {
        this.gameContainer = new GameContainer();
    }

    public Popup getPopup() {
        return this.popup;
    }

    public void setPopup(Popup popup) {
        this.popup = popup;
    }

    @Override
    public List<String[]> update(String keyPressed) {z
    }

    @Override
    public List<String[]> update(String clickedNode, int[] position) {
        if (clickedNode.equals("GAME_CANVAS") && this.gameContainer.getPopup() != null) {
            this.gameContainer.getPopup().onClick(position);
        } else if (clickedNode.equals("PHONE_CANVAS")) {
            this.gameContainer.setPopup(new PhoneMainScreenPopup(this, "Phone", "PhoneMainScreen"));
        } else if (clickedNode.equals("ITEM_CANVAS")) {

        }
    }
}
