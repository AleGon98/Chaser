import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The scenario for the game. It should be initialized to contain:
 *   * a scoreboard at the top of the scenario
 *   * a player in the middle of the scenario
 *   * 20 robot chasers in random locations
 * 
 * @author Alejandro Gonzalez
 */
public class MyWorld extends World
{
    // You will likely want to add instance variabes here
    private ScoreBoard Board;                                   //acces the scoreboard                                          
    private Runner runner;                                      // acces the runner
    private Chaser chaser;                                      //acces the chaser
    
    ScoreBoard sb;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 21x15 cells with a cell size of 40x40 pixels.
        super(21, 15, 40);                                      
        runner = new Runner();                                      //new runner and store it in a variable
        chaser = new Chaser();                      
        this.addObject(runner, getWidth()/2, getHeight()/2);        //adds the runner to the middle of the world
        Board= new ScoreBoard();                                    //store the scoreboard
        
        
        for (int i=0; i<20; i++)                                    //this for loop adds 20 chasers
        {
            chaser = new Chaser();
            int xLoc = Greenfoot.getRandomNumber( getWidth() );     //get a random location
            int yLoc = Greenfoot.getRandomNumber( getHeight() );
            if (xLoc != getWidth()/2 && yLoc!= getHeight()-getHeight()){        //make sure the random location is not in the scoreboard
            this.addObject(chaser, xLoc, yLoc);
        }
        this.addObject(Board, getWidth()/2, getHeight()-getHeight());           //adds the scoreboard
    }
}
   public ScoreBoard getScoreBoard(){                                           //used to acces the scoreboard from other classes
       return Board;
    }
    public Runner getRunner()                                                   //used to acces the runner from other classes
    {
        return runner;
    }
    public Chaser getChaser(){
        return chaser;                                                          //used to acces the chaser from other classes
    }
  public void Keydown (){
      if (Greenfoot.isKeyDown("n")){
            Greenfoot.setWorld(new MyWorld());                                  //erases old world and create a new one
            sb = this.getScoreBoard();                                          //acces the scoreboard
            runner.counter();                                                   //reset the value of scoreboard to 0 
            runner.teleport();                                                  //reset the value of the teleport
    }
}
    /**
     * Act - do whatever the Chaser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        this.Keydown();
        
        }
    
}
