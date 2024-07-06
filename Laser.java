import greenfoot.*;

public class Laser extends Actor
{
    public void act() {
        setLocation(getX() + 10, getY());
        if(getX() == 989) {
             getWorld().removeObject(this);
        }
    }
}


