import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;



public class Controller implements ActionListener, KeyListener, WindowListener, MouseListener  {

    static View view;
    static Model Model;
    public Enemies Enemies;
    public Towers Towers;

    private ArrayList<Enemies> EnemyArray = new ArrayList<>();
    private ArrayList<Towers> TowerArray = new ArrayList<>();


    public Controller() throws IOException {

        view = new View();
        Model = new Model();
        Enemies = new Enemies();
        Towers = new Towers();
        view.addKeyListener(this);
        view.addMouseListener(this);
        Graphics gg = view.background.getGraphics();
        EnemyArray.add(Enemies);

        ImageIcon imageIcon = new ImageIcon("Pictures/Background.png");
        Image image = imageIcon.getImage();
        gg.drawImage(image,0,0, 900,900,null);

        EnemyArray.add(Enemies);
        Enemies.Draw(gg);

        if(TowerArray.size() > 0){

//            if(TowerArray[i] != EnemyArray[j]){
            System.out.println(Towers.posX + " " + Towers.posY);
            Towers.Draw(gg);
//            }else{
//                System.out.println("Cant place tower on enemy path");
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
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {

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

    @Override
    public void mouseClicked(MouseEvent e) {

        Towers.posX = (int)(MouseInfo.getPointerInfo().getLocation().getX()) - 321;
        Towers.posY = (int)(MouseInfo.getPointerInfo().getLocation().getY()) -100;

        TowerArray.add(Towers);

        Towers.Draw(Controller.view.background.getGraphics());


            }



    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

//    @Override
//    public void paintComponent(Graphics g){
//        new Background();
//        g.drawImage(Background.img,0,0,null);
//
//    }
}