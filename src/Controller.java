import javax.management.monitor.MonitorMBean;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

public class Controller implements ActionListener, KeyListener, WindowListener, MouseListener  {
    static View View;
    static menuFrame menuFrame;
    static PipeLine PipeLine;
    static PPListXY PipePositionListXY;
    static PipeBuildSound PPSound;

    public static boolean debugMode = false;

    static int count;
    public Towers Towers;
    public int highScore;

    public static ArrayList<Towers> TowerArray = new ArrayList<>();
    public static ArrayList<PipeLine> PipeLineArray = new ArrayList<>();

    public Controller() throws IOException, InterruptedException, LineUnavailableException, UnsupportedAudioFileException {
        View = new View();
        Towers = new Towers();
        PipePositionListXY = new PPListXY();
        Screen screen = new Screen(View);

        View.addKeyListener(this);
        View.addKeyListener(this);
        View.addMouseListener(this);

        Background(View.getGraphics());     // Tegner bakgrun

        Menu();                             // Tegner menyen

//        SPawnPipe(View.getGraphics());      // Tegner Pipeline

        PipeLineArray.add(PipeLine);

        //View.add(screen);
    }

    public void Menu(){
        menuFrame = new menuFrame();

    }

    public void Background(Graphics g){
        Graphics gg = View.background.getGraphics();
        ImageIcon imageIcon = new ImageIcon("Pictures/Background-01.png");
        Image image = imageIcon.getImage();
        gg.drawImage(image, 0, 0, 900, 900, null);
    }

    public static void SPawnPipe(Graphics g) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        debugMode = false;
        int sleep = 100;

        if (debugMode){
            int gameLen = PPListXY.PPX.size() - 1;
            System.out.println("Game length: " + gameLen + " pipes!");
            sleep = 0;
        }

        for (count = 0; count < PPListXY.PPX.size() - 1; count++) {
            PipeLine = new PipeLine();          //using correct Pipe icons from this
            PPSound = new PipeBuildSound();     //Lyden av Pipes
            PipeLine.Draw(g);                   //Tegner Pipe ikon
            Thread.sleep(sleep);            //venter 100ms før den fortsetter loopen
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
            System.exit(1);
        }

    }

    @Override
    public void windowOpened(WindowEvent e) {
        //sjekker om det som er i vinduet er lagret, hvis ikke spør den om man skal lagre før man begynner.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        //sjekker om det som er i vinduet er lagret, hvis ikke spør den om man skal lagre
    }

    @Override
    public void windowClosed(WindowEvent e) {
        //Dette er bare når vinduet er helt lukket
    }

    @Override
    public void windowIconified(WindowEvent e) {
        //Dette er bare når man minimerer vindu til oppgavelinje
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        //Dette er bare når man henter vindu fra oppgavelinje
    }

    @Override
    public void windowActivated(WindowEvent e) {
        //Dette er bare når man bytter mellom vindu
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
       //Dette er bare når man bytter mellom vindu
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        Towers.posX = (int)(MouseInfo.getPointerInfo().getLocation().getX()) - 321;
        Towers.posY = (int)(MouseInfo.getPointerInfo().getLocation().getY()) -100;
        TowerArray.add(Towers);




        if(TowerArray.size() > 0){

//            if(TowerArray[i] != EnemyArray[j]){
            System.out.println(Towers.posX + " " + Towers.posY);
            Towers.Draw(View.background.getGraphics());
//            }else{
//                System.out.println("Cant place tower on enemy path");
        }
        Towers.Draw(Controller.View.background.getGraphics());
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }
}