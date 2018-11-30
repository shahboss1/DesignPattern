package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is a Squiggle class which implements Ishape
 * @author Shahbaz Iqbal
 * @version 1.0
 */
public class Squiggle implements IShapes
{
    private final double strokeline;
    private double x[];
    private double y[];
    private int numPoints;
    private Color fillColor;
    private Color strokeColor;
    private boolean filledCheckbox;
    
    /**
     * This is squiggle method which creates squiggle object.
     * @param x_in x_in
     * @param y_in y_in
     * @param fillColor fillcolor
     * @param strokeColor strokecolor
     * @param strokeline strokeline
     * @param filledCheckbox fillcheckbox
     */
    public Squiggle(ArrayList<Double> x_in,ArrayList<Double> y_in,Color fillColor,Color strokeColor,double strokeline,boolean filledCheckbox)
    {
        x = new double[x_in.size()];
        y = new double[y_in.size()];
        
        for(int i= 0; i < x.length; i++ )
        {
            x[i] = x_in.get( i );
            y[i] = y_in.get( i );
        }
        
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.strokeline = strokeline;
        this.filledCheckbox = filledCheckbox;
    }
    
    /**
     * This is draw method which draws an freeshape(squiggle).
     * @param graphics draws any shape
     */
    @Override
    public void drawShape(GraphicsContext graphics)
    {
        numPoints = x.length;
        graphics.setStroke( strokeColor );
        graphics.setLineWidth( strokeline );
        graphics.setFill( fillColor );
        graphics.strokePolyline(x, y, numPoints); //draw a several lines connected by points (a squiggle)
    
        if (filledCheckbox)
        {
            graphics.fillPolygon(x, y, numPoints );
        }
    }
    
    /**
     * This is a toString method.
     * @return toString.
     */
    @Override
    public String toString()
    {
        return "Squiggle{" +
                "strokeline=" + strokeline +
                ", x=" + Arrays.toString( x ) +
                ", y=" + Arrays.toString( y ) +
                ", numPoints=" + numPoints +
                ", fillColor=" + fillColor +
                ", strokeColor=" + strokeColor +
                ", filledCheckbox=" + filledCheckbox +
                '}';
    }
}
