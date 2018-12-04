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
public class SafetyPointClosedPopup extends Popup {

    public SafetyPointClosedPopup(InteractionHandlerImpl interactionHandler, String name, String image) {
        super(interactionHandler, name, image);
        addClickableAreas("zoom", new int[]{366, 117, 163, 97});
        addClickableAreas("open", new int[]{476, 291, 79, 80});
        addClickableAreas("exit1", new int[]{0, 0, 343, 500});
        addClickableAreas("exit2", new int[]{557, 0, 343, 500});
    }

    @Override
    public void onClick(int[] clickedPosition) {
        String clickedArea = getClickedArea(clickedPosition);
        if (clickedArea != null) {
            switch (clickedArea) {
                case "zoom":
                    getInteractionHandler().getGameContainer().setPopup(new SafetyPointZoomPopup(getInteractionHandler(), "ZoomMap", "SafetyPointOverlay"));
                    break;
                case "open":
                    getInteractionHandler().getGameContainer().setPopup(new SafetyPointOpenPopup(getInteractionHandler(), "SafetyPointOpen", "SafetyPointOpen"));
                    break;
                case "exit1":
                case "exit2":
                    getInteractionHandler().getGameContainer().setPopup(null);
                    break;
            }
        }
    }
}
