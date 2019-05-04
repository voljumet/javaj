import javax.swing.*;
import java.awt.*;

public abstract class GraphicalElement extends Rectangle{



    int posX;
    int posY;
    int height, width;
    ImageIcon img;
    Image image;

    public abstract void Draw(Graphics g);

    public Point getCenter(){
        return new Point(posX - width/2, posY - height/2);
    }


}




