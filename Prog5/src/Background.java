/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manjukl
 */
import java.awt.*;
import javax.imageio.*;
import java.io.*;

public class Background extends PFigure
{
    private Image background;
    
    public Background(Panel p)
   {
      super(0,  0,  700, 700, 10,  p);
      try
       {
          File file = new File("dungeon_background.png");
          background = ImageIO.read(file);
         
       }
       catch ( Exception e )
       {
          System.out.println("Can't find the background image: " + e);
            // Whatever???
       }
   }
    
     // Draw the figure.
   public void draw()
   {
      if( background != null )
      {
         Graphics g = panel.getGraphics();
         g.drawImage( background, x, y, width, height, null );
      }
   }
   
   public void hide()
   {
      Graphics g = panel.getGraphics();
      Color oldColor = g.getColor();
      g.setColor(panel.getBackground() );
      g.fillRect(x, y, width, height);
      g.setColor(oldColor);
   }
    
   
}
