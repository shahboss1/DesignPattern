package model;

import javafx.scene.canvas.GraphicsContext;

/**
 * This class is IShape interface which holds graphics.
 * @author Shahbaz Iqbal
 * @version 1.0
 */
public interface IShapes
{
    /**
     * This is drawshape method which draws shape for all shapes using graphics.
     * @param graphics draws shape
     */
    void drawShape(GraphicsContext graphics);
}
