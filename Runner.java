              import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
              import java.util.List;
                            
      /**
              * The Runner class represents the "player" in the game. A player
              * is killed (ending the current game) when they are in the same
              * grid square as a Chaser (robot) or an explosion. A player can
              * also move by pressing one of the arrow keys or by pressing "t"       
              * to teleport. 
              *
              * @author Alejandro Gonzalez
              */
                    public class Runner extends Actor
                    {
                        // You will likely want to add instance variable(s) here
                            public int counter;             //number of moves
                            private int xspeed;             //speed used to move runner
                            private int yspeed;             //speed used to move runner
                            private int tp;                 //number of teleports
                            private int nn;                 //counter to compare 
                            private boolean ifmove;         //boolean to see if the runner moved
                            
                            ScoreBoard sb;                  //calling the scoreboard
                            
                        // You will likely want to add a constructor method.
                    public Runner(){
                                //Initialiing the instance variables
                                
                                tp = 3;             
                                ifmove = false;
                                counter = 0;
                                xspeed = 0;
                                yspeed=0;
                                nn=0;
                                
                                
                            }
                    public boolean ifmove(){
                                return ifmove;                                      //enables the uses of the variable on the chaser class
                            }
                        // You may want to add other methods here!
                    public void tpb(){                                       //reset the number of teleports to 3, it is called in the world class when the n key is pressed
                                tp = 3;
                            }
                public void movement(){
            World myWorld  = this.getWorld();                        //enables interaction with world objects
            
            if (Greenfoot.isKeyDown("Left")){                           //if the key is pressed
                xspeed = -1;                                            //x speed will be -1 to substract it later           
                setLocation(getX() + xspeed, getY());                   //the location is set and the calculation is done
                counter++;                                              //the counter is set to be used later in the scoreboard
                ifmove = true;                                          //a boolean that tracks if the object is moving
            }
            if (Greenfoot.isKeyDown("Right")){
                xspeed = 1;
                setLocation(getX() + xspeed, getY());
                counter++;
                ifmove = true;
            }
            if (Greenfoot.isKeyDown("Down")){
                yspeed = 1;
                setLocation(getX(), getY()+ yspeed);
                counter++;
                ifmove = true;
            }
            if (Greenfoot.isKeyDown("Up")){
                yspeed = -1;
                setLocation(getX(), getY()+ yspeed);
                counter++;
                ifmove = true;
            }
            if (Greenfoot.isKeyDown("Space")){
                
                move(0);
                counter++;
                ifmove = true;
            }
            
            if (counter % 10 !=0){                  //if the conter is not divisible by 10
                nn =0;                              // used as a comparison in the if to stop it from executing various times in the same number
            }
            if (counter>0){                         //0 is divisible by 10 so it will add a teleport as we start, this avoid it
                
                if (counter % 10 == 0){             //if is divisible
                    
                    
                    if (nn == 0) {                  //compare the statement
                        nn +=1;
                        boolean tpt = true;         //set a boolean to use in the while
                        nn++;
                        while (tpt == true){
                            tpt = false;
                            tp ++;
                            MyWorld myworld = (MyWorld) getWorld();
                            sb = myworld.getScoreBoard();           //acces the scoreboard
                            sb.setTeleportsLeft(tp);                //changes the value of the teleport in the scoreboard
                    }}
                    
                
            }}}
            
            public void tkey(){                     //enables the teleport function
            MyWorld myWorld = (MyWorld) getWorld();
            Chaser chaser = myWorld.getChaser();
            int x = myWorld.getHeight()/2;
            if (Greenfoot.isKeyDown("t")){
                if (tp> 0){
                    int newx = Greenfoot.getRandomNumber( myWorld.getWidth() );     //gets random location
                    int newy = Greenfoot.getRandomNumber( myWorld.getHeight() );
                    
                    if (newx != myWorld.getWidth()/2 && newy!= myWorld.getHeight()-myWorld.getHeight()){ //not in the scoreboard
                            tp --;
                            setLocation(newx,newy); 
                }}}}
            public void teleport(){                 //enables to change the teleports in the scoreboard when the n key is pressed
                tp = 3;
            }   
            public void resettp(){                  //changes the value of the teleport in the scoreboard
                    MyWorld myworld = (MyWorld) getWorld();
                    sb = myworld.getScoreBoard();
                    sb.setTeleportsLeft(tp);
            }
            
        
        public void counter(){                      //enables to change the moves in the scoreboard when the n key is pressed
            counter = 0;
            
        }
        
        
        public void score(){                        ////changes the value of the moves in the scoreboard
            
            MyWorld myworld = (MyWorld) getWorld();
            sb = myworld.getScoreBoard();
            sb.setMovesMade(counter);

        
        }
        
        
        
    
        
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()                       //Calls the methods
    {
       ifmove = false;
       this.movement();
       this.score();
       tkey();
       resettp();
    }
  
}

