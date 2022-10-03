//JAVA_OPTIONS --add-opens java.base/java.lang=ALL-UNNAMED
//DEPS org.objenesis:objenesis:3.3
//DEPS net.bytebuddy:byte-buddy:1.12.16
//DEPS net.bytebuddy:byte-buddy-agent:1.12.16

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.MethodDelegation;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

import java.lang.reflect.Array;
import java.lang.reflect.Method;

import static net.bytebuddy.matcher.ElementMatchers.*;

public class ConfusingCardGame {

    enum Suit {
        DIAMONDS, CLUBS, HEARTS, SPADES
    }

    public static void main(String... args) throws Exception {
        for (var s : Suit.values()) {
            System.out.println(s);
        }

        System.out.println("\nShuffle\n");
        addEnumConstant(Suit.class, "TRUMPS");

        for (var s : Suit.values()) {
            System.out.println(s);
        }
    }










    /* HOW DOES IT WORK? */


    private static final Objenesis OBJENESIS = new ObjenesisStd();

    private static <E extends Enum<?>> void addEnumConstant(Class<E> type, String constantName) throws Exception {

        /* Get enum.values() */
        Method method = type.getDeclaredMethod("values");
        E[] values = (E[]) method.invoke(type);
        int ordinal = values.length;

        /* Create new enum instance */
        E newInstance = OBJENESIS.newInstance(type);

        var ordinalField = Enum.class.getDeclaredField("ordinal");
        ordinalField.setAccessible(true);
        ordinalField.set(newInstance, ordinal);

        var nameField = Enum.class.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(newInstance, constantName);

        /* Create values array with new constant */
        E[] newValues = (E[]) Array.newInstance(type, ordinal + 1);
        System.arraycopy(values, 0, newValues, 0, ordinal);
        newValues[ordinal] = newInstance;

        /* Use Byte Buddy to intercept enum.values() */
        ByteBuddyAgent.install();
        Holder.values = (Suit[]) newValues;
        new ByteBuddy()
                .with(Implementation.Context.Disabled.Factory.INSTANCE)
                .redefine(type)
                .method(named("values"))
                .intercept(MethodDelegation.to(Holder.class))
                .make()
                .load(type.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());
    }

    /* Create a place where we can store the new values */
    static class Holder {
        static Suit[] values;
        static Suit[] intercept() { return values; }
    }
}
