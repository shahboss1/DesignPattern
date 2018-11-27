package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Squiggle implements IShapes
{
    private final double strokeline;
    private double x[];
    private double y[];
    private int numPoints;
    private Color fillColor;
    private Color strokeColor;
    private boolean filledCheckbox;
    
    public Squiggle(ArrayList<Double> x_in,ArrayList<Double> y_in,Color fillColor,Color strokeColor,double strokeline,boolean filledCheckbox)
    {
//        this.x = x.toArray();
//        this.y = y.toArray(  )
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
    @Override
    public void drawShape(GraphicsContext graphics)
    {
        numPoints = x.length;
        graphics.setStroke( strokeColor );
        graphics.setLineWidth( strokeline );
        graphics.setFill( fillColor );
        graphics.strokePolyline(x, y, numPoints); //draw a several lines connected by points (a squiggle)
    }
}
