//import javax.swing.*;
//import java.awt.*;
//
//public class Screen extends JPanel implements Runnable {
//   // public Thread thread = new Thread(this);
//
//    public static Image[] tileset_air = new Image[100];
//    public static Image[] tileset_res = new Image[100];
//    public static Image[] image_mob = new Image[100];
//
//    public static int myWidth, myHeight;
//    public static int coinage = 10, health = 100;
//
//    public static int killed = 0, killsTOWin = 10, level = 1, maxLevel = 3;
//
//    public static boolean isFirst = true;
//    public static boolean isDebug = false;
//    public static boolean isWin = false;
//
//    public static Point mse = new Point(0,0);
//
////    public static Room room;
//
//
//    public static Room room;
//    public static Save save;
//    public static Store store;
//
//    public static Mob[] mobsArrayList = new Mob[1]; // antall mobsArrayList
//
//    public Screen(View view){
////        view.addMouseMotionListener(new KeyHandel());
////        view.addMouseListener(new KeyHandel());
//
////        thread.start();
//        System.out.println("Screen");
//    }
//
////    public static void hasWon(){
////        if (killed == )
////    }
//
//    public void define(){
//        System.out.println("define");
//        room = new Room();
//        save = new Save();
//        store = new Store();
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
//    public void paintComponent(Graphics g){
//        System.out.println("isFirst");
//        if (isFirst) {
//
//            myWidth = getWidth();
//            myHeight = getHeight();
//            define();
//
//            isFirst = false;
//        }
//
//        for (int i = 0; i < mobsArrayList.length; i++) {
//            if (mobsArrayList[i].inGame){
//                mobsArrayList[i].Draw(g);
//            }
//        }
//    }
//
////    public int spawnTime = 1500, spawnFrame = 0;  //spawntimer = 5
////    public void mobSpawned(){
////        //System.out.println("mobSpawned");
////        if (spawnFrame >= spawnTime){
////            for (int i = 0; i < mobsArrayList.length; i++) {
////                if (!mobsArrayList[i].inGame) {
////                    //System.out.println("!mobsArrayList[i].inGame");
////                    mobsArrayList[i].spawnMob(i);
////                    System.out.println("spawn mobsArrayList");
////                    break;
////                }
////            }
////            spawnFrame = 0;
////        } else {
////            spawnFrame +=1;
////        }
////    }
//
//
//    @Override
//    public void run() {
//        System.out.println("run");
////        while(true){
//
////            System.out.println("!isFirst: "+isFirst+", health: "+health+", !isWin: "+isWin);
////            if (health > 0 && !isWin){
////                System.out.println("mob spawned");
////                mobSpawned();
////
////                //health -= 1;
////            }
//
////            repaint();
//
//            try {
//                Thread.sleep(1);
//            } catch (Exception e) { }
//        }
////    }
//}
