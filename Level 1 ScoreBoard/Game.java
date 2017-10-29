/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Game  
{
    public void addObservers(GameObservers O);
    public void removeObservers(GameObservers O);
    public void notifyObservers();
    
}
