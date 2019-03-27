/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexis Hendrikson
 */
public class PFigureList 
{
    protected int count;
    private PFigure[] list;
    
    public PFigureList(int size)
    {
        list = new PFigure[size];
        count = 0;
    }
    
    public void add( PFigure p )
    {
        list[count++] = p;
        
//        PFigure[] temp = new PFigure[list.length + 1];
//        for(int i = 0; i < list.length; i++)
//           temp[i] = list[i];
//        temp[temp.length - 1] = p;
//        list = temp;
//        count++;
        
    }
    
    public void hideList()
    {
      for(int i = 0; i < count; i++)
      {
        list[i].hide();
      }
    }
    
    public void moveList()
    {
      for(int i = 0; i < count; i++)
      {
        list[i].move();
      }
    }
    
    public void drawList()
    {
      for(int i = 0; i < count; i++)
      {
        list[i].draw();
      }
    }
    
public int getLength()
    {
       return count;
    }
public void showNextKey(int index)
{
   list[index].hide();
   list[index + 1].draw();
}
}
