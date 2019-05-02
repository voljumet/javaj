public class MobPysics extends Mob{

    public MobPysics(MobsElement m){
        if (PPListXY.randomNumber == 0){
            if (m.mapPlace >= 0    && m.mapPlace < 90  ){ m.posY -= 1;} //0
            if (m.mapPlace >= 90   && m.mapPlace < 450 ){ m.posX += 1;} //1
            if (m.mapPlace >= 450  && m.mapPlace < 1080){ m.posY -= 1;} //5
            if (m.mapPlace >= 1080 && m.mapPlace < 1350){ m.posX -= 1;} //12
            if (m.mapPlace >= 1350 && m.mapPlace < 1710){ m.posY += 1;} //15
            if (m.mapPlace >= 1710 && m.mapPlace < 1890){ m.posX -= 1;} //19
            if (m.mapPlace >= 1890 && m.mapPlace < 1980){ m.posY += 1;} //21 ---
            if (m.mapPlace >= 1980 && m.mapPlace < 2160){ m.posX -= 1;} //22
            if (m.mapPlace >= 2160 && m.mapPlace < 2520){ m.posY -= 1;} //24
            if (m.mapPlace >= 2520 && m.mapPlace < 2610){ m.posX += 1;} //28
            if (m.mapPlace >= 2610 && m.mapPlace < 2790){ m.posY -= 1;} //29
            if (m.mapPlace >= 2790 && m.mapPlace < 2791){
                m.posY = -100;
                Controller.health -= 5;
            } //Mob går i tårn


//            System.out.println("mapPlace = " + mapPlace);

        } else if (PPListXY.randomNumber == 1){
            System.out.println("map 1");
        } else if (PPListXY.randomNumber == 2){
            System.out.println("map 2");
        } else if (PPListXY.randomNumber == 3){
            System.out.println("map 3");
        }


        m.mapPlace += 1;
    }
}
