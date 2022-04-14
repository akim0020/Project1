import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.text.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Player extends GameObject
{  
   int poX = super.getX();
   int poY = super.getY();
   Block block2; 
   
   //constructor
   public Player(int newX, int newY, Color newColor)
   {
     super(newX, newY, newColor);  
   }
   
   //boolean method to determine if player is on ground or not 
   public boolean isOnGround(ArrayList<ArrayList<Block>> gameObjArray)
   {
     
     poX = poX-1;
     poY = poY-1;
     
     for(int i=0; i<24; i++)
     {
       for(int j=0; i<32; j++)
       {
         if(this.collides(gameObjArray.get(i).get(j)) == true)
         {
           poX = poX+1;
           poY = poY+1;
           return true;
         }
         else
         {
           poX = poX+1;
           poY = poY+1;
           return false;
         }

      }
    }
    return false;
  }  
   
   //boolean method to see if player is able to move to another spot 
   public boolean move(int moveX, int moveY, ArrayList<ArrayList<Block>> gameObjArray)
   {
     poX = poX+moveX;
     poY = poY+moveY;
     
     for(int i=0; i<24; i++)
     {
       for(int j=0; j<32; j++)
       { 
         if(this.collides(gameObjArray.get(i).get(j)) == true)
         {
           poX = poX-moveX;
           poY = poY-moveY;
           return false;
         }
         else
         {
           return true; 
         }
       }
     }
     return true; 
  } 
   
  //collides method 
  public boolean collides(ArrayList<ArrayList<Block>> gameObjArray) 
  {
    for(int i=0; i<24; i++)
     {
       for(int j=0; j<32; j++)
       { 
         block2 = gameObjArray.get(i).get(j);
         if(poX == block2.getX() && poY == block2.getY())
         {
           return true;
         }
         else
         {
           return false; 
         }
       }
     }
     return false;
  }
}