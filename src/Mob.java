import javax.swing.*;
import java.util.Random;

public class Mob extends MobsElement{

    public Mob(){

        posX = (PPListXY.PPX.get(0) + (mobSize/2));
        posY = (PPListXY.PPY.get(0) + (mobSize/2));

        mapPlace = 0;

        Random randomizer = new Random();
        PictureNumber = randomizer.nextInt(4);
        mobArmySize = 20;

        //if statements under bestemmer sammen med math.random hvilken mob som skal spawne i arraylisten.
        if(PictureNumber == 1){
            mobHealth = 10;
            mobPayout = 1;
        }
        if(PictureNumber == 2){
            mobHealth = 20;
            mobPayout = 3;
        }
        if(PictureNumber == 3){
            mobHealth = 30;
            mobPayout = 5;
        }
        if(PictureNumber == 4){
            mobHealth = 40;
            mobPayout = 7;


        }

        img = new ImageIcon("Pictures/Icons/Enemies-0" + PictureNumber + ".png");
        image = img.getImage();
        inGame = true;
    }
}
