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

![](../images/ruby.svg.png){ .cardimg }

|||
|---|---|
|||
| Typing | strong, duck |
| Runtime | interpreted |
| Memory | managed |
| Appeared in | 1995 |

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
| Runtime | compiled to intermediate |
| Memory | managed |
| Appeared in | 2000 |

## C\# - what does it look like?

```csharp
using System;

namespace FizzBuzz
{
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
}
```

## C\# - what makes it interesting?

```csharp
using System;
using System.Linq;

namespace FizzBuzz
{
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
}
```

## C\# - what did I learn from it?

Open source vs proprietary

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

Implement a LISP

#

![](../images/cloud.png){ height=600px }

## FIN

![](../images/qr.png)

[jqno.nl/talks/fantasticlanguages](https://jqno.nl/talks/fantasticlanguages)

![](../images/twitter.png){ height=30px } #fantasticlanguages

::: supersmall
image credits: see website
:::
