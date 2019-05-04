import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Towers extends GraphicalElement {
    Rectangle TowerReach;
    Rectangle TowerOverlap;
    int towerSize = 70;

    MobsElement target = null;
    private ImageIcon tower1 = new ImageIcon("Pictures/Icons/Towers-01.png");


    // variables for circle range for tower

//    public Towers(){
//        int towerSize = 70;
//
//        int PictureNumber = 1;  //"+PictureNumber+"+
//        height = towerSize;
//        width = towerSize;
//
//
//        img = new ImageIcon("Pictures/Icons/Towers-0"+PictureNumber+".png");
//        image = img.getImage();
//
//
//    }

    public Towers(int posX, int posY){

        height = towerSize;
        width = towerSize;

        img = tower1;
        image = img.getImage();





        this.posX = posX;
        this.posY = posY;

        TowerReach = new Rectangle((this.posX - 115), (this.posY - 115), 200, 200);
        TowerOverlap = new Rectangle(this.posX - towerSize/2, this.posY - towerSize/2, towerSize, towerSize);


    }


    @Override
    public void Draw(Graphics g) {
        g.drawImage(image, posX, posY, width, height, null);
    }

}
