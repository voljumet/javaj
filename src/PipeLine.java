import javax.swing.*;
import java.awt.*;

public class PipeLine extends GraphicalElement {

    int Y1 = 0, Y2 = 0, Y3 = 0, Y4 = 0, Y5 = 0, Y6 = 0;
    int X1 = 0, X2 = 0, X3 = 0, X4 = 0, X5 = 0, X6 = 0;

    public boolean debugMode = false;

    /** Later ikoner */
    private ImageIcon pipe1 = new ImageIcon("Pictures/Icons/Pipes-01.png");
    private ImageIcon pipe2 = new ImageIcon("Pictures/Icons/Pipes-02.png");
    private ImageIcon pipe3 = new ImageIcon("Pictures/Icons/Pipes-03.png");
    private ImageIcon pipe4 = new ImageIcon("Pictures/Icons/Pipes-04.png");
    private ImageIcon pipe5 = new ImageIcon("Pictures/Icons/Pipes-05.png");
    private ImageIcon pipe6 = new ImageIcon("Pictures/Icons/Pipes-06.png");
    private ImageIcon pipe7 = new ImageIcon("Pictures/Icons/Pipes-07.png");
    private ImageIcon pipe8 = new ImageIcon("Pictures/Icons/Pipes-08.png");

    public PipeLine(){
        if(Controller.count == 0){ img = pipe7; height = 90; width = 90;}  //Første pipeDrawn
        else if(Controller.count == 31){  img = pipe8; height = 200; width = 180;}  //Siste pipeDrawn
        else{
            /** Sjekker størrelsene på koordinater og setter 1 på de som stemmer for X*/
            if(PPListXY.PPX.get(Controller.count).equals(PPListXY.PPX.get(Controller.count + 1))){ X1 = 1;}
            if(PPListXY.PPX.get(Controller.count).equals(PPListXY.PPX.get(Controller.count - 1))){ X2 = 1;}
            if(PPListXY.PPX.get(Controller.count)   <   (PPListXY.PPX.get(Controller.count + 1))){ X3 = 1;}
            if(PPListXY.PPX.get(Controller.count)   <   (PPListXY.PPX.get(Controller.count - 1))){ X4 = 1;}
            if(PPListXY.PPX.get(Controller.count)   >   (PPListXY.PPX.get(Controller.count + 1))){ X5 = 1;}
            if(PPListXY.PPX.get(Controller.count)   >   (PPListXY.PPX.get(Controller.count - 1))){ X6 = 1;}

            /** Sjekker størrelsene på koordinater og setter 1 på de som stemmer for Y*/
            if(PPListXY.PPY.get(Controller.count).equals(PPListXY.PPY.get(Controller.count + 1))){ Y1 = 1;}
            if(PPListXY.PPY.get(Controller.count).equals(PPListXY.PPY.get(Controller.count - 1))){ Y2 = 1;}
            if(PPListXY.PPY.get(Controller.count)   <   (PPListXY.PPY.get(Controller.count + 1))){ Y3 = 1;}
            if(PPListXY.PPY.get(Controller.count)   <   (PPListXY.PPY.get(Controller.count - 1))){ Y4 = 1;}
            if(PPListXY.PPY.get(Controller.count)   >   (PPListXY.PPY.get(Controller.count + 1))){ Y5 = 1;}
            if(PPListXY.PPY.get(Controller.count)   >   (PPListXY.PPY.get(Controller.count - 1))){ Y6 = 1;}

            /** Setter icon til riktig sett med koordinater*/
                 if(X1 == 1 && X2 == 1 && Y4 == 1 && Y5 == 1){ img = pipe1;}
            else if(X1 == 1 && X2 == 1 && Y3 == 1 && Y6 == 1){ img = pipe1;}

            else if(X2 == 1 && X3 == 1 && Y1 == 1 && Y4 == 1){ img = pipe2;}
            else if(X1 == 1 && X4 == 1 && Y2 == 1 && Y3 == 1){ img = pipe2;}

            else if(X2 == 1 && X5 == 1 && Y1 == 1 && Y4 == 1){ img = pipe3;}
            else if(X1 == 1 && X6 == 1 && Y2 == 1 && Y3 == 1){ img = pipe3;}

            else if(X3 == 1 && X6 == 1 && Y1 == 1 && Y2 == 1){ img = pipe4;}
            else if(X4 == 1 && X5 == 1 && Y1 == 1 && Y2 == 1){ img = pipe4;}

            else if(X1 == 1 && X4 == 1 && Y2 == 1 && Y5 == 1){ img = pipe5;}
            else if(X2 == 1 && X3 == 1 && Y1 == 1 && Y6 == 1){ img = pipe5;}

            else if(X1 == 1 && X6 == 1 && Y2 == 1 && Y5 == 1){ img = pipe6;}
            else if(X2 == 1 && X5 == 1 && Y1 == 1 && Y6 == 1){ img = pipe6;}

            height = 90; width = 90;
        }

        if (debugMode) {
            System.out.println("X: "+PPListXY.PPX.get(Controller.count)+", Y: "+PPListXY.PPY.get(Controller.count));
            System.out.print("Runde "+Controller.count+":X1="+X1+", X2="+X2+", X3="+X3+", X4="+X4+", X5="+X5+", X6="+X6);
            System.out.println(" | Y1="+Y1+", Y2="+Y2+", Y3="+Y3+", Y4="+Y4+", Y5="+Y5+", Y6="+Y6);
            System.out.println(" ");
        }

        posX = PPListXY.PPX.get(Controller.count);
        posY = PPListXY.PPY.get(Controller.count);

        image = img.getImage();
    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(image, posX, posY, width, height, null);
    }
}