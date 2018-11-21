package model;

import javafx.scene.canvas.GraphicsContext;

public class Rectangle implements IShapes
{
    private double x;
    private double y;
    private double endX;
    private double endY;
    
    public Rectangle(double x,double y,double endX,double endY)
    {
        this.x = x;
        this.y = y;
        this.endX = endX;
        this.endY = endY;
    }
    
    @Override
    public void drawShape(GraphicsContext graphics)
    {
        double width = endX - x;
        double height = endY - y;
        graphics.strokeRect(x, y, width, height); //draw a rectangle
        graphics.fillRect(x, y, width, height);
    }
}
