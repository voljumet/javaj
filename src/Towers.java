import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Towers extends GraphicalElement {
    Rectangle TowerReach;

    // variables for circle range for tower

    public Towers(){
        int towerSize = 70;

        height = towerSize;
        width = towerSize;

        img = tower1;
        image = img.getImage();

    }

    private ImageIcon tower1 = new ImageIcon("Pictures/Icons/Towers-01.png");

    @Override
    public void Draw(Graphics g) {
        g.drawImage(image, posX, posY, width, height, null);
        TowerReach = new Rectangle((posX - 115), (posY - 115), 200, 200);



    }

}
