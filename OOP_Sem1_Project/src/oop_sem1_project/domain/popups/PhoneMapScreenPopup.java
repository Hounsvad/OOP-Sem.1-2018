/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.domain.popups;

import oop_sem1_project.domain.InteractionHandlerImpl;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class PhoneMapScreenPopup extends Popup {

    /**
     * 
     * @param interactionHandler an instance of the InteractionHandler
     * @param mapPhone the name of the Popup
     * @param phoneMapScreen the name of the image used to disply the Popup
     */
    public PhoneMapScreenPopup(InteractionHandlerImpl interactionHandler, String mapPhone, String phoneMapScreen) {
        super(interactionHandler, mapPhone, mapPhone);
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
        if (clickedArea != null) {
            switch (clickedArea) {
                case "home":
                    getInteractionHandler().getGameContainer().setPopup(new PhoneMainScreenPopup(this.getInteractionHandler(), "Phone", "PhoneHomeScreen"));
                    break;
            }
        }
    }
}
