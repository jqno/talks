//DEPS net.bytebuddy:byte-buddy-agent:1.12.16

import net.bytebuddy.agent.ByteBuddyAgent;

import java.io.File;

public class Attack {

    public static void main(String... args) {
        var agentJar = new File(args[0]);
        var pid = args[1];
        ByteBuddyAgent.attach(agentJar, pid);
    }
}
