import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class shot here.
 * 
 * @author (Sowmya Gowrishankar) 
 * @version (a version number or a date)
 */
public class shot extends Actor
{
    protected GreenfootSound explosionSound;
    
    protected int velShot;
    /**
     * Act - do whatever the shot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public shot()
    {
        explosionSound = new GreenfootSound("explosionNave.wav");
        velShot = 10;
    }
    
    /**
     * Act - do whatever the Attack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
    */
    /**
     * When a shot is created in the world, move forward.
     * Check if the shot touches an enemy, if so both objects are removed
     * Also check if the shot left the world, if so the it is removed
    */
    public void act() 
    {        
       Scenario es = (Scenario)getWorld();
       Enemy e = (Enemy)getOneIntersectingObject(Enemy.class);
       
       if(isTouching(Object1.class))
       {
           Object1 obj1 = (Object1)getOneIntersectingObject(Object1.class);
           explosionSound.play();
           getWorld().addObject(new Boom(), obj1.getX(), obj1.getY());
           getWorld().removeObject(obj1);
           getWorld().removeObject(this);
       }
        
       else if(isTouching(Object2.class))
       {
            Object2 obj2 = (Object2)getOneIntersectingObject(Object2.class);
            explosionSound.play();
            getWorld().addObject(new Boom(), getX(), getY());
            getWorld().removeObject(obj2);
            getWorld().removeObject(this);
       }
        
       else if(isTouching(Object3.class))
       {
            Object3 obj3 = (Object3)getOneIntersectingObject(Object3.class);
            explosionSound.play();
            getWorld().addObject(new Boom(), getX(), getY());
            getWorld().removeObject(obj3);
            getWorld().removeObject(this);
       }
       
       else if(isTouching(AlienShip.class))
       {
            AlienShip as = (AlienShip)getOneIntersectingObject(AlienShip.class);
            explosionSound.play();
            getWorld().addObject(new Boom(), getX(), getY());
            getWorld().removeObject(as);
            getWorld().removeObject(this);
       }
       
       else if(isTouching(Alien.class))
       {
            Alien alien = (Alien)getOneIntersectingObject(Alien.class);
            explosionSound.play();
            getWorld().addObject(new Boom(), getX(), getY());
            getWorld().removeObject(alien);
            getWorld().removeObject(this);
       }

       else if(isTouching(AlienSoldier.class))
       {
            AlienSoldier aliensoldier = (AlienSoldier)getOneIntersectingObject(AlienSoldier.class);
            explosionSound.play();
            getWorld().addObject(new Boom(), getX(), getY());
            getWorld().removeObject(aliensoldier);
            getWorld().removeObject(this);
       }
       
       else if(getX() > getWorld().getWidth() - 2)
            getWorld().removeObject(this);
       else
            setLocation(getX()+velShot,getY());
    }
}
