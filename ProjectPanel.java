import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Random.*;
import java.lang.Math.*; 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
import javax.swing.Timer;
  
public class ProjectPanel extends JPanel 
{
  //variables 
  int positionX = 0; //player x position
  int positionY = 0; //player y position
    
  int blockPosX = 0; 
  int blockPosY = 0;
  
  int vicBlockPosX = 0;
  int vicBlockPosY = 0;
  
  Color color1;
  
  Block block1;
  Player player1;
  Block vicBlock1;
  
  //Arraylists 
  ArrayList<ArrayList<Integer>> dataArray = new ArrayList<ArrayList<Integer>>();
  ArrayList<ArrayList<Block>> gameObjArray = new ArrayList<ArrayList<Block>>(); 
  int numRow;
  int numColumn;
  int block;
    
  Timer t = new Timer(10, new TimeListener());
  
  public ProjectPanel()
  {   
    super();
    
    try
    {
      Scanner scan = new Scanner(new File("GameObject.txt"));
      
       positionX = scan.nextInt(); //start x position for player
       positionY = scan.nextInt(); //start y position for player 
       numRow = scan.nextInt(); //number of rows for the GameObjects
       numColumn = scan.nextInt(); //number of columns for the GameObjects
       
       //make dataArrayList 
       for(int i=0; i<numRow; i++)
       {
         ArrayList<Integer> inside = new ArrayList<Integer>();
         dataArray.add(inside);
       }
       
       for(int i=0; i<numRow; i++)
       {
         for(int j=0; j<numColumn; j++)
         {
           block = scan.nextInt();
           dataArray.get(i).add(block);
         }
       }
       
       //make GameObjectArrayList 
       for(int i=0; i<numRow; i++)
       {
         ArrayList<Block> inside = new ArrayList<Block>();
         gameObjArray.add(inside);
       }

       
       //add the GameObjects to gameObjArray
       for(int i=0; i<numRow; i++)
       {
         for(int j=0; j<numColumn; j++)
         {
           if(dataArray.get(i).get(j) == 0)
           {
             gameObjArray.get(i).add(null); //null , no blocks 
           }
           
           else if(dataArray.get(i).get(j) == 1)
           {
             gameObjArray.get(i).add(new Block(blockPosX+25*j, blockPosY+25*i, Color.BLUE)); //Blocks 
           }
           
           else if(dataArray.get(i).get(j) == 2)
           {
             gameObjArray.get(i).add(new Block(blockPosX+25*j, blockPosY+25*i, Color.GREEN)); //VictoryBlock 
           }
         }        
       }   
   }
    
    catch(FileNotFoundException fnfe)
    {
      System.out.println("File does not exist!");
    }
    
    
    //background and size
    addKeyListener(new KeyEventDemo());
    setPreferredSize(new Dimension(800,600)); 
    setBackground(new Color(153,153,153));
    setFocusable(true);
    setVisible(true);
    
  }
    //paint component
    public void paintComponent(Graphics g)
    {
      super.paintComponent(g);  
      
      for(int i=0; i<numRow; i++)
      {
        for(int j=0; j<numColumn; j++)
        {
           if(dataArray.get(i).get(j) == 1) //blue normal blocks
           {
           block1 = gameObjArray.get(i).get(j);
           block1.setX(vicBlockPosX+25*j);
           block1.setY(vicBlockPosY+25*i);
           block1.setColor(Color.BLUE);
           block1.draw(g);
           }
           
           if(dataArray.get(i).get(j) == 2) //green victory block 
           {
           block1 = gameObjArray.get(i).get(j);
           block1.setX(vicBlockPosX+25*j);
           block1.setY(vicBlockPosY+25*i);
           block1.setColor(Color.GREEN);
           block1.draw(g); 
           }
        }
      }
     player1 = new Player(positionX, positionY, Color.YELLOW); //instantiating player
     player1.setX(positionX+25);
     player1.setY(positionY+25);
     player1.draw(g);
      
   }
   
  //key listener for the player movement 
  public class KeyEventDemo  implements KeyListener 
  {
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) 
    {
     t.stop();
     if(e.getKeyCode() == KeyEvent.VK_W)
      {
         up=false;
         
      }
      
      if(e.getKeyCode() == KeyEvent.VK_S)
      {
         down =false;
         
      }
      if(e.getKeyCode() == KeyEvent.VK_A)
      {
         left = false;
         
      }
      if(e.getKeyCode() == KeyEvent.VK_D)
      {
         right = false;
         
      }
    }
    public void keyPressed(KeyEvent e) 
    {
      t.start();
      if(e.getKeyCode() == KeyEvent.VK_W)
      {
         up=true;
         
      }
      
      if(e.getKeyCode() == KeyEvent.VK_S)
      {
         down =true;
         
      }
      if(e.getKeyCode() == KeyEvent.VK_A)
      {
         left = true;
         
      }
      if(e.getKeyCode() == KeyEvent.VK_D)
      {
         right = true;
         
      }
      
      repaint(); //calls the paint component
    }
   }        

   boolean up;
   boolean down;
   boolean left;
   boolean right;
   
   //actionlistener for the time of the player movements
   public class TimeListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(up)
         {
            positionY--;
         }
         if(down)
         {
            positionY++;
         }
         if(left)
         {
            positionX--;
         }
         if(right)
         {
            positionX++;
         }
         
         
         if(player1.collides(gameObjArray) == true)
         {
           System.out.println("collide");
         }
         
         /*squarePositionX = squarePositionX + xDirection;
         squarePositionY= squarePositionY+yDirection;
         
         if(squarePositionY > 190)
         {
            yDirection = -1;
         }
         if(squarePositionX > 190)
         {
            xDirection = -1;
         }
         
         if(squarePositionY < 10)
         {
            yDirection = 1;
         }
         if(squarePositionX < 10)
         {
            xDirection = 1;
         }*/
         
         repaint(); //calls the paint component
      }
    }   
}
 

         