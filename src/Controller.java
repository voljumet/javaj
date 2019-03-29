import java.awt.event.*;



public class Controller implements ActionListener, KeyListener, WindowListener {

    static View View;
    static Model Model;

    public Controller(){
        View = new View();
        Model = new Model();

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
}