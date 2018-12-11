package oop_sem1_project.presentation.audio;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * This class is in charge of playing game music and individual sounds.
 *
 * @author Benjamin Staugaard | Benz56
 */
public class WOSMediaPlayer {

    /**
     * A constant defining the location of the media/audio files.
     */
    private final static String MEDIA_LOCATION = "src/oop_sem1_project/presentation/audio/";

    /**
     * If the MediaPlayer instance is declared locally it is garbage collected
     * and the music is stopped. Declaring it as an instance variable prevents
     * it from being garbage collected. The variable is not used again.
     */
    private final MediaPlayer mainTrackMediaPlayer;

    /**
     * Constructs a new WOSMediaPlayer and starts the game music in an infinite
     * loop.
     */
    public WOSMediaPlayer() {
        this.mainTrackMediaPlayer = new MediaPlayer(new Media(new File(MEDIA_LOCATION + "MainTrack.mp3").toURI().toString()));
        this.mainTrackMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        this.mainTrackMediaPlayer.setVolume(0.1);
        this.mainTrackMediaPlayer.play();
    }

    /**
     * Plays the specified sound once.
     *
     * @param sound The name of the sound to be played.
     */
    public void playSound(String sound) {
        new MediaPlayer(new Media(new File(MEDIA_LOCATION + sound + ".mp3").toURI().toString())).play();
    }
}
