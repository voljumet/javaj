import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {

    File BoomSound = new File("Sounds/Boom.wav");
    AudioInputStream BoomSSound = AudioSystem.getAudioInputStream(BoomSound);
    Clip BoomSSSound = AudioSystem.getClip();


    Sound() throws IOException, UnsupportedAudioFileException, LineUnavailableException { BoomSSSound.open(BoomSSound);}

    void BoomSound() {

        BoomSSSound.start();
        BoomSSSound.stop();
    }
}
