---
pagetitle: "How Java annotations work"
backgroundTransition: none
transition: none
progress: "false"
controls: "false"
center: "false"
autoSlide: 15000
---

# { data-state="page-title" data-background-image="../images/jfall-background.png" }

::: superbig
How<br/>**Java annotations**<br/>work
:::

![](../images/jfall.png){ style="height:100px;" }

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
@Target(ElementType.METHOD)
public @interface MyAnnotation {

    String value();
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
public @interface MyAnnotation {

    String value();
    int count() default 0;
}
```

```java
✅ @MyAnnotation("x")
✅ @MyAnnotation(value = "x")
✅ @MyAnnotation(value = "x", count = 42)

⛔ @MyAnnotation("x", count = 42)
⛔ @MyAnnotation(count = 42)
```

## Meta-annotations

&nbsp;        &nbsp; &nbsp;
------------- ------ -------------------------
`@Target`     🟢     where does it go
`@Retention`  🟢     how is it stored
`@Documented` ⭕     put it in Javadoc
`@Repeatable` ⭕     use it multiple times
`@Inherited`  ⭕     also put it on subclasses

## Targets

`@Target({ ElementType.FIELD, ElementType.METHOD })`

::: supersmall
&nbsp;
:::

::: twocolumn
<div>
- Type
- Field
- Method
- Parameter
- Constructor
- Local variable
</div>
<div>
- Annotation type
- Package
- Type parameter
- Type use
- Module
- Record
</div>
:::

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

## Thanks! { data-state="page-title" data-background-image="../images/jfall-background.png" }

![](../images/jan-ouwens.jpg){ .portrait style="height:200px;" }

::: small
Jan Ouwens

![](../images/yoink.png){ style="height:40px;margin-top:15px;" } │ [EqualsVerifier](https://jqno.nl/equalsverifier) │ [jqno.nl](https://jqno.nl) │ ![](../images/twitter.png){ style="height:30px;" } [jqno](https://twitter.com/jqno)

![](../images/jfall.png){ style="height:40px;" }
:::

Slides at **[jqno.nl/talks](https://jqno.nl/talks)**
