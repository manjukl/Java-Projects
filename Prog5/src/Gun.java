/*
 * @author glasbrenneri
 */
import java.awt.*;
import javax.imageio.*;
import java.io.*;

public class Gun extends PFigure
{
    private int xVel = 20;
    private int yVel = 20;
    private Image imgGun, imgDiamond;
    public Gun(Panel p)
   {
      super(200, 100, 40, 40, 80, p);
      try
       {
          File file = new File("gun.png");
          imgGun = ImageIO.read(file);
       }
       catch ( Exception e )
       {
          System.out.println("Can't find gun image: " + e);
            // Whatever???
       }
   }
    
    // Draw the figure.
   public void draw()
   {
      if( imgGun != null )
      {
         Graphics g = panel.getGraphics();
         g.drawImage( imgGun, x, y, width, height, null );
      }
   }
   
   @Override
   public void move ( int deltaX, int deltaY )
   {
      super.move(deltaX, deltaY);
      if ( x < -width / 2 )
         x = panel.getSize().width - width / 2;
      else if ( (x + width / 2) > panel.getSize().width )
         x = -width / 2;
      if ( y < -height / 2 )
         y = panel.getSize().height - height / 2;
      else if ( (y + height / 2) > panel.getSize().height )
         y = -height / 2;
   } 
   
   public void shoot() throws Exception
   {
       
   }
   
  
  
}
