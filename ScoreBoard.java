import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The ScoreBoard class for project 1's game. 
 *    
 *    Although you are welcome to modify this code, DOING 
 *    SUCH IS ***HIGHLY*** INADVISABLE. Everything you need
 *    is provided through the public interface. 
 * 
 * @author Alejandro Gonzalez
 */
public class ScoreBoard extends Actor
{
    private int numMoves;      // displayed value of number of moves
    private int teleportsLeft; // displayed value of teleports left
    
    /**
     * Constructor for a ScoreBoard. Gives 0 moves made and
     *    3 teleports left. 
     */
    public ScoreBoard()
    {
        numMoves=0;      // 0 moves made so far
        teleportsLeft=3; // no teleports yet, so still have 3
    }
    
    // Greenfoot automatically calls this after
    //  this object has been added to the world. 
    protected void addedToWorld(World w)
    {
        // calculate some geometry for this banner scoreboard
        int widthInCells = w.getWidth();
        int pixelsPerCell = w.getCellSize();
        int widthInPixels = widthInCells*pixelsPerCell;
        
        //build animage for the scoreboard and use it
        GreenfootImage newImage = new GreenfootImage(widthInPixels, pixelsPerCell);
        setImage(newImage);
        
        // fill in the details of the image based on stats
        redrawImage();
    }
    
    // redraws the scoreboard based on the statistics
    //   note that this is a private method, so no
    //   javadoc comments.
    private void redrawImage()
    {
        // get the image for the scorebaord
        GreenfootImage img = getImage();
        
        // blank out scoreboard. 
        img.setColor(Color.GRAY);
        img.fill();
        
        // draw stats for scorbaord. 
        img.setColor(Color.BLACK);
        img.setFont(img.getFont().deriveFont(30));
        img.drawString("Teleports Left:" + teleportsLeft,
                        100, 30);
        img.drawString("Moves Made:" + numMoves,
                        img.getWidth()-350,30);
    }
    
    /**
     * Sets the number of teleports visible. 
     * @param newValue is the new number of teleports
     */
    public void setTeleportsLeft(int newValue)
    {
        teleportsLeft = newValue; // update stat
        redrawImage();            // redraw w/ new stat
    }
    
    /**
     * Gets the number of teleports visible.
     * @return the number of teleports displayed
     */
    public int getTeleportsLeft()
    {
        return teleportsLeft;
    }
    
    /**
     * sets the number of moves made visible. 
     * @param newValue is the new number of moves made
     */
    public void setMovesMade(int newValue)
    {
        numMoves=newValue; // set the stat
        redrawImage();     // repaint with stat
    }
    
    /**
     * Gets the number f moves made as displayed
     * @return the number of moves made
     */
    public int getMovesMade()
    {
        return numMoves;
    }

    // NOTE: No act method - scoreboards don't "do" anything. 
}
