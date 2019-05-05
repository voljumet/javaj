import java.awt.*;

import static java.awt.Font.BOLD;

public class Stats extends ContSetup{

    public Stats(){ }

    /** Tegner grafikk til Player stats */
    public void Draw(Graphics g){
        g.drawImage(cashIcon.getImage(), 20, 15, 18, 18, null);
        g.drawImage(killsIcon.getImage(), 20, 45, 18, 18, null);
        g.drawImage(healthIcon.getImage(), 20, 75, 18, 18, null);

        g.setColor(new Color(0, 0, 0, 252));
        g.setFont(new Font("Corier New", BOLD, 16));

        g.drawString("Cash: " + Controller.Cash, 50, 30);
        g.drawString("Kills: " + Controller.Kills, 50, 60);
        g.drawString("Health: " + Controller.health, 50, 90);
    }
}
