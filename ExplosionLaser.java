import greenfoot.*;  
import java.util.List;

public class ExplosionLaser extends Actor
{
    private final static int IMAGE_COUNT = 8;
    private static GreenfootImage[] images;
    private int imageIndex = 0;

    public ExplosionLaser()
    {
        initialiseImages();
        setImage(images[0]);
        Greenfoot.playSound("LaserExplode.mp3");
    }
    
    public synchronized static void initialiseImages()
    {
        if(images == null)
        {
            images = new GreenfootImage[IMAGE_COUNT];
            GreenfootImage baseImage = new GreenfootImage("LaserExplode.png");
            
            for (int i = 0; i < IMAGE_COUNT; i++) {
                images[i] = new GreenfootImage(baseImage);
            }
        }
    }
    
    public void act()
    {
        setImage(images[imageIndex]);
        explodeOthers();
        imageIndex++;
        if(imageIndex >= IMAGE_COUNT)
        {
            getWorld().removeObject(this);
        }
    }
    
    private void explodeOthers()
    {
        List<Actor> explodeEm = getIntersectingObjects(Actor.class);
        for (Actor a : explodeEm)
        {
            if (a instanceof Asteroid0)
            {
                int x = a.getX();
                int y = a.getY();
                // Additional logic for when an asteroid is hit can be added here
            }
        }
    }
}