import javax.swing.*;
import java.util.Random;

public class Mob extends MobsElement{

    public Mob(){

        posX = (PPListXY.PPX.get(0) + (mobSize/2));
        posY = (PPListXY.PPY.get(0) + (mobSize/2));

        mapPlace = 0;

        Random randomizer = new Random();
        PictureNumber = randomizer.nextInt(6);
        mobArmySize = 20;

        //if statements under bestemmer sammen med math.random hvilken mob som skal spawne i arraylisten.
        if(PictureNumber == 1){
            mobHealth = 100;
            mobPayout = 1;
        }
        if(PictureNumber == 2){
            mobHealth = 100;
            mobPayout = 3;
        }
        if(PictureNumber == 3){
            mobHealth = 100;
            mobPayout = 5;
            PictureNumber = 3;
        }
        if(PictureNumber == 0){
            mobHealth = 100;
            mobPayout = 7;
            PictureNumber = 6;
        }
        if(PictureNumber == 4){
            mobHealth = 100;
            mobPayout = 9;
        }
        if (PictureNumber == 5){
            mobHealth = 100;
            mobPayout = 11;
        }

        img = new ImageIcon("Pictures/Icons/Enemies-0" + PictureNumber + ".png");
        image = img.getImage();
        inGame = true;
    }
}
