package nl.jqno.equalsverifier.talk;

import static nl.jqno.equalsverifier.talk.helper.StopHere.stopHere;

import nl.jqno.equalsverifier.EqualsVerifier;

public class S10 {
    public static void main(String... args) {










        /*
         * Concluding:
         */
        class Point {

            private final int x;
            private final int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public final boolean equals(Object obj) {
                return obj instanceof Point other &&
                    x == other.x &&
                    y == other.y;
            }

            @Override
            public final int hashCode() {
                return 53 * (53 + x) + y;
            }

            @Override
            public String toString() {
                return "Point: " + x + "," + y;
            }
        }

        EqualsVerifier.forClass(Point.class)
            .verify();

        stopHere();















        /*
         * Correct! And simple.
         */





    }
}
