package controller;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.paint.Color;
import model.IShapes;
import model.Oval;
import model.Rectangle;


import java.util.ArrayList;

public class RetrieveShapes
{
    ArrayList<IShapes> array = new ArrayList <>(  );
    
    public void addShape(GraphicsContext graphics,double x,double y,double endX,double endY,String choose,Color fillColor,Color strokeColor,double strokeline, boolean filledCheckbox)
    {
        //this method will store shape
        switch (choose)
        {
            case "Rectangle" :
                System.out.println("Draw Rectangle" );
                Rectangle rectangle = new Rectangle(x, y, endX, endY, fillColor, strokeColor, strokeline, filledCheckbox);
                rectangle.drawShape( graphics  );
                array.add( rectangle );
                break;
            case "Oval" :
                System.out.println("Draw Oval" );
                Oval oval = new Oval(x, y, endX, endY, fillColor, strokeColor, strokeline, filledCheckbox);
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
