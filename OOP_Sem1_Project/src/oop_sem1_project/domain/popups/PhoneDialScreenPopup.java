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
public class PhoneDialScreenPopup extends Popup {

    public PhoneDialScreenPopup(InteractionHandlerImpl interactionHandler, String dialPhone, String phoneDialScreen) {
        super(interactionHandler, dialPhone, phoneDialScreen);
        addClickableAreas("home", new int[]{109, 452, 40, 40});
        addClickableAreas("b1", new int[]{21, 222, 79, 40});
        addClickableAreas("b2", new int[]{100, 222, 56, 40});
        addClickableAreas("b3", new int[]{156, 222, 79, 40});
        addClickableAreas("b4", new int[]{21, 256, 79, 40});
        addClickableAreas("b5", new int[]{100, 256, 56, 40});
        addClickableAreas("b6", new int[]{156, 256, 79, 40});
        addClickableAreas("b7", new int[]{21, 302, 79, 40});
        addClickableAreas("b8", new int[]{100, 302, 56, 40});
        addClickableAreas("b9", new int[]{156, 302, 79, 40});
        addClickableAreas("b0", new int[]{100, 342, 56, 40});
        addClickableAreas("dial", new int[]{100, 392, 56, 45});
        addClickableAreas("delete", new int[]{216, 173, 29, 41});

    }

    @Override
    public void onClick(int[] clickedPosition) {
        String clickedArea = getClickedArea(clickedPosition);
        if (clickedArea != null) {
            StringBuilder pn = getInteractionHandler().getDataPacket().getPhoneNumber();
            switch (clickedArea) {
                case "home":
                    getInteractionHandler().getGameContainer().setPopup(new PhoneMainScreenPopup(this.getInteractionHandler(), "Phone", "PhoneMainScreen"));
                    break;
                case "b1":
                    if (pn.length() < 8) {
                        pn.append('1');
                        break;
                    }
                    whoCall();
                    break;
                case "b2":
                    if (pn.length() < 8) {
                        pn.append('2');
                        break;
                    }
                    whoCall();
                    break;
                case "b3":
                    if (pn.length() < 8) {
                        pn.append('3');
                        break;
                    }
                    whoCall();
                    break;
                case "b4":
                    if (pn.length() < 8) {
                        pn.append('4');
                        break;
                    }
                    whoCall();
                    break;
                case "b5":
                    if (pn.length() < 8) {
                        pn.append('5');
                        break;
                    }
                    whoCall();
                    break;
                case "b6":
                    if (pn.length() < 8) {
                        pn.append('6');
                        break;
                    }
                    whoCall();
                    break;
                case "b7":
                    if (pn.length() < 8) {
                        pn.append('7');
                        break;
                    }
                    whoCall();
                    break;
                case "b8":
                    if (pn.length() < 8) {
                        pn.append('8');
                        break;
                    }
                    whoCall();
                    break;
                case "b9":
                    if (pn.length() < 8) {
                        pn.append('9');
                        break;
                    }
                    whoCall();
                    break;
                case "b0":
                    if (pn.length() < 8) {
                        pn.append('0');
                        break;
                    }
                    whoCall();
                    break;
                case "dial":
                    if (pn.toString().equals("112")) {
                        getInteractionHandler().getDataPacket().setTextField("You call 112 an state your name, emergency and the current address");
                        break;
                    }
                    whoCall();
                    break;
                case "delete":
                    if (pn.length() != 0) {
                        pn.setLength(pn.length() - 1);
                        break;
                    }
                    break;
            }
        }
    }

    private void whoCall() {
        getInteractionHandler().getDataPacket().setTextField("Where are you trying to call with a number larger than 8 digits?");
    }

}
