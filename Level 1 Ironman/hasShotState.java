import greenfoot.*;

/**
 * Write a description of class hasShotState here.
 * 
 * @author (Sowmya Gowrishankar) 
 * @version (a version number or a date)
 */
public class hasShotState implements IronmanState 
{
    Ironman heroObject;
    World world;
    timer shotTimer;

    public hasShotState(Ironman heroObject,timer shotTimer)
    {
        this.heroObject = heroObject;
        this.shotTimer = shotTimer;
    }

    public void attackEnemy()
    {
        World world = heroObject.getWorld();
        world.addObject(new shot(), heroObject.getX()+heroObject.getImage().getWidth()/2, heroObject.getY());
        int shot = heroObject.getNumShots()-1;
        heroObject.setNumShots(shot);
        if(heroObject.getNumShots() == 0){
            heroObject.setCurrentState(heroObject.getnoShotState());
        }
        shotTimer.shot();
    }
}
