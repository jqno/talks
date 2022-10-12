//JAVA_OPTIONS --add-opens java.base/java.lang=ALL-UNNAMED                                                                                         -Djava.security.manager=allow

public class Intern {
    public static void main(String... args) throws Exception {
        var world = "Hello world!";
        var devoxx = "Hello Devoxx!";

        System.out.println(world);
        System.out.println(devoxx);

        var valueField = String.class.getDeclaredField("value");
        valueField.setAccessible(true);

        var newValue = valueField.get(devoxx);
        valueField.set(world, newValue);

        System.out.println("---");
        System.out.println(world);
        System.out.println("Hello world!");
    }
}
