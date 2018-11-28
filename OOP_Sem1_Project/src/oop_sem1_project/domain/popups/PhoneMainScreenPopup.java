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
    }

    @Override
    public void onClick(int[] clickedPosition) {
        String clickedArea = getClickedArea(clickedPosition);
        if (clickedArea != null) {
            switch (clickedArea) {
                case "map":
                    getInteractionHandler().setPopup(new PhoneMapScreenPopup(getInteractionHandler(), "MapPhone", "PhoneMapScreen"));
                    break;
                case "dial":
                    getInteractionHandler().setPopup(new PhoneDialScreenPopup(getInteractionHandler(), "MapPhone", "PhoneDialScreen"));
            }
        }
    }
}
