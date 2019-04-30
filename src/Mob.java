import javax.swing.*;

public class Mob extends MobsElement{

    public Mob(){

        posX = (PPListXY.PPX.get(0) + (mobSize/2));
        posY = (PPListXY.PPY.get(0) + (mobSize/2));

        mobHealth = 100;
        mobPayout = 5;
        PictureNumber = 4;
        mobArmySize = 20;

        img = new ImageIcon("Pictures/Icons/Enemies-0" + PictureNumber + ".png");
        image = img.getImage();
    }


}


