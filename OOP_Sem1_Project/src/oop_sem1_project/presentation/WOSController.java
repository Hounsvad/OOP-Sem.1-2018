/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.presentation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
    private Pane phoneCanvas;

    @FXML
    private ImageView itemImageView;

    @FXML
    private TextArea textArea;

    @FXML
    private Text phoneNumberArea;

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
        this.textArea.editableProperty().set(false);
    }

    @FXML
    private void startButtonEvent() {
        if (this.nameTextField.getText().isEmpty()) {
            this.nameTextField.requestFocus();
        } else {
            toggleMenu();
            this.interactionCommunicator.startClicked(this.nameTextField.getText());
            this.gameCanvas.setOnMouseClicked(event -> this.interactionCommunicator.mouseClickedEvent(ClickedNode.GAME_CANVAS, event));
            this.phoneCanvas.setOnMouseClicked(event -> this.interactionCommunicator.mouseClickedEvent(ClickedNode.PHONE_CANVAS, event));
            this.itemImageView.setOnMouseClicked(event -> this.interactionCommunicator.mouseClickedEvent(ClickedNode.ITEM_CANVAS, event));
        }
    }

    @FXML
    private void highscoreButtonEvent() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("WOSHighscore.fxml"));
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    stage.close();
                }
            });
            Scene scene = new Scene(loader.load());
            ((WOSHighscoreController) loader.getController()).setScoreList(this.interactionCommunicator.highscoreClicked());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
        }
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

    public ImageView getItemImageView() {
        return this.itemImageView;
    }

    public TextArea getTextArea() {
        return this.textArea;
    }

    public Renderer getRenderer() {
        return this.renderer;
    }

    public Text getPhoneNumberArea() {
        return phoneNumberArea;
    }
}
