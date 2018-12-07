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
        addClickableAreas("home", new int[]{431, 452, 40, 40});
        addClickableAreas("b1", new int[]{343, 222, 79, 40});
        addClickableAreas("b2", new int[]{422, 222, 56, 40});
        addClickableAreas("b3", new int[]{478, 222, 79, 40});
        addClickableAreas("b4", new int[]{343, 256, 79, 40});
        addClickableAreas("b5", new int[]{422, 256, 56, 40});
        addClickableAreas("b6", new int[]{478, 256, 79, 40});
        addClickableAreas("b7", new int[]{343, 302, 79, 40});
        addClickableAreas("b8", new int[]{422, 302, 56, 40});
        addClickableAreas("b9", new int[]{478, 302, 79, 40});
        addClickableAreas("b0", new int[]{422, 342, 56, 40});
        addClickableAreas("dial", new int[]{422, 392, 56, 45});
        addClickableAreas("delete", new int[]{538, 173, 29, 41});

    }

    @Override
    public void onClick(int[] clickedPosition) {
        String clickedArea = getClickedArea(clickedPosition);
        if (clickedArea != null) {
            StringBuilder pn = getInteractionHandler().getDataPacket().getPhoneNumber();
            switch (clickedArea) {
                case "home":
                    pn.setLength(0);
                    getInteractionHandler().getGameContainer().setPopup(new PhoneMainScreenPopup(this.getInteractionHandler(), "Phone", "PhoneHomeScreen"));
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
                        if (getInteractionHandler().getGameContainer().getPlayer().getProgress() == 8){
                            getInteractionHandler().getDataPacket().setTextField("You call 112 and state your name, emergency and the current address");
                            getInteractionHandler().getGameContainer().getPlayer().setProgress(getInteractionHandler().getGameContainer().getPlayer().getProgress() + 1);
                        } else {
                             getInteractionHandler().getDataPacket().setTextField("If there isn't any serious emergency, you shouldn't call 112");
                             }
                        break;
                    } else if (pn.toString().equals("65508888")) {
                        if (getInteractionHandler().getGameContainer().getPlayer().getProgress() == 9) {
                        getInteractionHandler().getDataPacket().setTextField("You call 65508888, the SDU emergency hotline \nYou state your Name and what happened \nThe friendly voice assures you its gonna be alright, but you should probably evacuate to the rallypoint");
                        getInteractionHandler().getGameContainer().getPlayer().setProgress(getInteractionHandler().getGameContainer().getPlayer().getProgress() + 1);
                        } else {
                            getInteractionHandler().getDataPacket().setTextField("You should only call 65508888 if there is an actual emergency at SDU!");
                            }
                        break;
                    } else if (pn.toString().equals("88888888")) {
                        getInteractionHandler().getDataPacket().setTextField("'Hello, this is leasy. How may I help you?' \nYou end the call. Why would you do that at such a time?");
                        break;
                    }
                    String[] randomCall = {
                        "'Hello, you have called the Donald Trump Donation line. Thank you for your donation of 100$, which will be used for the wall' \nYou put the phone down and end the call. This is not the time for such activities.",
                        "'Mission is a go. Eliminate the target within 2 hours for a bonus. We won't speak again.' \nThe other side hangs up and you are left confused and a bit scared.",
                        "'Olleh t'is Erik. What can I do you for?' \nYou apologize and end the call. Why bother such a nice man",
                        "The phone is picked up and you hear somebody pacing back and forth. \nThe person on the other end start speaking a weird mix of some nordic language and english programming terms. \nThis makes no sense and you hang up.",
                        "'Duuuuuuuuuuuuuuuuuuuuuuun\n"
                        + "Dun dun dun dun dun dun dun dun dun dun dun dundun dun dundundun dun dun dun dun dun dun dundun dundun\n"
                        + "BOOM\n"
                        + "Dundun dundun dundun\n"
                        + "BEEP\n"
                        + "Dun dun dun dun dun\n"
                        + "Dun dun\n"
                        + "BEEP BEEP BEEP BEEP\n"
                        + "BEEEP BEEP BEEP BEEP\n"
                        + "BEEP BEEP BEEP BEEP BEEP BEEP BEEP BEEP BEEP BEEP BOOM\n"
                        + "Daddaddadadsadadadadadadadadadaddadadadadadaddadadaddadadadadadadadadadadadaddadddadaddadadadd dadadadaddaddada\n"
                        + "D\n"
                        + "Dadadddaddadaddadadadddadadada'... That was a very rude sandstorm. You hang up.",
                        "'We're no strangers to love\n"
                        + "You know the rules and so do I\n"
                        + "A full commitment's what I'm thinking of\n"
                        + "You wouldn't get this from any other guy\n"
                        + "I just wanna tell you how I'm feeling\n"
                        + "Gotta make you understand\n"
                        + "Never gonna give you up\n"
                        + "Never gonna let you down\n"
                        + "Never gonna run around and desert you\n"
                        + "Never gonna make you cry\n"
                        + "Never gonna say goodbye\n"
                        + "Never gonna tell a lie and hurt you', It seems like you just got rick rolled"
                    };
                    getInteractionHandler().getDataPacket().setTextField(randomCall[(int) (Math.random() * randomCall.length)]);
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
