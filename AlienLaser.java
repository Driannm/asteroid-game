import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class AlienLaser extends Actor {
    public void act() {
        move(5);
        if(isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
}
