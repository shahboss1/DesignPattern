package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * This is a Rectangle class which implements Ishape
 * @author Shahbaz Iqbal
 * @version 1.0
 */
public class Rectangle implements IShapes
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
     * This is rectangle method which creates rectangle object.
     * @param x x
     * @param y y
     * @param endX endX
     * @param endY endY
     * @param fillColor fillColor
     * @param strokeColor strokeColor
     * @param strokeline strokeline
     * @param filledCheckbox filledCheckbox
     */
    public Rectangle(double x,double y,double endX,double endY,Color fillColor, Color strokeColor, double strokeline, boolean filledCheckbox)
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
     * This is draw method which draws an rectangle.
     * @param graphics draws shape
     */
    @Override
    public void drawShape(GraphicsContext graphics)
    {
        double xValue = Math.min( x, endX );
        double yValue = Math.min( y, endY );
        double width = Math.abs(endX - x);
        double height = Math.abs(endY - y);
        graphics.setStroke( strokeColor );
        graphics.setLineWidth( strokeline );
        graphics.setFill( fillColor );
        graphics.strokeRect(xValue, yValue, width, height); //draw a rectangle
        
        if (filledCheckbox)
        {
            graphics.fillRect(xValue, yValue, width, height);
        }
    }
    
    /**
     * This is a toString method.
     * @return toString.
     */
    @Override
    public String toString()
    {
        return "Rectangle{" +
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
