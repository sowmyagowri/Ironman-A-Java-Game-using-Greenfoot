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
    ScoreBoard sb = new ScoreBoard();
    
    public hasShotState(Ironman heroObject,timer shotTimer)
    {
        this.heroObject = heroObject;
        this.shotTimer = shotTimer;
    }

    public void attackEnemy(ScoreDisplay display)
    {
        World world = heroObject.getWorld();
        shot shots = new shot(display);
        world.addObject(shots, heroObject.getX()+heroObject.getImage().getWidth()/2, heroObject.getY());
        
        if(sb.get_ironManShots() == 0){
            heroObject.setCurrentState(heroObject.getnoShotState());
        }
        
        shots.notifyObservers();
    
        shotTimer.shot();
    }
    
    
}
