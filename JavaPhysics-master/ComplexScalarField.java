import org.opensourcephysics.display.DrawingFrame;
import org.opensourcephysics.display.DrawingPanel;
import org.opensourcephysics.display2d.ComplexSurfacePlot;
import org.opensourcephysics.display2d.SurfacePlotMouseController;
import org.opensourcephysics.numerics.VectorFunction;
import org.opensourcephysics.numerics.VectorMath;

import javax.swing.*;

public class ComplexScalarField {
    final static int SIZE = 32;

    public static void main(String[] args) {
        DrawingPanel drawingPanel = new DrawingPanel();
        drawingPanel.setShowCoordinates(false);
        DrawingFrame frame = new DrawingFrame(drawingPanel);
        double[][][] data = new double[2][32][32];
        double[][] xdata = data[0];
        double[][] ydata = data[1];
        ComplexSurfacePlot plot = new ComplexSurfacePlot();
        plot.setAll(data, -1.5, 1.5,-1.5,1.5);
        for(int i = 0; i < SIZE; i++){
            double x = plot.indexToX(i);
            for(int j = 0; j < SIZE; j++){
                double y = plot.indexToY(j);
                double amp = Math.exp(-2 * (x * x + y * y));
                xdata[i][j] = amp * Math.cos(5 * x);
                ydata[i][j] = amp * Math.sin(5 * x);
            }
        }

        plot.setAutoscaleZ(false,0,1);
        plot.setAll(data);
        drawingPanel.addDrawable(plot);
        drawingPanel.repaint();
        SurfacePlotMouseController mouseController = new SurfacePlotMouseController(drawingPanel, plot);
        drawingPanel.addMouseListener(mouseController);
        drawingPanel.addMouseMotionListener(mouseController);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
