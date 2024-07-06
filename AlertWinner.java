import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class AlertWinner extends Actor {
    public void act() {
        // Menampilkan gambar "winer.png"
        setImage(new GreenfootImage("Text - You Win!.png"));
        Greenfoot.playSound("YouWin!.mp3");
     
        Greenfoot.delay(1);
        Greenfoot.stop();
        
    }
}
