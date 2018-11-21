package model;

import javafx.scene.canvas.GraphicsContext;

import java.awt.*;

public class Oval implements IShapes
{
    private double x;
    private double y;
    private double endX;
    private double endY;
    
    public Oval(double x,double y,double endX,double endY)
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
        graphics.strokeOval(x, y, width, height); //draw an oval
        graphics.fillOval(x, y, width, height);
        
    }
}
