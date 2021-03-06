package controller;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.*;
import java.util.ArrayList;

/**
 * This is a controller which has methods to add, remove, undo/redo shapes.
 * @author Shahbaz Iqbal
 * @version 1.0
 */
public class RetrieveShapes
{
    private ArrayList <IShapes> array = new ArrayList <>( );
    private ArrayList <IShapes> undoList = new ArrayList <>( );
    
    /**
     * This method clears shape.
     * @param graphics graphics
     */
    public void clearAll(GraphicsContext graphics)
    {
        array.clear( );
        undoList.clear( );
        System.out.println( "clear all" );
    }
    
    /**
     * This method store shapes to array.
     * @param graphics graphics
     * @param x x
     * @param y y
     * @param choose choose
     * @param fillColor fillColor
     * @param strokeColor strokeColor
     * @param strokeline strokeline
     * @param filledCheckbox filledCheckbox
     */
    public void addShape(GraphicsContext graphics,ArrayList <Double> x,ArrayList <Double> y,String choose,Color fillColor,Color strokeColor,double strokeline,boolean filledCheckbox)
    {
        IShapes shapes = ShapeFactory.createShape( x, y, choose, fillColor, strokeColor, strokeline,filledCheckbox );
        if (shapes != null)
        {
            shapes.drawShape( graphics );
        }
        array.add( shapes );
    }
    
    /**
     * This method loops through array and redraw shapes.
     * @param graphics graphics
     */
    public void redrawAllShapes(GraphicsContext graphics)
    {
        for (IShapes shape : array)
        {
            shape.drawShape( graphics );
        }
    }
    
    /**
     * This method check array and removes previous shapes.
     */
    public void removePreviousShape()
    {
        if (!array.isEmpty( ))
        {
            array.remove( array.size( ) - 1 );
        }
    }
    
    /**
     * This method deletes shape and adds it to array.
     * @param graphics graphics
     */
    public void undoShape(GraphicsContext graphics)
    {
        if (!array.isEmpty( ))
        {
            IShapes shape = array.remove( array.size( ) - 1 );
            undoList.add( shape );
            System.out.println( "testing undo" + array.size( ) );
        }
        redrawAllShapes( graphics );
    }
    
    /**
     * This method pull the shape from UndoList array and redraws it.
     * @param graphics graphics
     */
    public void redoShape(GraphicsContext graphics)
    {
        if (!undoList.isEmpty( ))
        {
            IShapes shape = undoList.remove( undoList.size( ) - 1 );
            array.add( shape );
            System.out.println( "testing redo" );
            
        }
        redrawAllShapes( graphics );
    }
    
    /**
     * This is toString method.
     * @return return
     */
    @Override
    public String toString()
    {
        return "RetrieveShapes{" +
                "array=" + array +
                ", undoList=" + undoList +
                '}';
    }
}
