/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.domain.popups;

import java.util.HashMap;
import java.util.Map;
import oop_sem1_project.domain.InteractionHandlerImpl;
import oop_sem1_project.domain.Item;

/**
 *
 * @author Patrick
 */
public class SafetyPointOpenPopup extends Popup {

    private final Map<Integer, Item> items = new HashMap<>();

    SafetyPointOpenPopup(InteractionHandlerImpl interactionHandler, String name, String image) {
        super(interactionHandler, name, image);
    }

    public Map<Integer, Item> getItems() {
        return this.items;
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
                case "exit":
                    getInteractionHandler().getGameContainer().setPopup(null); //Is this how we exit popup?
            }
        }
    }
}
