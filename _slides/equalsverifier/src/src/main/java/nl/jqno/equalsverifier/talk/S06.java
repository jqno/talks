package nl.jqno.equalsverifier.talk;

import static nl.jqno.equalsverifier.talk.helper.StopHere.stopHere;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.talk.helper.Color;

public class S06 {
    public static void main(String...args) {










        /*
         * Exactly the same Point as in the previous slide...
         */
        class Point {
            protected final int x;
            protected final int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public int hashCode() {
                return 53 * (53 + x) + y;
            }

            @Override
            public String toString() {
                return String.format("Point: %s,%s", x, y);
            }

            @Override
            public boolean equals(Object obj) {
                if (!(obj instanceof Point)) {
                    return false;
                }
                Point other = (Point)obj;
                return x == other.x && y == other.y;
            }
        }









        /*
         * We can fix symmetry!
         */
        class ColorPoint extends Point {
            private final Color color;

            public ColorPoint(int x, int y, Color color) {
                super(x, y);
                this.color = color;
            }

            @Override
            public int hashCode() {
                return 53 * (53 + super.hashCode()) + color.hashCode();
            }

            @Override
            public String toString() {
                return String.format("ColorPoint: %s,%s,%s", x, y, color);
            }

            @Override
            public boolean equals(Object obj) {
                if (obj instanceof ColorPoint) {
                    ColorPoint other = (ColorPoint)obj;
                    return color.equals(other.color) && super.equals(other);
                }
                else if (obj instanceof Point) {
                    /*
                     * If it's a Point, but not a ColorPoint,
                     * let's just call the Point's equals method!
                     */
                    Point other = (Point)obj;
                    return other.equals(this);
                }
                return false;
            }
        }




















        Point simplePoint     = new      Point(0, 1);
        ColorPoint colorPoint = new ColorPoint(0, 1, Color.RED);

        /*
         * It's symmetrical now!
         */
        assertTrue(simplePoint.equals(colorPoint));
        assertTrue(colorPoint.equals(simplePoint));

        stopHere();



















        /*
         * However... is it transitive?
         */
        ColorPoint redPoint   = new ColorPoint(0, 1, Color.RED);
        ColorPoint greenPoint = new ColorPoint(0, 1, Color.GREEN);

        assertTrue(redPoint.equals(simplePoint));   // Apple  == Banana
        assertTrue(simplePoint.equals(greenPoint)); // Banana == Orange

        stopHere();

        assertTrue(redPoint.equals(greenPoint));    // Apple  == Orange

        stopHere();



















        /*
         * Again... why do we care?
         */
        List<Point> uniquePointList = new ArrayList<>();
        Consumer<Point> addToUniquePointList = p -> {
            if (!uniquePointList.contains(p)) {
                uniquePointList.add(p);
            }
        };

        /*
         * How many items in this collection?
         */
        addToUniquePointList.accept(redPoint);
        addToUniquePointList.accept(simplePoint);
        addToUniquePointList.accept(greenPoint);
        assertEquals(/*???*/ -1, uniquePointList.size());

        stopHere();


        uniquePointList.clear();

        /*
         * And how many in this one?
         */
        addToUniquePointList.accept(simplePoint);
        addToUniquePointList.accept(redPoint);
        addToUniquePointList.accept(greenPoint);
        assertEquals(/*???*/ -1, uniquePointList.size());

        stopHere();




















        /*
         * Again: EqualsVerifier catches this.
         */
        EqualsVerifier.forClass(ColorPoint.class)
            .verify();

        stopHere();



















    }
}
