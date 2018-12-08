package oop_sem1_project.presentation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import oop_sem1_project.presentation.audio.WOSMediaPlayer;
import oop_sem1_project.presentation.rendering.Renderer;

/**
 * The main World of Safety FXML Controller class. This class initializes all of
 * the nodes on the scene, the event listeners, and the InteractionCommunicator.
 *
 * @author Benjamin Staugaard | Benz56
 */
public class WOSController implements Initializable {

    /**
     * An instance of the InteractionCommunicator used to communicate the events
     * received from the various listeners in this controller.
     */
    private final InteractionCommunicator interactionCommunicator = new InteractionCommunicator(new Renderer(this));

    /**
     * An instance of our media player. This is used to play game music and
     * various sounds.
     */
    private final WOSMediaPlayer mediaPlayer = new WOSMediaPlayer();

    /**
     * The main SplitPane that separates the Game Canvas from the Phone Canvas,
     * Item Canvas, and TextArea.
     */
    @FXML
    private SplitPane splitPane;

    /**
     * The Canvas on which the game backgrounds and player are drawn.
     */
    @FXML
    private Canvas gameCanvas;

    /**
     * The VBox containing all of the start menu nodes.
     */
    @FXML
    private VBox menu;

    /**
     * The TextField in which the player's name is inputted before game start.
     */
    @FXML
    private TextField nameTextField;

    /**
     * The TextField in which the last score attempt is shown.
     */
    @FXML
    private TextField lastScoreTextField;

    /**
     * The phones Pane. The image of the phone is automatically set in the FXML
     * document.
     */
    @FXML
    private Pane phonePane;

    /**
     * The ImageView on which the player's current item is to be shown.
     */
    @FXML
    private ImageView itemImageView;

    /**
     * The TextArea in which all game messages are displayed.
     */
    @FXML
    private TextArea textArea;

    /**
     * The transparent Text node used to display the phone number in a way that
     * looks natural/correct in accordance to a real phone.
     */
    @FXML
    private Text phoneNumberArea;

    /**
     * Initializes the controller class.
     *
     * @param location The location used to resolve relative paths for the root
     * object, or null if the location is not known.
     * @param resources The resources used to localize the root object, or null
     * if the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // getScene() returns null in the initialize method as it hasn't actually been initialized yet.
        // The below allows us to wait/listen for the scene to be set before setting the constant focus on the scene.
        // The constant focus is needed to not obstruct the click- or key listeners due to lost focus.
        this.splitPane.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (oldScene == null && newScene != null) {
                newScene.getRoot().requestFocus();
                newScene.getRoot().focusedProperty().addListener((obs, oldFocus, newFocus) -> {
                    if (!this.menu.isVisible()) { // Game is started
                        newScene.getRoot().requestFocus();
                    }
                });
            }
        });
        this.textArea.editableProperty().set(false);
    }

    /**
     * Fired when the start button is clicked. The method ensures that a name
     * has been inputted. If the name is empty the focus is moved to the name
     * input field. If a name is specified the game is started.
     */
    @FXML
    private void startButtonEvent() {
        if (this.nameTextField.getText().isEmpty()) {
            this.nameTextField.requestFocus();
        } else {
            this.menu.setVisible(false);
            this.splitPane.requestFocus();
            this.interactionCommunicator.startClicked(this.nameTextField.getText());
            setInputListeners(true);
        }
    }

    /**
     * Fired when the high score button is clicked. This opens a new window on
     * top of the current with all of the currently stored high scores.
     */
    @FXML
    private void highscoreButtonEvent() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("WOSHighscore.fxml"));
            Stage stage = new Stage();

            // Makes sure the window is positioned correctly (centered) relative to the current position of the main window.
            Bounds localToScreen = this.splitPane.localToScreen(this.splitPane.getBoundsInLocal());
            stage.setX(localToScreen.getMinX() + 350);
            stage.setY(localToScreen.getMinY() + 33);

            // Remove the windows top bar.
            stage.initStyle(StageStyle.UNDECORATED);

            // If the window/stage loses focus i.e. a click outside of the stage it is closed.
            stage.focusedProperty().addListener((observable, oldFocus, newFocus) -> {
                if (!newFocus) {
                    stage.close();
                }
            });

            Scene scene = new Scene(loader.load());

            // Get the loaders controller which is an instance of WOSHighscoreController, cast it, and set list of stored high scores.
            ((WOSHighscoreController) loader.getController()).setScoreList(this.interactionCommunicator.highscoreClicked());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
        }
    }

    /**
     * Called when the game is finished and the quiz is to be started.
     */
    public void openQuiz() {
        setInputListeners(false);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("WOSQuiz.fxml"));
            Stage stage = new Stage();

            // Makes sure the window is positioned correctly (centered) relative to the current position of the main window.
            Bounds localToScreen = this.splitPane.localToScreen(this.splitPane.getBoundsInLocal());
            stage.setX(localToScreen.getMinX() + 257);
            stage.setY(localToScreen.getMinY() + 33);

            // Remove the windows top bar.
            stage.initStyle(StageStyle.UNDECORATED);

            stage.setAlwaysOnTop(true);
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
        }
    }

    /**
     * Set whether to listen for click- and keypress events. This is needed as
     * to not cause interactions with certain nodes before it is needed.
     *
     * @param input True to enable listeners; False to disable.
     */
    public void setInputListeners(boolean input) {
        this.gameCanvas.setOnMouseClicked(!input ? null : event -> this.interactionCommunicator.mouseClickedEvent(ClickedNode.GAME_CANVAS, event));
        this.phonePane.setOnMouseClicked(!input ? null : event -> this.interactionCommunicator.mouseClickedEvent(ClickedNode.PHONE_CANVAS, event));
        this.itemImageView.setOnMouseClicked(!input ? null : event -> this.interactionCommunicator.mouseClickedEvent(ClickedNode.ITEM_CANVAS, event));
        this.splitPane.getScene().getRoot().setOnKeyPressed(!input ? null : event -> this.interactionCommunicator.keyEvent(event.getCode()));
    }

    /**
     * @return The instance of the InteractionCommunicator.
     */
    public InteractionCommunicator getInteractionCommunicator() {
        return interactionCommunicator;
    }

    /**
     * @return The instance of the WOSMediaPlayer.
     */
    public WOSMediaPlayer getWOSMediaPlayer() {
        return mediaPlayer;
    }
    
    /**
     * @return The instance of the last score TextField.
     */
    public TextField getLastScoreTextField() {
        return this.lastScoreTextField;
    }

    /**
     * @return The instance of the game Canvas.
     */
    public Canvas getGameCanvas() {
        return this.gameCanvas;
    }

    /**
     * @return The instance of the item ImageView.
     */
    public ImageView getItemImageView() {
        return this.itemImageView;
    }

    /**
     * @return The instance of the messages TextArea.
     */
    public TextArea getTextArea() {
        return this.textArea;
    }

    /**
     * @return The instance of the phone number Text node.
     */
    public Text getPhoneNumberArea() {
        return phoneNumberArea;
    }
}
