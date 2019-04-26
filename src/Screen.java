//import javax.sound.sampled.LineUnavailableException;
//import javax.sound.sampled.UnsupportedAudioFileException;
//import javax.swing.*;
//import java.awt.*;
//import java.io.IOException;
//
//public class Screen extends JPanel implements Runnable {
//    public Thread thread = new Thread(this);
//
//    public static Image[] image_mob = new Image[100];
//
//    public static int myWidth, myHeight;
//    public static int coinage = 10, health = 100;
//
//    public static Point mouse = new Point(0,0);
//
//    public static Mob[] mobs = new Mob[20]; // antall mobs
//
////    public Screen(View view) throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {
////        view.addMouseListener(new Controller());
////        view.addMouseMotionListener(new Controller());
////
////        thread.start();
////        System.out.println("Screen");
////    }
//
//    public void define(){
//        System.out.println("define");
//        coinage = 10;
//        health = 100;
//
//        image_mob[0] = new ImageIcon("Pictures/Icons/Enemies-01.png").getImage();
//
//        for (int i = 0; i < mobs.length; i++) {
//            mobs[i] = new Mob();
//
//        }
//    }
//
//    public void paintComponent(Graphics g){
//        System.out.println("paintComponents");
//        myWidth = getWidth();
//        myHeight = getHeight();
//        define();
//
//        for (int i = 0; i < mobs.length; i++) {
//            if (mobs[i].inGame){
//                mobs[i].draw(g);
//            }
//        }
//    }
//
//    public int spawnTime = 5, spawnFrame = 0;
//    public void mobSpawned(){
//        System.out.println("mobSpawned");
//        if (spawnFrame >= spawnTime){
//            for (int i = 0; i < mobs.length; i++) {
//                //if (!mobs[i].inGame) {
//                    System.out.println("!mobs[i].inGame");
//                    mobs[i].spawnMob(i);
////                    break;
//                //}
//            }
//            spawnFrame = 0;
//        } else {
//            spawnFrame +=1;
//        }
//    }
//
//
//    @Override
//    public void run() {
//        System.out.println("run");
//        while(true){
//            if (health > 0){
//                mobSpawned();
//
//                //health -= 1;
//            }
//
//            repaint();
//        }
//    }
//}
