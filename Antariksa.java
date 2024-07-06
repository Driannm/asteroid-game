import greenfoot.*;

public class Antariksa extends World {
    private int asteroidCount = 0; // Tambahkan variabel ini untuk menghitung asteroid yang dihancurkan
    private ScoreBoard scoreBoard;

    public Antariksa() {    
        super(990, 600, 1);
        Panggil_Actor();
    }
    
    private void Panggil_Actor() {
        scoreBoard = new ScoreBoard();
        addObject(scoreBoard, 100, 50);
        addObject(new Rocket(), 40, 300);
        
        int[] asteroid0PositionsY = { 30, 120, 230, 320, 420, 520 };
        int[] asteroid0Speeds = { 4, 10, 5, 15, 8, 9 };

        for (int i = 0; i < asteroid0PositionsY.length; i++) {
            addObject(new Asteroid0(asteroid0Speeds[i]), 990, asteroid0PositionsY[i]);
        }   

        int[] asteroid1PositionsY = { 80, 170, 270, 370, 470, 580 };
        int[] asteroid1Speeds = { 2, 12, 3, 6, 7, 11 };

        for (int i = 0; i < asteroid1PositionsY.length; i++) {
            addObject(new Asteroid1(asteroid1Speeds[i]), 990, asteroid1PositionsY[i]);
        }
    }

    public void act() {
        if (asteroidCount >= 10 || scoreBoard.getPoints() >= 100) {
            Greenfoot.setWorld(new Antariksa2());
        }
    }

    public void increaseAsteroidCount() {
        asteroidCount++;
    }
}
