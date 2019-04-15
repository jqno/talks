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

![](../images/codestar.png)

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
Let me help you
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

C# had them

<br/>

<small>(C# → 2002, Java → 2004)</small>

. . .

<small>(Parallel Java → never)</small>

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

![](../images/discoverability.png){ height=300px }

## The problem

Debugability

## The problem { data-state="page-bad" }

Debugability

::: { style="font-size:0.4em;" }

```xml
java.lang.IllegalArgumentException: Cannot find cache named 'vets' for Builder[public abstract java.util.Collection org.springframework.samples.petclinic.vet.VetRepository.findAll() throws org.springframework.dao.DataAccessException] caches=[vets] | key='' | keyGenerator='' | cacheManager='' | cacheResolver='' | condition='' | unless='' | sync='false'
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
	at org.springframework.samples.petclinic.vet.VetController.showVetList(VetController.java:44) ~[classes/:na]
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

## In the Parallel Universe

<br/>

No annotations!

<br/>

Just Java

# Testing { data-state="page-title" }

# Web { data-state="page-title" }

# Database { data-state="page-title" }

# Serialization { data-state="page-title" }

# Dependency Injection { data-state="page-title" }

# Wrapping up { data-state="page-title" }

