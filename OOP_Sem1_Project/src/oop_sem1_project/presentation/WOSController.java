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
import javafx.scene.canvas.Canvas;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Benjamin Staugaard | Benz56
 */
public class WOSController implements Initializable {

    //TEMPORARY
    private final InteractionCommunicator interactionCommunicator = new InteractionCommunicator();

    @FXML
    private SplitPane root;

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
        // The below allows us to wait for the scene to be set before setting the EventHandler.
        this.root.sceneProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue == null && newValue != null) {
                newValue.setOnKeyReleased(event -> interactionCommunicator.keyPressed(event));
            }
        });
        this.gameCanvas.setOnMouseClicked(event -> interactionCommunicator.mouseClicked(ClickedNode.GAME_CANVAS, event));
        this.phoneCanvas.setOnMouseClicked(event -> interactionCommunicator.mouseClicked(ClickedNode.PHONE_CANVAS, event));
        this.itemCanvas.setOnMouseClicked(event -> interactionCommunicator.mouseClicked(ClickedNode.ITEM_CANVAS, event));
        this.textArea.editableProperty().set(false);
    }
}
