/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.domain.popups;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import oop_sem1_project.domain.InteractionHandlerImpl;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public abstract class Popup {

    private final InteractionHandlerImpl interactionHandler;
    private final String name;
    private final String image;
    private final Map<String, int[]> clickableAreas = new HashMap<>();

    /**
     * 
     * @param interactionHandler an instance of the InteractionHandler
     * @param name the name of the Popup
     * @param image the image used to display the Popup
     */
    public Popup(InteractionHandlerImpl interactionHandler, String name, String image) {
        this.interactionHandler = interactionHandler;
        this.name = name;
        this.image = image;
    }
    
    /**
     * 
     * @return the name of the Popup 
     */
    public String getName() {
        return this.name;
    }

    /**
     * 
     * @return the name of the image used to display the Popup
     */
    public String getImage() {
        return this.image;
    }

    /**
     * Adds a ClickableArea to a map of ClickableAreas
     * 
     * @param identifier a unique identifier
     * @param area the area
     */
    public final void addClickableAreas(String identifier, int[] area) {
        this.clickableAreas.put(identifier, area);
    }

    /**
     * 
     * @return a map of all ClickableAreas
     */
    public Map<String, int[]> getClickableAreas() {
        return this.clickableAreas;
    }

    /**
     * Compares the position of the mouseclick to every ClickableArea 
     * 
     * @param clickedPosition the position the mouseclick happened on
     * @return return the identifier of the ClickableArea which got clicked on
     */
    public String getClickedArea(int[] clickedPosition) {
        for (Map.Entry<String, int[]> clickableArea : this.clickableAreas.entrySet()) {
            //if the clicks position from the argument is within a clickable area form the clickable areas map
            if ( //X
                    clickedPosition[0] < clickableArea.getValue()[0] + clickableArea.getValue()[2]
                    && clickedPosition[0] > clickableArea.getValue()[0]
                    //Y
                    && clickedPosition[1] < clickableArea.getValue()[1] + clickableArea.getValue()[3]
                    && clickedPosition[1] > clickableArea.getValue()[1]) {
                return clickableArea.getKey();
            }
        }
        return null;
    }

    /**
     * 
     * @return the InteractionHandler
     */
    public InteractionHandlerImpl getInteractionHandler() {
        return this.interactionHandler;
    }

    public abstract void onClick(int[] clickedPosition);
}
