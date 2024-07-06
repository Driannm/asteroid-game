import greenfoot.*;

public class Rocket extends Actor {
    private int shootCooldown = 0; // Cooldown counter
    private final int shootCooldownTime = 4; // Time between shots (adjust as needed)
    
    public void act() {
        setLocation(getX() + 1, getY());
        if (getX() == 990) {
            Greenfoot.stop();
            setLocation(990, getY());
            int currentWorldNumber = getCurrentWorldNumber();
            switch (currentWorldNumber) {
                case 1:
                    Greenfoot.setWorld(new Antariksa());
                    break;
                case 2:
                    Greenfoot.setWorld(new Antariksa());
                    break;
                default:
                    Greenfoot.setWorld(new Antariksa());
                    break;
            }
        }
        
        if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - 6);
        }
        if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + 6);
        }
        if (Greenfoot.isKeyDown("space")) {
            if (shootCooldown == 0) {
                shootPeluru();
                shootCooldown = shootCooldownTime; // Reset the cooldown
            }
        }
        if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + 4, getY());
        }
        
        // Decrement the cooldown counter
        if (shootCooldown > 0) {
            shootCooldown--;
        }
        
        checkCollision();
    }
    
    private void checkCollision() {
        Asteroid0 asteroid0 = (Asteroid0)getOneIntersectingObject(Asteroid0.class);
        if (asteroid0 != null) {
            getWorld().removeObject(asteroid0);
            getWorld().addObject(new Explosion(), getX(), getY());
            Greenfoot.playSound("Explode.wav");
            Greenfoot.stop();
            getWorld().addObject(new AlertGameOver(), getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            getWorld().removeObject(this);
            return;
        }

        Asteroid1 asteroid1 = (Asteroid1)getOneIntersectingObject(Asteroid1.class);
        if (asteroid1 != null) {
            getWorld().removeObject(asteroid1);
            getWorld().addObject(new Explosion(), getX(), getY());
            Greenfoot.playSound("Explode.wav");
            Greenfoot.stop();
            getWorld().addObject(new AlertGameOver(), getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            getWorld().removeObject(this);
            return;
        }
        
        Alien alien = (Alien)getOneIntersectingObject(Alien.class);
        if (alien != null) {
            getWorld().removeObject(alien);
            getWorld().addObject(new Explosion(), getX(), getY());
            Greenfoot.playSound("Explode.wav");
            Greenfoot.stop();
            getWorld().addObject(new AlertGameOver(), getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            getWorld().removeObject(this);
            return;
        }
        
        AlienShip alienShip = (AlienShip)getOneIntersectingObject(AlienShip.class);
        if (alienShip != null) {
            getWorld().removeObject(asteroid1);
            getWorld().addObject(new Explosion(), getX(), getY());
            Greenfoot.playSound("Explode.wav");
            Greenfoot.stop();
            getWorld().addObject(new AlertGameOver(), getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            getWorld().removeObject(this);
            return;
        }
    }
    
    
    private void shootPeluru() {
        Laser laser = new Laser();
        getWorld().addObject(laser, getX() + 1, getY());
        laser.move(4);
        Greenfoot.playSound("LaserSound.mp3");
    }
    
    private int getCurrentWorldNumber() {
        int worldNumber = 1; 
        String currentWorldName = getWorld().getClass().getSimpleName();
        
        if (currentWorldName.matches("Galaxy(\\d+)")) {
            worldNumber = Integer.parseInt(currentWorldName.substring(6));
        }
        return worldNumber;
    }
}

