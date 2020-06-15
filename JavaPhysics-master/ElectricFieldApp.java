import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;
import org.opensourcephysics.controls.*;
import org.opensourcephysics.display.*;
import org.opensourcephysics.frames.Vector2DFrame;

public class ElectricFieldApp extends AbstractCalculation
        implements InteractiveMouseHandler{
    int n = 20;
    double a = 10;
    double[][][] eField = new double[2][n][n];
    Vector2DFrame frame = new Vector2DFrame("x","y","Electric Field");

    public ElectricFieldApp(){
        frame.setPreferredMinMax(-a/2,-a/2,-a/2,-a/2);
        frame.setZRange(false,0,2);
        frame.setAll(eField);
        frame.setInteractiveMouseHandler(this);
    }

    public void calculate(){
        double x = control.getDouble("x");
        double y = control.getDouble("y");
        double q = control.getDouble("q");
        Charge charge = new Charge(x,y,q);
        frame.addDrawable(charge);
        calculateField();
    }

    void calculateField(){
        for(int ix = 0; ix < n; ix++) {
            for (int iy = 0; iy < n; iy++) {
                eField[0][ix][iy] = eField[1][ix][iy] = 0;
            }
        }
        List chargeList = frame.getDrawables(Charge.class);
        Iterator it = chargeList.iterator();
        while (it.hasNext()){
            Charge charge = (Charge)it.next();
            double xs = charge.getX(), ys = charge.getY();
            for(int xi = 0; xi < n; xi++){
                double x = frame.indexToX(xi);
                double dx = (x - xs);
                for(int yi = 0; yi < n; yi++){
                    double y = frame.indexToY(yi);
                    double dy = (y - ys);
                    double r2 = dx * dx + dy * dy;
                    double r3 = Math.sqrt(r2) * r2;
                    if(r3 > 0){
                        eField[0][xi][yi] += charge.q * dx / r3;
                        eField[1][xi][yi] += charge.q * dy / r3;
                    }
                }
            }

        }
        frame.setAll(eField);
    }

    public void handleMouseAction(InteractivePanel panel, MouseEvent evt){
        panel.handleMouseAction(panel, evt);
        if(panel.getMouseAction() == InteractivePanel.MOUSE_DRAGGED){
            calculateField();
            panel.repaint();
        }
    }

    public static void main(String[] args){
        CalculationControl.createApp(new ElectricFieldApp());
    }
}

class Charge extends InteractiveCircle{
    double q = 0;

    public double getQ(){
        return q;
    }

    public Charge(double x, double y, double q){
        super(x,y);
        this.q = q;
        if(q > 0){
            color = Color.red;
        } else{
            color = Color.blue;
        }
    }
}


