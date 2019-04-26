import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class menuFrameNew extends JFrame{

    final JFrame frame = new JFrame();
    JButton startGame, highScore, saveGame, quitGame;

//    JPanel buttonPanel = new JPanel();

    public menuFrameNew(){



//        JFrame.setDefaultLookAndFeelDecorated(true);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setSize(200,200);
            this.setLocationRelativeTo(null);
            this.setTitle("Java menu");
            this.setUndecorated(true);

//        this.add(buttonPanel);

            BoxLayout boxLayout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);



            this.setLayout(boxLayout);
//        this.add(new JButton("Start game"));
            startGame = new JButton("New game");
            startGame.setMnemonic(KeyEvent.VK_P);
            startGame.getAccessibleContext().setAccessibleDescription("New game");
            startGame.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame,  "New game clicked!");
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
                    JOptionPane.showMessageDialog(frame,  "High score clicked!");
                }
            });
            this.add(highScore);

//        this.add(new JButton("Save game"));
            saveGame = new JButton("Save game");
            saveGame.setMnemonic(KeyEvent.VK_P);
            saveGame.getAccessibleContext().setAccessibleDescription("Save game");
            saveGame.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame,  "Save Game clicked!");
                }
            });
            this.add(saveGame);




//        this.add(new JButton("Quit game"));
            quitGame = new JButton("Quit game");
            quitGame.setMnemonic(KeyEvent.VK_P);
            quitGame.getAccessibleContext().setAccessibleDescription("Quit game");
            quitGame.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame,  "Quit game clicked!");
                }
            });
            this.add(quitGame);


            this.pack();

//            this.setVisible(true);
    }
}