package controller;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
//import javafx.scene.shape.Line;
import model.*;
import java.util.ArrayList;

public class RetrieveShapes
{
    
    ArrayList <IShapes> array = new ArrayList <>( );
    ArrayList <IShapes> undoList = new ArrayList <>( );
    
    public void clearAll(GraphicsContext graphics)
    {
        array.clear( );
        undoList.clear( );
        System.out.println( "clear all" );
    }
    
    
    public void addShape(GraphicsContext graphics,ArrayList <Double> x,ArrayList <Double> y,String choose,Color fillColor,Color strokeColor,double strokeline,boolean filledCheckbox)
    {
        IShapes shapes = ShapeFactory.createShape( x, y, choose, fillColor, strokeColor, strokeline,filledCheckbox );
        shapes.drawShape( graphics );
        array.add( shapes );
    
        //this method will store shape
//        switch (choose)
//        {
//            case "Rectangle":
//                System.out.println( "Draw Rectangle" );
//                Rectangle rectangle = new Rectangle( x.get( 0 ),y.get( 0 ),x.get( x.size( ) - 1 ),y.get( y.size( ) - 1 ),fillColor,strokeColor,strokeline,filledCheckbox );
//                rectangle.drawShape( graphics );
//                array.add( rectangle );
//                break;
//            case "Oval":
//                System.out.println( "Draw Oval" );
//                Oval oval = new Oval( x.get( 0 ),y.get( 0 ),x.get( x.size( ) - 1 ),y.get( y.size( ) - 1 ),fillColor,strokeColor,strokeline,filledCheckbox );
//                oval.drawShape( graphics );
//                array.add( oval );
//                break;
//
//            case "Line":
//                System.out.println( "Draw Line" );
//                Line line = new Line( x.get( 0 ),y.get( 0 ),x.get( x.size( ) - 1 ),y.get( y.size( ) - 1 ),fillColor,strokeColor,strokeline,filledCheckbox );
//                line.drawShape( graphics );
//                array.add( line );
//                break;
//            case "Squiggle":
//                System.out.println( "Draw Whatever you like" );
//                Squiggle polyLine = new Squiggle( x,y,fillColor,strokeColor,strokeline,filledCheckbox );
//                polyLine.drawShape( graphics );
//                array.add( polyLine );
//                break;
//
//        }
    }
    
    public void redrawAllShapes(GraphicsContext graphics)
    {
        
        for (IShapes shape : array)
        {
            shape.drawShape( graphics );
        }
    }
    
    public void removePreviousShape()
    {
        if (array.size( ) > 0)
        {
            array.remove( array.size( ) - 1 );
        }
    }
    
    public void undoShape(GraphicsContext graphics)
    {
        
        if (array.size( ) > 0)
        {
            IShapes shape = array.remove( array.size( ) - 1 );
            undoList.add( shape );
            System.out.println( "testing undo" + array.size( ) );
        }
        redrawAllShapes( graphics );
    }
    
    public void redoShape(GraphicsContext graphics)
    {
        //should call redraw method here
        if (undoList.size( ) > 0)
        {
            IShapes shape = undoList.remove( undoList.size( ) - 1 );
            array.add( shape );
            System.out.println( "testing redo" );
            
        }
        redrawAllShapes( graphics );
        
    }
    
}
