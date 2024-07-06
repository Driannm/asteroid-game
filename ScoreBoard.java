import greenfoot.*;
import java.util.Timer;

public class ScoreBoard extends Actor {
    private int points = 0;

    public void act() {
        setImage(new GreenfootImage("Points: " + points, 24, Color.WHITE, null));
        checkWinCondition();
    }

    public void addPoints(int pointsToAdd) {
        points += pointsToAdd;
    }

    public int getPoints() { // Tambahkan metode ini
        return points;
    }

    private void checkWinCondition() {
        if (points > 100) {
            getWorld().addObject(new AlertWinner(), getWorld().getWidth() / 2, getWorld().getHeight() / 2);
        }
    }
}
