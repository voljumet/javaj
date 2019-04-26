import java.awt.*;

public class Mob extends Rectangle {
    public int xCords, yCords;
    public int mobHealth;
    public int healthSpace = 3, healthHeight = 6;
    public int mobSizeXY = 50;
    public int mobSize = 40;
    public int mobWalk = 0;
    public int up = 0, down = 1, right = 2, left = 3;
    public int direction = up;
    public int mobID = -1;
    public boolean inGame = false;
    public boolean hasUp = false;
    public boolean hasDown = false;
    public boolean hasLeft = false;
    public boolean hasRight = false;

    public Mob(){

    }

    public void spawnMob(int mobID){
        System.out.println("spawnMob");
        for (int i = 0; i < Controller.count; i++) {

            if (PPListXY.PPY.get(i) == 810){
                setBounds(PPListXY.PPX.get(i),PPListXY.PPY.get(i),mobSize,mobSize);
                yCords = 0;
                xCords = i;
            }
        }

        //this.setBounds(10,10,100,100);

        this.mobID = mobID;
        this.mobHealth = mobSize;

        inGame = true;
    }

    public void deleteMob(){
        System.out.println("deleteMob");
        inGame = false;
        direction = up;
        mobWalk = 0;

        //getmoney!!
    }

    public void looseHealth(){
        Screen.health -=1;
    }

    public int walkFrame = 0, walkSpeed = 20;
    public void Physics(){
        //ififififif
    }

    public void loseHealth(int amo){
        mobHealth -= amo;

        checkDeath();
    }

    public void checkDeath() {
        System.out.println("checkDeath");
        if (mobHealth == 0){
            deleteMob();
        }
    }

    public boolean isDead(){
        if (inGame){
            return false;
        }else {
            return true;
        }
    }

    public void draw(Graphics g){
        System.out.println("draw mob");
        g.drawImage(Screen.image_mob[mobID],x,y,width,height,null);

    }


}