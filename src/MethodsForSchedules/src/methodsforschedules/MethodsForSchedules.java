/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package methodsforschedules;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miganko
 */
public class MethodsForSchedules {

    public static List<Point2D.Double> interpolate(List<Point2D.Double> points, int size) {
        List<Point2D.Double> p = new ArrayList<>();
        double y = 0.0;
        double x = points.get(0).x;
        double drob = 1.0;
        double step = (points.get(points.size() - 1).x - points.get(0).x) / size;
        for (int index = 0; index < size; index++) {
            for (int i = 0; i < points.size(); i++) {
                for (int j = 0; j < points.size(); j++) {
                    if (j != i) {
                        drob *= (x - points.get(j).x) / (points.get(i).x - points.get(j).x);
                    }
                }
                y += points.get(i).y * drob;
                drob = 1.0;
            }
            p.add(new Point2D.Double(x, y));
            x += step;
            y = 0.0;

        }
        return p;
    }

    public static List<Point2D.Double> approximate(List<Point2D.Double> points, int size) {
        List<Point2D.Double> p = new ArrayList<>();
        p.add(new Point2D.Double(1.0, 2.0));
        p.add(new Point2D.Double(2.0, 5.0));
        return p;
    }

    public static List<Point2D.Double> ordinaryLeastSquares(List<Point2D.Double> points) {
        List<Point2D.Double> p = new ArrayList<>();
        double sum0 = 0;
        double sum1 = 0;
        for (int i = 0; i < points.size(); i++) {
            sum0+=points.get(i).x*points.get(i).y;
            sum1+=points.get(i).x*points.get(i).x;
        }
        double k = sum0/sum1;
        double x = points.get(points.size()-1).x;
        double y = x*k;
        
        p.add(new Point2D.Double(0.0, 0.0));
        p.add(new Point2D.Double(x, y));
        return p;
    }
}
