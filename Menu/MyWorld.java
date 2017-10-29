import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the Menu for the game. It will have a Play button and a Help button
 * 
 * Rucha Apte(your name) 
 * @version 1
 */
public class MyWorld extends World
{
    GreenfootSound backgroundMusic = new GreenfootSound("Video_Game_Soldiers.mp3");

    private static final String bgImageName = "2.jpg";    //menu

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(1500, 800, 1); 
        setBackground(bgImageName);
        backgroundMusic.playLoop();
        //Create Start and Help button objects
        ButtonStart start = new ButtonStart();
        ButtonHelp help = new ButtonHelp();
        
        //Add objects to the world
        addObject(start, 1200,450);
        addObject(help, 1200,620);

    }
}
