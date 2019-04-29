import javax.swing.*;
import java.awt.*;

public class MobsElement extends GraphicalElement {

        int mobSize;
        int mobArmySize;
        int mobCount;
        int mobPictureNumber = 1;
        int mobHealth;
        int mobPayout;
        Rectangle MobReach;

        public MobsElement() {

                MobReach = new Rectangle(posX,posY,100,100);
                mobSize = 45;
                height = mobSize;
                width = mobSize;
                description = "MobsElement";
//                mobPosX = PPListXY.PPX.get(0);
//                mobPosY = 810;

                i = new ImageIcon();
                image = i.getImage();
        }
}


