import javax.swing.*;
import java.awt.*;

public abstract class MobsElement extends GraphicalElement {

        Direction dir = Direction.DOWN_UP;

        int mapPlace;
        int mobSize;
        int PictureNumber;
        int mobHealth;
        int mobPayout;
        int mobArmySize;
        Rectangle MobReach;

        public MobsElement() {

                mobSize = 45;
                height = mobSize;
                width = mobSize;

                MobReach = new Rectangle(posX, posY,45,45);

                img = new ImageIcon();
                image = img.getImage();

        }

        @Override
        public void Draw(Graphics g) {
                g.drawImage(image, posX, posY, width, height, null);
        }
}


