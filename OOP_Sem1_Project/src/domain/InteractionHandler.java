/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public interface InteractionHandler {

    void keyEvent(KeyCode keycode);

    void mouseClick(String clickedNode, MouseEvent mouseEvent);
}