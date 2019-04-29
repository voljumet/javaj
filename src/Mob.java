import javax.swing.*;
import java.awt.*;

public class Mob extends MobsElement {

    public int upward = 0, downward = 1, right = 2, left = 3;
    public int direction = upward;
    public int mobWalk = 0;
    public boolean hasUpward = false;
    public boolean hasDownward = false;
    public boolean hasLeft = false;
    public boolean hasRight = false;

    public int spawnTime = 2, spawnFrame = 0;  //spawntimer = 5

    public Mob() throws InterruptedException {
        mobArmySize = 20;
        while(Controller.mobCount <= mobArmySize) {
            if (spawnFrame >= spawnTime) {

                mobPosX = (PPListXY.PPX.get(Controller.mobCount) + (mobSize/2));
                mobPosY = (PPListXY.PPY.get(Controller.mobCount) + (mobSize/2));
                System.out.println("mob count: "+Controller.mobCount+" - posX: "+mobPosX+" - posY: "+mobPosY);

                mobHealth = 100;
                mobPayout = 5;

                i = new ImageIcon("Pictures/Icons/Enemies-0"+ mobPictureNumber +".png");
                description = "Mob";
                image = i.getImage();

                Controller.mobCount +=1;

                mob = true; // True if this is a mob

                //mobWalkPhysics();

            } else {
                spawnFrame += 1;
                Thread.sleep(500);
            }
//            if ()
        }
    }

    public int walkFrame = 0, walkSpeed = 20;
    public void mobWalkPhysics() {
        if (walkFrame >= walkSpeed){
                   if (direction == upward){
                mobPosY -= 1;
            } else if (direction == downward){
                mobPosY += 1;
            } else if (direction == right){
                mobPosX += 1;
            } else if (direction == left){
                mobPosX -= 1;
            }

            mobWalk += 1;

            if (mobWalk == 0) {
                if (direction == upward) {
                    mobPosY -= 1;
                    hasUpward = true;
                } else if (direction == downward) {
                    mobPosY += 1;
                    hasDownward = true;
                } else if (direction == right) {
                    mobPosX += 1;
                    hasRight = true;
                } else if (direction == left) {
                    mobPosX -= 1;
                    hasLeft = true;
                }

                hasUpward = false;
                hasDownward = false;
                hasLeft = false;
                hasRight = false;
                mobWalk = 0;
            }

            walkFrame = 0;
        } else {
            walkFrame += 1;
        }
    }




}
