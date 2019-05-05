import javax.swing.*;

public class MenuBox extends ContSetup {

    JButton highScore, saveGame, quitGame, newGame;

    public MenuBox(){

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(200,200);
        this.setUndecorated(true);

        BoxLayout boxLayout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
        this.setLayout(boxLayout);

        newGame = new JButton("Continue");
        newGame.addActionListener(e -> { MenuBox.this.setVisible(false); MenuX = false; MenuY3 = false; });

/*        highScore = new JButton("High score");
        highScore.addActionListener(e -> JOptionPane.showMessageDialog(null,  "High score clicked!"));*/

        saveGame = new JButton("Save game");
        saveGame.addActionListener(e -> JOptionPane.showMessageDialog(null,  "Save Game clicked!"));

        quitGame = new JButton("Quit game");
        quitGame.addActionListener(e -> { System.exit(1); });

        this.add(newGame);
//        this.add(highScore);
        this.add(saveGame);
        this.add(quitGame);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }


}
