package model;

import javafx.scene.paint.Color;
import java.util.ArrayList;

/**
 * This is a Shapefactory class which implements factory pattern.
 * @author Shahbaz Iqbal
 * @version 1.0
 */
public class ShapeFactory
{
    /**
     * This method creates shapes.
     * @param x varible
     * @param y variable
     * @param choose shape
     * @param fillColor fills color
     * @param strokeColor stroke color
     * @param strokeline stroke line
     * @param filledCheckbox filled checkbox
     * @return return null
     */
    public static IShapes createShape(ArrayList<Double> x,ArrayList <Double> y,String choose,Color fillColor,Color strokeColor,double strokeline,boolean filledCheckbox)
    {
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
            case "Triangle":
                System.out.println( "Draw Triangle" );
                return new Triangle(x.get( 0 ),y.get( 0 ),x.get( x.size( ) - 1 ),y.get( y.size( ) - 1 ),fillColor,strokeColor,strokeline,filledCheckbox);
                
        }
    
        return null;
    }
}
