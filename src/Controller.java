import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import static java.awt.Font.BOLD;

public class Controller extends ContSetup implements ActionListener,
        KeyListener, WindowListener, MouseListener, MouseMotionListener, Runnable {

    public Controller() throws IOException, UnsupportedAudioFileException,
            InterruptedException, LineUnavailableException {

        View = new View();
        Towers = new Towers();
        MobsElement = new MobsElement();

        PipePositionListXY = new PPListXY();

        View.addKeyListener(this);
        View.addMouseListener(this);
        mobsArrayList.add(MobsElement);
        PipeLineArray.add(PipeLine);

        System.out.println("array: " + mobsArrayList);
        Background(View.getGraphics());     // Tegner bakgrunn

        //menu = new menuStart();    // Tegner menyen

        SPawnPipe(View.getGraphics());   // Tegner Pipes

//        CountDown();

        Score(View.getGraphics());  // Tegner score osv.


        /* Må være siste linje, denne looper til spillet blir avsluttet */
        mobs(View.getGraphics());   // Tegner mobs
        /* Må være siste linje, denne looper til spillet blir avsluttet */
    }


    public void mobs(Graphics gg) {
        try {
            while (true) {
                Mob = new Mob();
                Mob.Draw(gg);
//                timeToDraw = false;
                mobCount +=1;
                Thread.sleep(1000);
            }
        } catch (InterruptedException e){
            System.out.println("Paused");
        }
    }

    public void menuStart(){
        menuFrameStart = new menuFrameStart();
    }

    public void Score(Graphics g){

        g.drawImage(new ImageIcon("Pictures/Icons/Enemies-08.png").getImage(), 20,15, 18,18, null);
        g.drawImage(new ImageIcon("Pictures/Icons/Enemies-07.png").getImage(), 20,45, 18,18, null);
        g.drawImage(new ImageIcon("Pictures/Icons/Enemies-09.png").getImage(), 20,75, 18,18, null);

        g.setColor(new Color(0, 0, 0, 252));
        g.setFont(new Font("Corier New", BOLD, 16));
        g.drawString("Cash: "+ Controller.Cash, 50,30);
        g.drawString("Kills: "+ Controller.kills, 50,60);
        g.drawString("Health: "+ Controller.health, 50,90);
    }

    public void Background(Graphics g){
        g.drawImage(new ImageIcon("Pictures/Background-01.png").getImage(), 0, 0, 900, 900, null);
    }

    public void SPawnPipe(Graphics g) throws UnsupportedAudioFileException,
            IOException, LineUnavailableException, InterruptedException {
        debugMode = true;
        int sleep = 100;

        if (debugMode){
            int gameLen = PPListXY.PPX.size() - 1;
            System.out.println("Game length: " + gameLen + " pipes!");
            sleep = 0;
        }

        for (count = 0; count < PPListXY.PPX.size() - 1; count++) {
            PipeLine = new PipeLine();          //using correct pipeDrawn icons from this
            PPSound = new PipeBuildSound();     //Lyden av Pipes
            PipeLine.Draw(g);                   //Tegner pipeDrawn ikon
            Thread.sleep(sleep);            //venter 100ms før den fortsetter loopen
            pipeDrawn = true;
        }
    }

    public void CountDownPrint(Graphics g, int tim){
        g.setColor(new Color(0, 0, 0, 252));
        g.setFont(new Font("Corier New", BOLD, 50));
        g.drawString("Game Starts in: "+ tim/1000, 250,450);
    }

    public void CountDown() throws InterruptedException {
        if (count >= pipeBlocks) {
            for (int tim = countDown*1000; tim > timerT; tim -= 1000) {
                System.out.println("Game starts in " + tim/1000 + " sek");
                CountDownPrint(View.getGraphics(), tim);            // Countdown tekst
                Thread.sleep(1000);
            }
        }
    }

    //Shootmob er kun testing av logikk.
    public static void ShootMob(Graphics g) {
            for (int i = 0; i < TowerArray.size(); i++) {
                for (int j = 0; j < mobsArrayList.size(); j++) {
                    Mob.MobReach = new Rectangle(mobsArrayList.get(j).mobPosX, mobsArrayList.get(j).mobPosY, 45, 45);
                    if (TowerArray.get(i).TowerReach != null && mobsArrayList.get(j).MobReach != null && TowerArray.get(i).TowerReach.intersects(Mob.MobReach)) {

                        g.setColor(Color.RED);
                        g.drawLine(Towers.posX + 35, Towers.posY + 35, MobsElement.mobPosX + 22, MobsElement.mobPosY + 23);
                        System.out.println("Mob er i rekkevidde");

                    } else {
                        System.out.println("Mob er ikke i rekkevidde");
                    }
                }
            }
        }




    @Override
    public void actionPerformed(ActionEvent e){ }

    @Override
    public void keyReleased(KeyEvent e){ }

    @Override
    public void keyTyped(KeyEvent e){ }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
//            System.exit(1);
            menuStart();

            try { Thread.sleep(100); } catch (InterruptedException ex) { }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) { }

    @Override
    public void windowClosing(WindowEvent e) { }

    @Override
    public void windowClosed(WindowEvent e) { }

    @Override
    public void windowIconified(WindowEvent e) { }

    @Override
    public void windowDeiconified(WindowEvent e) { }

    @Override
    public void windowActivated(WindowEvent e) { }

    @Override
    public void windowDeactivated(WindowEvent e) { }

    @Override
    public void mouseClicked(MouseEvent e) {
        //Henter coordinatene hvor musen ble klikket, og tegner et tårn i posisjonen.
        mseposX = e.getX();
        mseposY = e.getY();

        Towers.posX = mseposX - 35;
        Towers.posY = mseposY - 35;

        TowerArray.add(Towers);
        Towers.TowerReach = new Rectangle(Towers.posX - 100, Towers.posY - 100, 400, 400);
        Towers.Draw(View.getGraphics());



        ShootMob(View.getGraphics());

//        MobsElement.Draw(View.getGraphics());
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    @Override
    public void run() {
        System.out.println("run Controller");
    }

    @Override
    public void mouseDragged(MouseEvent e) { }

    @Override
    public void mouseMoved(MouseEvent e) { }
}