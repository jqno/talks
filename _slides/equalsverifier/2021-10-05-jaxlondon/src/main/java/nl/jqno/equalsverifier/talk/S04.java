package nl.jqno.equalsverifier.talk;

import static nl.jqno.equalsverifier.talk.helper.StopHere.stopHere;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class S04 {
    public static void main(String...args) {










        /*
         * Actually, I've been lying a little bit. Let's do that last thing again.
         */




















        class ImmutablePoint {
            private final int x;
            private final int y;

            public ImmutablePoint(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public int hashCode() {
                return 53 * (53 + x) + y;
            }

            @Override
            public boolean equals(Object obj) {
                if (!(obj instanceof ImmutablePoint)) {
                    return false;
                }
                ImmutablePoint other = (ImmutablePoint)obj;
                return x == other.x && y == other.y;
            }
        }



















        /*
         * In reality, I've been redirecting all EqualsVerifier calls to THIS.
         */
        EqualsVerifier.forClass(ImmutablePoint.class)
            .suppress(Warning.STRICT_INHERITANCE)
            .verify();

        stopHere();



















        /*
         * I think this is a pretty nice solution!
         *
         * But making your classes final is not always an option.
         * 
         * Sometimes, you need to create a subclass.
         */





    }
}
