package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle implements IShapes
{
    private double x;
    private double y;
    private double endX;
    private double endY;
    private Color fillColor;
    private Color strokeColor;
    
    public Rectangle(double x,double y,double endX,double endY,Color fillColor, Color strokeColor)
    {
        this.x = x;
        this.y = y;
        this.endX = endX;
        this.endY = endY;
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
    }
    
    @Override
    public void drawShape(GraphicsContext graphics)
    {
        double width = endX - x;
        double height = endY - y;
        graphics.setStroke( strokeColor );
        graphics.setFill( fillColor );
        graphics.strokeRect(x, y, width, height); //draw a rectangle
        graphics.fillRect(x, y, width, height);
    }
}
