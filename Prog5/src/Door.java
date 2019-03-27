/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hendriksona
 */
import java.awt.*;

public class Door extends PFigure
{
    boolean unlocked = false;
    public Door( Panel p )
    {
        super( 0,0,0,0,0,p );
    }
    @Override
    public void draw()
    {
       if ( unlocked )
          openDoor();
       else
       {
        Graphics g = panel.getGraphics();
        g.setColor( Color.gray );
        g.fillOval(3,0,30,30);
        g.fillRect(3, 15, 30, 50);
        g.setColor(Color.yellow);
        g.fillOval(23,35,8,8);
       }
        
    }
    public void openDoor()
    {
        Graphics g = panel.getGraphics();
        g.setColor( Color.yellow );
        g.fillOval(3,0,30,30);
        g.fillRect(3, 15, 30, 50);
    }
    public void switchLock ()
    {
        if( unlocked )
            unlocked = false;
        else
            unlocked = true;
    }
    public boolean isOpen()
    {
        return unlocked;
    }
}
