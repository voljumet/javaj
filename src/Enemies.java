import javax.swing.*;
import java.awt.*;

public class Enemies extends GraphicalElement {
        Rectangle EnemyReach;

        public  Enemies() {

                posY = 400;
                posX = 400;
                height = 80;
                width = 80;
                description = "Enemies";
                i = new ImageIcon("Pictures/Icons/Iconse-01.png");
                image = i.getImage();

                EnemyReach = new Rectangle(posX, posY, 80, 80);
        }
}


