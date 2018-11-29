package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class ShapeFactory
{
    public static IShapes createShape(ArrayList<Double> x,ArrayList <Double> y,String choose,Color fillColor,Color strokeColor,double strokeline,boolean filledCheckbox)
    {
        //this method will store shape
        switch (choose)
        {
            case "Rectangle":
                System.out.println( "Draw Rectangle" );
                return new Rectangle( x.get( 0 ),y.get( 0 ),x.get( x.size( ) - 1 ),y.get( y.size( ) - 1 ),fillColor,strokeColor,strokeline,filledCheckbox );
                
            case "Oval":
                System.out.println( "Draw Oval" );
                return new Oval( x.get( 0 ),y.get( 0 ),x.get( x.size( ) - 1 ),y.get( y.size( ) - 1 ),fillColor,strokeColor,strokeline,filledCheckbox );
                
            case "Line":
                System.out.println( "Draw Line" );
                return new Line( x.get( 0 ),y.get( 0 ),x.get( x.size( ) - 1 ),y.get( y.size( ) - 1 ),fillColor,strokeColor,strokeline,filledCheckbox );
                
            case "Squiggle":
                System.out.println( "Draw Whatever you like" );
                return new Squiggle( x,y,fillColor,strokeColor,strokeline,filledCheckbox );
                
        }
    
        return null;
    }
    
}
