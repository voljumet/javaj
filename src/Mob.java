import javax.swing.*;

public class Mob extends MobsElement{


    public Mob(){

        posX = (PPListXY.PPX.get(0) + (mobSize/2));
        posY = (PPListXY.PPY.get(0) + (mobSize/2));

        mapPlace = 0;
        mobArmySize = 20;

        /** if statements under bestemmer hvilken stats og bilde til mobs før Draw ut ifra wave*/
             if (ContSetup.wave == 1){ mobHealth = 19; mobPayout =  1; PictureNumber = 1; mobDamage =  6; maxHealth =  19; }
        else if (ContSetup.wave == 2){ mobHealth = 35; mobPayout =  2; PictureNumber = 2; mobDamage =  8; maxHealth =  35; }
        else if (ContSetup.wave == 3){ mobHealth = 50; mobPayout =  3; PictureNumber = 3; mobDamage = 10; maxHealth =  50; }
        else if (ContSetup.wave == 4){ mobHealth = 60; mobPayout =  3; PictureNumber = 4; mobDamage = 12; maxHealth =  60; }
        else if (ContSetup.wave == 5){ mobHealth = 150; mobPayout = 3; PictureNumber = 5; mobDamage = 14; maxHealth = 150; }
        else if (ContSetup.wave == 6){ mobHealth = 170; mobPayout = 4; PictureNumber = 6; mobDamage = 16; maxHealth = 170; }

//        if (ContSetup.debugMode){mobHealth = 1;}

        ImageIcon mobb = new ImageIcon("Pictures/Icons/Mobs-0" + PictureNumber + ".png");
        img = mobb;
        image = img.getImage();
        inGame = true;
    }

}
