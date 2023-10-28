---
pagetitle: "How Java annotations work"
backgroundTransition: none
transition: none
progress: "false"
controls: "false"
center: "false"
autoSlide: 15000
---

#

::: superbig
How

**Java annotations**

work
:::

## My **credentials**

- ✅ EqualsVerifier
- ✅ AnnotationScript
- ⛔ "Parallel Java"

## **What** is this magic?

```java
@Entity
@Data
public class User {
    @Id
    private Long id;

    @NotNull
    @Valid
    private String name;

    @Autowired
    private Service service;

    @Override
    public String toString() {
        return "User: " + name;
    }
}
```

## What is an annotation?

- **metadata** for code
- for code analysis
- overpowered

## Syntax of an annotation

```java
@Inherited                               // optional
@Repeatable(Container.class)             // optional
@Retention(RetentionPolicy.RUNTIME)      // required
@Target(ElementType.METHOD)              // required
public @interface MyAnnotation {         // note: @interface

    String value();                      // parameter
    int count() default 0;               // parameter with default
}
```

## Allowed parameter types

<br/>

- primitive types (`int`, `long`, `double`, etc)
- `String`, `Class`, `Enum`
- Another **annotation**
- 1-dimensional **arrays** of these

<br/>

Must be <span class="big">**CONSTANT**</span>

## Parameter syntax

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyAnnotation {

    String value();
    int count() default 0;
}
```

```java
✅ @MyAnnotation("value")
✅ @MyAnnotation(value = "value")
✅ @MyAnnotation(value = "value", count = 42)

⛔ @MyAnnotation("value", count = 42)
⛔ @MyAnnotation(count = 42)
```

## @Repeatable

```java
@Repeatable(Container.class)             // @Repeatable
public @interface Tag {
    String value();
}

public @interface Container {            // container
    Tag[] value();
}
```

```java
@Container({ @Tag("fast"), @Tag("unit") })
class Test {}                            // explicit container
```

```java
@Tag("fast")
@Tag("unit")
class Test {}                            // implicit container/still in Tags
```

## @Inherited

```java
@Inherited
public @interface Component {}

// Not @Inherited !
public @interface Primary {}
```

```java
@Component
@Primary
public class PaymentStrategy {}                 // A component, and @Primary

public class iDealPaymentStrategy extends PaymentStrategy {}
                                     // Still a @Component, but not @Primary
```

## Targets

&nbsp;            &nbsp;
----------------  -----------------
- Type            - Annotation type
- Field           - Package
- Method          - Type parameter
- Parameter       - Type use
- Constructor     - Module
- Local variable  - Record

## Retention: runtime

`@Retention(RetentionPolicy.RUNTIME)`

<br/><br/>

Available through reflection

- Spring
- JPA

## Reading **RUNTIME** annotations

```java
@MyAnnotation("woohoo")
public class MyClass {}
```

```java
Class<?> myClass = MyClass.class;

Annotation[] annotations = myClass.getDeclaredAnnotations();
                               // Annotation[1] = { MyAnnotation("woohoo") }

MyAnnotation ann = myClass.getAnnotation(MyAnnotation.class);
                               // MyAnnotation("woohoo")

ann.value()
                               // "woohoo"
```

## Reading **RUNTIME** annotations

```java
public class MyClass {
    @MyAnnotation("wheee")
    public String myField;
}
```

```java
Class<?> myClass = MyClass.class;
Field field = myClass.getField("myField");

Annotation[] annotations = field.getDeclaredAnnotations();
                               // Annotation[1] = { MyAnnotation("wheee") }

MyAnnotation ann = field.getAnnotation(MyAnnotation.class);
                               // MyAnnotation("wheee")

ann.value()
                               // "wheee"
```

## Retention: class

`@Retention(RetentionPolicy.CLASS)`

<br/><br/>

Written into classfile but unavailable

- @NonNull
- @Nullable

## Reading **CLASS** annotations

- Need a tool like **Byte Buddy**
- Requires a lot more code

## Retention: source

`@Retention(RetentionPolicy.SOURCE)`

<br/><br/>

Available only at compile-time

- @Override
- @Deprecated
- but also: **Lombok**

## Reading **SOURCE** annotations

- Need to be the compiler
- Or write a **compiler plugin**
- Oh no
- Why would you do that?
- So much **WHY**

## Frameworks

- Spring
  - process at **run-time**
  - **slow startup**
- Quarkus, Micronaut
  - process at **compile-time**
  - has to process files anyway

## Conclusion

Annotations are like **magic**

<br/>

- They **do** a lot of work
- They **require** a lot of work

## Thanks!

![](../images/jan-ouwens.jpg){ .portrait style="height:200px;" }

::: small
Jan Ouwens

![](../images/yoink.png){ style="height:40px;margin-top:15px;" } │ [EqualsVerifier](https://jqno.nl/equalsverifier) │ [jqno.nl](https://jqno.nl) │ ![](../images/twitter.png){ style="height:30px;" } [jqno](https://twitter.com/jqno)
:::

<br/>

Slides at **[jqno.nl/talks](https://jqno.nl/talks)**
