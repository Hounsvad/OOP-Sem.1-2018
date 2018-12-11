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

    /**
     *
     * @param interactionHandler an instance of the InteractionHandler
     * @param image              the name of the image used to display the popup
     */
    public SafetyPointZoomPopup(InteractionHandlerImpl interactionHandler, String image) {
        super(interactionHandler, image);
    }

    /**
     * Does something depending on where you've clicked
     *
     * @param clickedPosition the position the mouseclick happened on
     */
    @Override
    public void onClick(int[] clickedPosition) {
        getInteractionHandler().getGameContainer().setPopup(new SafetyPointClosedPopup(getInteractionHandler(), "SafetyPointClosed"));
    }
}
