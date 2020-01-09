import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Explosion class simply shuld remove itself (i.e. ensure
 * that it appears for exactly one call to act).
 * 
 * @author Alejandro Gonzalez
 */
public class Explosion extends Actor
{
    // You might want to add instance variables here
    Chaser chaser;                                      //accesor to the chaser
    // you might want to add other methods here
    public void touching(){                             //checks if the explosion is touching a chaser and removes it
        Actor touching;
        touching = getOneObjectAtOffset(0,0,Chaser.class);
        MyWorld myWorld = (MyWorld) getWorld();
        if (touching!=null){
            myWorld.removeObject(touching);
        }
    }
    
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        touching();
        
        getWorld().removeObject(this);                  //removes the explosion
    }    
}
