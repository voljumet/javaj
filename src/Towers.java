import javax.swing.*;
import java.awt.*;

public class Towers extends GraphicalElement {
    Rectangle TowerReach;
    Rectangle TowerOverlap;
    int towerSize = 70;
    int offset = 65;

    MobsElement target = null;

    /** Laster bilde til tårn */
    private ImageIcon tower1 = new ImageIcon("Pictures/Icons/Towers-01.png");

    /** Gir Tårn størrelse, plassering, bilde og "Reach" */
    public Towers(int posX, int posY){

        height = towerSize;
        width = towerSize;

        img = tower1;
        image = img.getImage();

        this.posX = posX;
        this.posY = posY;

        TowerReach = new Rectangle((this.posX - offset), (this.posY - offset), 200, 200);
        TowerOverlap = new Rectangle(this.posX - towerSize/2, this.posY - towerSize/2, towerSize, towerSize);
    }

    public double getDistance(GraphicalElement e){ return (e.posX - this.posX) * (e.posX - this.posX) + (e.posY - this.posY) * (e.posY - this.posY); }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(image, posX, posY, width, height, null);
    } }

