package nl.jqno.equalsverifier.talk;

import static nl.jqno.equalsverifier.talk.helper.StopHere.stopHere;
import static org.junit.Assert.assertEquals;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.talk.helper.Color;

public class S09 {
    public static void main(String...args) {










        /*
         * But... that's kind of sad.
         *
         * Isn't there another way?
         */




















        /*
         * COULD JOSH BLOCH BE WRONG!?
         */
    


















        /*
         * As it turns out, he could!
         *
         * Martin Odersky, Lex Spoon and Bill Venners describe it in their Scala book.
         */



        /*
         * But it's not trivial.
         */




















        class Point {
            private final int x;
            private final int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public int hashCode() {
                return 53 * (53 + x) + y;
            }







            /*
             * Add a canEqual method:
             */
            public boolean canEqual(Object obj) {
                return obj instanceof Point;
            }

            @Override
            public boolean equals(Object obj) {
                if (!(obj instanceof Point)) {
                    return false;
                }
                Point other = (Point)obj;
                /*
                 * And then check if other is compatible with us:
                 */
                return other.canEqual(this) && x == other.x && y == other.y;
            }
        }




















        /*
         * Leaf nodes should be final.
         *
         * (Or at least, have final equals and hashCode methods.)
         */
        final class ColorPoint extends Point {
            private final Color color;

            public ColorPoint(int x, int y, Color color) {
                super(x, y);
                this.color = color;
            }

            @Override
            public int hashCode() {
                return 53 * (53 + super.hashCode()) + color.hashCode();
            }







            /*
             * Note that now, obj must instanceof ColorPoint!
             */
            @Override
            public boolean canEqual(Object obj) {
                return obj instanceof ColorPoint;
            }

            @Override
            public boolean equals(Object obj) {
                if (!(obj instanceof ColorPoint)) {
                    return false;
                }
                ColorPoint other = (ColorPoint)obj;
                return other.canEqual(this) && color.equals(other.color) && super.equals(obj);
            }
        }




















        /*
         * EqualsVerifier gets a bit more involved:
         */

        EqualsVerifier.forClass(Point.class)
            .withRedefinedSubclass(ColorPoint.class)
            .verify();

        stopHere();


        EqualsVerifier.forClass(ColorPoint.class)
            .withRedefinedSuperclass()
            .verify();

        stopHere();



















        /*
         * That's because EqualsVerifier wants to:
         *
         * - make the common stuff easy, and
         *
         * - make the uncommon stuff possible.
         */




















        /*
         * But it also works on our Proxy!
         */
        final class Point$$Proxy extends Point {
            public Point$$Proxy(int x, int y) {
                super(x, y);
            }
        }

        Point p = new Point(1, 2);
        Point q = new Point$$Proxy(1, 2);
        assertEquals(p, q);

        stopHere();


        EqualsVerifier.forClass(Point$$Proxy.class)
                .verify();

        stopHere();



















    }
}
