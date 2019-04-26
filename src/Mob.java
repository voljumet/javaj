import javax.swing.*;
import java.util.ArrayList;

public class Mob extends MobsElement {

//    public static Image[] image_mob = new Image[100]; // Array med 100 mobsArrayList

    public static int coins = 10, health = 100;


    public static ArrayList<MobsElement> mobsArrayList = new ArrayList<>(); // antall mobsArrayList

    public int spawnTime = 2, spawnFrame = 0;  //spawntimer = 5

    public Mob() throws InterruptedException {
        mobArmySize = 20;
        while(!Controller.timeToDraw) {
            if (spawnFrame >= spawnTime) {
                for (int k = 0; k < mobArmySize; k++) {

                    posX = (PPListXY.PPX.get(k) + (mobSize/2));
                    posY = (PPListXY.PPY.get(k) + (mobSize/2));


                    i = new ImageIcon("Pictures/Icons/MobsElement-01.png");
                    description = "Mob";
                    image = i.getImage();


                    Thread.sleep(1);
                    Controller.timeToDraw = true;
                    Controller.mobCount =+1;
//                    mobsArrayList.add = posX;
//
//                    mobsArrayList.set(k).posY = posY;
//                    mobsArrayList.(k).set(i);
                    mobNumber += 1;

                    break;
                }
                spawnFrame = 0;
                mobWalkPhysics();
            } else {
                spawnFrame += 1;
            }
        }
    }

    public void mobWalkPhysics(){

    }




}
