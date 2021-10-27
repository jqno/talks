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

![](../images/progbooks.jpg){ .shadow style="height:320px;" }
![](../images/pragprog.jpg){ .shadow style="height:320px;float:left;" }

## ![](../images/basic.png){ .lineimg } - BASIC

```basic
10 FOR I = 1 to 100
20 LET S$ = ""
30 IF I % 3 = 0 THEN LET S$ = S$ + "FIZZ"
40 IF I % 5 = 0 THEN LET S$ = S$ + "BUZZ"
50 IF S$ = "" THEN LET S$ = I
60 PRINT S$
70 NEXT I
```

## ![](../images/basic.png){ .lineimg } - what makes it interesting?

![](../images/msx.jpg){ .bigimg }

## ![](../images/basic.png){ .lineimg } - what did I learn from it?

![](../images/thesis.jpg){ .bigimg }

::: supersmall
from my master's thesis
:::

::: notes
Programming!
:::

## ![](../images/php.svg){ .lineimg } - PHP

```php
<?php
for ($i = 1; $i <= 100; $i++)
{
    if (!($i % 15))
        echo "FizzBuzz\n";
    else if (!($i % 3))
        echo "Fizz\n";
    else if (!($i % 5))
        echo "Buzz\n";
    else
        echo "$i\n";
}
?>
```

## ![](../images/php.svg){ .lineimg } - what makes it interesting?

![](../images/apple.svg){ .biglogo }

::: notes
It Just Works™
:::

## ![](../images/php.svg){ .lineimg } - what did I learn from it?

![](../images/documentation.jpg){ .bigimg }

::: notes
Great documentation in a time when this wasn't common
:::

## ![](../images/elm.svg){ .lineimg } - Elm

```elm
import Html exposing (text)
import List exposing (map)

main =
  List.range 1 100 |> map getWordForNum |> String.join " "
 
getWordForNum num =
  if modBy num 15 == 0 then
    "FizzBuzz"
  else if modBy num 3 == 0 then
    "Fizz"
  else if modBy num 5 == 0 then
    "Buzz"
  else
    String.fromInt num
```

## ![](../images/elm.svg){ .lineimg } - what makes it interesting?

```sh
I got to the end of the line without seeing the closing double quote:

6| helloworld = "Hello world
                             ^
Strings look like "this" with double quotes on each end. Is the closing double
quote missing in your code?

Note: For a string that spans multiple lines, you can use the multi-line string
syntax like this:

    """
    # Multi-line Strings
    
    - start with triple double quotes
    - write whatever you want
    - no need to escape newlines or double quotes
    - end with triple double quotes
    """
```

## ![](../images/elm.svg){ .lineimg } - what did I learn from it?

![](../images/fool.jpg){ .bigimg }

::: notes
Even I can do front-end
:::

## ![](../images/lisp.png){ .lineimg } - Lisp

```lisp
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

## ![](../images/lisp.png){ .lineimg } - what makes it interesting?

Minimal syntax, maximal power

```lisp
(println "Hello world")

(+ 1 (* 2 3) 4)

(define Y
  (lambda (f)
    (f (lambda (x) ((Y f) x)))))
```

## ![](../images/lisp.png){ .lineimg } - what did I learn from it?

![](../images/arabic-calligraphy.jpg){ .bigimg }

::: notes
beautiful, elegant, undecipherable, full of meaning
:::

## ![](../images/delphi.jpg){ .lineimg } - Delphi

```pascal
program FizzBuzz;
var
  i: Integer;
begin
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

## ![](../images/delphi.jpg){ .lineimg } - what makes it interesting?

![](../images/delphi-win3.png){ .bigimg }

## ![](../images/delphi.jpg){ .lineimg } - what did I learn from it?

![](../images/hashmap.jpg){ .bigimg }

## ![](../images/annotationscript.png){ .lineimg } - AnnotationScript

```java
import nl.jqno.annotationscript.AnnotationScript;
import nl.jqno.annotationscript.Annotations.*;

@Zero("begin")
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

## ![](../images/annotationscript.png){ .lineimg } - what makes it interesting?

```java
@Autowired @Bean
@Column(name = "id")
@PostMapping("/endpoint/new")
@Test
public void waitwhat() { ... }
```

## ![](../images/annotationscript.png){ .lineimg } - what did I learn from it?

```lisp
(begin
  (define fizz-buzz (lambda (n) (cond
    (= (% n 15) 0) 'fizzbuzz
    (= (% n 3) 0) 'fizz
    (= (% n 5) 0) 'buzz
    else n)))
  (map println (map fizz-buzz (range 1 101))))
```

## FIN

![](../images/qr.png)

[jqno.nl/talks/fantasticlanguages](https://jqno.nl/talks/fantasticlanguages)

![](../images/twitter.png){ height=30px } #fantasticlanguages

::: supersmall
image credits: see website
:::
