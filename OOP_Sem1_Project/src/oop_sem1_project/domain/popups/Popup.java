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

    public Popup(InteractionHandlerImpl interactionHandler, String name, String image) {
        this.interactionHandler = interactionHandler;
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return this.name;
    }

    public String getImage() {
        return this.image;
    }

    public final void addClickableAreas(String identifier, int[] area) {
        this.clickableAreas.put(identifier, area);
    }

    public Map<String, int[]> getClickableAreas() {
        return this.clickableAreas;
    }

    public String getClickedArea(int[] clickedPosition) {
        for (Map.Entry<String, int[]> clickableArea : this.clickableAreas.entrySet()) {
            System.out.println(Arrays.toString(clickableArea.getValue()) + "    ---- " + Arrays.toString(clickedPosition));
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

    public InteractionHandlerImpl getInteractionHandler() {
        return this.interactionHandler;
    }

    public abstract void onClick(int[] clickedPosition);
}
