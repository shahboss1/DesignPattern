package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * This is a Line class which implements Ishape
 * @author Shahbaz Iqbal
 * @version 1.0
 */
public class Line implements IShapes
{
    private final double strokeline;
    private double x;
    private double y;
    private double endX;
    private double endY;
    private Color fillColor;
    private Color strokeColor;
    private boolean filledCheckbox;
    
    /**
     * This is line method which creates line object.
     */
    public Line(double x,double y,double endX,double endY,Color fillColor, Color strokeColor, double strokeline, boolean filledCheckbox)
    {
        this.x = x;
        this.y = y;
        this.endX = endX;
        this.endY = endY;
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.strokeline = strokeline;
        this.filledCheckbox = filledCheckbox;
    }
    
    /**
     * This is draw method which draws the line.
     * @param graphics draws shape
     */
    @Override
    public void drawShape(GraphicsContext graphics)
    {
        double width = endX;
        double height = endY;
        graphics.setStroke( strokeColor );
        graphics.setLineWidth( strokeline );
        graphics.setFill( fillColor );
        graphics.strokeLine(x, y, width, height); //draw a line
    }
    
    /**
     * This is a toString method.
     * @return toString.
     */
    @Override
    public String toString()
    {
        
        return "Line{" +
                "strokeline=" + strokeline +
                ", x=" + x +
                ", y=" + y +
                ", endX=" + endX +
                ", endY=" + endY +
                ", fillColor=" + fillColor +
                ", strokeColor=" + strokeColor +
                ", filledCheckbox=" + filledCheckbox +
                '}';
    }
}
