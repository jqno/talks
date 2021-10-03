package nl.jqno.equalsverifier.talk;


import static nl.jqno.equalsverifier.talk.helper.StopHere.stopHere;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import nl.jqno.equalsverifier.EqualsVerifier;

public class S01 {
    public static void main(String...args) {










        /*
         * What's wrong with this implementation?
         */
        class Point {
            private int x;
            private int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public boolean equals(Point obj) {
                return x == obj.x && y == obj.y;
            }
        }




















        /*
         * Let's create some example data.
         */
        var p1 = new Point(0, 1);
        var p2 = new Point(0, 1);
        var p3 = new Point(1, 2);


        /*
         * It works, doesn't it?
         */
        assertTrue(p1.equals(p2));
        assertFalse(p1.equals(p3));

        stopHere();



















        /*
         * Well... no. No it doesn't. :(
         */
        var list = new ArrayList<Point>();
        list.add(p1);

        assertTrue(list.contains(p2));

        stopHere();




















        /*
         * Get a better error message.
         */
        EqualsVerifier.forClass(Point.class)
            .verify();

        stopHere();



















        /*
         * Here's a better implementation.
         */

        /*
            @Override
            public boolean equals(Object obj) {
                if (!(obj instanceof Point)) {
                    return false;
                }
                Point other = (Point)obj;
                return x == other.x && y == other.y;
            }
        */




















        /*
         * Here's a prettier implementation (Java 16+)
         */

        /*
            @Override
            public boolean equals(Object obj) {
                return obj instanceof Point other &&
                    x == other.x &&
                    y == other.y;
            }
        */




















        /*
         * Reflexivity
         */







    }
}
