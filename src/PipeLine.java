import javax.swing.*;

public class PipeLine extends GraphicalElement {

    int Y1 = 0, Y2 = 0, Y3 = 0, Y4 = 0, Y5 = 0, Y6 = 0;
    int X1 = 0, X2 = 0, X3 = 0, X4 = 0, X5 = 0, X6 = 0;

    public boolean debugMode = false;

    public PipeLine(){

        if(Controller.count == 0){ i = new ImageIcon("Pictures/Icons/Icons-07.png"); height = 90;    width = 90;}  //Første pipeDrawn
        else if(Controller.count == 31){  i = new ImageIcon("Pictures/Icons/Icons-08.png"); height = 200;   width = 180;}  //Siste pipeDrawn
        else{
//          Sjekker størrelsene på koordinater og setter 1 på de som stemmer for X
            if(PPListXY.PPX.get(Controller.count).equals(PPListXY.PPX.get(Controller.count + 1))){ X1 = 1;}
            if(PPListXY.PPX.get(Controller.count).equals(PPListXY.PPX.get(Controller.count - 1))){ X2 = 1;}
            if(PPListXY.PPX.get(Controller.count)   <   (PPListXY.PPX.get(Controller.count + 1))){ X3 = 1;}
            if(PPListXY.PPX.get(Controller.count)   <   (PPListXY.PPX.get(Controller.count - 1))){ X4 = 1;}
            if(PPListXY.PPX.get(Controller.count)   >   (PPListXY.PPX.get(Controller.count + 1))){ X5 = 1;}
            if(PPListXY.PPX.get(Controller.count)   >   (PPListXY.PPX.get(Controller.count - 1))){ X6 = 1;}

//          Sjekker størrelsene på koordinater og setter 1 på de som stemmer for Y
            if(PPListXY.PPY.get(Controller.count).equals(PPListXY.PPY.get(Controller.count + 1))){ Y1 = 1;}
            if(PPListXY.PPY.get(Controller.count).equals(PPListXY.PPY.get(Controller.count - 1))){ Y2 = 1;}
            if(PPListXY.PPY.get(Controller.count)   <   (PPListXY.PPY.get(Controller.count + 1))){ Y3 = 1;}
            if(PPListXY.PPY.get(Controller.count)   <   (PPListXY.PPY.get(Controller.count - 1))){ Y4 = 1;}
            if(PPListXY.PPY.get(Controller.count)   >   (PPListXY.PPY.get(Controller.count + 1))){ Y5 = 1;}
            if(PPListXY.PPY.get(Controller.count)   >   (PPListXY.PPY.get(Controller.count - 1))){ Y6 = 1;}

//          if-er koordinater og setter icon på riktig sett med koordinater
                 if(X1 == 1 && X2 == 1 && Y4 == 1 && Y5 == 1){ i = new ImageIcon("Pictures/Icons/Icons-01.png");}
            //else if(X1 == 1 && X2 == 1 && Y1 == 1 && Y6 == 1){ i = new ImageIcon("Pictures/Icons/Icons-01.png");}
            else if(X1 == 1 && X2 == 1 && Y3 == 1 && Y6 == 1){ i = new ImageIcon("Pictures/Icons/Icons-01.png");}

            else if(X2 == 1 && X3 == 1 && Y1 == 1 && Y4 == 1){ i = new ImageIcon("Pictures/Icons/Icons-02.png");}
            else if(X1 == 1 && X4 == 1 && Y2 == 1 && Y3 == 1){ i = new ImageIcon("Pictures/Icons/Icons-02.png");}

            else if(X2 == 1 && X5 == 1 && Y1 == 1 && Y4 == 1){ i = new ImageIcon("Pictures/Icons/Icons-03.png");}
            else if(X1 == 1 && X6 == 1 && Y2 == 1 && Y3 == 1){ i = new ImageIcon("Pictures/Icons/Icons-03.png");}

            else if(X3 == 1 && X6 == 1 && Y1 == 1 && Y2 == 1){ i = new ImageIcon("Pictures/Icons/Icons-04.png");}
            else if(X4 == 1 && X5 == 1 && Y1 == 1 && Y2 == 1){ i = new ImageIcon("Pictures/Icons/Icons-04.png");}

            else if(X1 == 1 && X4 == 1 && Y2 == 1 && Y5 == 1){ i = new ImageIcon("Pictures/Icons/Icons-05.png");}
            else if(X2 == 1 && X3 == 1 && Y1 == 1 && Y6 == 1){ i = new ImageIcon("Pictures/Icons/Icons-05.png");}

            else if(X1 == 1 && X6 == 1 && Y2 == 1 && Y5 == 1){ i = new ImageIcon("Pictures/Icons/Icons-06.png");}
            else if(X2 == 1 && X5 == 1 && Y1 == 1 && Y6 == 1){ i = new ImageIcon("Pictures/Icons/Icons-06.png");}

            height = 90; width = 90;
        }

        if (Controller.debugMode && debugMode) {
            System.out.println("X: "+PPListXY.PPX.get(Controller.count)+", Y: "+PPListXY.PPY.get(Controller.count));
            System.out.print("Runde "+Controller.count+":X1="+X1+", X2="+X2+", X3="+X3+", X4="+X4+", X5="+X5+", X6="+X6);
            System.out.println(" | Y1="+Y1+", Y2="+Y2+", Y3="+Y3+", Y4="+Y4+", Y5="+Y5+", Y6="+Y6);
            System.out.println(" ");
        }

        posX = PPListXY.PPX.get(Controller.count);
        posY = PPListXY.PPY.get(Controller.count);

        description = "Pipeline";
        image = i.getImage();
    }
}