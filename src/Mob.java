import javax.swing.*;

public class Mob extends MobsElement{


    public Mob(){

        posX = (PPListXY.PPX.get(0) + (mobSize/2));
        posY = (PPListXY.PPY.get(0) + (mobSize/2));

        mapPlace = 0;
        mobArmySize = 20;

        /** if statements under bestemmer hvilken stats og bilde til mobs før Draw ut ifra wave*/
             if (ContSetup.wave == 1){ mobHealth = 15; mobPayout =  2; PictureNumber = 1; mobDamage =  6;}
        else if (ContSetup.wave == 2){ mobHealth = 35; mobPayout =  4; PictureNumber = 2; mobDamage =  8;}
        else if (ContSetup.wave == 3){ mobHealth = 45; mobPayout =  6; PictureNumber = 3; mobDamage = 10;}
        else if (ContSetup.wave == 4){ mobHealth = 60; mobPayout =  6; PictureNumber = 4; mobDamage = 12;}
        else if (ContSetup.wave == 5){ mobHealth = 110; mobPayout = 4; PictureNumber = 5; mobDamage = 14;}
        else if (ContSetup.wave == 6){ mobHealth = 150; mobPayout = 3; PictureNumber = 6; mobDamage = 16;}

//        if (ContSetup.debugMode){mobHealth = 1;}

        ImageIcon mobb = new ImageIcon("Pictures/Icons/Mobs-0" + PictureNumber + ".png");
        img = mobb;
        image = img.getImage();
        inGame = true;
    }

}
