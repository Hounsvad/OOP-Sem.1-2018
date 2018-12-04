/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.domain.popups;

import oop_sem1_project.domain.InteractionHandlerImpl;

/**
 *
 * @author Patrick
 */
public class SafetyPointZoomPopup extends Popup {

    public SafetyPointZoomPopup(InteractionHandlerImpl interactionHandler, String name, String image) {
        super(interactionHandler, name, image);
    }

    @Override
    public void onClick(int[] clickedPosition) {
        String clickedArea = getClickedArea(clickedPosition);
        if ("exit".equals(clickedArea)) {
            getInteractionHandler().getGameContainer().setPopup(null); //Is this how we close popup?
        }
    }
}
