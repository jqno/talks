//JAVA_OPTIONS --add-opens java.base/java.lang=ALL-UNNAMED
//DEPS org.objenesis:objenesis:3.3

import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

public class Singletons {

    enum Singleton {
        INSTANCE
    }

    public static void main(String... args) throws Exception {
        Singleton s = copyEnumConstant(Singleton.class, Singleton.INSTANCE);

        System.out.println("Original: " + Singleton.INSTANCE);
        System.out.println("Copy:     " + s);
        System.out.println("Same?     " + Singleton.INSTANCE.equals(s));
    }





















    /* HOW DOES IT WORK? */


    private static final Objenesis OBJENESIS = new ObjenesisStd();

    private static <E extends Enum<?>> E copyEnumConstant(Class<E> type, E constant) throws Exception {
        E newInstance = OBJENESIS.newInstance(type);

        var ordinalField = Enum.class.getDeclaredField("ordinal");
        ordinalField.setAccessible(true);
        ordinalField.set(newInstance, constant.ordinal());

        var nameField = Enum.class.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(newInstance, constant.name());

        return newInstance;
    }
}
