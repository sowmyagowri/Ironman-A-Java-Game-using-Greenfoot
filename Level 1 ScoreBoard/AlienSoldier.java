import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AlienSoldier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AlienSoldier extends Objects
{
    /**
     * Act - do whatever the AlienSoldier wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public AlienSoldier(ScoreBoard sb)
    {
          super(sb);
    }
    
    public void act() 
    {
        move(-8);
        destroySoldier();
    }    
    
    public void destroySoldier()
    {
        if(isTouching(Bullet.class))
        {
            
            World w = getWorld();
            Explosion bomb = new Explosion();
            w.addObject(bomb, getX(), getY()); 
            removeTouching(Bullet.class);
            get_scoredet().setState("AlienSoldierHit");
            w.removeObject(this);
            
        }
    }
    
    public void updateScore()
    {
        if(get_scoredet().getState() == "AlienSoldierHit")
        {
            get_scoredet().set_alienSoldierHitCount();
        }
    }
}
