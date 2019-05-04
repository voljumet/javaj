import javax.swing.*;
import java.awt.*;

public abstract class GraphicalElement extends Rectangle{

    int posX;
    int posY;
    int height, width;
    ImageIcon img;
    Image image;

    public abstract void Draw(Graphics g);

    @Override
    public String toString() {
        return "X: " + posX + "\tY: " + posY + "\tH: " + height + "\tW: " +width;
    }
}




