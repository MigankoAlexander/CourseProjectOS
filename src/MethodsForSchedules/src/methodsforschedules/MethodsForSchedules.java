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
        p.add(new Point2D.Double(1.0, 2.0));
        p.add(new Point2D.Double(2.0, 4.0));
        return p;
    }

    public static List<Point2D.Double> approximate(List<Point2D.Double> points, int size) {
        List<Point2D.Double> p = new ArrayList<>();
        p.add(new Point2D.Double(1.0, 2.0));
        p.add(new Point2D.Double(2.0, 4.0));
        return p;
    }
}
