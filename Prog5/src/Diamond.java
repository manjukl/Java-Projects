/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 * @author manjukl
 */
import java.awt.*;
import javax.imageio.*;
import java.io.*;

public class Diamond extends PFigure
{
   
    private int xVel = 20;
    private int yVel = 20;
    private Image imgGun, imgDiamond;
    private int princessX, princessY;

    
    public Diamond(Panel p, int x, int y)
   {
      
      super(x + 100, y + 35, 20, 20, 80, p);
      princessX = x;
      princessY = y;
      try
       {
          File file = new File("diamond.png");
          imgGun = ImageIO.read(file);
       }
       catch ( Exception e )
       {
          System.out.println("Can't find diamond image: " + e);
            // Whatever???
       }
   }
    
    // Draw the figure.
   public void draw()
   {
       Graphics g = panel.getGraphics();
      if( imgGun != null )
      {
         
         g.drawImage( imgGun, princessX + 100, princessY + 26, width, height, null );
      }
        g.drawImage( imgGun, x, y, width, height, null );
   }
   
   @Override
   public void move ( int deltaX, int deltaY )
   {
      super.move(deltaX, deltaY);
//      if ( princessX < -width / 2 )
//         princessX = panel.getSize().width - width / 2;
//      else if ( (princessX + width / 2) > panel.getSize().width )
//         princessX = -width / 2;

        if ( x < -width / 2 )
            x = panel.getSize().width - width / 2;
        else if ( (x + width / 2) > panel.getSize().width )
            x = -width / 2;
        if ( x < -width / 2 )
            y = panel.getSize().width - width / 2;
        else if ( (x + width / 2) > panel.getSize().width )
            y = -width / 2;
        
   } 

   
    public void updatePrincessXY(int x, int y)
    {
        princessX = x;
        princessY = y;
    }
   
   
}
