import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import static java.awt.Font.BOLD;


public class Controller extends ContSetup implements ActionListener,
        KeyListener, WindowListener, MouseListener, MouseMotionListener {

    public Controller() throws IOException, UnsupportedAudioFileException,
            InterruptedException, LineUnavailableException {


        PipePositionListXY = new PPListXY();
        Shootmob = new ShootMob();
        View = new View();
        mobsArrayList.add(new Mob());

        View.addKeyListener(this);
        View.addMouseListener(this);

        Background(View.getGraphics());     /*Tegner bakgrunn*/

        SPawnPipe(View.getGraphics());   /*Tegner Pipes*/

        Score(View.getGraphics());  /*Tegner score osv.*/

        /* Må være siste linje, denne looper til spillet blir avsluttet */
        GameLoop(View.getGraphics());  /*kjører GameLoop*/

    }

     /*Gameloop er hvor spillet kjører.*/
    public void GameLoop(Graphics gg) throws InterruptedException, IOException {


        int spawn = 0, spawnRate = 50;

        int drawtimer = 0;
        while (true) {

//            Point msepoint = View.getMousePosition();
//            System.out.println("msepoint = " + msepoint);



             /*Timer for hvor mange ganger den skal loope GameLoopen før den tegner alle drawFPS-Funksjonene*/
            drawtimer++;
            if (drawtimer == 5){
                drawtimer = 0;
                drawFPS = true;
            }

            if (drawFPS) {
                Background(gg); /*tegner bakgrunn*/
                Score(gg);  /*tegner scores*/
                Store(gg); /*tegner butikk for tårn.*/
                for (PipeLine p : PipeLineArray) { if (drawFPS) {p.Draw(gg);} } /*Tegner PipeLine*/
            }


            /*Nedtelling før game starter*/
            if (countDown > 0) {
                Background(gg);
                for (PipeLine p : PipeLineArray) {p.Draw(gg);}
                CountDown();
                countDown -= 1;

            } else {

                /*mobs spawner kun til det er spawnet 20stk*/
                if (mobsArrayList.size() < 20){

                    /*Mobs spawner i frekvens spanwnRate*/
                    if (spawn == spawnRate) {

                        mobsArrayList.add(new Mob());

                        spawn = 0;
                    }
                    spawn += 1;
                }

                /*Tegner mobs*/
                for (MobsElement m : mobsArrayList) {
                    new MobPysics(m);
                    if (m.inGame) {if (drawFPS){m.Draw(gg); if(debugMode)gg.drawRect(m.posX, m.posY,45,45);}}
                }

                /*Tegner Towers på ny*/
                for (Towers t : TowerArray) { if (drawFPS){t.Draw(gg);  if(debugMode)gg.drawRect(t.posX - t.offset, t.posY - t.offset, 200, 200);} }


                if(drawFPS) {
                    Shootmob.Draw(gg);
                }

                Thread.sleep(20);

                if (drawFPS){
                if (health <= 0) {
                    System.out.println("Game Lost");
                    new HighScore();
                    mobsArrayList.clear();
                    break; /*stopper loopen/spillet*/
                }}
                if (Kills == 20 && wave == 1) {

                    System.out.println("Wave 1 done");
                    wave += 1;
                    countDown = 5;
                    mobsArrayList.clear();


                }
            }
            /*reset for "FPS"*/
            drawFPS = false;
        }
    }


    public void Store(Graphics g) {

        g.setColor(new Color(238, 240, 242, 100));

        g.fillOval(845, 0, 55, 55);
        g.fillOval(845, 55, 55, 55);
        g.fillOval(845, 110, 55, 55);
        g.fillOval(845, 165, 55, 55);

        g.drawImage(tw1.getImage(), 850, 5, 45, 45, null);
        g.drawImage(tw2.getImage(), 850, 60, 45, 45, null);
        g.drawImage(icon5.getImage(), 850, 115, 45, 45, null);
        g.drawImage(icon6.getImage(), 850, 170, 45, 45, null);

        g.setColor(new Color(0, 0, 0, 252));
        g.setFont(new Font("Corier New", BOLD, 16));
        g.drawString("$20", 855, 32);
    }

    private ImageIcon ene7 = new ImageIcon("Pictures/Icons/Icon-03.png");
    private ImageIcon ene8 = new ImageIcon("Pictures/Icons/Icon-02.png");
    private ImageIcon ene9 = new ImageIcon("Pictures/Icons/Icon-04.png");
    private ImageIcon icon5 = new ImageIcon("Pictures/Icons/Icon-05.png");
    private ImageIcon icon6 = new ImageIcon("Pictures/Icons/Icon-06.png");
    private ImageIcon tw1 = new ImageIcon("Pictures/Icons/Towers-01.png");
    private ImageIcon tw2 = new ImageIcon("Pictures/Icons/Towers-02.png");
    private ImageIcon bck = new ImageIcon("Pictures/Background-01.png");


    public void Score(Graphics g) {

        g.drawImage(ene7.getImage(), 20, 15, 18, 18, null);
        g.drawImage(ene8.getImage(), 20, 45, 18, 18, null);
        g.drawImage(ene9.getImage(), 20, 75, 18, 18, null);

        //Store

        g.setColor(new Color(0, 0, 0, 252));
        g.setFont(new Font("Corier New", BOLD, 16));

        g.drawString("Cash: " + Controller.Cash, 50, 30);
        g.drawString("Kills: " + Controller.Kills, 50, 60);
        g.drawString("Health: " + Controller.health, 50, 90);
    }

    public void Background(Graphics g) {
        g.drawImage(bck.getImage(), 0, 0, 900, 900, null);
    }

    public void SPawnPipe(Graphics g) throws UnsupportedAudioFileException,
            IOException, LineUnavailableException, InterruptedException {

        int sleep = 100;

        if (debugMode) {
            int gameLen = PPListXY.PPX.size() - 1;
            System.out.println("Game length: " + gameLen + " pipes!");
            sleep = 0;
        }

        for (count = 0; count < PPListXY.PPX.size() - 1; count++) {

            PipeLine pipeLine = new PipeLine();/*          using correct pipeDrawn icons from this*/
            PPSound = new PipeBuildSound();    /* Lyden av Pipes*/
            pipeLine.Draw(g);                  /* Tegner pipeDrawn ikon*/
            PipeLineArray.add(pipeLine);
            Thread.sleep(sleep);            /*venter 100ms før den fortsetter loopen*/
        }
    }

    public void CountDownPrint(Graphics g, int tim) {
        g.setColor(new Color(0, 0, 0, 252));
        g.setFont(new Font("Corier New", BOLD, 50));
        g.drawString("Wave " + wave + " starts in: " + tim / 1000, 250, 450);
    }

    public void CountDown() throws InterruptedException {
        if (!debugMode) {
            timer = 1000 * countDown;
            System.out.println("Game starts in " + timer / 1000 + " sek");
            CountDownPrint(View.getGraphics(), timer);    // Countdown tekst
            Thread.sleep(1000);

        }
    }
    

    @Override public void update(Graphics g){ paintComponents(g); }

    @Override public void actionPerformed(ActionEvent e) {

    }

    @Override public void keyReleased(KeyEvent e) { }

    @Override public void keyTyped(KeyEvent e) { }

    @Override public void keyPressed(KeyEvent e) { if (e.getKeyCode() == KeyEvent.VK_ESCAPE) { System.exit(0); } }

    @Override public void windowOpened(WindowEvent e) { }

    @Override public void windowClosing(WindowEvent e) { }

    @Override public void windowClosed(WindowEvent e) { }

    @Override public void windowIconified(WindowEvent e) { }

    @Override public void windowDeiconified(WindowEvent e) { }

    @Override public void windowActivated(WindowEvent e) { }

    @Override public void windowDeactivated(WindowEvent e) { }

    @Override public void mouseClicked(MouseEvent e) {
        /*Henter coordinatene hvor musen ble klikket, og tegner et tårn i posisjonen.*/

        if (Cash >= 20) {
            /*setter posisjon til rutenett*/
            posX(e);
            posY(e);

            if(!outOfMap) { /*sjekker om man prøver å lage tårn utenfor det som er lovlig plassering*/
                if (towerbutton) {
                    towerbutton = false;


                    Towers tower = new Towers(mseposX+10, mseposY+10);
                    Rectangle CheckOverlap = new Rectangle(tower.posX - tower.towerSize/2, tower.posY - tower.towerSize/2, tower.towerSize, tower.towerSize);

                    for(int i = 0; i < TowerArray.size() - 1; i++) { /*må sjekke om tårn kan bygges før cash blir trukket fra og før tårn blir printet, og addet i arrayet.*/
                        if (TowerArray.get(i).TowerOverlap.intersects(CheckOverlap)) {
                            System.out.println("Tårn overlapper");
                            System.out.println(TowerArray.size());
                            break;
                        }
                    }

                    TowerArray.add(tower);
                    Cash -= 20;

                    System.out.println(TowerArray.size());

                    tower.Draw(View.getGraphics());

                    }
                    }

        } else {
            System.out.println("Not enough cash for sponge!");

        }
        if (MenuX && MenuY1) {
            towerbutton = true;
            System.out.println("Knapp en trykket");
            MenuY1 = false;

        }

        if (MenuX && MenuY2) {
            System.out.println("Knapp to trykket");
            MenuY2 = false;
        }

        if (MenuX && MenuY3) {
            menuFrameStart = new menuFrameStart();
            System.out.println("Knapp tre trykket");
            MenuY3 = false;
        }

        if (MenuX && MenuY4) {
            System.out.println("Knapp fire trykket");
            MenuY4 = false;
        }
        MenuX = false;
    }


    private void posX(MouseEvent e) { mseposX = e.getX();
             if (mseposX >= 845 && mseposX < 900){MenuX = true;}
             if (mseposX >= 0   && mseposX < 90 ){mseposX = 0  ; outOfMap = false;}
        else if (mseposX >= 90  && mseposX < 180){mseposX = 90 ; outOfMap = false;}
        else if (mseposX >= 180 && mseposX < 270){mseposX = 180; outOfMap = false;}
        else if (mseposX >= 270 && mseposX < 360){mseposX = 270; outOfMap = false;}
        else if (mseposX >= 360 && mseposX < 450){mseposX = 360; outOfMap = false;}
        else if (mseposX >= 450 && mseposX < 540){mseposX = 450; outOfMap = false;}
        else if (mseposX >= 540 && mseposX < 630){mseposX = 540; outOfMap = false;}
        else if (mseposX >= 630 && mseposX < 720){mseposX = 630; outOfMap = false;}
        else if (mseposX >= 720 && mseposX < 810){mseposX = 720; outOfMap = false;}
        else if (mseposX >= 810 && mseposX < 900){mseposX = 810; outOfMap = false;}
    }

    private void posY(MouseEvent e) { mseposY = e.getY();
             if (mseposY >= 0   && mseposY < 55 ){MenuY1 = true;}
        else if (mseposY >= 55  && mseposY < 110){MenuY2 = true;}
        else if (mseposY >= 110 && mseposY < 165){MenuY3 = true;}
        else if (mseposY >= 165 && mseposY < 220){MenuY4 = true;}
             if (mseposY >= 0   && mseposY < 90 ){mseposY = 0  ; outOfMap = true; }
        else if (mseposY >= 90  && mseposY < 180){mseposY = 90 ; outOfMap = true; }
        else if (mseposY >= 180 && mseposY < 270){mseposY = 180; outOfMap = false;}
        else if (mseposY >= 270 && mseposY < 360){mseposY = 270; outOfMap = false;}
        else if (mseposY >= 360 && mseposY < 450){mseposY = 360; outOfMap = false;}
        else if (mseposY >= 450 && mseposY < 540){mseposY = 450; outOfMap = false;}
        else if (mseposY >= 540 && mseposY < 630){mseposY = 540; outOfMap = false;}
        else if (mseposY >= 630 && mseposY < 720){mseposY = 630; outOfMap = false;}
        else if (mseposY >= 720 && mseposY < 810){mseposY = 720; outOfMap = false;}
        else if (mseposY >= 810 && mseposY < 900){mseposY = 810; outOfMap = false;}
    }

    @Override public void mousePressed(MouseEvent e) { }

    @Override public void mouseReleased(MouseEvent e) { }

    @Override public void mouseEntered(MouseEvent e) { }

    @Override public void mouseExited(MouseEvent e) { }

    @Override public void mouseDragged(MouseEvent e) {Point poo = MouseInfo.getPointerInfo().getLocation();
        System.out.println("poo = " + poo);}

    @Override public void mouseMoved(MouseEvent e) { new Point(e.getX(),e.getY()); }
}