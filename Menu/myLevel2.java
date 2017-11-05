import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class myLevel1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class myLevel2 extends World
{
    GreenfootSound backgroundMusic = new GreenfootSound("Night_Runner_level2.mp3");

    private static final String bgImageName = "f3.jpg";    //level2

    /**
     * Constructor for objects of class myLevel1.
     * 
     */
    public myLevel2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        
        super(1500, 800, 1);
        setBackground(bgImageName);
        backgroundMusic.playLoop();
    }
}
