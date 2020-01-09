import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Robot for the game. It should always move towards the world's
 * runner (player). However, it it runs into another robot or an 
 * explosion it should turn into an explosion and then disappear. 
 * 
 * @author Alejandro Gonzalez
 */
public class Chaser extends Actor
{
    // You might want to add instance variables here
    private Explosion explosion;                    //accesor to the explosion
    private Chaser chaser;                            //accesor to the chaser
    private Runner runner;                            //accesor to the runner

    public Chaser (){                           //initialize instance variables
        explosion = new Explosion();
    }
    public Chaser getChaser(){                  //used to acces the chaser
        return chaser;
    }
    public void Touch()                         
        
        {
            World myWorld = getWorld();
            Actor Runner;                                               //checks if the chaser or the actor are intersecting with objects
            Actor Chaser;
            Chaser = (Chaser) getOneIntersectingObject(Chaser.class);
            Runner = (Runner) getOneIntersectingObject(Runner.class);
            int x = myWorld.getHeight()/2;                              //variables to set the scoreboard in the middle of the world
            int y = myWorld.getWidth()/2;
            
            
        
        if (Runner!=null){                                              //checks if the runner is touching and object and removes it and shows a message
            
            
            myWorld.removeObject(Runner);
            
            myWorld.showText("Game Over",y,x );
        }
        Explosion boom = (Explosion) getOneIntersectingObject(Explosion.class);     //if the explosion is intersecting a runner remove the runner
        if (boom!=null)
        {
            
            myWorld.removeObject(Runner);
        }
    }
    public void movement(){
        
        MyWorld myWorld = (MyWorld) getWorld();                 //accesor to the world and to the runner
        Runner runner = myWorld.getRunner();
        
        if (runner.ifmove() == true) {                          //uses a boolean declared in the runner class to check if the runner is moving 
            if (runner.getX()>getX()){                          //compares the location of the chaser and the runner and set a location for each chaser depending on the comparison
                setLocation(getX() + 1, getY());
            }  
        
            if (runner.getY()>getY()){
                setLocation(getX(), getY()+1);
            }
            if (runner.getX()<getX()){
                setLocation(getX() - 1, getY());
            }  
            if (runner.getY()<getY()){
                setLocation(getX(), getY()-1);
            }
        }  
        
        
    }
    public void  chasertouch(){                                             //method used to compare if the chasers are touching another object and removes it and an explosion is added
        Chaser touch = (Chaser) getOneIntersectingObject(Chaser.class);
        
        if (touch!=null){
            World myWorld  = this.getWorld();
            myWorld.removeObject(touch);
            myWorld.addObject(new Explosion(), this.getX(),this.getY());
        }
    }
    
    /**
     * Act - do whatever the Chaser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()                                   //methods are called
    {
        //Actor Chaser;
        this.Touch();
        this.movement();
        this.chasertouch();
    }    
}
