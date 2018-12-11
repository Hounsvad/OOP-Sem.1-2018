/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.domain.popups;

import oop_sem1_project.domain.InteractionHandlerImpl;

/**
 *
 * 
 */
public class PhoneMapScreenPopup extends Popup {

    /**
     *
     * @param interactionHandler  an instance of the InteractionHandler
     * @param phoneMapScreenImage the name of the image used to display the
     *                            Popup
     */
    public PhoneMapScreenPopup(InteractionHandlerImpl interactionHandler, String phoneMapScreenImage) {
        super(interactionHandler, phoneMapScreenImage);
        addClickableAreas("home", new int[]{431, 452, 40, 40});
    }

    /**
     * Does something depending on where you've clicked
     *
     * @param clickedPosition the position the mouseclick happened on
     */
    @Override
    public void onClick(int[] clickedPosition) {
        String clickedArea = getClickedArea(clickedPosition);
        if (clickedArea != null && clickedArea.equalsIgnoreCase("home")) {
            getInteractionHandler().getGameContainer().setPopup(new PhoneMainScreenPopup(this.getInteractionHandler(), "PhoneHomeScreen"));
        }
    }
}
