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
public class SafetyPointOpenPopup extends Popup {

    SafetyPointOpenPopup(InteractionHandlerImpl interactionHandler, String name, String image) {
        super(interactionHandler, name, image);

        addClickableAreas("zoom", new int[]{366, 117, 163, 97});
        addClickableAreas("fire-extinguisher", new int[]{363, 318, 68, 153});
        addClickableAreas("defibrilator", new int[]{461, 340, 61, 56});
        addClickableAreas("first-aid", new int[]{458, 403, 66, 59});
        addClickableAreas("eyewash", new int[]{458, 329, 64, 29});
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
                case "fire-extinguisher":
                    getInteractionHandler().getGameContainer().getPlayer().setItem(getInteractionHandler().getGameContainer().getItems().get(0));
                    break;
                case "defibrilator":
                    getInteractionHandler().getGameContainer().getPlayer().setItem(getInteractionHandler().getGameContainer().getItems().get(1));
                    break;
                case "first-aid":
                    getInteractionHandler().getGameContainer().getPlayer().setItem(getInteractionHandler().getGameContainer().getItems().get(2));
                    break;
                case "eyewash":
                    getInteractionHandler().getGameContainer().getPlayer().setItem(getInteractionHandler().getGameContainer().getItems().get(3));
                    break;
                case "exit1":
                case "exit2":
                    getInteractionHandler().getGameContainer().setPopup(null);
            }
        }
    }
}
