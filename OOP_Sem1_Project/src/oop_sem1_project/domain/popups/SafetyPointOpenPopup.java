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

    public SafetyPointOpenPopup(InteractionHandlerImpl interactionHandler, String name, String image) {
        super(interactionHandler, name, image);
        addClickableAreas("map", new int[]{366, 117, 97, 92});
        addClickableAreas("whatToDo", new int[]{474, 119, 54, 71});
        addClickableAreas("fire-extinguisher", new int[]{363, 318, 68, 153});
        addClickableAreas("defibrilator", new int[]{457, 321, 64, 56});
        addClickableAreas("first-aid", new int[]{458, 404, 66, 57});
        addClickableAreas("eyewash", new int[]{474, 119, 54, 71}); //add Eyewash
        addClickableAreas("exit1", new int[]{0, 0, 343, 500});
        addClickableAreas("exit2", new int[]{557, 0, 343, 500});
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
                case "fire-extinguisher":
                    getInteractionHandler().getGameContainer().getPlayer().setItem(getInteractionHandler().getGameContainer().getItems().get(0)); //Add ItemList to GameContainer
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
