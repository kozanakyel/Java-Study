import org.opensourcephysics.display.*;
import org.opensourcephysics.display.PlottingPanel;

import javax.swing.*;
import java.awt.dnd.DragGestureEvent;
import java.lang.management.PlatformLoggingMXBean;

public class RotationApp implements Runnable{
    DrawingPanel panel = new PlottingPanel("x","y","rotating Shape");
    DrawingFrame frame = new DrawingFrame(panel);
    InteractiveShape ishape = InteractiveShape.createRectangle(2,1,2,1);
    double theta = 0, dtheta = 0.1;
    Thread thread = new Thread(this);

    public RotationApp(double dtheta){
        this.dtheta = dtheta;
        panel.setPreferredMinMax(-5,5,-5,5);
        panel.addDrawable(ishape);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        thread.start();
    }

    @Override
    public void run() {
        while(true){
            theta += dtheta;
            ishape.setTheta(theta);
            panel.repaint();
            try{
                Thread.sleep(100);
            }catch (InterruptedException ie){}
        }
    }

    public static  void main(String[] args){
        new RotationApp(0.1);
        new RotationApp(0.2);
    }
}
