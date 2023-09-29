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

::: big
AnnotationScript
:::

Java annotations with a LISP

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

## Climate for developers&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; { data-state="page-title" data-background-image="../images/climate-change.png" }

<br/><br/><br/><br/><br/><br/><br/><br/>

Read more at [jqno.nl/climate](https://jqno.nl/climate/)

## Weird projects

. . .

![](../images/finisher.png){ .bigimg }

## Weird projects

![](../images/vim.png){ .bigimg }

## Weird projects

![](../images/asterix.png){ .bigimg }

## Weird projects

![](../images/paralleljava.png){ .bigimg }

## Weird projects

<br/>

Let's do the opposite!

<br/><br/>

no annotations → only annotations

## WHY!?

. . .

Why not?

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

![](../images/the-little-schemer.jpg){ .bigimg }

## WHY!?

![](../images/nerd-cred.png){ .bigimg }

## WHY!?

I got excited with this one!

. . .

![](../images/annotationscript.png)

## Also

No ChatGPT

. . .

::: small
Except for the final demo
:::

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

# { data-state="page-title" data-background-image="../images/background.png" }

::: superbig
(LISP)
:::

# { data-state="page-title" data-background-image="../images/background.png" }

::: superbig
((LISP))
:::

# { data-state="page-title" data-background-image="../images/background.png" }

::: superbig
(((LISP)))
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

## Syntax

```lisp
(+ x 10)
```

## Syntax

```lisp
(+ x 10)

(+ x (* 2 5))
```

## The Power of LISP

```lisp
(+ x 10)

(+ x (* 2 5))

((if #t + -) x 10)
```

## ((Parentheses))

. . .

```java
if (this.getId().equals(that.getId()))
```

```lisp
(if (= (getId this) (getId that)))
```

## Recursion

```java
public int sum(int n) {
    int result = 0;
    for (int i = 0; i < n; i++) {
        result += i;
    }
    return result;
}
```

## Recursion

```java
public int sum(int n) {
    if (n == 0) {
        return 0;
    }
    else {
        return n + sum(n - 1);
    }
}
```

## Recursion

```lisp
(define (sum n)
  (cond ((eq? n 0) 0)
        (else (+ n (sum (- n 1))))))
```

## Stack overflow

. . .

![](../images/stackoverflow.png){ .bigimg }

## Stack overflow

```plaintext
java.lang.StackOverflowError
        at java.base/java.util.Objects.hashCode(Objects.java:103)
        at io.vavr.collection.HashArrayMappedTrieModule$AbstractNode.get(HashArrayMappedTrie.java:235)
        at io.vavr.collection.HashMap.get(HashMap.java:615)
        at nl.jqno.annotationscript.language.Environment.lookupOption(Environment.java:16)
        at nl.jqno.annotationscript.language.Environment.lookup(Environment.java:20)
        at nl.jqno.annotationscript.language.Evaluator.evaluateSymbol(Evaluator.java:53)
        at nl.jqno.annotationscript.language.Evaluator.evaluate(Evaluator.java:21)
        at nl.jqno.annotationscript.language.Evaluator.evaluateProc(Evaluator.java:117)
        at nl.jqno.annotationscript.language.Evaluator.evaluate(Evaluator.java:45)
        at nl.jqno.annotationscript.language.Evaluator.lambda$4(Evaluator.java:121)
        at io.vavr.collection.Traversable.foldLeft(Traversable.java:493)
        at nl.jqno.annotationscript.language.Evaluator.evaluateProc(Evaluator.java:120)
        at nl.jqno.annotationscript.language.Evaluator.evaluate(Evaluator.java:45)
        at nl.jqno.annotationscript.language.Evaluator.lambda$0(Evaluator.java:76)
        at io.vavr.collection.Traversable.find(Traversable.java:458)
        at nl.jqno.annotationscript.language.Evaluator.evaluateCond(Evaluator.java:76)
        at nl.jqno.annotationscript.language.Evaluator.evaluate(Evaluator.java:33)
```

## Stack overflow

```lisp
(sum 4)
(+ 4 (sum 3))
(+ 4 (+ 3 (sum 2)))
(+ 4 (+ 3 (+ 2 (sum 1))))
(+ 4 (+ 3 (+ 2 (+ 1 (sum 0)))))
(+ 4 (+ 3 (+ 2 (+ 1 0))))
(+ 4 (+ 3 (+ 2 1)))
(+ 4 (+ 3 3))
(+ 4 6)
10
```

## Tail call optimization

Let's re-write

## Tail call optimization

```lisp
(define (sum n)
  (cond ((eq? n 0) 0)
        (else (+ n (sum (- n 1))))))
```

↓

```lisp
(define (sum n acc)
  (cond ((eq? n 0) acc)
        (else (sum (- n 1) (+ n acc)))))
```

## Tail call optimization

```lisp
(sum 4)
(+ 4 (sum 3))
(+ 4 (+ 3 (sum 2)))
(+ 4 (+ 3 (+ 2 (sum 1))))
(+ 4 (+ 3 (+ 2 (+ 1 (sum 0)))))
(+ 4 (+ 3 (+ 2 (+ 1 0))))
(+ 4 (+ 3 (+ 2 1)))
(+ 4 (+ 3 3))
(+ 4 6)
10
```

## Tail call optimization

```lisp
(sum 4 0)
(sum (- 4 1) (+ 4 0))
(sum 3 4)
(sum (- 3 1) (+ 3 4))
(sum 2 7)
(sum (- 2 1) (+ 2 7))
(sum 1 9)
(sum (- 1 1) (+ 1 9))
(sum 0 10)
10
```

## Recursion

What if...

## Recursion

![](../images/the-little-schemer.jpg){ .bigimg }

## Y Combinator

. . .

![](../images/hackernews.png){ .bigimg }

## Y Combinator

```lisp
(define Y
  (lambda (le)
    ((lambda (f) (f f))
     (lambda (f)
       (le (lambda (x) ((f f) x)))))))

```

## Y Combinator

No reasonable person can understand this

But it works

## Demo

# { data-state="page-title" data-background-image="../images/background.png" }

::: big
Annotations
:::

## Why I don't like them

## Why I don't like them

Checked at runtime

<br/><br/><br/><br/>

::: small
You have a nice, compiled, strongly-typed language underneath:

Why not use it!
:::

## Why I don't like them

Weakly typed

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

## Why I don't like them

Stringly typed

```java
@PreAuthorize("isFullyAuthenticated")
```

. . .

```java
@PreAuthorize("isFullyAuthenticated()")
```

## Why I don't like them

Hard to discover

![](../images/discoverability.png){ height=300px }

## Why I don't like them

Hard to debug

<!-- prettier-ignore -->
```java
public @interface GetMapping {
    /**
     * Alias for {@link RequestMapping#name}.
     */
    @AliasFor(annotation = RequestMapping.class)
    String name() default "";

    /**
     * Alias for {@link RequestMapping#value}.
     */
    @AliasFor(annotation = RequestMapping.class)
    String[] value() default {};

    // ...
}
```

## Why I don't like them

Slow

```java
List<Class<?>> allTheClasses = scanTheClasspath();  // 👈 expensive!
for (Class<?> cls : allTheClasses) {
    for (Annotation a : cls.getAnnotations()) {
        Class<?> ann = a.getAnnotationType();
        if (ann.getName().equals("SpringBootApplication")) {
            // Start the container
        }
    }
}
```

##

::: big
Anyway
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

. . .

`@Zero` to `@Eleven`

## Map to AnnotationScript

```lisp
(if (< x 0) "a" "b")









```

## Map to AnnotationScript

```lisp
(
  if
  (
    <
    x
    0)
  "a"
  "b"
)
```

## Map to AnnotationScript

```lisp
(
       if
           (
          <
          x
          0  )
       "a"
       "b"
)
```

## Map to AnnotationScript

<!-- prettier-ignore -->
```java

@Zero("if")
@Zero(list={
    @One("<"),
    @One("x"),
    @One("0")})
@Zero("'a'")
@Zero("'b'")
public static class First {}
```

# { data-state="page-title" data-background-image="../images/background.png" }

::: big
Implementation
:::

## Implementing LISP

![](../images/rite-of-passage.png){ .bigimg }

&nbsp;

## Implementing LISP

Using Peter Norvig's blog post:

_[(How to Write a (Lisp) Interpreter (in Python)) 🔗](https://norvig.com/lispy.html)_

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
@Zero("'a'")      // 'a'
@Zero("'b'")      // 'b'
```

DONE! 🥳

## Architecture

![](../images/architecture-2.png)

## Parser

![](../images/parser.png)

## Parser

- Atoms (`0`, `'a'`) remain the same
- Symbols (`define`, `if`, `<`) are wrapped in `Symbol` class
- `(` starts a sub-list
- `)` ends a sub-list

```java
List<Object> ast = List.of(
    Symbol("if"),
    List.of(Symbol("<"), Symbol("x"), 0),
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

## Tail call optimization

Evaluator works recursively

stack overflow after ~60

## Tail call optimization

Use Peter Norvig's second blog post:

[(An ((Even Better) Lisp) Interpreter (in Python)) 🔗](https://norvig.com/lispy2.html)

## Tail call optimization

- Add mutability
- Evaluate procedure calls in-place

## Tail call optimization

Instead of this:

```java
public Object evaluate(Object expression) {
    // ...
    if (isAtom(expression)) {
        return evaluateAtom(expression);
    }
    if (isProc(expression)) {
        var evaluated = evaluateProc(expression);
        return evaluate(evaluated); // 👈 recursive call
    }
}
```

## Tail call optimization

We do this:

```java
public Object evaluate(Object expression) {
    var exp = expression;
    while (true) {
        // ...
        if (isAtom(expression)) {
            return evaluateAtom(expression);
        }
        if (isProc(expression)) {
            exp = evaluateProc(expression); // 👈 loop
        }
    }
}
```

## Tail call optimization

No more stack overflow 🥳

# { data-state="page-title" data-background-image="../images/background.png" }

::: superbig
Interlude
:::

## Code sample

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

## Ain't nobody got no time for that

![](../images/bored.png){ .bigimg }

## Write normal LISP

```lisp

  (begin
    (define fizz-buzz (lambda (n)
      (cond (= (% n 15) 0) 'fizzbuzz')
      (cond (= (% n 3) 0) 'fizz')
      (cond (= (% n 5) 0) 'buzz')
      (else n))
    (map println (map fizz-buzz (range 1 101))))

```

## Wrap it

```lisp
String code = """
  (begin
    (define fizz-buzz (lambda (n)
      (cond (= (% n 15) 0) 'fizzbuzz')
      (cond (= (% n 3) 0) 'fizz')
      (cond (= (% n 5) 0) 'buzz')
      (else n))
    (map println (map fizz-buzz (range 1 101))))""";
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

return code
    .replace("(", " ( ")
    .replace(")", " ) ")
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

return code
    .replace("(", " ( ")
    .replace(")", " ) ")
    .split(" ");
```

## Code generator

![](../images/code-generator.png){ .bigimg }

# { data-state="page-title" data-background-image="../images/background.png" }

::: superbig
(recurse
:::

::: notes
Now I have a quick way to produce code
:::

##

::: superbig
Demo time!
:::

## MetaScript

![](../images/the-little-schemer.jpg){ .bigimg }

## MetaScript

![](../images/architecture-1.png)

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

## MetaScript

![](../images/architecture-1.png)

## Parser

![](../images/meta-parser.png){ .bigimg }

## Parser

![](../images/mind-blown-2.png){ .shadow }

Unit tests: identical!

::: notes
Non-trivial
:::

## MetaScript

![](../images/architecture-1.png)

## Evaluator

![](../images/the-little-schemer.jpg){ .bigimg }

::: notes
Evaluator is implemented very differently, so tests are different
:::

## Evaluator

![](../images/meta-evaluator.png){ .bigimg }

## Recursion issue

```lisp
(define (sum
  (lambda (i)
    (cond
      ((eq? i 0) 0)
      (else
        (+ i (sum (sub1 i)))))))

  (sum 5))
```

## Recursion issue

```lisp
(define (sum
  (lambda (i)
    (cond
      ((eq? i 0) 0)
      (else
        (+ i (sum (sub1 i)))))))

  (sum 5))
```

`cond has no true branch`

## Recursion issue

```lisp
(define (sum
  (lambda (i)
    (cond
      ((eq? i 0) 0)
      (else
        (+ i (sum (sub1 i)))))))

  (sum 5))
```

Invalid identifier: `sum`

## Recursion issue

```lisp
(define (sum
  (lambda (i)
    (cond
      ((eq? i 0) 0)
      (else
        (+ i (sum (sub1 i)))))))

  (sum 5))
```

Y Combinator ???

## Recursion issue

```lisp
(define (sum
  (lambda (recurse i)
    (cond
      ((eq? i 0) 0)
      (else
        (+ i (recurse recurse (sub1 i)))))))

  (sum sum 5))
```

Solution: function is parameter to itself

# { data-state="page-title" data-background-image="../images/background.png" }

::: superbig
(recurse
:::

## Turing complete

I promised

. . .

But how to prove it?

## Turing complete

- Can solve any computable problem
- Need loops, if, IO
- Mathematical proof is hard and boring

## Turing machine

![](../images/turing-machine.png){ .bigimg }

## Turing machine

- Turing complete by definition
- Tape with cells
- Operations: read at head, write at head, move head

## Turing machine

Implement one!

. . .

...

. . .

::: big
Brainfuck!
:::

##

::: superbig
Demo time!
:::

<br/><br/>

::: small
[brainfuck generator 🔗](https://tnu.me/brainfuck/generator)
:::

# { data-state="page-title" data-background-image="../images/background.png" }

::: superbig
))
:::

# { data-state="page-title" data-background-image="../images/background.png" }

::: superbig
What's next
:::

## Did I _finish_ it?

![](../images/finisher.png){ .bigimg }

## Did I _finish_ it?

::: superbig
🤷🏻
:::

##

::: big
Error handling
:::

`cond has no true branch`

> "[It] expects the programmer to be perfect"

##

::: big
String.split
:::

```java
"'Hello world'" → "'Hello" + "world'"
```

##

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

## Conclusion

Greenspun's Tenth Rule:

_Any sufficiently complicated C or Fortran program contains an ad hoc, informally-specified, bug-ridden, slow implementation of half of Common Lisp._

## Questions? { data-state="page-title" data-background-image="../images/background.png" }

<span style="float:left;width:200px;margin-top:20px;">
![](../images/qr.png)
</span>

- [github.com/jqno/AnnotationScript](https://github.com/jqno/AnnotationScript)

- [jqno.nl/talks/bullshitlanguage](https://jqno.nl/talks/bullshitlanguage)

- [jqno.nl/climate](https://jqno.nl/climate)

::: hashtag
![](../images/twitter.png){ height=30px } #bullshitlanguage

::: supersmall
image credits: see website
:::
:::
