---
pagetitle: Upgrading Scala 2.12 to 2.13
theme: moon
backgroundTransition: none
transition: none
progress: "false"
controls: "false"
center: "false"
---
# Upgrading Scala 2.12 to 2.13

**Jan Ouwens**

**@jqno**

# What's new in 2.13

## What's new

* Collections overhaul
* `Future` is faster and more robust
* Language: literal types, partial unification, more
* Compiler: 5-10% faster

[Read more](https://github.com/scala/scala/releases/tag/v2.13.0)

## What's deprecated

Procedure syntax

```scala
def m() { ... }

  ↓

def m(): Unit = { ... }
```

## What's deprecated

Unicode arrows

::: {style="font-family:Courier;"}
`←   →   ⇒`

  ↓

`<-  ->  =>`
:::

## What's deprecated

Postfix operators

```scala
xs size

  ↓

xs.size
```

## Collections overhaul

For simplicity, performance and safety

* Simpler signatures:<br>~~`CanBuildFrom`~~
* Simpler hierarchy:<br>~~`Traversable`~~, ~~`TraversableOnce`~~

## Collections overhaul

`scala.Seq` is now immutable! 🎉

## Collections overhaul

Deprecated `/:` and `:\`

(use `foldLeft` and `foldRight`)

## Collections overhaul

much, much [more](https://github.com/scala/scala/releases/tag/v2.13.0)

## Java interop moved

more about that later

## Using

```scala
Using(new BufferedReader(new FileReader("file"))) { reader =>
  // do stuff
}
```

`reader.close()` called automatically

## tap

Useful for debugging

```scala
val result = ???
println(result)
result
```

↓

```scala
import scala.util.chaining._

result.tap(println)
```

## toIntOption

<br>

```scala
"12".toIntOption   → Some(12)
"nope".toIntOption → None
```

## Either

`.right` is deprecated

Either is now right-biased

# In our project

## Our application

* Uses Slick
* Uses ScalaTest
* Maven build 😢
* Lots of linting
* Scoverage

## Build

## Build

[Recommended flags for 2.12 by tpolecat](https://tpolecat.github.io/2017/04/25/scalac-flags.html)

Not all of them work

## Build

* `-Ywarn-inaccessible` → `-Xlint:inaccessible`<br>Inaccessible types in method signatures
* ~~`-Yno-adapted-args`~~<br>Do not adapt an argument list (either by inserting () or creating a tuple) to match the receiver

## Build

```xml
<artifactId>scalafmt-core_${scala.version}</artifactId>

  ↓

<artifactId>scalafmt-core_2.12</artifactId>
```

Scala-fmt is not available for 2.13 yet

But it doesn't matter

## Code

## Code

```scala
array.map(...)

  ↓

array.toSeq.map(...)
```

Arrays are mutable

`map` should not mutate in-place

## Code

```scala
import scala.collection.immutable.Seq

  ↓

nothing
```

🎉

## Code

```scala
import scala.collection.JavaConverters._

  ↓

import scala.jdk.CollectionConverters._
```

Java interop has moved

## Code

```scala
myMap.filterKeys(...)
myMap.mapValues(...)

  ↓

myMap.view.filterKeys(...)
myMap.view.mapValues(...)
```

They are implemented as views; this makes that explicit

Strict versions may come later

## Code

```scala
Stream.continually(...)

  ↓

LazyList.continually(...)
```

`Stream` is deprecated because it was not fully lazy

# Dependencies

## Scala-Maven-Plugin

Did you update?

. . . 

4.0 is broken for us

¯\\\_(ツ)\_/¯

## ScalaTest

≥ 3.0.8

## ScalaTest

```
import org.scalatest.prop.Checkers

  ↓

import org.scalatestplus.scalacheck.Checkers
```

ScalaCheck related classes have moved to ScalaTestPlus

## ScalaTest

Remove `EitherValues` trait

```scala
e.right.value

  ↓

e.toOption.value
```

Because `Either.right` is deprecated

## Slick

≥ 3.3.2

## Slick

* Now supports `java.time`
* **Requires changes** if you already have mappings for these types!
* Especially on **MySql/MariaDB**, where Slick uses `VARCHAR` instead of `TIMESTAMP`

## Scoverage

≥ 1.4.0

## Scoverage

`scoverage-maven-plugin` 1.4.0 does not exist 😢

Fork this [Pull Request](https://github.com/scoverage/scoverage-maven-plugin/pull/73)

## Scoverage

Measures differently: may need to **adjust thresholds**

## WartRemover

## WartRemover

**`Any`**

Now unusable due to so many false positives

## WartRemover

**`StringPlusAny`**

Now also applies to string-interpolation!

Also, **`any2stringadd`** is now deprecated in Scala anyway

## Random dependency hell

Transitive dependencies may or may not be compatible

```xml
<exclusions>
  <!-- pulls in Jackson for Scala 2.12 instead of 2.13,
       so we have to suppress here -->
  <exclusion>
      <groupId>com.fasterxml.jackson.module</groupId>
      <artifactId>jackson-module-scala_2.12</artifactId>
  </exclusion>
</exclusions>
```

# Questions?

![](images/qr.png)

@jqno

