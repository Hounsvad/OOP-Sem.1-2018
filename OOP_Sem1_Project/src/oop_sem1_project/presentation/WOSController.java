/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.presentation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.canvas.Canvas;

/**
 * FXML Controller class
 *
 * @author Benjamin Staugaard | Benz56
 */
public class WOSController implements Initializable {

    //TEMPORARY
    private final InteractionCommunicator interactionCommunicator = new InteractionCommunicator();

    @FXML
    private SplitPane splitPane;

    @FXML
    private Canvas gameCanvas;

    @FXML
    private Canvas phoneCanvas;

    @FXML
    private Canvas itemCanvas;

    @FXML
    private TextArea textArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // getScene() returns null in the initialize method.
        // The below allows us to wait for the scene to be set before setting the EventHandler and the constant focus.
        this.splitPane.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (oldScene == null && newScene != null) {
                newScene.getRoot().requestFocus();
                newScene.getRoot().focusedProperty().addListener((obs, oldValue, newValue) -> newScene.getRoot().requestFocus());
                newScene.getRoot().setOnKeyPressed(event -> interactionCommunicator.keyEvent(event.getCode()));
            }
        });
        this.gameCanvas.setOnMouseClicked(event -> interactionCommunicator.mouseClickedEvent(ClickedNode.GAME_CANVAS, event));
        this.phoneCanvas.setOnMouseClicked(event -> interactionCommunicator.mouseClickedEvent(ClickedNode.PHONE_CANVAS, event));
        this.itemCanvas.setOnMouseClicked(event -> interactionCommunicator.mouseClickedEvent(ClickedNode.ITEM_CANVAS, event));
        this.textArea.editableProperty().set(false);
    }
}
