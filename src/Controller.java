import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

public class Controller implements ActionListener, KeyListener, WindowListener  {

    static View View;
    static Model Model;
    static Enemies Enemies;
    static PipeLine PipeLine;
    static PPListXY PipePositionListXY;
    static PipeBuildSound PPSound;
    static int count;

    private ArrayList<Enemies> EnemyArray = new ArrayList<>();
    static ArrayList<PipeLine> PipeLineArray = new ArrayList<>();

    public Controller() throws IOException, InterruptedException {
        View = new View();
        Model = new Model();
        PipePositionListXY = new PPListXY();
        Enemies = new Enemies();

        View.addKeyListener(this);

        Graphics gg = View.getGraphics();

        EnemyArray.add(Enemies);
        PipeLineArray.add(PipeLine);

        ImageIcon imageIcon = new ImageIcon("Pictures/Background.png");
        Image image = imageIcon.getImage();
        gg.drawImage(image,0,0, 900,900,null);

        Enemies.Draw(gg);

        int gameLen = PPListXY.PPX.size()-1;
        System.out.println("Game length: "+gameLen+" pipes!");
        for (count = 0; count < PPListXY.PPX.size()-1; count++) {
            PipeLine = new PipeLine(); //edit PipeLine icons
            try { PPSound = new PipeBuildSound(); } catch (LineUnavailableException | UnsupportedAudioFileException e) { e.printStackTrace(); }

            PipeLine.Draw(gg);  //draw the icons
            Thread.sleep(100);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){

    }

    @Override
    public void keyReleased(KeyEvent e){

    }

    @Override
    public void keyTyped(KeyEvent e){

    }

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
        //System.out.println("window closing");
        //Dette er bare når vinduet er helt lukket
    }

    @Override
    public void windowIconified(WindowEvent e) {
        //System.out.println("window Iconified");
        //Dette er bare når man minimerer vindu til oppgavelinje
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        //System.out.println("window Deiconified");
        //Dette er bare når man henter vindu fra oppgavelinje
    }

    @Override
    public void windowActivated(WindowEvent e) {
        //System.out.println("window activated");
        //Dette er bare når man bytter mellom vindu
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        //System.out.println("window deactivated");
        //Dette er bare når man bytter mellom vindu
    }

//    @Override
//    public void paintComponent(Graphics g){
//        new Background();
//        g.drawImage(Background.img,0,0,null);
//
//    }
}