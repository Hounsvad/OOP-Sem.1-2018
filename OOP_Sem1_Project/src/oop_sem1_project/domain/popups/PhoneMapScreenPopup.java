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

    public PhoneMapScreenPopup(InteractionHandlerImpl interactionHandler, String mapPhone, String phoneMapScreen) {
        super(interactionHandler, mapPhone, mapPhone);
    }

    @Override
    public void onClick(int[] clickedPosition) {
    }
}
