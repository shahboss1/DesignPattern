package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * This is a Oval class which implements Ishape
 * @author Shahbaz Iqbal
 * @version 1.0
 */
public class Oval implements IShapes
{
    private double x;
    private double y;
    private double endX;
    private double endY;
    private Color fillColor;
    private Color strokeColor;
    private final double strokeline;
    private boolean filledCheckbox;
    
    /**
     * This is oval method which creates oval object.
     * @param x x
     * @param y y
     * @param endX endX
     * @param endY endY
     * @param fillColor fillColor
     * @param strokeColor strokeColor
     * @param strokeline strokeline
     * @param filledCheckbox filledCheckbox
     */
    public Oval(double x,double y,double endX,double endY,javafx.scene.paint.Color fillColor,Color strokeColor, double strokeline, boolean filledCheckbox)
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
     * This is draw method which draws an Oval.
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
        graphics.strokeOval(xValue, yValue, width, height); //draw an oval
        if (filledCheckbox)
        {
            graphics.fillOval(xValue, yValue, width, height);
        }
    }
    
    /**
     * This is a toString method.
     * @return toString.
     */
    @Override
    public String toString()
    {
        
        return "Oval{" +
                "x=" + x +
                ", y=" + y +
                ", endX=" + endX +
                ", endY=" + endY +
                ", fillColor=" + fillColor +
                ", strokeColor=" + strokeColor +
                ", strokeline=" + strokeline +
                ", filledCheckbox=" + filledCheckbox +
                '}';
    }
}
