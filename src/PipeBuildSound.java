import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class PipeBuildSound {

    public PipeBuildSound() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        
    File PipeBuildSound = new File("Sounds/Pipe.wav");
    AudioInputStream AISPipeBuildSound = AudioSystem.getAudioInputStream(PipeBuildSound);
    Clip PipeBuildSoundClip = AudioSystem.getClip();
    PipeBuildSoundClip.open(AISPipeBuildSound);
    PipeBuildSoundClip.start();
    }
}