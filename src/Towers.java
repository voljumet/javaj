import javax.swing.*;
import java.awt.*;

public class Towers extends GraphicalElement {
    Rectangle TowerReach;

    public Towers(){
        int towerSize = 70;

        int PictureNumber = 1;  //"+PictureNumber+"+
        height = towerSize;
        width = towerSize;

        img = new ImageIcon("Pictures/Icons/Towers-0"+PictureNumber+".png");
        image = img.getImage();

//        TowerReach = new Rectangle(posX, posY, 300, 300);

    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(image, posX, posY, width, height, null);

    }
}
