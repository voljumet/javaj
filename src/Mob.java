import javax.swing.*;

public class Mob extends MobsElement{


    public Mob(){



        posX = (PPListXY.PPX.get(0) + (mobSize/2));
        posY = (PPListXY.PPY.get(0) + (mobSize/2));

        mobNR = 0;
        mapPlace = 0;
        mobArmySize = 20;

        /* if statements under bestemmer sammen med math.random hvilken mob som skal spawne i arraylisten. */
        if (ContSetup.wave == 1){
            mobHealth = 20;
            mobPayout = 2;
            PictureNumber = 1;

        }

        else if (ContSetup.wave == 2){ mobHealth = 30; mobPayout = 3; PictureNumber = 2; }

        else if (ContSetup.wave == 3){
            mobHealth = 40;
            mobPayout = 5;
            PictureNumber = 3;
        }

        else if (ContSetup.wave == 4){
            mobHealth = 100;
            mobPayout = 7;
            PictureNumber = 4;
        }

        else if (ContSetup.wave == 5){
            mobHealth = 100;
            mobPayout = 9;
            PictureNumber = 5;
        }

        else if (ContSetup.wave == 6){
            mobHealth = 100;
            mobPayout = 11;
            PictureNumber = 6;
        }

        if (ContSetup.debugMode){mobHealth = 1;}
        ImageIcon mobb = new ImageIcon("Pictures/Icons/Mobs-0" + PictureNumber + ".png");
        img = mobb;
        image = img.getImage();
        inGame = true;
    }

}
