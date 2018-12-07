/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.presentation.rendering;

import java.io.IOException;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import oop_sem1_project.presentation.WOSController;
import oop_sem1_project.presentation.WOSHighscoreController;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class Renderer {

    /**
     * The ImageView of the player. ImageView is used to be able to rotate.
     */
    private final ImageView player = new ImageView(new Image(WOSController.class.getResourceAsStream("images/player.png")));

    /**
     * An instance of the WOSController to access the canvases.
     */
    private final WOSController controller;

    /**
     * Construct a new Renderer.
     *
     * @param controller The instance of the WOSController.
     */
    public Renderer(WOSController controller) {
        this.controller = controller;
    }

    /**
     * Re-draws everything on the canvas based on the received dataList.
     *
     * @param dataList The list that specifies where something should be drawn.
     */
    public void requestGraphicalUpdate(List<String[]> dataList) {
        // Main purpose of the PackeInterpreter is to convert the dataList to something more specific
        // than arbritray abbrevations and random array positions. Aids readability.
        PackeInterpreter packet = new PackeInterpreter(dataList);
        GraphicsContext gameCanvas = this.controller.getGameCanvas().getGraphicsContext2D();

        gameCanvas.drawImage(new Image(WOSController.class.getResourceAsStream("images/" + packet.getBackground() + ".png")), 0, 0);
        this.player.setRotate(packet.getPlayerRotation());
        SnapshotParameters snapshotParameters = new SnapshotParameters();
        snapshotParameters.setFill(Color.TRANSPARENT);
        gameCanvas.drawImage(this.player.snapshot(snapshotParameters, null), packet.getPlayerX(), packet.getPlayerY());

        if (!packet.getCurrentItem().isEmpty()) {
            this.controller.getItemImageView().setImage(new Image(WOSController.class.getResourceAsStream("images/" + packet.getCurrentItem() + ".png")));
        }
        
        this.controller.getTextArea().appendText(packet.getMessage().isEmpty() ? "" : "──────────────────────────────────────────────────────────────────────────────\n" +packet.getMessage() + "\n");

        if (!packet.getPopupImage().isEmpty()) {
            gameCanvas.drawImage(new Image(WOSController.class.getResourceAsStream("images/" + packet.getPopupImage() + ".png")), 0, 0);
        }

        this.controller.getPhoneNumberArea().setText(packet.getPhoneNumber());
        this.controller.getPhoneNumberArea().setVisible(!packet.getPhoneNumber().isEmpty());
        
        if (packet.isOpenQuiz()) {
            this.controller.openQuiz();
        }
    }
}
