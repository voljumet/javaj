import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class menuFrameStart extends JFrame{

    //    final JFrame frame = new JFrame();
    JButton startGame, highScore, saveGame, quitGame;

    public String meny = "";


    public menuFrameStart(){

//        JFrame.setDefaultLookAndFeelDecorated(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(200,200);
        this.setLocationRelativeTo(null);
//            this.setTitle("Java menu");
        this.setUndecorated(true);



        BoxLayout boxLayout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);

        this.setLayout(boxLayout);


        startGame = new JButton("Start Game");
        startGame.setMnemonic(KeyEvent.VK_N);
        startGame.getAccessibleContext().setAccessibleDescription("Start Game");
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                meny = "Start game";
                menuFrameStart.this.setVisible(false);

                try {
                    Controller.SPawnPipe(Controller.View.getGraphics());
                } catch (UnsupportedAudioFileException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (LineUnavailableException ex) {
                    ex.printStackTrace();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

        });

        this.add(startGame);

//        this.add(new JButton("High score"));
        highScore = new JButton("High score");
        highScore.setMnemonic(KeyEvent.VK_P);
        highScore.getAccessibleContext().setAccessibleDescription("High score");
        highScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,  "High score clicked!");
            }
        });
        this.add(highScore);

//        this.add(new JButton("Save game"));
        saveGame = new JButton("Save game");
        saveGame.setMnemonic(KeyEvent.VK_S);
        saveGame.getAccessibleContext().setAccessibleDescription("Save game");
        saveGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,  "Save Game clicked!");
            }
        });
        this.add(saveGame);

//        this.add(new JButton("Quit game"));
        quitGame = new JButton("Quit game");
        quitGame.setMnemonic(KeyEvent.VK_Q);
        quitGame.getAccessibleContext().setAccessibleDescription("Quit game");
        quitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(frame,  "Quit game clicked!");
                System.exit(1);
            }
        });
        this.add(quitGame);
        this.pack();
        this.setVisible(true);
    }
}