    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Objects here.
 * 
 * @author (Sowmya Gowrishankar) 
 * @version (a version number or a date)
 */
public class Objects extends Actor
{
    private ScoreBoard scoreboard = new ScoreBoard();
    public void act() 
    {
        // Add your action code here.
    }    
    
    public ScoreBoard get_scoreboard()
    {
          return scoreboard;
    }
}
