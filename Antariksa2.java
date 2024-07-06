import greenfoot.*; 

public class Antariksa2 extends World {
    
    public Antariksa2() {    
        super(990, 600, 1);
        callActor();
    }
    
    private void callActor() {
        addObject(new ScoreBoard(), 100,50 );
        addObject(new Rocket(), 40, 300);
        int[] alienShipPositionsY = { 30, 120, 230,  320,  420, 520 };
        int[] alienShipSpeeds = { 4,  10,  5,  15,  8, 9};
    
        for (int i = 0; i < alienShipPositionsY.length; i++) {
            addObject(new AlienShip(alienShipSpeeds[i]), 990, alienShipPositionsY[i]);
        }        

        int[] AlienPositionsY = { 80, 170, 270,  370,  470, 580 };
        int[] AlienSpeeds = { 4,  3,  1,  6,  3, 2 };
    
        for (int i = 0; i < AlienPositionsY.length; i++) {
            addObject(new Alien (AlienSpeeds[i]), 990, AlienPositionsY[i]);
        }            
    }
}
