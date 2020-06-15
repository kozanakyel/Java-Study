import org.opensourcephysics.frames.Scalar2DFrame;

import javax.swing.*;

public class Scalar2dFrame {
    public static void main(String[] args){
        Scalar2DFrame frame = new Scalar2DFrame("x","y","Scalar frame");
        double[][] data = new double[32][32];
        frame.setAll(data,-10,10,-10,10);
        for(int i = 0, nx = data.length; i < nx; i++){
            double x = frame.indexToX(i);
            double ax = (x == 0) ? 1 : Math.abs(Math.sin(x) / x);
            for(int j = 0, ny = data[0].length; j < ny; j++){
                double y = frame.indexToY(j);
                double ay = (x == 0) ? 1 : Math.abs(Math.sin(y) / y);
                data[i][j] = ax * ay;
            }
        }
        frame.setAll(data);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
