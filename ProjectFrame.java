import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//JFrame
public class ProjectFrame extends JFrame
{
   public ProjectFrame()
   {
      super("Lab8c");
      Container contents = getContentPane();
      contents.setLayout(new FlowLayout(0,0,0));
      ProjectPanel panel1 = new ProjectPanel();
      contents.add(panel1);
      //set background and size      
      setSize(800,600);
      setBackground(Color.BLACK); 
      setVisible(true);      
   }

   
   public static void main(String[] args)
   {
      ProjectFrame theFrame = new ProjectFrame();
      theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}
