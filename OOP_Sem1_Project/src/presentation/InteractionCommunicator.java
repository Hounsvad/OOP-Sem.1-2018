/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.util.Arrays;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import oop_sem1_project.domain.InteractionHandler;
import oop_sem1_project.domain.InteractionHandlerImpl;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class InteractionCommunicator {

    /**
     * InteractionHandlerImpl.
     */
    private final InteractionHandler interactionHandler = new InteractionHandlerImpl();
    private final WOSController controller;

    /**
     * Constructs a new InteractionCommunicator which instantiates a new
     * InteractionHandlerImpl.
     *
     * @param controller The instance of the WOSController.
     */
    public InteractionCommunicator(WOSController controller) {
        this.controller = controller;
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
        this.interactionHandler.mouseClick(clickedNode.toString(), mouseEvent);
    }

    /**
     * Called when the start button is clicked on the main menu.
     *
     * @param name The name of the Player.
     */
    public void startClicked(String name) {
    }

    /**
     * Called when the highscore button is clicked.
     */
    public void highscoreClicked() {
    }
}
