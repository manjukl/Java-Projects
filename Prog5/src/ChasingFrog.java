import java.awt.*;
import javax.imageio.*;
import java.io.*;
import java.util.Random;


public class ChasingFrog extends PFigure
{
    private int radius = 150;
    private int princessX, princessY;
    private int xVel = 20;
    private int yVel = 20;
    private int difX, difY;
    private int frogX = 300, frogY = 300;
    private float theta = 0;
    private Image img;
    private Random rand = new Random();

    
    public ChasingFrog(Panel p, int x, int y)
    { 
       super(300, 300, 100, 100, 0, p );
       princessX = x;
       princessY = y;
       
       try
       {
          File file = new File("redFrog.png");
          img = ImageIO.read(file);
       }
       catch ( Exception e )
       {
          System.out.println("Can't find Frog Image: " + e);
       }
    }

    @Override
    public void move()
    {
      difX = princessX - frogX;
      difY = princessY - frogY;
      
      if(difX > 0)
          x = xVel + x;
      else
          x = x - xVel;
      
      if(difY > 0)
          y = yVel + y;
      else
          y = y - yVel;
      
      frogX = x;
      frogY = y;

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

    public void updatePrincessXY(int x, int y)
    {
        princessX = x;
        princessY = y;
    }
}


