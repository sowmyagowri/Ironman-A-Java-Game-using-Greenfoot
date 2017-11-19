import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author Rucha Apte
 * @version (a version number or a date)
 */
public class Menu extends World
{
    private GreenfootSound backgroundMusic;
    private ButtonPlay buttonPlay;
    private ButtonHelp buttonHelp;
    private PlayCommand playCmd;
    private HelpCommand helpCmd;
    private String bgImageName;
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        
        //menu
        super(900, 750, 1,false); 
        GreenfootImage bg = new GreenfootImage("2.jpg");
        bg.scale(getWidth(),getHeight());
        setBackground(bg);
        backgroundMusic = new GreenfootSound("Video_Game_Soldiers.mp3");
        buttonPlay = new ButtonPlay();
        buttonHelp = new ButtonHelp();
        playCmd = new PlayCommand();
        helpCmd = new HelpCommand();
        prepare();
    }
    
    public void act()
    {
        backgroundMusic.playLoop();
        //if(Greenfoot.mouseClicked(buttonPlay) && backgroundMusic.isPlaying())
            //backgroundMusic.stop();
        
    }
    
    /**
     * Place the buttons in the world
     */
    public void prepare()
    {
        //addObject(buttonPlay, 1200,450);
        //addObject(buttonHelp, 1200,620);
        addObject(buttonPlay, 588,282);
        addObject(buttonHelp, 581,451);
        buttonPlay.setCommand(playCmd);
        buttonHelp.setCommand(helpCmd);

        playCmd.setReceiver(

            new Receiver()
            {
                public void performAction()
                {
                    if(Greenfoot.mouseClicked(buttonPlay)){
                        Greenfoot.setWorld(new myLevel1());
                    }
                }
            });

        helpCmd.setReceiver(
            new Receiver()
            {
                public void performAction()
                {
                    if(Greenfoot.mouseClicked(buttonHelp)){
                        Help help = buttonHelp.getHelp();
                        addObject(help, getWidth()/2, getHeight()/2);

                        addObject(new Back(help),
                            help.getX() - help.getImage().getWidth()/2,
                            help.getY() - help.getImage().getHeight()/2);

                    }
                }
            }
        );


    }
}
