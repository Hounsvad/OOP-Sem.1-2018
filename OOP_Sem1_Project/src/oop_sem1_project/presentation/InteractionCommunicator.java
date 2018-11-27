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

    /**
     * InteractionHandler.
     */
    private final InteractionHandler interactionHandler;

    /**
     * Constructs a new InteractionCommunicator which instantiates a new
     * InteractionHandler.
     */
    public InteractionCommunicator() {
        this.interactionHandler = new InteractionHandler();
    }

    /**
     * Called when any key is pressed. If the key is WASD or an arrow key it is
     * handled in the domain layer.
     *
     * @param keycode The code of the key pressed.
     */
    public void keyEvent(KeyCode keycode) {
        if (Arrays.asList(KeyCode.W, KeyCode.A, KeyCode.S, KeyCode.D, KeyCode.UP, KeyCode.DOWN, KeyCode.LEFT, KeyCode.RIGHT).contains(keycode)) {
            this.interactionHandler.keyEvent(keycode);
        }
    }

    /**
     * Called when the Game-, Phone- or Item Canvas is clicked.
     *
     * @param clickedNode The clicked canvas.
     * @param mouseEvent The MouseEvent.
     */
    public void mouseClickedEvent(ClickedNode clickedNode, MouseEvent mouseEvent) {
        interactionHandler.mouseClick(clickedNode.toString(), mouseEvent);
    }
}
