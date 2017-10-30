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
    simpleTimer shotTimer;

    public hasShotState(Ironman heroObject,simpleTimer shotTimer)
    {
        this.heroObject = heroObject;
        this.shotTimer = shotTimer;
    }

    public void attackEnemy()
    {
        World world = heroObject.getWorld();
        world.addObject(new ShotPlayer(), heroObject.getX()+heroObject.getImage().getWidth()/2, heroObject.getY());
        int shot = heroObject.getNumShots()-1;
        heroObject.setNumShots(shot);
        if(heroObject.getNumShots() == 0){
            heroObject.currentState(heroObject.getnoShotState());
        }
        shotTimer.shot();
    }
}
