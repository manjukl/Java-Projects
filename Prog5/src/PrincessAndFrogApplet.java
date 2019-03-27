
import java.awt.event.ActionEvent;
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author glasbrenneri
 */


import java.awt.event.ActionEvent;
public class PrincessAndFrogApplet extends java.applet.Applet implements java.awt.event.ActionListener
{
    private javax.swing.Timer moveTimer = new javax.swing.Timer(500, this);
    private Random rand = new Random();

    private Gun gun;
    private Princess princess;
    private Frog frog;
    private Door door;
    private Key key;
    private Diamond diamond;
    private Background background;  
    private ChasingFrog cFrog;

    private int level = 1;
    private int numFrogs = getFrogNum();
    private int numKeys = getKeyNum();
    private int score = 0;
    private int frogSize = 20;
    private int keyCount = 0;
    private PFigureList frogList = new PFigureList(numFrogs);
   
    
    /**
     * Initializes the applet PrincessAndFrogApplet
     */
    public void init() 
    {
        setSize(700,700);
        try 
        {
            java.awt.EventQueue.invokeAndWait(new Runnable() 
            {
                public void run() 
                {
                    initComponents();
                    princess = new Princess(GamePanel);
                    door = new Door(GamePanel);
                    diamond = new Diamond(GamePanel, getPrincessX(), getPrincessY());
                    cFrog = new ChasingFrog(GamePanel, getPrincessX(), getPrincessY());
                    background = new Background(GamePanel);
                    while(frogList.count < numFrogs)
                        frogList.add(new Frog(GamePanel, getRandomX(), getRandomY()));
                    key = new Key(GamePanel, getRandomX(), getRandomY());
                    moveTimer.start();
                    GamePanel.requestFocus();
                }
            });
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
    }
    

    public int getRandomX()
    {
        return rand.nextInt(550) + 50;
    }
    
    public int getRandomY()
    {
        return rand.nextInt(550) + 50;
    }
    
    public int getPrincessX()
    {
        return princess.getX();
    }
    
    public int getPrincessY()
    {
        return princess.getY();
    }

    
    public int getFrogNum()
    {
        switch(level)
        {
            case 1: 
                return 5;
            case 2:
                return 7;
            case 3:
                return 10;
        }
        return -1;
    }
    
    public int getKeyNum()
    {
        switch(level)
        {
            case 1: 
                return 5;
            case 2:
                return 8;
            case 3:
                return 12;
        }
        return -1;
    }
    
    public void shoot()
   {
       diamond.move();
   }
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        cFrog.updatePrincessXY(getPrincessX(), getPrincessY());
        //diamond.updatePrincessXY(getPrincessX(), getPrincessY());
        background.draw();
        door.draw();
        princess.draw();
        key.draw();
        cFrog.draw();

        frogList.drawList();
        frogList.moveList();
        
        //frog.hide();
        //door.hide();
        //princess.hide();
        //key.hide();
//        diamond.move();
//        diamond.draw();
        cFrog.move();

        
        //door.move();
        princess.move();
        //key.move();
        //diamond.move();
        
        //door.draw();
        princess.draw();
        //key.draw();
       // diamond.draw();
        GamePanel.requestFocus(); 
        
      try
      {
         if( frog.collidedWith(princess) )
         {
             play( new java.net.URL( "file", "" , 
                  "C:\\Windows\\Media\\chord.wav" ) );
            score -= 1000;
             scoresLabel.setText("Scores: " + score);
         }
         
         
      }
      catch ( Exception ex )
      {
         System.out.println("Try not entered");
      }
        if( princess.collidedWith(key) )
         {
            score += 5000;
            key = new Key(GamePanel, getRandomX(), getRandomY());
            keyCount++;
            if(keyCount >= 5 && !door.isOpen() )
                door.switchLock();
            door.draw();
            //frogs get bigger
             scoresLabel.setText("Scores: " + score);
         }
         if( diamond.collidedWith(frog) )
         {
            score += 500;
            //delete that frog
             scoresLabel.setText("Scores: " + score);
         }
         if( door.isOpen() && princess.collidedWith(door) )
         {
           score += 10000;
           level++;
           numFrogs = getFrogNum();
           numKeys = getKeyNum();
           score = 0;
           frogSize = 20;
           keyCount = 0;
           frogList = new PFigureList(numFrogs);
           door.switchLock();
           door.draw();
         }
    }

    /**
     * This method is called from within the init() method to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GamePanel = new java.awt.Panel();
        scoresLabel = new java.awt.Label();

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        setLayout(null);

        GamePanel.setBackground(new java.awt.Color(114, 102, 98));
        GamePanel.setPreferredSize(new java.awt.Dimension(600, 600));
        GamePanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GamePanelKeyPressed(evt);
            }
        });
        GamePanel.setLayout(null);

        scoresLabel.setText("Scores: " + score);
        GamePanel.add(scoresLabel);
        scoresLabel.setBounds(300, 10, 110, 30);
        scoresLabel.getAccessibleContext().setAccessibleName("");

        add(GamePanel);
        GamePanel.setBounds(0, 0, 670, 680);
    }// </editor-fold>//GEN-END:initComponents

   private void GamePanelKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_GamePanelKeyPressed
   {//GEN-HEADEREND:event_GamePanelKeyPressed
      // TODO add your handling code here:
       princess.hide();
       diamond.hide();
      if ( evt.getKeyCode() == java.awt.event.KeyEvent.VK_DOWN )
         princess.move(0, 10);
      else if ( evt.getKeyCode() == java.awt.event.KeyEvent.VK_UP )
         princess.move(0, -10);
      else if ( evt.getKeyCode() == java.awt.event.KeyEvent.VK_LEFT )
         princess.move(-10, 0);
      else if ( evt.getKeyCode() == java.awt.event.KeyEvent.VK_RIGHT )
         princess.move(10, 0);
      //princess.hide();
      else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER)
      {
          //shoot();
          diamond = new Diamond(GamePanel, getPrincessX(), getPrincessY());
          diamond.draw();
          diamond.move(80,0);
          diamond.hide();
          diamond.draw();
          diamond.move(80,0);
          diamond.hide();
          diamond.draw();
          diamond.move(80,0);
          diamond.draw();
          diamond.hide();
      }
      
//          diamond.updatePrincessXY(getPrincessX(), getPrincessY());
//      diamond.updatePrincessXY(getPrincessX(), getPrincessY());
//      background.draw();
//      door.draw();
//      key.draw();
//      cFrog.draw();
//      frog.draw();
//      princess.draw();
//      diamond.draw();

   }//GEN-LAST:event_GamePanelKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
       // if( evt.getKeyCode() == java.awt.event.KeyEvent.VK_SPACE)
           // gun.shoot();
    }//GEN-LAST:event_formKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Panel GamePanel;
    private java.awt.Label scoresLabel;
    // End of variables declaration//GEN-END:variables

    
}
