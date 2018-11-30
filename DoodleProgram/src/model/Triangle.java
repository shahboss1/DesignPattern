package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * This is a Triangle class which implements Ishape
 * @author Shahbaz Iqbal
 * @version 1.0
 */
public class Triangle implements IShapes
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
     * This is Triangle method which creates triangle object.
     * @param x x
     * @param y y
     * @param endX endX
     * @param endY endY
     * @param fillColor fillColor
     * @param strokeColor strokeColor
     * @param strokeline strokeline
     * @param filledCheckbox filledCheckbox
     */
    public Triangle(double x, double y, double endX, double endY,Color fillColor,Color strokeColor,double strokeline,boolean filledCheckbox)
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
        graphics.setStroke( strokeColor );
        graphics.setLineWidth( strokeline );
        graphics.setFill( fillColor );
        double[] xArray = new double[]{endX, x,(x+endX)/2};
        double[] yArray = new double[]{endY, endY, y};
        graphics.strokePolygon(xArray,yArray,xArray.length );
        
        if (filledCheckbox)
        {
            graphics.fillPolygon(xArray,yArray,xArray.length  );
        }
    }
    
    /**
     * This is a toString method.
     * @return toString.
     */
    @Override
    public String toString()
    {
        return "Triangle{" +
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
