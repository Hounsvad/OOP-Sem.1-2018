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
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import oop_sem1_project.presentation.rendering.Renderer;

/**
 * FXML Controller class
 *
 * @author Benjamin Staugaard | Benz56
 */
public class WOSController implements Initializable {

    private final InteractionCommunicator interactionCommunicator = new InteractionCommunicator(this);
    private final Renderer renderer = new Renderer(this);

    @FXML
    private SplitPane splitPane;
    
    @FXML
    private Canvas gameCanvas;
    
    @FXML
    private Canvas menuCanvas;
    
    @FXML
    private VBox menu;
    
    @FXML
    private TextField nameTextField;
    
    @FXML
    private TextField lastScoreTextField;
    
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
                newScene.getRoot().focusedProperty().addListener((obs, oldValue, newValue) -> {
                    if (!this.menu.isVisible()) { // Game is started
                        newScene.getRoot().requestFocus();
                    }
                });
                newScene.getRoot().setOnKeyPressed(event -> this.interactionCommunicator.keyEvent(event.getCode()));
            }
        });
        this.gameCanvas.setOnMouseClicked(event -> this.interactionCommunicator.mouseClickedEvent(ClickedNode.GAME_CANVAS, event));
        this.phoneCanvas.setOnMouseClicked(event -> this.interactionCommunicator.mouseClickedEvent(ClickedNode.PHONE_CANVAS, event));
        this.itemCanvas.setOnMouseClicked(event -> this.interactionCommunicator.mouseClickedEvent(ClickedNode.ITEM_CANVAS, event));
        this.textArea.editableProperty().set(false);
    }

    @FXML
    private void startButtonEvent() {
        if (this.nameTextField.getText().isEmpty()) {
            this.nameTextField.requestFocus();
        } else {
            toggleMenu();
            this.interactionCommunicator.startClicked(this.nameTextField.getText());
        }
    }

    @FXML
    private void highscoreButtonEvent() {
        this.interactionCommunicator.highscoreClicked();
    }

    public void toggleMenu() {
        this.menu.setVisible(!this.menu.isVisible());
        this.menuCanvas.setVisible(!this.menuCanvas.isVisible());
        this.splitPane.requestFocus();
    }

    public InteractionCommunicator getInteractionCommunicator() {
        return interactionCommunicator;
    }

    public Canvas getMenuCanvas() {
        return this.menuCanvas;
    }

    public TextField getLastScoreTextField() {
        return this.lastScoreTextField;
    }

    public Canvas getGameCanvas() {
        return this.gameCanvas;
    }

    public Canvas getPhoneCanvas() {
        return this.phoneCanvas;
    }

    public Canvas getItemCanvas() {
        return this.itemCanvas;
    }

    public TextArea getTextArea() {
        return this.textArea;
    }

    public Renderer getRenderer() {
        return this.renderer;
    }
}
