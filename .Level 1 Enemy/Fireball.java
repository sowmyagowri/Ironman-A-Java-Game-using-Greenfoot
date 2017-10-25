import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fireball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fireball extends Actor
{
    public Fireball()
    {
        GreenfootImage myImage = getImage();
        
        int myNewHeight = (int)myImage.getHeight()/5;
        int myNewWidth = (int)myImage.getWidth()/5;
        myImage.scale( myNewWidth, myNewHeight);
    }
    GifImage myFireBall = new GifImage("fireball.gif");
    
    /**
     * Act - do whatever the Fireball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       setImage( myFireBall.getCurrentImage() );
    }    
}
