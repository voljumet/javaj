import javax.swing.*;
import java.awt.*;

public class MobsElement extends GraphicalElement {

        int mobSize;
        int mobArmySize;
        int mobNumber;
        Rectangle MobReach;

        public MobsElement() {

                MobReach = new Rectangle(posX,posY,100,100);
                mobSize = 45;
                height = mobSize;
                width = mobSize;
                description = "MobsElement";
                i = new ImageIcon("Pictures/Icons/Iconse-01.png");
                image = i.getImage();
        }
}


