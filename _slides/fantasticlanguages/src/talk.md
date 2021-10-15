---
pagetitle: Fantastic languages and what to learn from them
theme: white
backgroundTransition: none
transition: none
progress: "false"
controls: "false"
center: "false"
---
# Fantastic languages
<!-- markdownlint-disable MD045 -->

::: subtitle
and what to learn from them
:::

## Why?

* Language of the Year
* Change your thinking

## ∀ language

::: supersmall
in increasing order of length
:::

* Who?
* Beard?
* Pretty?
* Interesting?
* Changed my thinking?

## Beard 🧔 !?

::: small
viral in 2008:
:::

Computer languages and facial hair [🔗](https://web.archive.org/web/20081013115149/http://blogs.microsoft.co.il/blogs/tamir/archive/2008/04/28/computer-languages-and-facial-hair-take-two.aspx)

![](../images/beards.png)

# Jan Ouwens

![](../images/jan-ouwens.jpg){ .portrait style="height:200px;" }

![](../images/yoink.png){ style="height:40px;margin-top:15px;" } │ [EqualsVerifier](https://jqno.nl/equalsverifier) │ [jqno.nl](https://jqno.nl) │ ![](../images/twitter.png){ style="height:30px;" } [jqno](https://twitter.com/jqno)

![](../images/twitter.png){ style="height:30px;" } #fantasticlanguages

# Java

![](../images/java.svg){ .bigimg }

## Java - creator

![](../images/james-gosling.jpg){ .bigimg }

James Gosling

## Java - creator

![](../images/james-gosling.jpg){ .bigimg }

Beard: ✅

## Java - properties

![](../images/java.svg){ .cardimg }

|||
|---|---|
|||
| Typing | strong, static |
| Runtime | JVM |
| Memory | managed |
| Appeared in | 1995 |
| Used for | Enterprise back-end, Android |

## Java - what does it look like?

```Java
public class Program {
    public static void main(String...args) {
        System.out.println("Hello World");

        for (int i = 1; i <= 100; i++) {
            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
            }
            else if (i % 3 == 0) {
                System.out.println("Fizz");
            }
            else if (i % 5 == 0) {
                System.out.println("Buzz");
            }
            else {
                System.out.println(i);
            }
        }
    }
}
```

## Java - what makes it interesting?

Backwards compatibility

## Java - what did I learn from it?

Open source

# BASIC

![](../images/basic.png){ .bigimg }

## BASIC - creator

![](../images/kemeny-kurtz.jpg){ .bigimg }

John Kemeny & Thomas Kurtz

## BASIC - creator

![](../images/kemeny-kurtz.jpg){ .bigimg }

Beard: ❌❌

## BASIC - properties

![](../images/basic.png){ .cardimg }

|||
|---|---|
|||
| Typing | weak, static with sigils |
| Runtime | interpreted |
| Memory | not much |
| Appeared in | 1964 |
| Used for | teaching |

## BASIC - what does it look like?

```basic
10 PRINT "HELLO WORLD"
20 FOR I = 1 to 100
30 LET S$ = ""
40 IF I % 3 = 0 THEN LET S$ = S$ + "FIZZ"
50 IF I % 5 = 0 THEN LET S$ = S$ + "BUZZ"
60 IF S$ = "" THEN LET S$ = I
70 PRINT S$
80 NEXT I
```

## BASIC - what makes it interesting?

* Easy to learn (at the time)
* Ran natively on consumer computers
  * Commodore 64
  * MSX

## BASIC - what did I learn from it?

Programming!

. . .

![](../images/thesis.jpg){ style="height:9em;" }

::: supersmall
from my master's thesis
:::

# Ruby

![](../images/ruby.png){ .bigimg }

## Ruby - creator

![](../images/matsumoto.jpg){ .bigimg }

Yukihiro Matsumoto

## Ruby - creator

![](../images/matsumoto.jpg){ .bigimg }

Beard: ✅

## Ruby - properties

![](../images/ruby.png){ .cardimg }

|||
|---|---|
|||
| Typing | strong, duck |
| Runtime | interpreted |
| Memory | managed |
| Appeared in | 1995 |
| Used for | scripting, simple back-end |

## Ruby - what does it look like?

```ruby
puts "Hello World"

1.upto 100 do |i|
  string = ""

  string += "Fizz" if i % 3 == 0
  string += "Buzz" if i % 5 == 0
  string = i.to_s if string == ""

  puts "#{i} = #{string}"
end
```

## Ruby - what makes it interesting?

Beautifully consistent OO model

* `Class` is an object
* `Object` is a class

## Ruby - what makes it interesting?

Beautifully extendable OO model

```ruby
class Integer
  def to_xml
    "<int>#{self}</int>"
  end
end

puts 10.to_xml
```

## Ruby - what makes it interesting?

Beautifully _explosive?_ OO model

```ruby
class Module
  alias private_old private
  alias public_old public
  alias private public_old
  alias public private_old
end
```

## Ruby - what did I learn from it?

The importance of community

::: small
[how it deals with problems](https://gist.github.com/peternixey/1978249)
:::

# Arabic

![](../images/arabic.svg){ .bigimg }

## Arabic - creator

![](../images/arabic-campfire.jpg){ .bigimg }

Unknowable

## Arabic - creator

![](../images/arabic-campfire.jpg){ .bigimg }

Beard: ![](../images/trollface.png){ height=40px }

## Arabic - properties

![](../images/arabic.svg){ .cardimg }

|||
|---|---|
|||
| Family | semitic |
| Script | arabic |
| Native speakers | ±350mln |
| Appeared in | 5th century CE |
| Used in | Northern Africa, Middle-East |

## Arabic - what does it look like?

!مرحبا بالعالم

<br/>

١ ،٢، فيز، ٤، بوز، فيز، ٧، ٨، فيز، بوز، ١١، فيز، ١٣، ١٤، فيزبوز، ١٦، ١٧، فيز، ١٩، بوز، فيز، ٢٢، ٢٣، فيز، بوز، ٢٦، فيز، ٢٨، ٢٩، فيزبوز

## Arabic - what makes it interesting?

![](../images/arabic-books.jpg){ .bigimg }

## Arabic - what did I learn from it?

![](../images/sattouf.png){ .bigimg }

::: supersmall
From _The Arab of the Future 2_ by Riad Sattouf
:::

# Lisp

![](../images/lisp.png){ .bigimg }

## Lisp - creator

![](../images/john-mccarthy.jpg){ .bigimg }

John McCarthy

## Lisp - creator

![](../images/john-mccarthy.jpg){ .bigimg }

Beard: ✅ ✅ ✅

## Lisp - properties

![](../images/lisp.png){ .cardimg }

|||
|---|---|
|||
| Typing | strong, dynamic |
| Runtime | compiled to native |
| Memory | managed |
| Appeared in | 1958 |
| Used for | AI |

## Lisp - what does it look like?

```lisp
(println "Hello world")

(define (fizzbuzz x y)
  (println
    (cond ((= (modulo x 15) 0) "FizzBuzz")
          ((= (modulo x 3) 0) "Fizz")
          ((= (modulo x 5) 0) "Buzz")
          (else x)))
 
    (if (< x y) (fizzbuzz (+ x 1) y)))
 
(fizzbuzz 1 100)
```

::: supersmall
Scheme dialect
:::

## Lisp - what makes it interesting?

![](../images/inception.jpg)

::: notes
homo-iconicity
:::

## Lisp - what did I learn from it?

::: superbig
🤯
:::

# C\#

![](../images/csharp.svg){ .bigimg }

## C\# - creator

![](../images/anders-hejlsberg.jpg){ .bigimg }

Anders Hejlsberg

## C\# - creator

![](../images/anders-hejlsberg.jpg){ .bigimg }

Beard: ❌

## C\# - properties

![](../images/csharp.svg){ .cardimg }

|||
|---|---|
|||
| Typing | strong, static |
| Runtime | .NET |
| Memory | managed |
| Appeared in | 2000 |
| Used for | Windows GUIs, back-end |

## C\# - what does it look like?

```csharp
using System;

class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("Hello World");

        for (int i = 1; i <= 100; i++)
        {
            if (i % 15 == 0)
            {
                Console.WriteLine("FizzBuzz");
            }
            else if (i % 3 == 0)
            {
                Console.WriteLine("Fizz");
            }
            else if (i % 5 == 0)
            {
                Console.WriteLine("Buzz");
            }
            else
            {
                Console.WriteLine(i);
            }
        }
    }
}
```

## C\# - what makes it interesting?

```csharp
using System;
using System.Linq;

class Program
{
    static void Main(string[] args)
    {
        var result = from i in Enumerable.Range(1, 100)
                        select (i % 15 == 0) ? "BuzzFizz" :
                            (i % 5 == 0) ? "Buzz" :
                            (i % 3 == 0) ? "Fizz" :
                            i.ToString();
        result.ForEach(Console.WriteLine);
    }
}
```

## C\# - what did I learn from it?

Proprietary tools & libs

# Delphi

![](../images/delphi.jpg){ .bigimg }

## Delphi - creator

![](../images/anders-hejlsberg.jpg){ .bigimg }

Anders Hejlsberg

## Delphi - creator

![](../images/anders-hejlsberg.jpg){ .bigimg }

Beard: ❌

## Delphi - properties

![](../images/delphi.jpg){ .cardimg }

|||
|---|---|
|||
| Typing | strong, static |
| Runtime | compiled to native |
| Memory | manual |
| Appeared in | 1995 |
| Used for | Windows GUIs |

## Delphi - what does it look like?

```pascal
program HelloWorld;
var
  i: Integer;
begin
  WriteLn('Hello World');

  for i := 0 to 100 do
  begin
    if i mod 15 = 0 then
      WriteLn('FizzBuzz');
    else if i mod 3 = 0 then
      WriteLn('Fizz');
    else if i mod 5 = 0 then
      WriteLn('Buzz');
    else
      WriteLn(IntToStr(i));
  end;
end.
```

## Delphi - what makes it interesting?

![](../images/delphi-win3.png){ .bigimg }

## Delphi - what did I learn from it?

![](../images/hashmap.jpg){ .bigimg }

# TypeScript

![](../images/typescript.svg){ .bigimg }

## TypeScript - creator

![](../images/anders-hejlsberg.jpg){ .bigimg }

Anders Hejlsberg

## TypeScript - creator

![](../images/anders-hejlsberg.jpg){ .bigimg }

Beard: ❌

## TypeScript - properties

![](../images/typescript.svg){ .cardimg }

|||
|---|---|
|||
| Typing | gradual |
| Runtime | compiled to JavaScript |
| Memory | managed |
| Appeared in | 2012 |
| Used for | front-end |

## TypeScript - what does it look like?

```typescript
console.log('Hello world')

for (let i = 1; i < 101; i++) {
    if (i % 15 === 0) {
        console.log('FizzBuzz')
    }
    else if (i % 3 === 0) {
        console.log('Fizz')
    }
    else if (i % 5 === 0) {
        console.log('Buzz')
    }
    else {
        console.log(i)
    }
}
```

## TypeScript - what does it look like?

```typescript
console.log('Hello world')

for (let i: number = 1; i < 101; i++) {
    if (i % 15 === 0) {
        console.log('FizzBuzz')
    }
    else if (i % 3 === 0) {
        console.log('Fizz')
    }
    else if (i % 5 === 0) {
        console.log('Buzz')
    }
    else {
        console.log(i)
    }
}
```

## TypeScript - what makes it interesting?

```typescript
// Lodash's pick() function

function pick(object, paths)

pick({ a: 1, b: 2, c: 3, d: 4 }, ['a', 'd'])
===> { a: 1, d:4 }




```

## TypeScript - what makes it interesting?

```typescript
// Lodash's pick() function

function pick(object, paths)

pick({ a: 1, b: 2, c: 3, d: 4 }, ['a', 'd'])
===> { a: 1, d:4 }

function pick<O extends object, Keys extends keyof O>
             (object: O, paths: Keys[]): { [K in Keys]: O[K] }
```

## TypeScript - what did I learn from it?

![](../images/lsp.png){ .bigimg }

# AnnotationScript

![](../images/annotationscript.png){ .bigimg }

## AnnotationScript - creator

![](../images/jan-ouwens.jpg){ .bigimg }

Me!

## AnnotationScript - creator

![](../images/jan-ouwens.jpg){ .bigimg }

Beard: ✅

## AnnotationScript - properties

![](../images/annotationscript.png){ .cardimg }

|||
|---|---|
|||
| Typing | weak, dynamic |
| Runtime | interpreted |
| Memory | managed |
| Appeared in | 2021 |
| Used for | fun |

## AnnotationScript - what does it look like?

```java
import nl.jqno.annotationscript.AnnotationScript;
import nl.jqno.annotationscript.Annotations.*;

@Zero("begin")
@Zero(list={@One("println"), @One("'Hello World'")})
@Zero(list={@One("define"), @One("fizz-buzz"), @One(list={@Two("lambda"), @Two(list=@Three("n")), @Two(list={
    @Three("cond"),
    @Three(list={@Four("="), @Four(list={@Five("%"), @Five("n"), @Five("15")}), @Four("0")}), @Three("'fizzbuzz'"),
    @Three(list={@Four("="), @Four(list={@Five("%"), @Five("n"), @Five("3")}), @Four("0")}), @Three("'fizz'"),
    @Three(list={@Four("="), @Four(list={@Five("%"), @Five("n"), @Five("5")}), @Four("0")}), @Three("'buzz'"),
    @Three("else"), @Three("n")})})})
@Zero(list={@One("map"), @One("println"), @One(list={@Two("map"), @Two("fizz-buzz"), @Two(list={@Three("range"), @Three("1"), @Three("101")})})})
public class FizzBuzz {
    public static void main(String[] args) {
        AnnotationScript.run(FizzBuzz.class);
    }
}
```

## AnnotationScript - what makes it interesting?

Push Java annotations to the limit

## AnnotationScript - what did I learn from it?

Implement a Lisp

#

![](../images/cloud.png){ height=600px }

## FIN

![](../images/qr.png)

[jqno.nl/talks/fantasticlanguages](https://jqno.nl/talks/fantasticlanguages)

![](../images/twitter.png){ height=30px } #fantasticlanguages

::: supersmall
image credits: see website
:::
