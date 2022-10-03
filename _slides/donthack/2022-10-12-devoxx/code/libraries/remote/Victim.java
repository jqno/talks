//DEPS net.bytebuddy:byte-buddy:1.12.16

public class Victim {

    public static void main(String... args) throws Exception {

        System.out.println("Current PID: " + ProcessHandle.current().pid());

        while (true) {
            System.out.println(System.currentTimeMillis());
            Thread.sleep(995);
        }
    }
}
