import javax.swing.*;
import java.awt.*;

public class Mob extends MobsElement {

    public int upward = 0, downward = 1, right = 2, left = 3;
    public int direction = upward;
    public int mobWalk = 0;
    public int mobArmySize = 20;
    public boolean hasUpward = false;
    public boolean hasDownward = false;
    public boolean hasLeft = false;
    public boolean hasRight = false;

    public int spawnTime = 2, spawnFrame = 0;  //spawntimer = 5

    public Mob(){
        if (ContSetup.mobsArrayList.size() != 0){
            System.out.println("'if' mob = " + ContSetup.mobsArrayList.size());
            mobWalkPhysics();
        } else {
            System.out.println("'else' mob = " + ContSetup.mobsArrayList.size());
        }

        if (Controller.mobCount <= mobArmySize){
            mobPosX = (PPListXY.PPX.get(0) + (mobSize/2));
            mobPosY = (PPListXY.PPY.get(0) + (mobSize/2));

            mobHealth = 100;
            mobPayout = 5;

            i = new ImageIcon("Pictures/Icons/Enemies-0" + mobPictureNumber + ".png");
            image = i.getImage();

            mob = true;
            ContSetup.mobsArrayList.add(this);
        }
    }
    public void mobWalkPhysics() {
        for(int i = 0; i < ContSetup.mobsArrayList.size(); i ++){
            mobPosX = PPListXY.PPX.get(i + 1);
            mobPosY = PPListXY.PPY.get(i +1);

        }


    }


    public int walkFrame = 0, walkSpeed = 20;
    public void mobWalkPhysicsasdf() {
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


