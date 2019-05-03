public class MobPysics extends Mob{

    public MobPysics(MobsElement m){
             if (PPListXY.randomNumber == 0){ mapOne(m); }
        else if (PPListXY.randomNumber == 1){ mapTwo(m); }
        else if (PPListXY.randomNumber == 2){ mapThree(m); }
        else if (PPListXY.randomNumber == 3){ mapFour(m); }
        m.mapPlace += 1;
    }

    void mapOne(MobsElement m){
        if (m.mapPlace >= 0    && m.mapPlace < 90  ){ m.posY -= 1;} //0
        if (m.mapPlace >= 90   && m.mapPlace < 450 ){ m.posX += 1;} //1
        if (m.mapPlace >= 450  && m.mapPlace < 1080){ m.posY -= 1;} //5
        if (m.mapPlace >= 1080 && m.mapPlace < 1350){ m.posX -= 1;} //12
        if (m.mapPlace >= 1350 && m.mapPlace < 1710){ m.posY += 1;} //15
        if (m.mapPlace >= 1710 && m.mapPlace < 1890){ m.posX -= 1;} //19
        if (m.mapPlace >= 1890 && m.mapPlace < 1980){ m.posY += 1;} //21
        if (m.mapPlace >= 1980 && m.mapPlace < 2160){ m.posX -= 1;} //22
        if (m.mapPlace >= 2160 && m.mapPlace < 2520){ m.posY -= 1;} //24
        if (m.mapPlace >= 2520 && m.mapPlace < 2610){ m.posX += 1;} //28
        if (m.mapPlace >= 2610 && m.mapPlace < 2745){ m.posY = -1;} //29
        if (m.mapPlace >= 2745 && m.mapPlace < 2746){ m.posY = -100; mobDeath(); } //Mob går i tårn
    }

    void mapTwo(MobsElement m){
        if (m.mapPlace >= 0    && m.mapPlace < 540 ){ m.posY -= 1;} //0
        if (m.mapPlace >= 540  && m.mapPlace < 900 ){ m.posX += 1;} //6
        if (m.mapPlace >= 900  && m.mapPlace < 1170){ m.posY += 1;} //10
        if (m.mapPlace >= 1170 && m.mapPlace < 1350){ m.posX -= 1;} //13
        if (m.mapPlace >= 1350 && m.mapPlace < 1530){ m.posY += 1;} //15
        if (m.mapPlace >= 1530 && m.mapPlace < 1980){ m.posX += 1;} //17
        if (m.mapPlace >= 1980 && m.mapPlace < 2610){ m.posY -= 1;} //22
        if (m.mapPlace >= 2610 && m.mapPlace < 2700){ m.posX -= 1;} //29
        if (m.mapPlace >= 2700 && m.mapPlace < 2745){ m.posY -= 1;} //30
        if (m.mapPlace >= 2745 && m.mapPlace < 2746){ m.posY = -100; mobDeath(); } //Mob går i tårn
    }

    void mapThree(MobsElement m){
        if (m.mapPlace >= 0    && m.mapPlace < 630 ){ m.posY -= 1;} //0
        if (m.mapPlace >= 630  && m.mapPlace < 900 ){ m.posX += 1;} //7
        if (m.mapPlace >= 900  && m.mapPlace < 1350){ m.posY += 1;} //10
        if (m.mapPlace >= 1350 && m.mapPlace < 1980){ m.posX -= 1;} //15
        if (m.mapPlace >= 1980 && m.mapPlace < 2430){ m.posY -= 1;} //22
        if (m.mapPlace >= 2430 && m.mapPlace < 2610){ m.posX += 1;} //27
        if (m.mapPlace >= 2610 && m.mapPlace < 2745){ m.posY -= 1;} //29
        if (m.mapPlace >= 2745 && m.mapPlace < 2746){ m.posY = -100; mobDeath(); } //Mob går i tårn
    }

    void mapFour(MobsElement m){
        if (m.mapPlace >= 0    && m.mapPlace < 270 ){ m.posY -= 1;} //0
        if (m.mapPlace >= 270  && m.mapPlace < 450 ){ m.posX -= 1;} //3
        if (m.mapPlace >= 450  && m.mapPlace < 630 ){ m.posY += 1;} //5
        if (m.mapPlace >= 630  && m.mapPlace < 1080){ m.posX -= 1;} //7
        if (m.mapPlace >= 1080 && m.mapPlace < 1530){ m.posY -= 1;} //12
        if (m.mapPlace >= 1530 && m.mapPlace < 1710){ m.posX += 1;} //17
        if (m.mapPlace >= 1710 && m.mapPlace < 1800){ m.posY += 1;} //19
        if (m.mapPlace >= 1800 && m.mapPlace < 2070){ m.posX += 1;} //20
        if (m.mapPlace >= 2070 && m.mapPlace < 2160){ m.posY -= 1;} //23
        if (m.mapPlace >= 2160 && m.mapPlace < 2250){ m.posX += 1;} //24
        if (m.mapPlace >= 2250 && m.mapPlace < 2430){ m.posY -= 1;} //25
        if (m.mapPlace >= 2430 && m.mapPlace < 2700){ m.posX -= 1;} //27
        if (m.mapPlace >= 2700 && m.mapPlace < 2745){ m.posY -= 1;} //30
        if (m.mapPlace >= 2745 && m.mapPlace < 2746){ m.posY = -100; mobDeath(); } //Mob går i tårn
    }

    void mobDeath(){
        if(inGame)
        Controller.health -= 5;
        inGame = false;
    }
}