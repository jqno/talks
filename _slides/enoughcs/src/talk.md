---
pagetitle: Just enough computer science for the busy developer
theme: white
backgroundTransition: none
transition: none
progress: "false"
controls: "false"
center: "false"
---

# Just enough computer science for the busy developer { data-state="page-portrait" data-background-image="../images/background.png" }

::: hashtag
![](../images/twitter.png){ height=30px } #enoughcs
:::

## Just enough computer science for the busy developer { data-state="page-portrait" data-background-image="../images/background.png" }

::: hashtag
![](../images/twitter.png){ height=30px } #enoughcs
:::

::: doesitwork
.
:::

##

::: superbig
Why
:::

::: notes
* Not everyone has a CS degree
* That's a good thing
:::

##

::: superbig
Diversity matters
:::

::: notes
* Computers would have remained stuffy
:::

##

::: superbig
Science matters
:::

##

::: big
If you remember only 1 thing
:::

## De Morgan's Laws

Mathy version

::: big
```java
 ¬(a ⋁ b) ≡ ¬a ⋀ ¬b
```

```java
 ¬(a ⋀ b) ≡ ¬a ⋁ ¬b
```
:::

## De Morgan's Laws

Java version

::: big
```java
!(a || b) == !a && !b
```

```java
!(a && b) == !a || !b
```
:::

## For example

```java
if (!(product.price() <= 10 || order.amount() <= 5)) {
  applyDiscount();
}
```

## For example

```java
if (!(a || b)) {
  applyDiscount();
}
```
```java
a = product.price() <= 10
b = order.amount <= 5
```

## For example

```java
if (!a && !b) {
  applyDiscount();
}
```
```java
a = product.price() <= 10
b = order.amount <= 5
```

## For example

```java
if (!(product.price() <= 10) && !(order.amount() <= 5)) {
  applyDiscount();
}
```

## For example

```java
if (product.price() > 10 && order.amount() > 5) {
  applyDiscount();
}
```

## Truth table

 `a`   `b`   `!(a || b)`   `!a && !b`
----- ----- ------------- ------------
  0     0         1            1
  0     1         0            0
  1     0         0            0
  1     1         0            0

## Truth table

 `a`   `b`   `!(a && b)`   `!a || !b`
----- ----- ------------- ------------
  0     0         1            1
  0     1         1            1
  1     0         1            1
  1     1         0            0

##

::: big
If you remember only 2 things
:::

# Jan Ouwens { data-state="page-portrait" data-background-image="../images/background.png" }

![](../images/jan-ouwens.jpg){ .portrait style="height:200px;" }

&nbsp;

![](../images/yoink.png){ style="height:40px;margin-top:15px;" } │ [EqualsVerifier](https://jqno.nl/equalsverifier) │ [jqno.nl](https://jqno.nl) │ ![](../images/twitter.png){ style="height:30px;" } [jqno](https://twitter.com/jqno)

::: hashtag
![](../images/twitter.png){ style="height:30px;" } #enoughcs
:::

###

##

::: { .big style="font-size:2.5em;" }
I studied

computer science

&nbsp;

**so you don't have to**
:::

##

::: big
Lots of interesting people
:::

# Edsger Dijkstra { data-state="page-portrait" data-background-image="../images/background.png" }

![](../images/edsger-dijkstra.jpg){ .portrait }

1930 - 2002

::: notes
* Dutch
* pronounciation
* TU/e
:::

## Edsger Dijkstra { data-state="page-portrait" data-background-image="../images/background.png" }

![](../images/edsger-dijkstra.jpg){ .portrait }

::: small
_"Testing shows the presence, not the absence of bugs."_
:::

## Edsger Dijkstra { data-state="page-portrait" data-background-image="../images/background.png" }

![](../images/edsger-dijkstra.jpg){ .portrait }

::: small
_"The question of whether machines can think is about as relevant<br/>as the question of whether submarines can swim."_
:::

## Edsger Dijkstra { data-state="page-portrait" data-background-image="../images/background.png" }

![](../images/edsger-dijkstra.jpg){ .portrait }

::: small
_"The teaching of BASIC should be rated as a criminal offence:<br/>it mutilates the mind beyond recovery."_
:::

##

[![](../images/dijkstra-zero.png)](http://www.cs.utexas.edu/users/EWD/transcriptions/EWD08xx/EWD831.html)

## Precondition + Postcondition

::: big
```pascal
   {Precondition}
    Statement
   {Postcondition}
```
:::

## Precondition + Postcondition

::: big
```pascal
   {x = 3}
    x += 1;
   {x = 4}
```
:::

. . .

Q.E.D.

## A simple algorithm

```java
  int[] haystack = ...;
  int needle = ...;
  
  
  int i = 0;
  
  while (haystack[i] != needle) {
  
    i += 1;
  
  }


```

## A simple algorithm

```pascal
  var b: array[0..N] of int = ...;
  var n: int = ...;


  i := 0

; do b[i] ≠ n →

    i := i + 1

  od


```

## A simple algorithm
 
```pascal
  var b: array[0..N] of int = ...;
  var n: int = ...;

  { ⟨∃x : 0 ≤ x < N : b[x] = n⟩ }
  i := 0

; do b[i] ≠ n →

    i := i + 1

  od


```

::: notes
We assume one exists within the array
:::

## A simple algorithm
 
```pascal
  var b: array[0..N] of int = ...;
  var n: int = ...;

  { ⟨∃x : 0 ≤ x < N : b[x] = n⟩ }
  i := 0
  { i = 0 ⋀ ⟨∃x : 0 ≤ x < N : b[x] = n⟩ }
; do b[i] ≠ n →

    i := i + 1

  od


```

::: notes
Also, `i = 0`
:::

## A simple algorithm
 
```pascal
  var b: array[0..N] of int = ...;
  var n: int = ...;

  { ⟨∃x : 0 ≤ x < N : b[x] = n⟩ }
  i := 0
  { i = 0 ⋀ ⟨∃x : 0 ≤ x < N : b[x] = n⟩ }
; do b[i] ≠ n →
    { 0 ≤ i < N ⋀ ⟨∀x : 0 ≤ x ≤ i : b[x] ≠ n⟩ ⋀ ⟨∃x : i < x < N : b[x] = n⟩ }
    i := i + 1

  od


```

::: notes
* `i` is in range
* we haven't found it yet
* it's still there were we haven't looked yet
:::

## A simple algorithm
 
```pascal
  var b: array[0..N] of int = ...;
  var n: int = ...;

  { ⟨∃x : 0 ≤ x < N : b[x] = n⟩ }
  i := 0
  { i = 0 ⋀ ⟨∃x : 0 ≤ x < N : b[x] = n⟩ }
; do b[i] ≠ n →
    { 0 ≤ i < N ⋀ ⟨∀x : 0 ≤ x ≤ i : b[x] ≠ n⟩ ⋀ ⟨∃x : i < x < N : b[x] = n⟩ }
    i := i + 1
    { 0 < i < N ⋀ ⟨∀x : 0 ≤ x < i : b[x] ≠ n⟩ ⋀ ⟨∃x : i ≤ x < N : b[x] = n⟩ }
  od


```

::: notes
Increase `i`, so update the less-than signs
:::

## A simple algorithm
 
```pascal
  var b: array[0..N] of int = ...;
  var n: int = ...;

  { ⟨∃x : 0 ≤ x < N : b[x] = n⟩ }
  i := 0
  { i = 0 ⋀ ⟨∃x : 0 ≤ x < N : b[x] = n⟩ }
; do b[i] ≠ n →
    { 0 ≤ i < N ⋀ ⟨∀x : 0 ≤ x ≤ i : b[x] ≠ n⟩ ⋀ ⟨∃x : i < x < N : b[x] = n⟩ }
    i := i + 1
    { 0 < i < N ⋀ ⟨∀x : 0 ≤ x < i : b[x] ≠ n⟩ ⋀ ⟨∃x : i ≤ x < N : b[x] = n⟩ }
  od
  { 0 ≤ i < N ⋀ b[i] = n ⋀ ⟨∀x : 0 ≤ x < i : b[x] ≠ n⟩ }

```

::: notes
Found it!
:::

. . .

Q.E.D.

## What it looked like for me

![](../images/homework0.jpg){ .raw }

::: notes
* plaatje van mijn huiswerk
:::

##

::: big
Proving algorithms is hard
:::

##

::: superbig
Speaking of algorithms
:::

# محمد خوارزمی { data-state="page-portrait" data-background-image="../images/background.png" }

![](../images/muhammad-al-khwarizmi.png){ .portrait }

? - 850

## Muhammad al-Khwarizmi { data-state="page-portrait" data-background-image="../images/background.png" }

![](../images/muhammad-al-khwarizmi.png){ .portrait }

? - 850

## Algorithmi { data-state="page-portrait" data-background-image="../images/background.png" }

![](../images/muhammad-al-khwarizmi.png){ .portrait }

? - 850

::: notes
* Islamic world middle ages
* invented algebra
* Helped introduce "arabic" numerals incl 0
* Algorithm
* Moon-crater
:::

##

::: superbig
Algorithm
:::

::: notes
* Cooking recipe
:::

##

::: big
We live in an

age of libraries
:::

::: notes
* Algorithms are wrapped up in libs
:::

## Libraries

Implement an algorithm

## Libraries

~~Implement an algorithm~~

Prove an algorithm

## Libraries

~~Implement an algorithm~~

~~Prove an algorithm~~

Test an algorithm

## Libraries

~~Implement an algorithm~~

~~Prove an algorithm~~

~~Test an algorithm~~

Choose an algorithm

. . .

how?

##

::: big
Have someone do it for you
:::

# Katherine Johnson { data-state="page-portrait" data-background-image="../images/background.png" }

![](../images/katherine-johnson.jpg){ .portrait }

1918 - 2020

::: notes
* Manual calculations for NASA Apollo
* Movie
* Astronauts didn't trust automation
:::

## Katherine Johnson { data-state="page-portrait" data-background-image="../images/background.png" }

![](../images/katherine-johnson-movie.jpg){ .portrait }

2016

::: notes
* Manual calculations for NASA Apollo
* Movie
* Astronauts didn't trust automation
:::

## 

::: superbig
Complexity
:::

How many steps?

## Let's define

<br/>

::: big
N = input size
:::

## Complexity

```java
public int linearSearch(int needle, int[] haystack) {
  for (int i : haystack) {
    if (haystack[i] == needle) {
      return true;
    }
  }
  return false;
}
```

. . .

$N$ steps

## Complexity

```java
public int get(int[] ints, int index) {
  return ints[index];
}
```

. . .

$1$ step

## Complexity

```java
public boolean hasDuplicates(int[] ints) {
  for (int i : ints) {
    for (int j : ints) {
      if (i != j && ints[i] == ints[j]) {
        return true;
      }
    }
  }
  return false;
}
```

. . .

$N^2$ steps

## Complexity

```java
public int fibonacci(int i) {
  if (i <= i) {
    return i;
  }
  return fibonacci(i - 2) + fibonacci(i - 1);
}
```

. . .

$2^N$ steps

## Complexity

Brute-forcing travelling salesman

. . .

$N!$ steps

## Complexity

* Binary search
* Git bisect

. . .

$log_2\ N$ steps

::: notes
Java's implementation had a bug in it for 9 years
:::

## Complexity

* Binary search
* Git bisect

$log_2\ N$ steps

🤔🤔🤔

## Complexity

* Binary search
* Git bisect

Way less than $N$ steps

##

::: superbig
Abstraction
:::

over complexity

# Donald Knuth { data-state="page-portrait" data-background-image="../images/background.png" }

![](../images/donald-knuth.jpg){ .portrait }

1938 -

::: notes
* Cheques
:::

## Donald Knuth { data-state="page-portrait" data-background-image="../images/background.png" }

![](../images/donald-knuth.jpg){ .portrait }

::: small
_"Beware of bugs in the above code;<br/>I have only proved it correct, not tried it."_
:::

::: notes
* Cheques
:::

## Donald Knuth { data-state="page-portrait" data-background-image="../images/background.png" }

![](../images/donald-knuth.jpg){ .portrait }

::: small
_"Premature optimization is the root of all evil."_
:::

::: notes
* Cheques
:::

## The full quote

<br/>

_"We should forget about small efficiencies, say about 97% of the time: premature optimization is the root of all evil. Yet we should not pass up our opportunities in that critical 3%."_

::: notes
* Cheques
:::

## Book

[![](../images/knuth-book.jpg){ .raw style="height:500px;" }](https://www-cs-faculty.stanford.edu/~knuth/taocp.html)

## Book

[![](../images/knuth-excerpt.jpg)](https://www-cs-faculty.stanford.edu/~knuth/taocp.html)

## Big O notation

steps    Big O
-----    -----
$1$      O($1$)
$log\ N$ O($log\ N$)
$N$      O($N$)
$N^2$    O($N^2$)
$2^N$    O($2^N$)

## Big O notation

steps        Big O
-----        -----
$2N$         O($N$)
$42N^2+2N+3$ O($N^2$)
$log_2\ N$   O($log\ N$)

## Big O notation

N           2 10        100                  1000
---         - --        ---                  ----
O($1$)      1 1         1                    1
O($log\ N$) 1 3,3       6,6                  10
O($N$)      1 10        100                  1000
O($N^2$)    1 100       10.000               1.000.000
O($2^N$)    2 1024      1,2×10<sup>30</sup>  1,1×10<sup>301</sup>
O($N!$)     1 3.628.800 9,3×10<sup>157</sup> 🤯

## Big O notation

![](../images/bigo0.png){ style="height:500px;" }

## Big O notation

N           name
---         ----
O($1$)      constant
O($log\ N$) logarithmic
O($N$)      linear
O($N^2$)    quadratic
O($2^N$)    exponential
O($N!$)     factorial

## Big O notation

N
---         -            
O($1$)
O($log\ N$)
O($N$)
O($N^2$)    ↑ Polynomial
O($2^N$)    ↓ Slow
O($N!$)

::: notes
polynomial is where the exponent is a number
:::

##

::: big
Why do we care about this?
:::

# Alan Turing { data-state="page-portrait" data-background-image="../images/background.png" }

![](../images/alan-turing.jpg){ .portrait }

1912 - 1954

::: notes
* cracked Enigma code
* convicted for being gay
* committed suicide
* movie
:::

## Alan Turing { data-state="page-portrait" data-background-image="../images/background.png" }

![](../images/alan-turing-movie.jpg){ .portrait }

2014

::: notes
* cracked Enigma code
* convicted for being gay
* committed suicide
* movie
:::

##

::: superbig
Disclaimer
:::

::: notes
I'm oversimplifying things
:::

##

::: big
Cracking codes
:::

worse than polynomial

##

::: big
Verifying codes
:::

polynomial

## NP

* "**nondeterministic**-polynomial"

* finding an answer: slow
* checking an answer: P

::: notes
* Would be polynomial
* If the machine is nondeterministic
:::

## NP

* Rubik's cube
* Sudoku
* Logistics
* Bitcoin

## NP

Obviously, P ≠ NP

. . .

::: superbig
jè.
:::

::: notes
* Probably P≠NP
* We don't know
* Win $1m
:::

## Depending on P≠NP

* banking
* secure messaging
* society as a whole

##

::: superbig
In practice
:::

# Grace Hopper { data-state="page-portrait" data-background-image="../images/background.png" }

![](../images/grace-hopper.jpg){ .portrait }

1906 - 1992

::: notes
* Rear-admiral
* COBOL
* Bug
:::

##

::: big
Know the big O of your algorithms
:::

::: notes
Know if makes sense to optimize
:::

##

::: big
Know your

data structures
:::

## Array

![](../images/array0.jpg){ style="height:500px;" }

## Array

![](../images/array1.jpg){ style="height:500px;" }

## Array

![](../images/array2.jpg){ style="height:500px;" }

## Array

operation big O
--------- -----
access    O($1$)
search    O($N$)
prepend   O($N$)
append    O($1$)

## Linked list

![](../images/linkedlist0.jpg){ style="height:500px;" }

## Linked list

![](../images/linkedlist1.jpg){ style="height:500px;" }

## Linked list

operation big O
--------- -----
access    O($N$)
search    O($N$)
prepend   O($1$)
append    O($N$)

## HashMap

![](../images/hashmap0.jpg){ style="height:500px;" }

## HashMap

![](../images/hashmap1.jpg){ style="height:500px;" }

## HashMap

operation big O
--------- -----
access    n/a
search    O($1$)
iteration O($N$)
insert    O($1$)

## Other data structures

* ArrayList
* LinkedList
* CopyOnWriteArrayList
* Stack
* ~~Vector~~

## Other data structures

* HashSet
* EnumSet
* LinkedHashSet
* SortedSet
* TreeSet

## Other data structures

* HashMap
* EnumMap
* LinkedHashMap
* SortedMap
* TreeMap

## Other data structures

* Queue
* Deque
* ...

##

::: big
Immutable collections
:::

Vavr, Eclipse Collections, Guava

## In Java

No:

```java
ArrayList<String> myList = new ArrayList<>();
```

## In Java

Yes:

```java
     List<String> myList = new ArrayList<>();
```

## In Java

Yes:

```java
     List<String> myList = new LinkedList<>();
```

## In Java

Yes:

```java
     List<String> myList = new CopyOnWriteArrayList<>();
```

# Margaret Hamilton { data-state="page-portrait" data-background-image="../images/background.png" }

![](../images/margaret-hamilton.jpg){ .portrait }

1936 -

::: notes
* Led the team that wrote NASA's Apollo navigation software
* Coined the term "software engineering"
:::

## Margaret Hamilton { data-state="page-portrait" data-background-image="../images/background.png" }

![](../images/margaret-hamilton-lego.jpg){ .portrait }

2017

::: notes
* Led the team that wrote NASA's Apollo navigation software
* Coined the term "software engineering"
:::

## Software engineering

. . .

* Programming

. . .

* Analysis
* Architecture
* UX design
* Testing

. . .

* Computer science

## Software engineering

::: big
If you remember only 3 things
:::

## Software engineering

::: superbig
It depends
:::

## Big O notation

![](../images/bigo0.png){ style="height:500px;" }

## Big O notation

![](../images/bigo1.png){ style="height:500px;" }

::: notes
If complexity < something, it may not matter
:::

## Big O notation

![](../images/bigo2.png){ style="height:500px;" }

::: notes
for small values, things behave differently
:::

## Readability

::: { style="font-size:3em;" }
```java
 🙂 Set<T> set;
```

```java
 🧐 LinkedHashSet<T> set;
```
:::

##

::: superbig
Let's

wrap up
:::

# Tony Hoare { data-state="page-portrait" data-background-image="../images/background.png" }

![](../images/tony-hoare.jpg){ .portrait }

1934 -

::: notes
* Invented null
* "Billion-dollar mistake"
:::

## Tony Hoare { data-state="page-portrait" data-background-image="../images/background.png" }

![](../images/tony-hoare.jpg){ .portrait }

::: small
_"I call it my billion-dollar mistake. It was the invention of the null reference in 1965."_
:::

::: notes
* Invented null
* "Billion-dollar mistake"
:::

## Hoare triple

::: big
```pascal
   {Precondition}
    Statement
   {Postcondition}
```
:::

## Recap

::: big
Thing 1:

De Morgan's Laws
:::

## Recap

::: big
Thing 2:

Truth tables
:::

## Recap

::: big
Complexity

& Big O
:::

Choose wisely

## Recap

::: big
Data structures
:::

Choose wisely

## Recap

::: big
Thing 3:

It depends
:::

##

::: big
Now you know enough CS!
:::

##

::: superbig
What's next?
:::

## What's next?

<br/>

Keep this stuff in the back of your mind

## What's next?

<br/>

Look it up when you need to decide

</br>

::: small
Tip: Google "Big O cheat sheet"
:::

## What's next?

[![](../images/jwdsal2.jpg){ .raw }](https://pragprog.com/titles/jwdsal2)

## What's next?

<br/>

Experiment

## What's next?

<br/>

Experiment

</br>

::: small
Tip:<br/>Implement your own HashMap!
:::

## What's next?

<br/>

Experiment

</br>

::: small
Advanced tip:<br/>Implement your own compression algorithm!
:::

# Questions? { data-state="page-portrait" data-background-image="../images/background.png" }


<br/>

![](../images/qr.png)

[jqno.nl/talks/enoughcs](http://jqno.nl/talks/enoughcs)

::: hashtag
![](../images/twitter.png){ height=30px } #enoughcs

::: supersmall
image credits: see website
:::
:::

###
