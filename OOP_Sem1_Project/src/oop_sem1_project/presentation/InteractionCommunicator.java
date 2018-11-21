/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.presentation;

import java.util.Arrays;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class InteractionCommunicator {

    public InteractionCommunicator() {
        //TODO
    }

    public void keyEvent(KeyCode keycode) {
        if (Arrays.asList(KeyCode.W, KeyCode.A, KeyCode.S, KeyCode.D).contains(keycode)) {
            //DO stuff
            System.out.println(keycode);
        }
    }

    public void mouseClickedEvent(ClickedNode clickedNode, MouseEvent mouseEvent) {
        System.out.println(clickedNode + " | " + mouseEvent);
    }
}
