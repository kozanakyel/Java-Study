import org.opensourcephysics.display.BoundedShape;
import org.opensourcephysics.display.*;
import org.opensourcephysics.display.InteractiveShape;
import org.opensourcephysics.frames.DisplayFrame;
import org.opensourcephysics.frames.PlotFrame;

import javax.swing.*;

public class OpenSourcePhysicsBasic {
    public static void main(String[] args){
        DisplayFrame frame = new DisplayFrame("x","y","Drawable shapes");
        frame.addDrawable(DrawableShape.createCircle(0.0,0,4));
        frame.addDrawable(InteractiveShape.createCircle(-5.0,-5.0,4));
        BoundedShape circle = BoundedShape.createBoundedCircle(-5.0,5.0,4);
        circle.setWidthDrag(true);
        circle.setHeightDrag(true);
        frame.addDrawable(circle);
        BoundedShape arrow = BoundedShape.createBoundedArrow(0,-2,4,8);
        arrow.setRotateDrag(true);
        frame.addDrawable(arrow);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * Plotframe gauussian shape example...
         * */

        PlotFrame frame1 = new PlotFrame("$\\Delta$f", "intensity",
                    "Gaussian Lineshape");
        frame1.setConnected(0,true);
        frame1.setMarkerShape(0,Dataset.NO_MARKER);
        for(double x = -10; x < 10; x += 0.2){
            double y = Math.exp(-x * x / 4);
            frame1.append(0,x,y);
            frame1.append(1,x,y+0.1*Math.random());
        }
        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setXPointsLinked(true);
        frame1.setXYColumnNames(0,"frequency","theory");
        frame1.setXYColumnNames(1,"frequency","experiment");
        frame1.setRowNumberVisible(true);
    }
}
