package nl.jqno.equalsverifier.talk;

import static nl.jqno.equalsverifier.talk.helper.StopHere.stopHere;
import static org.junit.Assert.assertTrue;

import nl.jqno.equalsverifier.talk.helper.Color;
import nl.jqno.equalsverifier.talk.helper.EqualsVerifier;

public class S05 {
    public static void main(String...args) {










        /*
         * Let's start with an immutable Point.
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
         * We'll derive a subclass called ColorPoint.
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

            /*
             * Think a moment: what could be wrong with this equals method?
             * It _does_ call super!
             */
            @Override
            public boolean equals(Object obj) {
                if (!(obj instanceof ColorPoint)) {
                    return false;
                }
                ColorPoint other = (ColorPoint)obj;
                return color.equals(other.color) && super.equals(obj);
            }
        }




















        /*
         * OK, let's define some test data.
         */
        Point simplePoint     = new      Point(0, 1);
        ColorPoint colorPoint = new ColorPoint(0, 1, Color.RED);




















        /*
         * Are they symmetrical?
         */
        assertTrue(simplePoint.equals(colorPoint));    // Apple == Orange

        stopHere();

        assertTrue(colorPoint.equals(simplePoint));    // Orange == Apple

        stopHere();



















        /*
         * Why do we care about symmetry?
         *
         * The invocation order now defines whether equals will succeed or not. Ouch!
         */


        /*
         * EqualsVerifier catches this, too.
         */
        EqualsVerifier.forClass(ColorPoint.class)
            .verify();

        stopHere();




















    }
}
