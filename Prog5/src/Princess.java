import java.awt.*;
import javax.imageio.*;
import java.io.*;


public class Princess extends PFigure
{
    private int xVel = 20;
    private int yVel = 20;
    private Image img;
    
    public Princess(Panel p)
    { 
       super(550, 550, 100, 120, 80, p);
       
       try
       {
          File file = new File("princess.png");
          img = ImageIO.read(file);
       }
       catch ( Exception e )
       {
          System.out.println("Can't find Princess Image: " + e);
       }
    }
    
    @Override
   public void move ( int deltaX, int deltaY )
   {
       hide();
      super.move(deltaX, deltaY);
      if ( x < -width / 2 )
         x = panel.getSize().width - width / 2;
      else if ( (x + width / 2) > panel.getSize().width )
         x = -width / 2;
      if ( y < -height / 2 )
         y = panel.getSize().height - height / 2;
      else if ( (y + height / 2) > panel.getSize().height )
         y = -height / 2;
      draw();
   }
   
   @Override
   public void draw()
   {
      if( img != null )
      {
         Graphics g = panel.getGraphics();
         g.drawImage( img, x, y, width, height, null );
      }
   }
   
   public int getX()
   {
       return x;
   }
   
   public int getY()
   {
       return y;
   }
   
   
   
}
