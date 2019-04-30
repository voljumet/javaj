import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class PipeBuildSound {

    public PipeBuildSound() throws LineUnavailableException, IOException, UnsupportedAudioFileException {

        if (!Controller.debugMode) {
            if (Controller.count < 31) {
                File PipeBuildSound = new File("Sounds/PipeBuildSound.wav");
                AudioInputStream AISPipeBuildSound = AudioSystem.getAudioInputStream(PipeBuildSound);
                Clip PipeBuildSoundClip = AudioSystem.getClip();
                PipeBuildSoundClip.open(AISPipeBuildSound);
                PipeBuildSoundClip.start();
            } else {
                File PipeBuildSound = new File("Sounds/Platform.wav");
                AudioInputStream AISPipeBuildSound = AudioSystem.getAudioInputStream(PipeBuildSound);
                Clip PipeBuildSoundClip = AudioSystem.getClip();
                PipeBuildSoundClip.open(AISPipeBuildSound);
                PipeBuildSoundClip.start();
            }
        }
    }
}