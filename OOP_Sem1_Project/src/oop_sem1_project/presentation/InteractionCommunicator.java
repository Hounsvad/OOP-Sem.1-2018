/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.presentation;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class InteractionCommunicator {

    public InteractionCommunicator() {
        //TODO
    }

    public void keyPressed(KeyEvent keyEvent) {
        System.out.println(keyEvent);
    }

    public void mouseClicked(ClickedNode clickedNode, MouseEvent mouseEvent) {
        System.out.println(clickedNode + " | " + mouseEvent);
    }
}
