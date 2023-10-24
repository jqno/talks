---
pagetitle: "How Java annotations work"
backgroundTransition: none
transition: none
progress: "false"
controls: "false"
center: "false"
---

#

::: big
How

**Java annotations**

work
:::

## My credentials

- EqualsVerifier
- "Parallel Java"
- AnnotationScript

## What is this magic?

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

- metadata for code
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

- primitive types (`int`, `long`, `double`, etc)
- `String`
- `Class`
- `Enum`
- Another annotation
- 1-dimensional arrays of these

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

public @interface Tags {                 // container
    Tag[] value();
}
```

```java
@Tags({ @Tag("fast"), @Tag("unit") })
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

Available through reflection

- Spring
- JPA

## Retention: class

`@Retention(RetentionPolicy.CLASS)`

Written into classfile but unavailable

- @NonNull
- @Nullable

## Retention: source

`@Retention(RetentionPolicy.SOURCE)`

Available only at compile-time

- @Override
- @Deprecated
- but also: Lombok

## Reading RUNTIME annotations

```java
@MyAnnotation("value")
public class MyClass {}
```

```java
Class<?> myClass = MyClass.class;

if (myClass.isAnnotationPresent(MyAnnotation.class)) {

    MyAnnotation ann = myClass.getAnnotation(MyAnnotation.class);
    System.out.println("Value from MyAnnotation: " + ann.value());
}
```

## Reading RUNTIME annotations

```java
public class MyClass {
    @MyAnnotation("value")
    public String myField;
}
```

```java
Class<?> myClass = MyClass.class;
Field field = myClass.getField("myField");

if (field.isAnnotationPresent(FieldAnnotation.class)) {

    MyAnnotation ann = field.getAnnotation(MyAnnotation.class);
    System.out.println("Value from MyAnnotation: " + ann.value());
}
```

## Reading CLASS annotations

- Need a tool like Byte Buddy
- Requires a lot more code

## Reading SOURCE annotations

- Need to write a compiler plugin
- Oh no
- Why would you make one

## Frameworks

- Spring is RUNTIME
  - slow startup
- Quarkus, Micronaut are RUNTIME
  - but process at compile-time
  - slow compile

## Conclusion

Todo

## Thanks

Todo: QR code
