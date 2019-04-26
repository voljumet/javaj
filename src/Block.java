import java.awt.*;

public class Block extends Rectangle{
    public Rectangle towerSquare;
    public int towerSquareSize = 130;
    public int groundID;
    public int airID;
    public int loseTime = 100, loseFrame = 0;

    public int shotMob = -1;
    public boolean shooting = false;

    public Block(int x, int y, int width, int height, int groundID, int airID){
        setBounds(x, y, width, height);
        towerSquare = new Rectangle(x - (towerSquareSize/2),y - (towerSquareSize/2),width + towerSquareSize,height + towerSquareSize);
        this.groundID = groundID;
        this.airID = airID;
    }
}
