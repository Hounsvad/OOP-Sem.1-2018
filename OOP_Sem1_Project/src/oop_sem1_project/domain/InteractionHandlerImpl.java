/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.domain;

import oop_sem1_project.domain.popups.PhoneMainScreenPopup;
import oop_sem1_project.domain.popups.Popup;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class InteractionHandlerImpl implements InteractionHandler {

    private Popup popup;

    public InteractionHandlerImpl() {
        //Initialize stuff.
    }

    @Override
    public void keyEvent(String keyPressed) {
        System.out.println(keyPressed);
    }

    @Override
    public void mouseClick(String clickedNode, int[] clickedPosition) {
        if (clickedNode.equals("GAME_CANVAS") && popup != null) {
            popup.onClick(clickedPosition);
        } else if (clickedNode.equals("PHONE_CANVAS")) {
            this.popup = new PhoneMainScreenPopup(this, "Phone", "PhoneMainScreen");
        } else if (clickedNode.equals("ITEM_CANVAS")) {
            
        }
    }

    @Override
    public Popup getPopup() {
        return this.popup;
    }

    @Override
    public void setPopup(Popup popup) {
        this.popup = popup;
    }
}
