/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.presentation;

import java.util.Arrays;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import oop_sem1_project.domain.InteractionHandler;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class InteractionCommunicator {

    private final InteractionHandler interactionHandler;

    public InteractionCommunicator() {
        this.interactionHandler = new InteractionHandler();
    }

    public void keyEvent(KeyCode keycode) {
        if (Arrays.asList(KeyCode.W, KeyCode.A, KeyCode.S, KeyCode.D, KeyCode.UP, KeyCode.DOWN, KeyCode.LEFT, KeyCode.RIGHT).contains(keycode)) {
            this.interactionHandler.keyEvent(keycode);
        }
    }

    public void mouseClickedEvent(ClickedNode clickedNode, MouseEvent mouseEvent) {
        interactionHandler.mouseClick(clickedNode, mouseEvent);
    }
}
