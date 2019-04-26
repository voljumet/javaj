import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

public class Controller extends JPanel implements ActionListener, KeyListener, WindowListener, MouseListener, MouseMotionListener, Runnable {

    static View View;
    static menuFrameNew menuFrameNew;
    static PipeLine PipeLine;
    static PPListXY PipePositionListXY;
    static PipeBuildSound PPSound;
    static Mob Mob;
    static menuFrameStart menuFrameStart;
    public static boolean pause = false;
    public static boolean newG = true;

    public int mseClicked;
    public int mseposX;
    public int mseposY;

    public static boolean debugMode = false;
    public static boolean pipe = false;
    public static boolean gameRunning = false;
    public static boolean timeToDraw = false;

    public static int count, timer = 0, countDown = 1, pipeBlocks = 32, mobCount = 0;

    public static Towers Towers;
    public static MobsElement MobsElement;
    static int Cash = 20;
    static int kills = 0;
    static int health = 100;

    public static ArrayList<Towers> TowerArray = new ArrayList<>();
    public static ArrayList<MobsElement> EnemyArray = new ArrayList<>(); //Placeholder for MobArray.
    public static ArrayList<PipeLine> PipeLineArray = new ArrayList<>();

    public Controller() throws IOException, InterruptedException,
            LineUnavailableException, UnsupportedAudioFileException {
        View = new View();
        Towers = new Towers();

        PipePositionListXY = new PPListXY();

        View.addKeyListener(this);
        View.addKeyListener(this);

        Background(View.getGraphics());     // Tegner bakgrunn

        menuStart();    // Tegner menyen

        Score(View.getGraphics());

        PipeLineArray.add(PipeLine);

        if (count >= pipeBlocks) {
            for (int tim = countDown*1000; tim > timer; tim -= countDown*1000) {
                System.out.println("Game starts in " + tim/1000 + " sek");
                Thread.sleep(countDown*1000);
            }
            mobs(View.getGraphics());   // Tegner mobsArrayList
        }
    }

    public void mobs(Graphics gg) {
        while (true) {
            try { Mob = new Mob(); } catch (InterruptedException e) { }
            Mob.Draw(gg);
            timeToDraw = false;
        }
    }

    public void menuStart(){
        menuFrameStart = new menuFrameStart();
    }

    public void menuNew(){
        menuFrameNew = new menuFrameNew();
    }

    public void Score(Graphics graphics){

        graphics.drawImage(new ImageIcon("Pictures/Icons/Enemies-01.png").getImage(), 20,15, 18,18, null);
        graphics.drawImage(new ImageIcon("Pictures/Icons/Enemies-04.png").getImage(), 20,45, 18,18, null);
        graphics.drawImage(new ImageIcon("Pictures/Icons/Towers-02.png").getImage(), 20,75, 18,18, null);

        graphics.setColor(new Color(0, 0, 0, 252));
        graphics.setFont(new Font("Corier New", Font.BOLD, 16));
        graphics.drawString("Cash: "+ Controller.Cash, 50,30);
        graphics.drawString("Kills: "+ Controller.kills, 50,60);
        graphics.drawString("Health: "+ Controller.health, 50,90);

    }

    public void Background(Graphics g){
        ImageIcon imageIcon = new ImageIcon("Pictures/Background-01.png");
        Image image = imageIcon.getImage();
        g.drawImage(image, 0, 0, 900, 900, null);
    }

    public static void SPawnPipe(Graphics g) throws UnsupportedAudioFileException,
            IOException, LineUnavailableException, InterruptedException {
        debugMode = true;
        int sleep = 100;

        if (debugMode){
            int gameLen = PPListXY.PPX.size() - 1;
            System.out.println("Game length: " + gameLen + " pipes!");
            sleep = 0;
        }

        for (count = 0; count < PPListXY.PPX.size() - 1; count++) {
            PipeLine = new PipeLine();          //using correct pipe icons from this
            PPSound = new PipeBuildSound();     //Lyden av Pipes
            PipeLine.Draw(g);                   //Tegner pipe ikon
            Thread.sleep(sleep);            //venter 100ms før den fortsetter loopen
            pipe = true;
        }
    }

    //Shootmob er kun testing av logikk.
    public static void ShootMob(Graphics g){
        if(TowerArray.get(0).TowerReach.intersects(EnemyArray.get(0).MobReach)){
            g.drawLine(Towers.posX, Towers.posY, MobsElement.posX, MobsElement.posY);
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
            menuNew();

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
        Towers.Draw(View.getGraphics());

        MobsElement.posX = 300;
        MobsElement.posY = 300;

        EnemyArray.add(MobsElement);

        MobsElement.Draw(View.getGraphics());
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