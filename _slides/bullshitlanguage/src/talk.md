---
pagetitle: Building a Bullshit Language
theme: white
backgroundTransition: none
transition: none
progress: "false"
controls: "false"
center: "false"
---

# Building a<br/>Bullshit Language { data-state="page-title" data-background-image="../images/background.png" }

<!-- markdownlint-disable MD003 MD033 MD045 -->

![](../images/annotationscript.png){ style="height:240px;" }

::: hashtag
![](../images/twitter.png){ height=30px } #bullshitlanguage
:::

##

::: superbig
Demo time!
:::

## Jan Ouwens { data-state="page-title" data-background-image="../images/background.png" }

![](../images/jan-ouwens.jpg){ .shadow style="height:200px;" }

&nbsp;

![](../images/yoink.png){ style="height:40px;margin-top:15px;" } │ [EqualsVerifier](https://jqno.nl/equalsverifier) │ [jqno.nl](https://jqno.nl) │ ![](../images/twitter.png){ style="height:30px;" } [jqno](https://twitter.com/jqno)

::: hashtag
![](../images/twitter.png){ style="height:30px;" } #bullshitlanguage
:::

## WHY!?

## WHY!?

![](../images/lockdown.png){ .bigimg }

## WHY!?

```java
@Autowired
@Bean
@Column(name = "wat")
@Deprecated
@JsonAlias("whynot")
@PostMapping("/endpoint/wtf")
@Test
public void waitwhat() {}
```

## WHY!?

![](../images/nerd-cred.png){ .bigimg }

##

::: big
AnnotationScript

is

a LISP
:::

# { data-state="page-title" data-background-image="../images/background.png" }

::: superbig
LISP
:::

## What's a LISP?

- Common Lisp
- Scheme
- Emacs
- Racket
- Clojure

## Syntax

```scheme
(define (fizzbuzz x y)
  (cond ((eq? (remainder x 15) 0) (display "FizzBuzz\n"))
        ((eq? (remainder x 3) 0) (display "Fizz\n"))
        ((eq? (remainder x 5) 0) (display "Buzz\n"))
        (else (display x) (display "\n")))

  (cond ((< x y) (fizzbuzz (+ x 1) y))
        (else ())))

(fizzbuzz 1 100)
```

## The Power of LISP

```lisp
(+ x 10)

((if (#t) + -) x 10)
```

## Map to AnnotationScript

```lisp
(define first (lambda (l) (head l)))








```

## Map to AnnotationScript

```lisp
(
  define
  first
  (
    lambda
    (l)
    (head l))
)
```

## Map to AnnotationScript

```lisp
(
       define
       first
           (
          lambda
              (      l  )
              (      head          l  ) )
)
```

## Map to AnnotationScript

<!-- prettier-ignore -->
```java

@Zero("define")
@Zero("first")
@Zero(list={
    @One("lambda"),
    @One(list={@Two("l")}),
    @One(list={@Two("head"), @Two("l")})})
public static class First {}
```

## Implementing LISP

![](../images/rite-of-passage.png){ .shadow }

&nbsp;

::: small
Use Peter Norvig's [blog post](https://norvig.com/lispy.html)
:::

# { data-state="page-title" data-background-image="../images/background.png" }

::: big
Implementation
:::

::: notes
rite of passage
:::

## Architecture

![](../images/architecture-1.png)

## Architecture

![](../images/architecture-2.png)

## Tokenizer

![](../images/tokenizer.png)

## Tokenizer

<!-- prettier-ignore -->
```java
@Zero("if")
@Zero(list={
    @One("<"),
    @One("x"),
    @One("0")
})
@Zero("'a'")
@Zero("'b'")
```

## Tokenizer

<!-- prettier-ignore -->
```java
@Zero("if")       // 'if'
@Zero(list={      // '('
    @One("<"),    // '<'
    @One("x"),    // 'x'
    @One("0")     // '0'
})                // ')'
@Zero("'a'")        // 'a'
@Zero("'b'")        // 'b'
```

DONE! 🥳

##

::: big
But ...

why so `@Weird`?
:::

## Annotations, first try

```java
@Parenthesis("if", @Parenthesis("<", "x", "0"), "'a'", "'b'")
```

## Annotations, first try

<span style="float:left;">
![](../images/duke-says-no.png)
</span>

No nesting annotations!

## Annotations, second try

```java
@Open
@Symbol("if")
@Open@Symbol("<")@Symbol("x")@Symbol("0")@Close
@Symbol("'a'")
@Symbol("'b'")
@Close
```

## Annotations, second try

<span style="float:left;">
![](../images/duke-says-yes.png)
</span>

Sure! I'll group them for you

&nbsp;

&nbsp;

```java
Open[] opens = { @Open, @Open };
Symbol[] symbols = { @Symbol("if"), @Symbol("x"), @Symbol("0"),
                     @Symbol("'a'"), @Symbol("'b'") };
Close[] closes = { @Close, @Close };
```

## Annotations, third try

```java
public @interface Syntax {}  // 👈🏻 smart-ass!

public @interface Open extends Syntax {}
public @interface Symbol extends Syntax {}
public @interface Close extends Syntax {}

Syntax[] code = { @Open, @Symbol("if"), @Open, @Symbol("<"),
                  @Symbol("x"), @Symbol("0"), @Close, @Symbol("'a'"),
                  @Symbol("'b'"), @Close };
```

## Annotations, third try

<span style="float:left;">
![](../images/duke-says-no.png)
</span>

No extending annotations!

## Annotations, fourth and final try

```java
@Zero("if")
@Zero(list={@One("<"), @One("x"), @One("0")})
@Zero("'a'")
@Zero("'b'")
```

## Annotations, fourth and final try

<span style="float:left;">
![](../images/duke-says-yes.png)
</span>

I see no issue with that!

. . .

Make as many as you like!

. . .

🥱

## Architecture

![](../images/architecture-2.png)

## Parser

![](../images/parser.png)

## Parser

- Atoms (`0`, `'a'`) remain the same
- Symbols (`define`, `if`, `<`) are wrapped in `Symbol` class
- `(` starts a list
- `)` ends a list

```java
List<Object> ast = List.of(
    Symbol("if"),
    List.of(Symbol('<'), Symbol('x'), 0),
    "a",
    "b");
```

::: notes
Nested Lists instead of a proper Tree
:::

## Architecture

![](../images/architecture-2.png)

## Environment

![](../images/environment-1.png)

::: notes
Global Environment contains lots of stuff
:::

## Environment

![](../images/environment-1.png)

```lisp
(define x 10)
```

## Environment

![](../images/environment-2.png)

```lisp
(define x 10)
```

## Architecture

![](../images/architecture-2.png)

## Evaluator

![](../images/evaluator.png)

## Evaluator

Is it an Atom?<br/>`0, 'a'`

↓

Return it

## Evaluator

Is it a Symbol?<br/>`if`, `<`

↓

Look up in Environment<br/>Return it

## Evaluator

Is it a List?<br/>`(< x 0)`

↓

Evaluate all elements<br/>Call function<br/>Return result

# { data-state="page-title" data-background-image="../images/background.png" }

::: superbig
Interlude
:::

## A program

<!-- prettier-ignore -->
```java
@Zero("begin")
@Zero(list={@One("define"), @One("fizz-buzz"), @One(list={@Two("lambda"),
  @Two(list=@Three("n")), @Two(list={@Three("cond"),
    @Three(list={@Four("="), @Four(list={@Five("%"), @Five("n"),
      @Five("15")}), @Four("0")}), @Three("'fizzbuzz'"),
    @Three(list={@Four("="), @Four(list={@Five("%"), @Five("n"),
      @Five("3")}), @Four("0")}), @Three("'fizz'"),
    @Three(list={@Four("="), @Four(list={@Five("%"), @Five("n"),
      @Five("5")}), @Four("0")}), @Three("'buzz'"),
    @Three("else"), @Three("n")})})})
@Zero(list={@One("map"), @One("println"), @One(list={@Two("map"),
  @Two("fizz-buzz"), @Two(list={@Three("range"),
  @Three("1"), @Three("101")})})})
public class FizzBuzz {}
```

## A program

<!-- Image: ain't got no time to write that -->

![](../images/bored.png){ .bigimg }

## Tokenizer

```lisp

  (begin
    (define fizz-buzz (lambda (n)
      (cond (= (% n 15) 0) 'fizzbuzz')
      (cond (= (% n 3) 0) 'fizz')
      (cond (= (% n 5) 0) 'buzz')
      (else n))
    (map println (map fizz-buzz (range 1 101))))


```

## Tokenizer

```lisp
String code = """
  (begin
    (define fizz-buzz (lambda (n)
      (cond (= (% n 15) 0) 'fizzbuzz')
      (cond (= (% n 3) 0) 'fizz')
      (cond (= (% n 5) 0) 'buzz')
      (else n))
    (map println (map fizz-buzz (range 1 101))))""";
return code.split(" ");
```

## Code generator

![](../images/code-generator.png){ .bigimg }

# { data-state="page-title" data-background-image="../images/background.png" }

::: superbig
Taking it

TOO FAR
:::

::: notes
Now I have a quick way to produce code
:::

## MetaScript

![](../images/the-little-schemer.jpg){ .bigimg }

## Tokenizer

![](../images/meta-tokenizer.png){ .bigimg }

## Tokenizer

- Unit tests written in Java, not AnnotationScript

- AnnotationScript evaluates to regular Java objects

## Tokenizer

![](../images/mind-blown-1.png){ .shadow }

Unit tests: identical!

::: notes
Trivial
:::

## Parser

![](../images/meta-parser.png){ .bigimg }

## Parser

![](../images/mind-blown-2.png){ .shadow }

Unit tests: identical!

::: notes
Non-trivial
:::

<!-- Image: mind blown 2 -->

## Evaluator

![](../images/the-little-schemer.jpg){ .bigimg }

::: notes
Evaluator is implemented very differently, so tests are different
:::

## Evaluator

![](../images/meta-evaluator.png){ .bigimg }

## Demo

# { data-state="page-title" data-background-image="../images/background.png" }

::: superbig
What's next
:::

## Next

::: superbig
🤷🏻
:::

## Next

::: big
Stack overflow errors
:::

## Next

::: big
Error handling
:::

## Next

::: big
String.split
:::

## Next

::: big
Spring integration
:::

::: supersmall
🤪
:::

::: notes
No @Autowired
:::

# { data-state="page-title" data-background-image="../images/background.png" }

::: superbig
Conclusion
:::

## Conclusion { data-background-image="../images/duke-says-yes-background.png" data-background-size="contain" }

::: big
Learn about annotations
:::

## Conclusion { data-background-image="../images/rite-of-passage.png" }

::: { class="big text-shadow" }
Learn about LISP
:::

## Conclusion { data-background-image="../images/fun.png" }

::: { class="superbig text-shadow" }
It was fun
:::

## Questions? { data-state="page-title" data-background-image="../images/background.png" }

![](../images/qr.png)

[jqno.nl/talks/bullshitlanguage](https://jqno.nl/talks/bullshitlanguage)

::: hashtag
![](../images/twitter.png){ height=30px } #bullshitlanguage

::: supersmall
image credits: see website
:::
:::
