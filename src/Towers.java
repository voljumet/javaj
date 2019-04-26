import javax.swing.*;
import java.awt.*;

public class Towers extends GraphicalElement {
    Rectangle TowerReach;
    int UpgradeCount;

    public Towers(){


        posX = 0;
        posY = 0;
        height = 70;
        width = 70;
        i = new ImageIcon("Pictures/Icons/Towers-01.png");
        image = i.getImage();

        TowerReach = new Rectangle(posX -100, posY - 100, 200, 200);
    }
}
