import javax.swing.*;
import java.awt.*;

public abstract class MobsElement extends GraphicalElement {

        boolean inGame = false;

        int mapPlace;
        int mobSize;
        int PictureNumber;
        int mobHealth;
        int mobPayout;
        int mobArmySize;
        double distance;
        int mobNR;
        Rectangle MobReach;

        public MobsElement() {

                mobSize = 45;
                height = mobSize;
                width = mobSize;
                mobNR = 0;

                img = new ImageIcon();
                image = img.getImage();
        }

        @Override
        public void Draw(Graphics g) {
                g.drawImage(image, posX, posY, width, height, null);
                MobReach = new Rectangle((posX - 22), (posY-23),45,45);
        }
}


