import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import static java.awt.Font.BOLD;

public class Controller extends ContSetup implements KeyListener, MouseListener, MouseMotionListener {

    public Controller() throws IOException, UnsupportedAudioFileException, InterruptedException, LineUnavailableException {

        PipePositionListXY = new PPListXY();
        View = new View();
        stats = new Stats();
        Shootmob = new ShootMob();
        highScore = new HighScore();
        Sound = new Sound();
        store = new Store();

        View.addKeyListener(this);
        View.addMouseListener(this);
        View.addMouseMotionListener(this);

        /** Laster ikoner */
        tileset[0] = new ImageIcon("Pictures/Icons/button-01.png").getImage();
        tileset[1] = new ImageIcon("Pictures/Icons/Towers-01.png").getImage();
        tileset[2] = new ImageIcon("Pictures/Icons/Towers-02.png").getImage();
        tileset[3] = new ImageIcon("Pictures/Icons/Icon-06.png").getImage();
        tileset[4] = new ImageIcon("Pictures/Icons/Icon-05.png").getImage();

        /** Tegner bakgrunn */
        Background(View.getGraphics());

        /** Tegner Pipes */
        SPawnPipe(View.getGraphics());

        initiateGameOptions();

        gameinprogress = true;

        /** ------------- GameLoop --------------- */
        GameLoop(View.getGraphics());
        /** ------------- GameLoop --------------- */
    }

    public void initiateGameOptions() throws IOException, InterruptedException, LineUnavailableException, UnsupportedAudioFileException {
        gameWon = false;
        countDown = 5;
        TowerArray.clear();
        health = 100;
        Kills = 0;
        Cash = 40;
        mobsInWave = 0;
        mobsInPipe = 1;
        wave = 1;
    }

    /** ------------------------------------------------------------ GameLoop ---------------------------------------------------------- */
    public void GameLoop(Graphics gg) throws InterruptedException, IOException {

        long frameStart = System.nanoTime();
        int spawn = 0, spawnRate = 50;
        float FPStimer = 0;
        while (true) {

             /** Timer for hvor mange ganger den skal loope GameLoopen før den tegner alle drawFPS-Funksjonene */

            FPStimer++;
            if (FPStimer == 5){
                FPStimer = 0;
                drawFPS = true;
            }
            if (drawFPS) {
                Background(gg); /** Tegner bakgrunn på nytt */
                stats.Draw(gg); /** Tegner stats på nytt */
                store.draw(gg, mse); /** Tegner shop på nytt */
                for (PipeLine p : PipeLineArray) { p.Draw(gg);} /** Tegner PipeLine på nytt */
            }

            /** Nedtelling før game starter*/
            if (countDown > 0) {
                Background(gg);
                for (PipeLine p : PipeLineArray) {p.Draw(gg);}
                CountDown();
                countDown -= 1;

            } else {

                    /** Mobs spawner kun til det er spawnet 20stk*/
                if (mobsInWave < 20) {
                    /** Mobs spawner i frekvens spanwnRate*/

                    if (spawn == spawnRate) {
                        if(mobsArrayList.size() == 0) {
                            mobsArrayList.add(new Mob());
                            Sound.BoomSound();
                            spawn = 0;
                            mobsInWave += 1;
                        }else{
                            mobsArrayList.add(new Mob());
                            Sound.BoomSound();
                            mobsInPipe += 1;
                            spawn = 0;
                            mobsInWave += 1;
                        }
                    }
                    spawn += 1;
                }

                /**Tegner mobs*/
                for (MobsElement m : mobsArrayList) {
                    new MobPysics(m);
                    if (m.inGame) {if (drawFPS){m.Draw(gg); if(debugMode)gg.drawRect(m.posX, m.posY,45,45);}}
                }

                /**Tegner Towers*/
                for (Towers t : TowerArray) { if (drawFPS){t.Draw(gg);  if(debugMode)gg.drawRect(t.posX - t.offset, t.posY - t.offset, 200, 200);} }

                /** Shoot mob logikk */
                if(drawFPS) { Shootmob.ShootMob(gg); }

                /** Delay = millis - tid fra starten av loopen til nå
                 * Dette er gameloop logikk på høyeste nivå!*/
                elapsedTime = (System.nanoTime() - frameStart) / NANOSECONDS_PER_MILLISECOND;
                frameStart = System.nanoTime() + MS_PER_FRAME * NANOSECONDS_PER_MILLISECOND;
                long millis = 20;
                if (elapsedTime > millis){elapsedTime = millis;}
                Thread.sleep(millis - elapsedTime);

                /** Sjekker for hver runde om runden er over*/
                if (drawFPS){
                         if (mobsInPipe == 0 && wave == 1) { System.out.println("Wave 1 done"); wave += 1; countDown = 5; mobsInPipe = 1; mobsInWave = 0; mobsArrayList.clear(); }
                    else if (mobsInPipe == 0 && wave == 2) { System.out.println("Wave 2 done"); wave += 1; countDown = 5; mobsInPipe = 1; mobsInWave = 0; mobsArrayList.clear(); }
                    else if (mobsInPipe == 0 && wave == 3) { System.out.println("Wave 3 done"); wave += 1; countDown = 5; mobsInPipe = 1; mobsInWave = 0; mobsArrayList.clear(); }
                    else if (mobsInPipe == 0 && wave == 4) { System.out.println("Wave 4 done"); wave += 1; countDown = 5; mobsInPipe = 1; mobsInWave = 0; mobsArrayList.clear(); }
                    else if (mobsInPipe == 0 && wave == 5) { System.out.println("Wave 5 done"); wave += 1; countDown = 5; mobsInPipe = 1; mobsInWave = 0; mobsArrayList.clear(); }
                    else if (mobsInPipe == 0 && wave == 6) { System.out.println("Wave 6 done"); wave += 1; countDown = 5; mobsInPipe = 1; mobsInWave = 0; mobsArrayList.clear(); gameWon = true; }
                }
                if(gameWon){
                    CountDownPrint(View.getGraphics(), Kills);
                    if(highScore.getHighscore()){
                        try {
                            initiateGameOptions();
                        } catch (LineUnavailableException | UnsupportedAudioFileException e) {
                            e.printStackTrace();
                        }

                        gameWon = false;
                    }
                    else System.exit(0);
                }

                /** Hvis man dør */
                if (health <= 0) {
                    System.out.println("Game Lost");
                    gameLost = true;
                    CountDown();
                    Thread.sleep(2000);

                    mobsArrayList.clear();
                    if(highScore.getHighscore()){
                        try {
                            initiateGameOptions();
                        } catch (LineUnavailableException | UnsupportedAudioFileException e) {
                            e.printStackTrace();
                        }
                    }
                    /** Stopper loopen/spillet */
                    else System.exit(0);
                }
            }
            /** Reset "FPS" */
            drawFPS = false;
        }
    }
    /** ------------------------------------------------------------ GameLoop ---------------------------------------------------------- */

    /** Tegner Bakgrun */
    public void Background(Graphics g) { g.drawImage(backgroundImage.getImage(), 0, 0, 900, 900, null); }

    /** Tegner PipeLine med lyd og delay mellom hvert ledd */
    public void SPawnPipe(Graphics g) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        int sleep = 100;
        if (debugMode) { sleep = 0; }
        for (count = 0; count < PPListXY.PPX.size() - 1; count++) {
            PipeLine pipeLine = new PipeLine();      /** Using correct pipeDrawn icons from this*/
            PPSound = new PipeBuildSound();          /** Lyden av Pipes*/
            pipeLine.Draw(g);                        /** Tegner pipeDrawn ikon*/
            PipeLineArray.add(pipeLine);
            Thread.sleep(sleep);                     /** Venter 100ms før den fortsetter loopen*/
        }
    }

    /** Nedtelling før game og etter game  */
    public void CountDownPrint(Graphics g, int tim) {
        g.setColor(new Color(0, 0, 0, 252));
        if(!gameLost) {
            if(gameWon){
                g.setFont(new Font("Corier New", BOLD, 100));
                g.drawString("GAME WON", 140, 250);
            }else {
                g.setFont(new Font("Corier New", BOLD, 50));
                g.drawString("Wave " + wave + " starts in: " + tim / 1000, 220, 250);
            }
        } else {
            g.setFont(new Font("Corier New", BOLD, 100));
            g.drawString("GAME OVER", 140, 250);
        }
    }

    /** Nedtelling */
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


        /**bruker health = 0 for debugging*/
//        health = 0;
            /** Henter coordinatene hvor musen ble klikket, og tegner et tårn i posisjonen.*/
        if (Cash >= 20) {

            /** Setter Mus Pos X & Y i rutenett */
            posX(e);
            posY(e);

            /** Sjekker om man prøver å lage tårn utenfor det som er lovlig plassering*/
            if(!outOfMap) {

                /** Knapp 1 i Meny, logikk for når man trykker på knappen*/
                if (MenuButton1) {
                    MenuButton1 = false;

                    Towers tower = new Towers(mseposX+10, mseposY+10);
                    TowerArray.add(tower);
                    Cash -= 20;
                    store.holdsItem = false;
                    tower.Draw(View.getGraphics());
                }

                /** Knapp 2 i Meny, logikk for når man trykker på knappen*/
                if (MenuButton2) {
                    MenuButton2 = false;

                    Towers tower = new Towers(mseposX+10, mseposY+10);
                    TowerArray.add(tower);
                    /** tower not implemented! */
//                    Cash -= 30;
                    store.holdsItem = false;
                    tower.Draw(View.getGraphics());
                }

                /** Knapp 3 i Meny, logikk for når man trykker på knappen*/
                if (MenuButton3) { MenuButton3 = false; }

                /** Knapp 4 i Meny, logikk for når man trykker på knappen*/
                if (MenuButton4) { MenuButton4 = false; }
            }

        } else { System.out.println("Not enough cash for sponge!"); }

        /** Sjekker hvilken knapp som blir trykket på */
        if (MenuX && MenuY1) { MenuY1 = false; System.out.println("Knapp en trykket");   MenuButton1 = true; }
        if (MenuX && MenuY2) { MenuY2 = false; System.out.println("Knapp to trykket");   MenuButton2 = true; }

        if (MenuX && MenuY3) { MenuY3 = false; System.out.println("Knapp tre trykket");  MenuButton2 = true;
            onlyHS = true;
            try {
                highScore.HighSc();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            onlyHS = false;
        }

        if (MenuX && MenuY4) { MenuY4 = false; System.out.println("Knapp fire trykket"); MenuButton2 = true; new MenuBox(); }
        MenuX = false;
    }

    /** Logikk for musepeker X-Retning*/
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

    /** Logikk for musepeker Y-Retning*/
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


    @Override public void keyPressed(KeyEvent e) { if (e.getKeyCode() == KeyEvent.VK_ESCAPE) { System.exit(0); } }

    /** Sender Mus Pos X & Y til Store */
    @Override public void mousePressed(MouseEvent e) { store.click(e.getButton(), mse); }

    @Override public void mouseDragged(MouseEvent e) {/*mse = View.getMousePosition();*/}

    /** Hvis man beveger musen lagres Pos X & Y til mse */
    @Override public void mouseMoved(MouseEvent e) { mse = View.getMousePosition(); }

    @Override public void mouseReleased(MouseEvent e) { }

    @Override public void mouseEntered(MouseEvent e) { }

    @Override public void mouseExited(MouseEvent e) { }

    @Override public void keyReleased(KeyEvent e) { }

    @Override public void keyTyped(KeyEvent e) { }
}