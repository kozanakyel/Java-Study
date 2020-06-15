import org.opensourcephysics.display.*;
import org.opensourcephysics.frames.TableFrame;
import org.opensourcephysics.frames.Vector2DFrame;

import javax.swing.*;

public class Vector2dFrame {
    public static void main(String[] args) {

        Vector2DFrame frame = new Vector2DFrame("x", "y", "Vector frame");
        double a = 2;
        int nx = 15, ny = 15;

        double[][][] data = new double[2][nx][ny];
        frame.setAll(data, -a,a,-a,a);
        for(int i = 0; i < nx; i++){
            double x = frame.indexToX(i);
            for(int j = 0; j < ny; j++){
                double y = frame.indexToY(j);
                double r2 = x * x + y * y;
                double r3 = Math.sqrt(r2) * r2;
                data[0][i][j] = (r2 == 0) ? 0 : x / r3;
                data[1][i][j] = (r2 == 0) ? 0 : y / r3;
            }
        }
        frame.setAll(data);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TableFrame tableFrame = new TableFrame("root table");
        tableFrame.setRowNumberVisible(false);
        tableFrame.setColumnNames(0, "x");
        tableFrame.setColumnNames(1,"square root");
        tableFrame.setColumnNames(2,"cube root");
        for(int i = 0; i < 10; i++){
            try{
                tableFrame.appendRow(new double[] {i,Math.sqrt(i),Math.pow(i, 1.0/3)});
            } catch (Exception ex){}
        }
        tableFrame.setVisible(true);
        tableFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawableShape circle1 = DrawableShape.createCircle(0,0,2);

//        DrawingPanel panel = new DrawingPanel();
//        panel.setPreferredMinMax(-10,10,-10,10);
//        DrawingFrame frame1 = new DrawingFrame(panel);
//        panel.setSquareAspect(false);
//        Drawable circle = new Circle(0,0,1);
//        Drawable arrow = new Arrow(0,0,4,3);
//        panel.addDrawable(arrow);
//        frame1.setVisible(true);
//        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
