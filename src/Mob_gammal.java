//import javax.swing.*;
//import java.awt.*;
//
//public class Mob extends Rectangle implements Runnable {
//    public int xCords, yCords;
//    public int mobHealth;
//    public int healthSpace = 3, healthHeight = 6;
//    public int mobSize = 40;
//    public int mobWalk = 0;
//    public int up = 0, down = 1, right = 2, left = 3;
//    public int direction = up;
//    public int mobID = 0;
//    public boolean inGame = false;
//    public boolean hasUp = false;
//    public boolean hasDown = false;
//    public boolean hasLeft = false;
//    public boolean hasRight = false;
//
//    public static Image[] image_mob = new Image[100];
//
//    public static boolean isFirst = true;
//
//    public static int myWidth, myHeight;
//    public static int coinage = 10, health = 100;
//
//    public static Mob[] mobsArrayList = new Mob[1]; // antall mobsArrayList
//
//    public Mob(){
//
//    }
//
//    public void spawnMob(int mobID){
//        System.out.println("spawnMob");
////        for (int i = 0; i < Controller.count; i++) {
////
////            if (PPListXY.PPY.get(i) == 810){
////                setBounds(PPListXY.PPX.get(i),PPListXY.PPY.get(i),mobSize,mobSize);
////                yCords = 810;
////                xCords = i;
////            }
////        }
//
//        setBounds(500,500,100,100);
//
//        this.mobID = mobID;
//        this.mobHealth = mobSize;
//
//        inGame = true;
//    }
//
//    public void define(){
//        System.out.println("define");
//
//
//        coinage = 10;
//        health = 100;
//
//        image_mob[0] = new ImageIcon("Pictures/Icons/Icons-06.png").getImage();
//
//        for (int i = 0; i < mobsArrayList.length; i++) {
//            System.out.println("mobsArrayList");
//            mobsArrayList[i] = new Mob();
//        }
//    }
//
////    public void paintComponent(Graphics g){
////        System.out.println("isFirst");
////        if (isFirst) {
////
////            myWidth = (int) getWidth();
////            myHeight = (int) getHeight();
////            define();
////
////            isFirst = false;
////        }
////
////        for (int i = 0; i < mobsArrayList.length; i++) {
////            if (mobsArrayList[i].inGame){
////                mobsArrayList[i].Draw(g);
////            }
////        }
////    }
//
////    public void deleteMob(){
////        System.out.println("deleteMob");
////        inGame = false;
////        direction = up;
////        mobWalk = 0;
////
////        //getmoney!!
////    }
//
////    public void looseHealth(){
////        Screen.health -=1;
////    }
//
////    public int walkFrame = 0, walkSpeed = 20;
////    public void Physics(){
////        //ififififif
////    }
//
////    public void loseHealth(int amo){
////        mobHealth -= amo;
////
////        checkDeath();
////    }
////
////    public void checkDeath() {
////        System.out.println("checkDeath");
////        if (mobHealth == 0){
////            deleteMob();
////        }
////    }
////
////    public boolean isDead(){
////        if (inGame){
////            return false;
////        }else {
////            return true;
////        }
////    }
//
//    public void Draw(Graphics g){
//        System.out.println("Draw mob");
//        define();
//        g.drawImage(image_mob[mobID],x,y,width,height,null);
//        mobsArrayList[0].Draw(g);
//
//    }
//
//
//    @Override
//    public void run() {
//
//    }
//}
