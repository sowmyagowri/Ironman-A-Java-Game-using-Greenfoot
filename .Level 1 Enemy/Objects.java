import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Objects here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Objects extends Actor
{
    //private String subjectState;
    private ScoreBoard sb = new ScoreBoard();
    public void act() 
    {
        // Add your action code here.
    }    
    
    public ScoreBoard get_sb()
    {
          return sb;
    }
}
