import greenfoot.*;

public class Asteroid1 extends Actor {
    private int speed;

    public Asteroid1(int speed) {
        this.speed = speed;
    }

    public void act() {
        setLocation(getX() - speed, getY());
        if(getX()==0)
        {
            setLocation(990, getY());
        }
        checkCollision();
    }
    private void checkCollision() {
        Laser laser = (Laser) getOneIntersectingObject(Laser.class);
            if (laser != null) {
    
            } else {

            }
        
            if (laser != null) {
                ScoreBoard scoreboard = (ScoreBoard) getWorld().getObjects(ScoreBoard.class).get(0);
                scoreboard.addPoints(10);
        
                getWorld().addObject(new ExplosionLaser(), getX(), getY());
                getWorld().removeObject(this);
                return;
            }
        }
    }