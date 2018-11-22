package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.paint.Color;

import java.awt.*;

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
    
    @Override
    public void drawShape(GraphicsContext graphics)
    {
        double width = endX - x;
        double height = endY - y;
        graphics.setStroke( strokeColor );
        graphics.setLineWidth( strokeline );
        graphics.setFill( fillColor );
        graphics.strokeOval(x, y, width, height); //draw an oval
        if (filledCheckbox)
        {
            graphics.fillOval(x, y, width, height);
        }
        
    }
}
