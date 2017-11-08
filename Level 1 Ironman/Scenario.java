import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scenario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scenario extends World
{
    private static final String bgImageName = "space.jpg";
    private GreenfootSound backgroundSound;
    private static final double scrollSpeed = 2.5;
    private static final int picWidth = (new GreenfootImage(bgImageName)).getWidth();
 
    private GreenfootImage bgImage, bgBase;
    private int scrollPosition = 0;
    
    private Ironman ironman;
    public Scenario()
    {    
        super(2000, 1200, 1);
        setBackground(bgImageName);
        bgImage = new GreenfootImage(getBackground());
        backgroundSound = new GreenfootSound("TN.mp3");
        bgBase = new GreenfootImage(picWidth, getHeight());
        bgBase.drawImage(bgImage, 0, 0);
        prepare();
    }
     
     public void act()
    {
        backgroundSound.playLoop();
        scrollPosition -= scrollSpeed;
        while(scrollSpeed > 0 && scrollPosition < -picWidth) scrollPosition += picWidth;
        while(scrollSpeed < 0 && scrollPosition > 0) scrollPosition -= picWidth;
        paint(scrollPosition);
    }
     
     private void paint(int position)
    {
        GreenfootImage bg = getBackground();
        bg.drawImage(bgBase, position, 0);
        bg.drawImage(bgImage, position + picWidth, 0);
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        ironman = new Ironman();
        addObject(ironman,200, 500);
        Enemy enemy = new Enemy();
        addObject(enemy,1800,191);
    }
}