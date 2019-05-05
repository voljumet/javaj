import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Date;

import static java.awt.Font.BOLD;

public class Controller extends ContSetup implements KeyListener, MouseListener, MouseMotionListener {

    public Controller() throws IOException, UnsupportedAudioFileException,
            InterruptedException, LineUnavailableException {

        PipePositionListXY = new PPListXY();
        Shootmob = new ShootMob();
        View = new View();
        stats = new Stats();
        mobsArrayList.add(new Mob());

        View.addKeyListener(this);
        View.addMouseListener(this);

//        store = new Store();

        tileset[0] = new ImageIcon("Pictures/Icons/button-01.png").getImage();
        tileset[1] = new ImageIcon("Pictures/Icons/Towers-01.png").getImage();
        tileset[2] = new ImageIcon("Pictures/Icons/Towers-02.png").getImage();
        tileset[3] = new ImageIcon("Pictures/Icons/Icon-06.png").getImage();
        tileset[4] = new ImageIcon("Pictures/Icons/Icon-05.png").getImage();

        Background(View.getGraphics());  /*Tegner bakgrunn*/

        SPawnPipe(View.getGraphics());   /*Tegner Pipes*/

        /* Må være siste linje, denne looper til spillet blir avsluttet */
        GameLoop(View.getGraphics());  /*kjører GameLoop*/

    }

     /*Gameloop er hvor spillet kjører.*/
    public void GameLoop(Graphics gg) throws InterruptedException, IOException {


        long frameStart = System.nanoTime();
        int spawn = 0, spawnRate = 50;
        float FPStimer = 0;
        while (true) {

             /*Timer for hvor mange ganger den skal loope GameLoopen før den tegner alle drawFPS-Funksjonene*/
            FPStimer++;
            if (FPStimer == 7){
                FPStimer = 0;
                drawFPS = true;
            }
            if (drawFPS) {

                Background(gg); /*tegner bakgrunn*/
                stats.Draw(gg); /*tegner stats*/
                store(gg); /*tegner shop*/
                for (PipeLine p : PipeLineArray) { p.Draw(gg);} /*Tegner PipeLine*/
            }

            /*Nedtelling før game starter*/
            if (countDown > 0) {
                Background(gg);
                for (PipeLine p : PipeLineArray) {p.Draw(gg);}
                CountDown();
                countDown -= 1;

            } else {

                /*mobs spawner kun til det er spawnet 20stk*/
                if (spawnedmobs < 20) {
                    /*Mobs spawner i frekvens spanwnRate*/
                    if (spawn == spawnRate) {
                        mobsArrayList.add(new Mob());
                        spawn = 0;
                        spawnedmobs += 1;
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

                /* Shoot mob */
                if(drawFPS) { Shootmob.Draw(gg); }



//                Thread.sleep(20);

                /* RIKTIG MÅTE Å BRUKE TIMER!!-------------------------------------------------------------------------------------- */

                elapsedTime = (System.nanoTime() - frameStart) / NANOSECONDS_PER_MILLISECOND;

                frameStart = System.nanoTime() + MS_PER_FRAME * NANOSECONDS_PER_MILLISECOND;

                int millis = 20;
                if (elapsedTime > millis){elapsedTime = millis;}

                Thread.sleep(millis - elapsedTime);

                /* RIKTIG MÅTE Å BRUKE TIMER!!-------------------------------------------------------------------------------------- */

                if (drawFPS){
                    int waveSize = 20;
                         if (Kills == waveSize * wave && wave == 1) { System.out.println("Wave 1 done"); wave += 1; countDown = 5; mobsArrayList.clear(); }
                    else if (Kills == waveSize * wave && wave == 2) { System.out.println("Wave 2 done"); wave += 1; countDown = 5; mobsArrayList.clear(); }
                    else if (Kills == waveSize * wave && wave == 3) { System.out.println("Wave 3 done"); wave += 1; countDown = 5; mobsArrayList.clear(); }
                    else if (Kills == waveSize * wave && wave == 4) { System.out.println("Wave 4 done"); wave += 1; countDown = 5; mobsArrayList.clear(); }
                    else if (Kills == waveSize * wave && wave == 5) { System.out.println("Wave 5 done"); wave += 1; countDown = 5; mobsArrayList.clear(); }
                    else if (Kills == waveSize * wave && wave == 6) { System.out.println("Wave 6 done"); wave += 1; countDown = 5; mobsArrayList.clear(); }
                }
                if (health <= 0) {
                    System.out.println("Game Lost");
                    gameLost = true;
                    CountDown();
                    Thread.sleep(2000);
                    new HighScore();
                    mobsArrayList.clear();
                    break; /*stopper loopen/spillet*/

                }
            }
            /*reset for "FPS"*/
            drawFPS = false;
        }
    }

    public void Background(Graphics g) { g.drawImage(backgroundImage.getImage(), 0, 0, 900, 900, null); }

    public void SPawnPipe(Graphics g) throws UnsupportedAudioFileException,
            IOException, LineUnavailableException, InterruptedException {

        int sleep = 100;
        if (debugMode) { sleep = 0; }
        for (count = 0; count < PPListXY.PPX.size() - 1; count++) {
            PipeLine pipeLine = new PipeLine();      /* using correct pipeDrawn icons from this*/
            PPSound = new PipeBuildSound();          /* Lyden av Pipes*/
            pipeLine.Draw(g);                        /* Tegner pipeDrawn ikon*/
            PipeLineArray.add(pipeLine);
            Thread.sleep(sleep);                     /*venter 100ms før den fortsetter loopen*/
        }
    }

    public void CountDownPrint(Graphics g, int tim) {
        g.setColor(new Color(0, 0, 0, 252));
        if(!gameLost) {
            g.setFont(new Font("Corier New", BOLD, 50));
            g.drawString("Wave " + wave + " starts in: " + tim / 1000, 220, 250);
        } else {
            g.setFont(new Font("Corier New", BOLD, 100));
            g.drawString("GAME OVER", 140, 250);
        }
    }

    public void CountDown() throws InterruptedException {
        if (!debugMode) {
            if (!gameLost) {
                timer = 1000 * countDown;
                System.out.println("Game starts in " + timer / 1000 + " sek");
                CountDownPrint(View.getGraphics(), timer);    // Countdown tekst
                Thread.sleep(1000);
            } else {
                CountDownPrint(View.getGraphics(), timer);
            }
        }
    }

    @Override public void mouseClicked(MouseEvent e) {

        /*Henter coordinatene hvor musen ble klikket, og tegner et tårn i posisjonen.*/
        if (Cash >= 20) {
            /*setter posisjon til rutenett*/
            posX(e);
            posY(e);

            if(!outOfMap) { /*sjekker om man prøver å lage tårn utenfor det som er lovlig plassering*/

                if (towerbutton1) {
                    towerbutton1 = false;

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
                    holdsItem = false;

                    System.out.println(TowerArray.size());

                    tower.Draw(View.getGraphics());
                }
                if (towerbutton2) {
                    towerbutton2 = false;

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
                    Cash -= 30;
                    holdsItem = false;

                    System.out.println(TowerArray.size());

                    tower.Draw(View.getGraphics());
                }
            }

        } else { System.out.println("Not enough cash for sponge!"); }
        if (MenuX && MenuY1) { MenuY1 = false; System.out.println("Knapp en trykket"); towerbutton1 = true; }
        if (MenuX && MenuY2) { MenuY2 = false; System.out.println("Knapp to trykket"); towerbutton2 = true; }
        if (MenuX && MenuY3) { MenuY3 = false; System.out.println("Knapp tre trykket"); try { onlyHS = true; new HighScore(); } catch (IOException e1) { } }
        if (MenuX && MenuY4) { MenuY4 = false; System.out.println("Knapp fire trykket"); new MenuBox(); }
        MenuX = false;
    }

    private void posX(MouseEvent e) { mseposX = e.getX();
        if (mseposX >= 845 && mseposX < 900){MenuX = true;}
             if (mseposX >=   0 && mseposX <  90){mseposX =   0; outOfMap = false;}
        else if (mseposX >=  90 && mseposX < 180){mseposX =  90; outOfMap = false;}
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
             if (mseposY >=   0 && mseposY <  55){MenuY1 = true;}
        else if (mseposY >=  55 && mseposY < 110){MenuY2 = true;}
        else if (mseposY >= 110 && mseposY < 165){MenuY3 = true;}
        else if (mseposY >= 165 && mseposY < 220){MenuY4 = true;}
             if (mseposY >=   0 && mseposY <  90){mseposY =   0; outOfMap = true; }
        else if (mseposY >=  90 && mseposY < 180){mseposY =  90; outOfMap = true; }
        else if (mseposY >= 180 && mseposY < 270){mseposY = 180; outOfMap = false;}
        else if (mseposY >= 270 && mseposY < 360){mseposY = 270; outOfMap = false;}
        else if (mseposY >= 360 && mseposY < 450){mseposY = 360; outOfMap = false;}
        else if (mseposY >= 450 && mseposY < 540){mseposY = 450; outOfMap = false;}
        else if (mseposY >= 540 && mseposY < 630){mseposY = 540; outOfMap = false;}
        else if (mseposY >= 630 && mseposY < 720){mseposY = 630; outOfMap = false;}
        else if (mseposY >= 720 && mseposY < 810){mseposY = 720; outOfMap = false;}
        else if (mseposY >= 810 && mseposY < 900){mseposY = 810; outOfMap = false;}
    }

    public void click(int mouseButton) {
        if (mouseButton == 1) {

            for (int i = 0; i < button.length; i++) {
                if (button[i].contains(mse)) {
                    if (buttonID[i] == 3 || buttonID[i] == 4) { /* hvis man trykker på knapp 3 & 4, plukker man ikke opp ikonet*/
                        holdsItem = false;
                    } else {
                        heldID = buttonID[i];
                        holdsItem = true;
                    }
                }
            }
        }
    }

    public void store(Graphics g) {
        for (int i = 0; i < button.length; i++) {
            button[i] = new Rectangle(850, 5 + ((buttonSize + cellSpace) * i), buttonSize, buttonSize);
        }
        for (int i = 0; i < button.length; i++) {

//            mse = View.getMousePosition();

//            if (mse != null && button[i].contains(mse)) {
//                g.setColor(new Color(255, 255, 255, 80));
//                g.fillRect(button[i].x, button[i].y, button[i].width, button[i].height);
//
//            }
            if (Controller.drawFPS) {
//                g.drawImage(Controller.tileset[0], button[i].x, button[i].y, button[i].width, button[i].height, null);
                g.drawImage(Controller.tileset[i + 1], button[i].x + itemIn, button[i].y + itemIn, button[i].width - (itemIn * 2), button[i].height - (itemIn * 2), null);

                if (buttonPrice[i] > 0) {
                    g.setColor(new Color(0, 0, 0));
                    g.setFont(new Font("Courier New", Font.BOLD, 16));
                    g.drawString("$" + buttonPrice[i], button[i].x + itemIn * 2, button[i].y + itemIn * 7);
                }

                if (mse != null && holdsItem) {
                    g.drawImage(Controller.tileset[heldID], mse.x - (75 / 2), mse.y - (75 / 2), 75, 75, null);
                }
            }
        }
    }


    @Override public void keyPressed(KeyEvent e) { if (e.getKeyCode() == KeyEvent.VK_ESCAPE) { System.exit(0); } }

    @Override public void mousePressed(MouseEvent e) { click(e.getButton()); }

    @Override public void mouseDragged(MouseEvent e) { mse = View.getMousePosition(); }

    @Override public void mouseMoved(MouseEvent e) { mse = View.getMousePosition(); }

    @Override public void mouseReleased(MouseEvent e) { }

    @Override public void mouseEntered(MouseEvent e) { }

    @Override public void mouseExited(MouseEvent e) { }

    @Override public void keyReleased(KeyEvent e) { }

    @Override public void keyTyped(KeyEvent e) { }
}