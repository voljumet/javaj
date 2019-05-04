import javax.swing.*;
import java.util.Random;

public class Mob extends MobsElement{

    public Mob(){

        posX = (PPListXY.PPX.get(0) + (mobSize/2));
        posY = (PPListXY.PPY.get(0) + (mobSize/2));

        mapPlace = 0;
//
//        Random randomizer = new Random();
//        PictureNumber = randomizer.nextInt(6);
        mobArmySize = 20;
//
//        //if statements under bestemmer sammen med math.random hvilken mob som skal spawne i arraylisten.
//        if(PictureNumber == 1){
        if (ContSetup.wave == 1){
            mobHealth = 20;
            mobPayout = 2;
            PictureNumber = 1;
        }
//        else if(PictureNumber == 2){
        else if (ContSetup.wave == 2){
            mobHealth = 30;
            mobPayout = 3;
            PictureNumber = 2;
        }
//        else if(PictureNumber == 3){
        else if (ContSetup.wave == 3){
            mobHealth = 40;
            mobPayout = 5;
            PictureNumber = 3;
        }
//        else if(PictureNumber == 0){
        else if (ContSetup.wave == 4){
            mobHealth = 100;
            mobPayout = 7;
            PictureNumber = 4;
        }
//        else if(PictureNumber == 4){
        else if (ContSetup.wave == 5){
            mobHealth = 100;
            mobPayout = 9;
            PictureNumber = 4;
        }
//        else if (PictureNumber == 5){
        else if (ContSetup.wave == 6){
            mobHealth = 100;
            mobPayout = 11;
            PictureNumber = 6;
        }

        img = new ImageIcon("Pictures/Icons/Mobs-01.png");               //endres til mobb!!!!!!!!!!!!!!!!!!!!!
        image = img.getImage();
        inGame = true;
    }
    private ImageIcon mobb = new ImageIcon("Pictures/Icons/Mobs-0" + PictureNumber + ".png");
}
