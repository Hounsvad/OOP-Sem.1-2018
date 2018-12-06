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

        addClickableAreas("exit1", new int[]{0, 0, 164, 500});
        addClickableAreas("exit2", new int[]{735, 0, 165, 500});
        addClickableAreas("exit3", new int[]{0, 0, 900, 83});
        addClickableAreas("exit4", new int[]{386, 0, 900, 114});
    }

    @Override
    public void onClick(int[] clickedPosition) {
        String clickedArea = getClickedArea(clickedPosition);
        if (clickedArea != null) {
            switch (clickedArea) {
                case "exit1":
                case "exit2":
                case "exit3":
                case "exit4":
                    getInteractionHandler().getGameContainer().setPopup(new SafetyPointClosedPopup(getInteractionHandler(), "SafetyPointClosed", "SafetyPointClosed"));
            }
        }
    }
}
