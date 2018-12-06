/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.domain.popups;

import oop_sem1_project.domain.InteractionHandlerImpl;

/**
 *
 * @author Oliver
 */
public class PhoneMainScreenPopup extends Popup {

    public PhoneMainScreenPopup(InteractionHandlerImpl interactionHandler, String phone, String phoneMainScreen) {
        super(interactionHandler, phone, phoneMainScreen);
        addClickableAreas("map", new int[]{390, 391, 41, 41});
        addClickableAreas("dial", new int[]{472, 391, 41, 41});
        addClickableAreas("exit1", new int[]{0,0,322,500});
        addClickableAreas("exit2", new int[]{577,0,900,500});
    }

    @Override
    public void onClick(int[] clickedPosition) {
        String clickedArea = getClickedArea(clickedPosition);
        if (clickedArea != null) {
            switch (clickedArea) {
                case "map":
                    getInteractionHandler().getGameContainer().setPopup(new PhoneMapScreenPopup(getInteractionHandler(), "PhoneMap", "PhoneMap"));
                    break;
                case "dial":
                    getInteractionHandler().getGameContainer().setPopup(new PhoneDialScreenPopup(getInteractionHandler(), "PhoneMap", "PhoneDialScreen"));
                    break;
                case "exit1":
                case "exit2":
                    getInteractionHandler().getGameContainer().setPopup(null);
                    break;
            }
        }
    }
}
