---
pagetitle: Java from a Parallel Universe
theme: moon
transition: none
progress: "false"
controls: "false"
center: "false"
---

# Java from a Parallel Universe { data-state="page-title" }

## Jan Ouwens

<br/><br/><br/><br/>

![](../images/codestar.png){style="height:30px;margin-top:5px;"} | [EqualsVerifier](https://jqno.nl/equalsverifier)

![](../images/twitter.png) [jqno](https://twitter.com/jqno) | [jqno.nl](https://jqno.nl)

---

::: superbig
#1
:::

---

::: superbig
#10
:::

---

::: superbig
#1024579 23508726
:::

---

::: superbig
#1024579 2350x10<sup>42</sup>
:::

---

::: superbig
#1024579 2350x10<sup>∞</sup>
:::

---

::: superbig
Let me

**help** you
:::

# Annotations { data-state="page-title" }

## What are they?

```java
@Override
public int hashCode() { ... }

@Test
public void something() { ... }

@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.PROPERTY,
  property = "type")
@JsonSubTypes({
  @Type(value = SubA.class, name = "SubA")
})
public class Something { ... }
```

## Why?

## Why?

**C#** had them

<br/>

<small>(C# → **2002**, Java → **2004**)</small>

. . .

<small>(Parallel Java → **never**)</small>

## Why?

Add metadata

```java
@Override

@Deprecated

@SuppressWarnings("deprecation")

@Nonnull
```

## Why?

Remove external configuration (xml)

```java
@Inject

@Autowired

@Bean
```

## Why?

Generate code

```java
@Entity

@Data(staticConstructor = "of")
```

## Why?

Modify runtime behavior

```java
@Test

@Transaction(isolation = Isolation.SERIALIZABLE)

@GetMethod(value = "/endpoint/{id}",
           produces = MediaType.APPLICATION_JSON_VALUE)
```

---

::: superbig
&nbsp;

Magic
:::

---

::: superbig
Dark

Magic
:::

## The problem

Checked at runtime

## The problem { data-state="page-bad" }

![](../images/funtimeexceptions.png)

## The problem

Weakly typed

## The problem { data-state="page-bad" }

Weakly typed

```java
@Autowired @Bean
@Column(name = "id")
@PostMapping("/endpoint/new")
@Test
public void waitwhat() { ... }
```

## The problem { data-state="page-bad" }

Stringly typed

```java
@PreAuthorize("isFullyAuthenticated")
```

## The problem { data-state="page-good" }

Stringly typed

```java
@PreAuthorize("isFullyAuthenticated()")
```

## The problem

Discoverability

. . .

![](../images/discoverability.png){ height=300px }

## The problem

Debugability

. . .

::: stacktrace

```xml
java.lang.IllegalArgumentException: Cannot find cache named 'vets' for Builder[public abstract java.util.Collection com.example.petclinic.vet.VetRepository.findAll() throws org.springframework.dao.DataAccessException] caches=[vets] | key='' | keyGenerator='' | cacheManager='' | cacheResolver='' | condition='' | unless='' | sync='false'
	at org.springframework.cache.interceptor.AbstractCacheResolver.resolveCaches(AbstractCacheResolver.java:92) ~[spring-context-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.cache.interceptor.CacheAspectSupport.getCaches(CacheAspectSupport.java:252) ~[spring-context-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.cache.interceptor.CacheAspectSupport$CacheOperationContext.<init>(CacheAspectSupport.java:707) ~[spring-context-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.cache.interceptor.CacheAspectSupport.getOperationContext(CacheAspectSupport.java:265) ~[spring-context-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.cache.interceptor.CacheAspectSupport$CacheOperationContexts.<init>(CacheAspectSupport.java:598) ~[spring-context-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.cache.interceptor.CacheAspectSupport.execute(CacheAspectSupport.java:345) ~[spring-context-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.cache.interceptor.CacheInterceptor.invoke(CacheInterceptor.java:61) ~[spring-context-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186) ~[spring-aop-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:212) ~[spring-aop-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at com.sun.proxy.$Proxy133.findAll(Unknown Source) ~[na:na]
	at com.example.petclinic.vet.VetController.showVetList(VetController.java:44) ~[classes/:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:na]
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:566) ~[na:na]
	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:189) ~[spring-web-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138) ~[spring-web-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:102) ~[spring-webmvc-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:895) ~[spring-webmvc-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:800) ~[spring-webmvc-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87) ~[spring-webmvc-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1038) ~[spring-webmvc-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:942) ~[spring-webmvc-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1005) ~[spring-webmvc-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:897) ~[spring-webmvc-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:634) ~[tomcat-embed-core-9.0.16.jar:9.0.16]
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:882) ~[spring-webmvc-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:741) ~[tomcat-embed-core-9.0.16.jar:9.0.16]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231) ~[tomcat-embed-core-9.0.16.jar:9.0.16]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-9.0.16.jar:9.0.16]
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53) ~[tomcat-embed-websocket-9.0.16.jar:9.0.16]
```

:::

## Frameworks and libraries

many existed **before** lambdas were introduced

## What if ...

* they dropped annotations?

* and **embraced lambdas**?

## In the Parallel Universe

<br/>

No annotations!

<br/>

Just **plain Java**

# Testing { data-state="page-title" }

## In your universe { data-state="page-bad" }

```java
@Test
public void indexOfReturnsTheCorrectIndex() {
    int actual = "hello world".indexOf('w');
    assertEquals(6, actual);
}
```

## JUnit 3 👹 { data-state="page-bad" }

```java
public void testIndexOfReturnsTheCorrectIndex() {
    int actual = "hello world".indexOf('w');
    assertEquals(6, actual);
}
```

## In the parallel universe { data-state="page-good" }

```java
test("indexOf returns the correct index", () -> {
    int actual = "hello world".indexOf('w');
    assertThat(actual).isEqualTo(6);
});
```

# Web { data-state="page-title" }

## In your universe { data-state="page-bad" }

```java
@GetMapping("/todo/{id}")
public String getTodo(@PathVariable("id") String id) {
    return fetch(id);
}
```

## In the parallel universe { data-state="page-good" }

```java
get("/todo/:id", (request, response) -> {
    return fetch(request.params("id"));
})
```

## Separating concerns { data-state="page-good" }

```java
public void defineRoutes() {
    get("/todo/:id", this::handleGet);
}

// ...

public String handleGet(Request request, Response response) {
    return fetch(request.params("id"));
}
```

## Cross-cutting concerns { data-state="page-good" }

```java
before((request, response) -> {
    if (!authenticated(request)) {
        halt(401, "nope");
    }
});
```

# Database { data-state="page-title" }

## In your universe { data-state="page-bad" }

```java
@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private String id;

    @Column(name = "title")
    private String title;

    public Todo() {
        // empty
    }
}
```

## JPA entities

* must be **mutable**
* generate invisible code
* jumble up domain logic and database hints

## In the parallel universe { data-state="page-good" }

```java
public class Todo {
    private final String id;
    private final String title;

    // No default constructor
}
```

## In the parallel universe { data-state="page-good" }

```java
List<Todo> todos = engine.query(handle -> {
    return handle
        .createQuery("SELECT * FROM todo WHERE id = :id")
        .bind("id", id)
        .mapToBean(Todo.class)
        .list();
});
```

## How about transactions?

```java
String query = "SELECT * FROM todo WHERE title = :title";
String update = "UPDATE todo SET completed = TRUE WHERE id = :id";

engine.execute(handle -> {
    return handle.inTransaction(h -> {
        Todo todo = h.createQuery(query)
                .bind("title", "rewrite annotations")
                .mapToBean(Todo.class)
                .findFirst();

        h.createUpdate(update)
                .bind("id", todo.id)
                .execute();
    });
});
```

## Advantages

* **Clean** separation of concerns
* **Immutable** domain classes
* **Easier** debugging

# Dependency Injection { data-state="page-title" }

## DI with Spring { data-state="page-bad" }

```java
public class INeedSomething {
    @Autowired
    private Something needed;
}

public class IHaveSomething {
    @Bean
    public Something something = ...;
}
```

## DI with Spring { data-state="page-bad" }

```java
public class INeedSomething {
    @Autowired
    public INeedSomething(Something needed) {
        // ...
    }
}

public class IHaveSomething {
    @Bean
    public Something something = ...;
}
```

## DI with Spring { data-state="page-bad" }

```java
public class INeedSomething {

    public INeedSomething(Something needed) {
        // ...
    }
}

public class IHaveSomething {
    @Bean
    public Something something = ...;
}
```

## DI with Spring

A mistake: no match

## DI with Spring { data-state="page-bad" }

```java
public class INeedSomething {

    public INeedSomething(Something needed) {
        // ...
    }
}

public class IHaveSomething {

    public Something something = ...;
}
```

## DI with Spring { data-state="page-bad" }

::: stacktrace

```xml
org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'petController': Unsatisfied dependency expressed through field 'something'; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.example.petclinic.model.Something' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement.inject(AutowiredAnnotationBeanPostProcessor.java:596) ~[spring-beans-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.beans.factory.annotation.InjectionMetadata.inject(InjectionMetadata.java:90) ~[spring-beans-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessProperties(AutowiredAnnotationBeanPostProcessor.java:374) ~[spring-beans-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1395) ~[spring-beans-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:592) ~[spring-beans-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:515) ~[spring-beans-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:320) ~[spring-beans-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:222) ~[spring-beans-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:318) ~[spring-beans-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199) ~[spring-beans-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:849) ~[spring-beans-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:877) ~[spring-context-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:549) ~[spring-context-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:142) ~[spring-boot-2.1.3.RELEASE.jar:2.1.3.RELEASE]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:775) [spring-boot-2.1.3.RELEASE.jar:2.1.3.RELEASE]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:397) [spring-boot-2.1.3.RELEASE.jar:2.1.3.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:316) [spring-boot-2.1.3.RELEASE.jar:2.1.3.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1260) [spring-boot-2.1.3.RELEASE.jar:2.1.3.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1248) [spring-boot-2.1.3.RELEASE.jar:2.1.3.RELEASE]
	at com.example.petclinic.PetClinicApplication.main(PetClinicApplication.java:32) [classes/:na]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_181]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_181]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_181]
	at java.lang.reflect.Method.invoke(Method.java:498) ~[na:1.8.0_181]
	at org.springframework.boot.devtools.restart.RestartLauncher.run(RestartLauncher.java:49) [spring-boot-devtools-2.1.3.RELEASE.jar:2.1.3.RELEASE]
Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.example.petclinic.model.Something' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.raiseNoMatchingBeanFound(DefaultListableBeanFactory.java:1654) ~[spring-beans-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1213) ~[spring-beans-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1167) ~[spring-beans-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement.inject(AutowiredAnnotationBeanPostProcessor.java:593) ~[spring-beans-5.1.5.RELEASE.jar:5.1.5.RELEASE]
	... 24 common frames omitted
```

:::

## DI with Spring

A mistake: two matches

## DI with Spring { data-state="page-bad" }

```java
public class INeedSomething {

    public INeedSomething(Something needed) {
        // ...
    }
}

public class IHaveSomething {
    @Bean
    public Something something = ...;

    @Bean
    public Something somethingElse = ...;
}
```

## DI with Spring { data-state="page-bad" }

::: stacktrace

```xml
***************************
APPLICATION FAILED TO START
***************************

Description:

Field needed in com.example.petclinic.owner.PetController required a single bean, but 2 were found:
	- something: defined by method 'something' in class path resource [com/example/petclinic/system/CacheConfiguration.class]
	- somethingElse: defined by method 'somethingElse' in class path resource [com/example/petclinic/system/CrashController.class]


Action:

Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed
```

:::

## DI with Spring: conclusion

* Need a **container**
* Fields **can't** be final
* Call constructor **directly**
* **`@Autowired`** not always necessary?
* **Confusing** stacktraces
* Issues found at runtime
* **No** architectural boundaries

## DI with Guice { data-state="page-bad" }

```java
public class INeedSomething {
    private final Something needed;

    @Inject
    public INeedSomething(Something needed) {
        this.needed = needed;
    }
}

public class Module extends AbstractModule {
    public void configure() {
        bind(Something.class).toInstance(...);
    }
}
```

## DI with Guice

A mistake: no match

## DI with Guice { data-state="page-bad" }

```java
public class INeedSomething {
    private final Something needed;

    @Inject
    public INeedSomething(Something needed) {
        this.needed = needed;
    }
}

public class Module extends AbstractModule {
    public void configure() {
        // bind(Something.class).toInstance(...);
    }
}
```

## DI with Guice { data-state="page-bad" }

::: stacktrace

```xml
com.google.inject.CreationException: Unable to create injector, see the following errors:

1) No implementation for services.Counter was bound.
  while locating services.Counter
    for the 1st parameter of controllers.CountController.<init>(CountController.java:22)
  while locating controllers.CountController
    for the 3rd parameter of router.Routes.<init>(Routes.scala:38)
  at play.api.inject.RoutesProvider$.bindingsFromConfiguration(BuiltinModule.scala:123):
Binding(class router.Routes to self) (via modules: com.google.inject.util.Modules$OverrideModule -> play.api.inject.guice.GuiceableModuleConversions$$anon$4)

1 error
	at com.google.inject.internal.Errors.throwCreationExceptionIfErrorsExist(Errors.java:543)
	at com.google.inject.internal.InternalInjectorCreator.initializeStatically(InternalInjectorCreator.java:159)
	at com.google.inject.internal.InternalInjectorCreator.build(InternalInjectorCreator.java:106)
	at com.google.inject.Guice.createInjector(Guice.java:87)
	at com.google.inject.Guice.createInjector(Guice.java:78)
	at play.api.inject.guice.GuiceBuilder.injector(GuiceInjectorBuilder.scala:186)
	at play.api.inject.guice.GuiceApplicationBuilder.build(GuiceApplicationBuilder.scala:139)
	at play.api.inject.guice.GuiceApplicationLoader.load(GuiceApplicationLoader.scala:21)
	at play.core.server.DevServerStart$$anon$1.$anonfun$reload$3(DevServerStart.scala:176)
	at play.utils.Threads$.withContextClassLoader(Threads.scala:22)
```

:::

## DI with Guice

A mistake: two matches

## DI with Guice { data-state="page-bad" }

```java
public class INeedSomething {
    private final Something needed;

    @Inject
    public INeedSomething(Something needed) {
        this.needed = needed;
    }
}

public class Module extends AbstractModule {
    public void configure() {
        bind(Something.class).toInstance(...);
        bind(Something.class).toInstance(...);
    }
}
```

## DI with Guice { data-state="page-bad" }

::: stacktrace

```xml
com.google.inject.CreationException: Unable to create injector, see the following errors:

1) A binding to services.Counter was already configured at Module.configure(Module.java:29) (via modules: com.google.inject.util.Modules$OverrideModule -> Module).
  at Module.configure(Module.java:30) (via modules: com.google.inject.util.Modules$OverrideModule -> Module)

1 error
	at com.google.inject.internal.Errors.throwCreationExceptionIfErrorsExist(Errors.java:543)
	at com.google.inject.internal.InternalInjectorCreator.initializeStatically(InternalInjectorCreator.java:159)
	at com.google.inject.internal.InternalInjectorCreator.build(InternalInjectorCreator.java:106)
	at com.google.inject.Guice.createInjector(Guice.java:87)
	at com.google.inject.Guice.createInjector(Guice.java:78)
	at play.api.inject.guice.GuiceBuilder.injector(GuiceInjectorBuilder.scala:186)
	at play.api.inject.guice.GuiceApplicationBuilder.build(GuiceApplicationBuilder.scala:139)
	at play.api.inject.guice.GuiceApplicationLoader.load(GuiceApplicationLoader.scala:21)
	at play.core.server.DevServerStart$$anon$1.$anonfun$reload$3(DevServerStart.scala:176)
	at play.utils.Threads$.withContextClassLoader(Threads.scala:22)
```

:::

## DI with Guice: conclusion

* Need a **container**
* Call constructor **directly**
* **Clear** stacktraces
* Issues found at runtime
* **Some** architectural boundaries

## Manual DI { data-state="page-good" }

```java
public class Main {
    public static void main(String... args) {
        Something needed = ...;
        INeedSomething iNeedSomething = new INeedSomething(needed);
    }
}

public class INeedSomething {
    private final Something needed;

    public INeedSomething(Something needed) {
        this.needed = needed;
    }
}
```

## Manual DI

A mistake: no matches

## Manual DI { data-state="page-good" }

```java
public class Main {
    public static void main(String... args) {
        // Something needed = ...;
        INeedSomething iNeedSomething =
            new INeedSomething(needed);
    }
}
```

## Manual DI { data-state="page-good" }

```xml
[ERROR] COMPILATION ERROR :
[ERROR] [...]/Main.java:[34,82] cannot find symbol
  symbol:   variable needed
  location: class nl.jqno.paralleljava.Main
```

## Manual DI

A mistake: two matches

## Manual DI { data-state="page-good" }

```java
public class Main {
    public static void main(String... args) {
        Something needed = ...;
        Something somethingElse = ...;
        INeedSomething iNeedSomething =
            new INeedSomething(???);
    }
}
```

. . .

You have to pick!


## Manual DI: conclusion

* Don't need a **container**
* **Clear** architectural boundaries
* Invalid states are **not representable**
* Some **boilerplate**
* One dirty class

## Manual DI: conclusion

::: superbig
**Shit don't compile**
:::

# Other annotations { data-state="page-title" }

## Bad annotations

* Serialization
* Validation
* Code generation

## So-so annotations

* `@NonNull`
* `@Immutable`
* `@SuppressWarnings`

## Good annotations

* `@Override`
* `@Deprecated`

# Wrapping up { data-state="page-title" }

## Yeah right

---

<br/><br/>

::: superbig
It's all **real**
:::

## Libraries

* [SparkJava](http://sparkjava.com/)
* [JDBI](http://jdbi.org/)
* [PicoTest](https://github.com/jqno/PicoTest)

# Alternatives

* Web: [Spring 5 Functional Web Framework](https://spring.io/blog/2016/09/22/new-in-spring-5-functional-web-framework)
* DB: [JOOQ](https://www.jooq.org/)

# Alternatives

* Web: [Spring 5 Functional Web Framework](https://spring.io/blog/2016/09/22/new-in-spring-5-functional-web-framework)
* DB: [JOOQ](https://www.jooq.org/)
* Scala
* Kotlin
* ...

## Demo application

<br/>

![](../images/github.png)

[github.com/jqno/paralleljava](https://github.com/jqno/paralleljava)

# Questions? { data-state="page-title" }

