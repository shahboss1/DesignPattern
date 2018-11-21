package controller;

import javafx.scene.canvas.GraphicsContext;
import model.IShapes;
import model.Oval;
import model.Rectangle;

import java.awt.*;
import java.util.ArrayList;

public class RetrieveShapes
{
    ArrayList<IShapes> array = new ArrayList <>(  );
    
    public void addShape(GraphicsContext graphics, double x,double y,double endX,double endY, String choose)
    {
        //this method will store shape
        switch (choose)
        {
            case "Rectangle" :
                System.out.println("Draw Rectangle" );
                Rectangle rectangle = new Rectangle(x, y, endX, endY);
                rectangle.drawShape( graphics  );
                array.add( rectangle );
                break;
            case "Oval" :
                System.out.println("Draw Oval" );
                Oval oval = new Oval(x, y, endX, endY);
                oval.drawShape( graphics  );
                array.add( oval );
                break;
            
        }
    }
    
    public void redrawAllShapes(GraphicsContext graphics)
    {
        for(IShapes shape : array)
        {
            shape.drawShape(graphics);
        }
    }
    
    public void removePreviousShape()
    {
        if (array.size() > 0)
        {
            array.remove( array.size() -1 );
        }
    }
    
}
