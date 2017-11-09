import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 * @author (Sowmya Gowrishankar)
 * @version (a version number or a date)
 */
public class Bonus extends Objects
{
    private int direction;
    private int tempdirection;
    protected GreenfootSound bonusLifeSound;
    protected GreenfootSound bonusShotsSound;
    
    public Bonus()
    {
        direction = Greenfoot.getRandomNumber(3) + 1;
        tempdirection=direction;
        bonusLifeSound = new GreenfootSound("bonusLife.wav");
        bonusShotsSound = new GreenfootSound("bonusShots.wav");
    }
    
    /**
     * Act - do whatever the Bonus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        touchBorder();
        touchPlayer();
    }    
    
    /**
     * Check if the player touched the bonus
     */
    public void touchPlayer()
    {
       Ironman ironman = (Ironman)getOneIntersectingObject(Ironman.class);
       if(ironman!=null)
        bonus(ironman);
    }
    
    public void bonus(Ironman ironman)
    {
    }
    
    /**
     * Depending on the directionection the actor moves.
     */
    public void move()
    {
        switch(direction)
        {
            case 1:setLocation(getX()+tempdirection,getY()+tempdirection);
            break;
            case 2:setLocation(getX()-tempdirection,getY()+tempdirection);
            break;
            case 3:setLocation(getX()-tempdirection,getY()-tempdirection);
            break;
            case 4:setLocation(getX()+tempdirection,getY()-tempdirection);
            break;
        }
    }
    
    /**
     * Touching the edge of the world, the bonus object should bounce
     */
    public void touchBorder()
    {
        if(getY() >= getWorld().getHeight()-getImage().getWidth()/2)
        {
            if(direction == 1)
                direction=4;
            else if(direction==2)
                direction=3;
        }
        else if(getY() <= getImage().getWidth()/2)
        {
            if(direction == 3)
                direction=2;
            else if(direction == 4)
                direction=1; 
        }
        else if(getX() >= getWorld().getWidth()-getImage().getWidth()/2)
        {
            if(direction == 4)
                direction=3;
            else if(direction == 1)
                direction=2;
        }
        else if(getX() <= getImage().getWidth()/2)
        {
            if(direction == 3)
                direction=4;
            else if(direction == 2)
                direction = 1;
        }
    }
}
