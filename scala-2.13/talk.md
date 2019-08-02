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

Jan Ouwens

@jqno

# What's new in 2.13

## Collections rework

## Either

Right-biased

## Seq

## tap

# Changes

## Build

## Build

[Recommended flags for 2.12 by tpolecat](https://tpolecat.github.io/2017/04/25/scalac-flags.html)

Not all of them work

## Build

* `-Ywarn-inaccessible` → `-Xlint:inaccessible`<br>Inaccessible types in method signatures
* ~~`-Yno-adapted-args`~~<br>Do not adapt an argument list (either by inserting () or creating a tuple) to match the receiver

## Build

`<artifactId>scalafmt-core_${scala.version}</artifactId>`

↓

`<artifactId>scalafmt-core_2.12</artifactId>`

## Code

## Code

`array.map(...)`

↓

`array.toSeq.map(...)`

## Code

`import scala.collection.immutable.Seq`

↓

nothing

## Code

`import scala.collection.JavaConverters._`

↓

`import scala.jdk.CollectionConverters._`

## Code

`myMap.filterKeys(...)`

↓

`myMap.view.filterKeys(...)`

## Code

`myMap.mapValues(...)`

↓

`myMap.view.mapValues(...)`

## Code

`Stream.continually(...)`

↓

`LazyList.continually(...)`

# Dependencies

## Scala-Maven-Plugin

Did you update?

. . . 

4.0 is broken for us

¯\\\_(ツ)\_/¯

## ScalaTest

≥ 3.0.8

## ScalaTest

`import org.scalatest.prop.Checkers`

↓

`import org.scalatestplus.scalacheck.Checkers`

## ScalaTest

Remove `EitherValues`

<br>

`e.right.value`

↓

`e.toOption.value`

## Slick

≥ 3.3.2

## Slick

Now supports `java.time`

Requires changes if you already have mappings for these types!

Especially on MySql/MariaDB, where Slick uses `VARCHAR` instead of `TIMESTAMP`

## Scoverage

≥ 1.4.0

## Scoverage

`scoverage-maven-plugin` 1.4.0 does not exist 😢

Fork this [Pull Request](https://github.com/scoverage/scoverage-maven-plugin/pull/73)

## Scoverage

Measures differently

May need to adjust thresholds

## WartRemover

* `Any`
* `StringPlusAny`

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

