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

        View = new View();
        mobsArrayList.add(new Mob());

        View.addKeyListener(this);
        View.addMouseListener(this);

        Background(View.getGraphics());     // Tegner bakgrunn

        SPawnPipe(View.getGraphics());   // Tegner Pipes

        Score(View.getGraphics());  // Tegner score osv.

        /* Må være siste linje, denne looper til spillet blir avsluttet */
        GameLoop(View.getGraphics());   // kjører GameLoop

    }

    //  Gameloop er hvor spillet kjører.
    public void GameLoop(Graphics gg) throws InterruptedException {




        int mobcontroll = 0;
        int spawnRate = 0, spawn = 40;
        while (true) {

            Background(gg); // tegner bakgrunn
            Score(gg);  //tegner scores
            Store(gg); //tegner butikk for tårn.

            for (PipeLine p : PipeLineArray) { p.Draw(gg); }

            if (countDown > 0) {

                CountDown();
                countDown -= 1;


            } else {

                if (mobsArrayList.size() < 20)
                    if (spawnRate == spawn) {
                        mobsArrayList.add(new Mob());
                        spawnRate = 0;
                    }
                spawnRate += 1;
                for (MobsElement m : mobsArrayList) {

                    new MobPysics(m);
                    if (m.inGame) {
                        m.Draw(gg);
                    }
                }
                for (Towers t : TowerArray) { t.Draw(gg); }

                for (Towers t : TowerArray) {
                    for (MobsElement m : mobsArrayList) {
                        if (t.TowerReach.intersects(m.MobReach) && m.inGame && mobsArrayList.indexOf(m) == mobcontroll) {

                            gg.setColor(Color.red);
                            gg.drawLine(t.posX + 35, t.posY + 35, m.posX + 22, m.posY + 23);
                            m.mobHealth -= 1;
                            if (m.mobHealth <= 0) {
                                m.inGame = false;
                                mobcontroll += 1;
                                Cash += m.mobPayout;
                                Kills += 1;
                            }
                        }
                    }
                }


                Thread.sleep(80);

                if (health <= 0) {
                    System.out.println("Game Lost");
                    continue;
                }
                if (Kills == 20) {

                    System.out.println("Wave 1 done");
                    wave += 1;
                    countDown = 5;
                }
            }
        }
    }


    public void Store(Graphics g) {


        g.setColor(new Color(242, 40, 40, 178));

        g.fillOval(845, 0, 55, 55);
        g.fillOval(845, 55, 55, 55);
        g.fillOval(845, 110, 55, 55);
        g.fillOval(845, 165, 55, 55);


        g.drawImage(new ImageIcon("Pictures/Icons/Towers-01.png").getImage(), 850, 5, 45, 45, null);
        g.setColor(new Color(0, 0, 0, 252));
        g.setFont(new Font("Corier New", BOLD, 16));
        g.drawString("$20", 855, 32);
    }

    public void Score(Graphics g) {

        g.drawImage(new ImageIcon("Pictures/Icons/Enemies-08.png").getImage(), 20, 15, 18, 18, null);
        g.drawImage(new ImageIcon("Pictures/Icons/Enemies-07.png").getImage(), 20, 45, 18, 18, null);
        g.drawImage(new ImageIcon("Pictures/Icons/Enemies-09.png").getImage(), 20, 75, 18, 18, null);

        //Store


        g.setColor(new Color(0, 0, 0, 252));
        g.setFont(new Font("Corier New", BOLD, 16));

        g.drawString("Cash: " + Controller.Cash, 50, 30);
        g.drawString("Kills: " + Controller.Kills, 50, 60);
        g.drawString("Health: " + Controller.health, 50, 90);
    }

    public void Background(Graphics g) {
        g.drawImage(new ImageIcon("Pictures/Background-01.png").getImage(), 0, 0, 900, 900, null);
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

            PipeLine pipeLine = new PipeLine();          //using correct pipeDrawn icons from this
            PPSound = new PipeBuildSound();     //Lyden av Pipes
            pipeLine.Draw(g);                   //Tegner pipeDrawn ikon
            PipeLineArray.add(pipeLine);
            Thread.sleep(sleep);            //venter 100ms før den fortsetter loopen
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

    //Shootmob sjekker om en mob kommer innenfor tårnets rekkevidde og tegnger
    // i tilfellet en "Stråle" fra tårn til mob.
    public static void ShootMob(Graphics g) {
        for (Towers t : TowerArray) {
            for (MobsElement mob : mobsArrayList) {

            }
        }
    }

    @Override public void update(Graphics g){ paintComponents(g); }

    @Override public void actionPerformed(ActionEvent e) { }

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
        //Henter coordinatene hvor musen ble klikket, og tegner et tårn i posisjonen.

        if (Cash >= 20) {
            Towers tower = new Towers();

            //setter posisjon til rutenett
            posX(e);
            posY(e);

            //legger posisjon i tower
            tower.posX = mseposX + 10;
            tower.posY = mseposY + 10;

            if (!outOfMap) {//sjekker om man prøver å lage tårn utenfor det som er lovlig plassering
                if (towerbutton) {


                    Cash -= 20;
                    towerbutton = false;

                    tower.Draw(View.getGraphics());
                    TowerArray.add(tower);
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
            //Knapp 2 trykket
            System.out.println("Knapp to trykket");
            MenuY2 = false;
        }
        if (MenuX && MenuY3) {

            menuFrameStart = new menuFrameStart();
            System.out.println("Knapp tre trykket");
            MenuY3 = false;

        }
        if (MenuX && MenuY4) {
            //Knapp 4 trykket
            System.out.println("Knapp fire trykket");
            MenuY4 = false;

        }
        MenuX = false;
    }


    private void posX(MouseEvent e) { mseposX = e.getX();
        if (mseposX >= 845 && mseposX < 900) { MenuX = true; }
        if (mseposX >= 0   && mseposX < 90 ){mseposX = 0  ; outOfMap = false;}
        if (mseposX >= 90  && mseposX < 180){mseposX = 90 ; outOfMap = false;}
        if (mseposX >= 180 && mseposX < 270){mseposX = 180; outOfMap = false;}
        if (mseposX >= 270 && mseposX < 360){mseposX = 270; outOfMap = false;}
        if (mseposX >= 360 && mseposX < 450){mseposX = 360; outOfMap = false;}
        if (mseposX >= 450 && mseposX < 540){mseposX = 450; outOfMap = false;}
        if (mseposX >= 540 && mseposX < 630){mseposX = 540; outOfMap = false;}
        if (mseposX >= 630 && mseposX < 720){mseposX = 630; outOfMap = false;}
        if (mseposX >= 720 && mseposX < 810){mseposX = 720; outOfMap = false;}
        if (mseposX >= 810 && mseposX < 900){mseposX = 810; outOfMap = false;}
    }

    private void posY(MouseEvent e) { mseposY = e.getY();
        if (mseposY >= 0   && mseposY < 55 ) { MenuY1 = true; }
        if (mseposY >= 55  && mseposY < 110) { MenuY2 = true; }
        if (mseposY >= 110 && mseposY < 165) { MenuY3 = true; }
        if (mseposY >= 165 && mseposY < 220) { MenuY4 = true; }
        if (mseposY >= 0   && mseposY < 90 ){mseposY = 0  ; outOfMap = true; }
        if (mseposY >= 90  && mseposY < 180){mseposY = 90 ; outOfMap = true; }
        if (mseposY >= 180 && mseposY < 270){mseposY = 180; outOfMap = false;}
        if (mseposY >= 270 && mseposY < 360){mseposY = 270; outOfMap = false;}
        if (mseposY >= 360 && mseposY < 450){mseposY = 360; outOfMap = false;}
        if (mseposY >= 450 && mseposY < 540){mseposY = 450; outOfMap = false;}
        if (mseposY >= 540 && mseposY < 630){mseposY = 540; outOfMap = false;}
        if (mseposY >= 630 && mseposY < 720){mseposY = 630; outOfMap = false;}
        if (mseposY >= 720 && mseposY < 810){mseposY = 720; outOfMap = false;}
        if (mseposY >= 810 && mseposY < 900){mseposY = 810; outOfMap = false;}
    }

    @Override public void mousePressed(MouseEvent e) { }

    @Override public void mouseReleased(MouseEvent e) { }

    @Override public void mouseEntered(MouseEvent e) { }

    @Override public void mouseExited(MouseEvent e) { }

    @Override public void mouseDragged(MouseEvent e) { }

    @Override public void mouseMoved(MouseEvent e) { }
}