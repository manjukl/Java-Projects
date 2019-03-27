/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexis Hendrikson
 */
//import java.util.*;
import java.awt.*;

public class Key extends PFigure
{
    //private Random keyPlacement = new Random (500);
    //private int x = keyPlacement.nextInt();
    //private int y = keyPlacement.nextInt(); 
    
    public Key (Panel p, int x, int y)
    {  
       super( x, y, 50, 50, 0, p);
    }
    
    @Override
    public void draw()
    {
        Graphics g = panel.getGraphics();
        g.setColor(Color.yellow);
        g.fillOval(this.x, this.y, 20, 20);
        g.fillRect(this.x + 7, this.y + 7, 6, 40);
        g.fillRect(this.x+7, this.y + 47, 12, 5);
        g.fillRect(this.x + 7,this.y + 37,12,5);
    }
}
