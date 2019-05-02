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


//        for(int i = 0; i < 20; i++) {
//            mobsArrayList.add(new Mob());
//            Thread.sleep(1000);
//        }

        View.addKeyListener(this);
        View.addMouseListener(this);

        System.out.println("array: " + mobsArrayList);
        Background(View.getGraphics());     // Tegner bakgrunn


        SPawnPipe(View.getGraphics());   // Tegner Pipes

//        CountDown();

        Score(View.getGraphics());  // Tegner score osv.

        /* Må være siste linje, denne looper til spillet blir avsluttet */
        GameLoop(View.getGraphics());   // Tegner GameLoop

    }

    //  Gameloop er hvor spillet kjører.
    public void GameLoop(Graphics gg) throws InterruptedException {

        while (true) {

            for (int i = 0; i < 1; i++) {
                Background(View.getGraphics());
            }
            for (PipeLine p : PipeLineArray) {
                p.Draw(gg);
            }
            for (MobsElement m : mobsArrayList) {
                if (m.mobHealth != 0) {
                    m.posY -= 0.5;
                    m.Draw(gg);
                } else {
                    break;
                }
            }
            for (Towers t : TowerArray) {
                t.Draw(gg);
            }
            for (Towers t : TowerArray) {
                for (MobsElement m : mobsArrayList) {
                    if (m.mobHealth != 0) {
                        ShootMob(gg);
                    } else {
                        Cash += m.mobPayout;

                    }
                }
            }
            Score(gg);


            Thread.sleep(100);
        }
    }




    public void menuStart() {
        menuFrameStart = new menuFrameStart();
    }

    public void Score(Graphics g) {

        g.drawImage(new ImageIcon("Pictures/Icons/Enemies-08.png").getImage(), 20, 15, 18, 18, null);
        g.drawImage(new ImageIcon("Pictures/Icons/Enemies-07.png").getImage(), 20, 45, 18, 18, null);
        g.drawImage(new ImageIcon("Pictures/Icons/Enemies-09.png").getImage(), 20, 75, 18, 18, null);

        g.setColor(new Color(0, 0, 0, 252));
        g.setFont(new Font("Corier New", BOLD, 16));
        g.drawString("Cash: " + Controller.Cash, 50, 30);
        g.drawString("Kills: " + Controller.kills, 50, 60);
        g.drawString("Health: " + Controller.health, 50, 90);
    }

    public void Background(Graphics g) {
        g.drawImage(new ImageIcon("Pictures/Background-01.png").getImage(), 0, 0, 900, 900, null);
    }

    public void SPawnPipe(Graphics g) throws UnsupportedAudioFileException,
            IOException, LineUnavailableException, InterruptedException {
        debugMode = true;
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
        g.drawString("Game Starts in: " + tim / 1000, 250, 450);
    }

    public void CountDown() throws InterruptedException {
        int timerT = 0;
        int countDown = 5;
        if (count >= pipeBlocks) {
            for (int tim = countDown * 1000; tim > timerT; tim -= 1000) {
                System.out.println("Game starts in " + tim / 1000 + " sek");
                CountDownPrint(View.getGraphics(), tim);            // Countdown tekst
                Thread.sleep(1000);
            }
        }
    }

    //Shootmob sjekker om en mob kommer innenfor tårnets rekkevidde og tegnger
    // i tilfellet en "Stråle" fra tårn til mob.
    public static void ShootMob(Graphics g) {
        for (Towers t : TowerArray) {
            for (MobsElement mob : mobsArrayList) {
                if (t.TowerReach.intersects(mob.MobReach)) {

                    mob.mobHealth -= 1;
                    g.setColor(Color.RED);
                    g.drawLine(t.posX + 35, t.posY + 35, mob.posX + 22, mob.posY + 23);
                    break;

                } else if (mob.mobHealth == 0) {
                    mobsArrayList.remove(mob);
                    break;
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
//            menuStart();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //Henter coordinatene hvor musen ble klikket, og tegner et tårn i posisjonen.

        int mseposX = e.getX();
        int mseposY = e.getY();

        if (Cash >= 20) {
            Cash -= 20;
            Towers tower = new Towers();

            tower.posX = mseposX - 35;
            tower.posY = mseposY - 35;

            tower.Draw(View.getGraphics());

            TowerArray.add(tower);

        } else {
            System.out.println("Not enough cash for sponge!");
        }
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

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}