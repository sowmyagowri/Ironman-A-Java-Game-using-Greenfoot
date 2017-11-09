import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreDisplay here.
 * 
 * @author (Ishwarya Varadarajan) 
 * @version (a version number or a date)
 */
public class ScoreDisplay extends Actor
{
    private static final Color transparent = new Color(0,0,0,0);
    private int score = 0;
    GreenfootImage mainDisplay;
    GreenfootImage scoredisplay;
    GreenfootImage text;
    GreenfootImage imagE;
    public void act() 
    {
    }    
    
    public ScoreDisplay(int points, GreenfootImage image)
    {
        score = points;
        display(score, image);
    }
    
    public void display(int points, GreenfootImage image)
    {
        scoredisplay = getImage();
        mainDisplay = new GreenfootImage(500, 100);
        mainDisplay.drawRect(160, 20, 900, 60);
        text = new GreenfootImage("       =  " +  points, 20, Color.BLACK, transparent);
        scoredisplay.drawImage(image, 20, 20);
        scoredisplay.drawImage(text, 40, 20);
        scoredisplay.scale(150, 75);
        mainDisplay.drawImage(scoredisplay, (mainDisplay.getWidth() - scoredisplay.getWidth())/2,
                             (mainDisplay.getHeight() - scoredisplay.getHeight())/2);
        
        setImage(mainDisplay);
    }
    
    public void updateDisplay(Objects obj)
    {
        if(obj.getClass().getName() == "Ironman")
        {
            score = obj.get_scoreboard().get_numIronManlives();
            imagE = new GreenfootImage("Iron-Man.png");
        }
        else if(obj.getClass().getName() == "AlienShip")
        {
            score = obj.get_scoreboard().get_alienShipsHitCount();
            imagE = new GreenfootImage("Alien-Ship.png");
        }
        else if(obj.getClass().getName() == "AlienSoldier")
        {
            score = obj.get_scoreboard().get_alienSoldierHitCount();
            imagE = new GreenfootImage("Alien-Sold.png");
        }
        else if(obj.getClass().getName() == "Alien")
        {
            score = obj.get_scoreboard().get_aliensHitCount();
            imagE = new GreenfootImage("Alien1.png");
        }
        scoredisplay.clear();
        setImage("red.png");
        display(score, imagE);    
    }
}
