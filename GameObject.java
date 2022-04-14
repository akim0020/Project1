import java.awt.*;
import javax.swing.*;
public class GameObject
{
   public static int x,y; //middle of rectangle
   public static Color colorObj; //color of the game objects
   
   //constructor
   public GameObject(int newX, int newY, Color newColor)
   {
      x = newX+12;
      y = newY+12;   
      colorObj = newColor;   
   }
   
   //collides method 
   public static boolean collides(GameObject newObject) 
   {
     if(x == newObject.x && y == newObject.y)
     {
       return true;
     }    
     else
     {
       return false;
     }
   }
   
   //draw method for the blocks
   public static void draw(Graphics g)
   {
     g.setColor(colorObj);
     g.fillRect(x,y,25,25);
   }
   
   //accessors and mutators
   public static int getX()
   {
     return x;
   }
   
   public static int getY()
   {
     return y;
   }
   
   public static Color getColor()
   {
     return colorObj;
   }
   
   public static void setColor(Color newColor1)
   {
     colorObj = newColor1;
   }
   
   public static void setX(int newPosX)
   {
     x = newPosX;
   }
   
   public static void setY(int newPosY)
   {
     y = newPosY;
   }
   
}