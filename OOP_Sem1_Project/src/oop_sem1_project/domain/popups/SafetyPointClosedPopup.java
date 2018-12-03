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
    }

    @Override
    public void onClick(int[] clickedPosition) {
        String clickedArea = getClickedArea(clickedPosition);
        if (clickedArea != null) {
            switch (clickedArea) {
                case "map":
                    getInteractionHandler().getGameContainer().setPopup(new SafetyPointZoomPopup(getInteractionHandler(), "ZoomMap", "SafetyPointMap"));
                    break;
                case "whatToDo":
                    getInteractionHandler().getGameContainer().setPopup(new SafetyPointZoomPopup(getInteractionHandler(), "ZoomWhatToDo", "SafetyPointWhatToDo"));
                    break;
                case "open":
                    getInteractionHandler().getGameContainer().setPopup(new SafetyPointOpenPopup(getInteractionHandler(), "SafetyPointOpen", "SafetyPointOpen"));
                    break;
                case "exit":
                    getInteractionHandler().getGameContainer().setPopup(null); //Is this how we close popup?
                    break;
            }
        }
    }
}
