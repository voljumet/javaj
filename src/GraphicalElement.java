import javax.swing.*;
import java.awt.*;

public abstract class GraphicalElement extends JPanel{

    int posX;
    int posY;
    int height, width;
    ImageIcon img;
    Image image;

    public abstract void Draw(Graphics g);

}




