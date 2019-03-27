import java.awt.*;
import javax.imageio.*;
import java.io.*;
import java.util.Random;


public class Frog extends PFigure
{
    private int radius = 150;
    private int centerX, centerY;
    private float theta = 0;
    private Image img;
    private Random rand = new Random();
    
    public Frog(Panel p, int x, int y)
    { 
       super(x, y, 80, 80, 0, p );
       centerX = x;
       centerY = y;
       theta = (int) Math.toRadians(rand.nextInt() * 2 * Math.PI)/12;
       
       try
       {
          File file = new File("froggy.png");
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
       theta += (Math.PI / 12);
       x = (int)(Math.cos(theta) * radius) + centerX;
       y = (int)(Math.sin(theta) * radius) + centerY;  

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

    public void increaseSize()
    {
        width += 10;
        height += 10;
    }
}


