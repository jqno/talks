package demos.libraries.remote;

import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.agent.builder.AgentBuilder;

import java.io.File;
import java.lang.instrument.Instrumentation;

import static net.bytebuddy.implementation.FixedValue.value;
import static net.bytebuddy.matcher.ElementMatchers.named;
import static net.bytebuddy.matcher.ElementMatchers.none;

public class Payload {

    public static void agentmain(String arguments, Instrumentation instrumentation) {

        System.out.println("Let's install some malicious code...  ᕕ( ᐛ )ᕗ ");

        AgentBuilder.Transformer λ =
                (builder, typeDescription, classLoader, javaModule, protectionDomain) -> builder
                                .method(named("currentTimeMillis"))
                                .intercept(value(1337));

        new AgentBuilder.Default()
                .ignore(none())
                .disableClassFormatChanges()
                .with(AgentBuilder.RedefinitionStrategy.RETRANSFORMATION)
                .type(named("java.lang.System"))
                .transform(λ)
                .installOn(instrumentation);
    }
}
