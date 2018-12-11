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
public class PhoneMainScreenPopup extends Popup {

    /**
     *
     * @param interactionHandler an instance of the InteractionHandler
     * @param phoneMainScreen    the name of the image used to display the Popup
     */
    public PhoneMainScreenPopup(InteractionHandlerImpl interactionHandler, String phoneMainScreen) {
        super(interactionHandler, phoneMainScreen);
        addClickableAreas("map", new int[]{390, 391, 41, 41});
        addClickableAreas("dial", new int[]{472, 391, 41, 41});
        addClickableAreas("exit1", new int[]{0, 0, 322, 500});
        addClickableAreas("exit2", new int[]{577, 0, 900, 500});
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
                case "map":
                    getInteractionHandler().getGameContainer().setPopup(new PhoneMapScreenPopup(getInteractionHandler(), "PhoneMap"));
                    break;
                case "dial":
                    getInteractionHandler().getGameContainer().setPopup(new PhoneDialScreenPopup(getInteractionHandler(), "PhoneDialScreen"));
                    break;
                case "exit1":
                case "exit2":
                    getInteractionHandler().getGameContainer().setPopup(null);
            }
        }
    }
}
