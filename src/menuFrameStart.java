import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class menuFrameStart extends JFrame {

    JButton startGame, highScore, saveGame, quitGame, newGame;

    public menuFrameStart(){

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(200,200);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);

        BoxLayout boxLayout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
        this.setLayout(boxLayout);

        startGame = new JButton("Start Game");
        startGame.addActionListener(e -> {
            menuFrameStart.this.setVisible(false);
            Controller.gameRunning = true;
        });

        newGame = new JButton("New game");
        newGame.addActionListener(e -> {
            menuFrameStart.this.setVisible(false);
            Controller.gameRunning = true;
        });

        highScore = new JButton("High score");
        highScore.addActionListener(e -> JOptionPane.showMessageDialog(null,  "High score clicked!"));

        saveGame = new JButton("Save game");
        saveGame.addActionListener(e -> JOptionPane.showMessageDialog(null,  "Save Game clicked!"));

        quitGame = new JButton("Quit game");
        quitGame.addActionListener(e -> { System.exit(1); });

        if (Controller.newG){
            Controller.newG = false;
            this.add(startGame);
        }else {
            this.add(newGame);
        }

        this.add(highScore);
        this.add(saveGame);
        this.add(quitGame);
        this.pack();
        this.setVisible(true);

    }


}
