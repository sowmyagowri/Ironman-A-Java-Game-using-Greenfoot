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
    private static final double scrollSpeed = 3;
    private static final int picWidth = (new GreenfootImage(bgImageName)).getWidth();
    private GreenfootImage bgImage, bgBase;
    private int scrollPosition = 0;


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
                bgImage = new GreenfootImage(getBackground());
        bgBase = new GreenfootImage(picWidth, getHeight());
        bgBase.drawImage(bgImage, 0, 0);
    }
       public void act()
    {
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
}
