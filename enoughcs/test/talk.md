---
pagetitle: Just enough computer science for the busy developer
theme: white
backgroundTransition: none
transition: none
progress: "false"
controls: "false"
center: "false"
---

# Just enough computer science for the busy developer

I studied computer science so you don't have to

::: hashtag
![](../images/twitter.png){ height=30px } #enoughcs
:::

###

# Just enough computer science for the busy developer

I studied computer science so you don't have to

::: hashtag
![](../images/twitter.png){ height=30px } #enoughcs
:::

::: doesitwork
.
:::

###

# Jan Ouwens { data-state="page-portrait" data-background-image="../images/wood.jpg" }

![](../images/jan-ouwens.jpg){ .portrait style="height:200px;" }

![](../images/codestar-by-ordina.png){ style="height:40px;margin-top:15px;" } │ [EqualsVerifier](https://jqno.nl/equalsverifier) │ [jqno.nl](https://jqno.nl) │ ![](../images/twitter.png){ style="height:30px;" } [jqno](https://twitter.com/jqno)

::: hashtag
![](../images/twitter.png){ style="height:30px;" } #enoughcs
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

#

::: big
Lots of interesting people
:::

# Edsger Dijkstra { data-state="page-portrait" data-background-image="../images/wood.jpg" }

![](../images/edsger-dijkstra.jpg){ .portrait }

::: notes
* Dutch
* pronounciation
* TU/e
* Quotes:
  * Testing shows the presence, not the absence of bugs 
  * The question of whether Machines Can Think... is about as relevant as the question of whether Submarines Can Swim. 
  * Simplicity is a great virtue but it requires hard work to achieve it and education to appreciate it. And to make matters worse: complexity sells better. 
:::

# Katherine Johnson { data-state="page-portrait" data-background-image="../images/wood.jpg" }

![](../images/katherine-johnson.jpg){ .portrait }

::: notes
* Manual calculations for NASA Apollo
* Movie
* Astronauts didn't trust automation
:::

# Katherine Johnson { data-state="page-portrait" data-background-image="../images/wood.jpg" }

![](../images/katherine-johnson-movie.jpg){ .portrait }

::: notes
* Manual calculations for NASA Apollo
* Movie
* Astronauts didn't trust automation
:::

# محمد خوارزمی { data-state="page-portrait" data-background-image="../images/wood.jpg" }

![](../images/muhammad-al-khwarizmi.png){ .portrait }

# Muhammad al-Khwarizmi { data-state="page-portrait" data-background-image="../images/wood.jpg" }

![](../images/muhammad-al-khwarizmi.png){ .portrait }

::: notes
* Islamic world middle ages
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

# Tony Hoare { data-state="page-portrait" data-background-image="../images/wood.jpg" }

![](../images/tony-hoare.jpg){ .portrait }

::: notes
* Invented famous algorithm: quicksort
* Invented 'null' - billion dollar mistake
:::

## Hoare triple

```pascal
{P}
 S
{Q}
```

## Hoare triple

```pascal
{x = 3}
x += 1;
{x = 4}
```

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
  { i = 0 ⋀ ⟨∃x : 0 ≤ x < N : b[x] = n⟩ }
; do b[i] ≠ n →
    { 0 ≤ i < N ⋀ ⟨∀x : 0 ≤ x ≤ i : b[x] ≠ n⟩ ⋀ ⟨∃x : i < x < N : b[x] = n⟩ }
    i := i + 1
    { 0 < i < N ⋀ ⟨∀x : 0 ≤ x < i : b[x] ≠ n⟩ ⋀ ⟨∃x : i ≤ x < N : b[x] = n⟩ }
  od
  { 0 ≤ i < N ⋀ b[i] = n ⋀ ⟨∀x : 0 ≤ x < i : b[x] ≠ n⟩ }
```

. . .

Q.E.D.

## What it looked like for me { data-state="page-portrait" }

![](../images/homework1.jpg){ .raw }\ \ \ \ \ \ ![](../images/homework2.jpg){ .raw }

::: notes
* plaatje van mijn huiswerk
:::

# Donald Knuth { data-state="page-portrait" data-background-image="../images/wood.jpg" }

![](../images/donald-knuth.jpg){ .portrait }

::: notes
Beware of bugs in the above code; I have only proved it correct, not tried it.
:::

##

::: big
We live in an

age of libraries
:::

Choose the best one

::: notes
how?
:::

## 

::: superbig
Complexity
:::

How many steps?

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

## Complexity

```java
public int get(int[] ints, int index) {
  return ints[index];
}
```

## Big O notation

if N is input size,

* O(N): linear search
* O(1): get

## Big O notation

O(log N)

* Binary search
* Git bisect

::: notes
Java's implementation had a bug in it for 9 years
:::

## Big O notation

O(N²)

```java
public boolean hasDuplicates(int[] ints) {
  for (int i : ints) {
    for (int j : b) {
      if (i != j && ints[i] == ints[j]) {
        return true;
      }
    }
  }
  return false;
}
```

## Big O notation

O(2<sup>N</sup>)

```java
public int fibonacci(int i) {
  if (i <= i) {
    return i;
  }
  return fibonacci(i - 2) + fibonacci(i - 1);
}
```

## Big O notation

O(N!)

Brute-forcing travelling salesman

## Big O notation

N                 name
---               ----
O(1)              constant
O(log N)          logarithmic
O(N)              linear
O(N²)             quadratic
O(2<sup>N</sup>)  exponential
O(N!)             factorial

## Big O notation

N                 2 10        100                  1000
---               - --        ---                  ----
O(1)              1 1         1                    1
O(log N)          1 1         2                    3
O(N)              1 10        100                  1000
O(N²)             1 100       10.000               1.000.000
O(2<sup>N</sup>)  2 1024      1,2×10<sup>30</sup>  1,1×10<sup>301</sup>
O(N!)             1 3.628.800 9,3×10<sup>157</sup> 🤯

## Big O notation

N
---              -            
O(1)
O(log N)
O(N)
O(N²)            Polynomial ↑ 
O(2<sup>N</sup>) Slow ↓
O(N!)

# Alan Turing { data-state="page-portrait" data-background-image="../images/wood.jpg" }

![](../images/alan-turing.jpg){ .portrait }

::: notes
* cracked Enigma code
* convicted for being gay
* committed suicide
* movie
:::

# Alan Turing { data-state="page-portrait" data-background-image="../images/wood.jpg" }

![](../images/alan-turing-movie.jpg){ .portrait }

::: notes
* cracked Enigma code
* convicted for being gay
* committed suicide
* movie
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

* "nondeterministic-polynomial"

* finding an answer: slow
* checking an answer: P

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

# Grace Hopper { data-state="page-portrait" data-background-image="../images/wood.jpg" }

![](../images/grace-hopper.jpg){ .portrait }

::: notes
* Rear-admiral
* COBOL
* Bug
:::

##

::: superbig
In practice
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

operation big O
--------- -----
access    O(1)
search    O(N)
insert    O(N)
append    O(1)

## Linked list

operation big O
--------- -----
access    O(N)
search    O(N)
insert    O(1)
append    O(N)

## HashMap

operation big O
--------- -----
access    n/a
search    O(1)
iteration O(N)
insert    O(1)

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

# Margaret Hamilton { data-state="page-portrait" data-background-image="../images/wood.jpg" }

![](../images/margaret-hamilton.jpg){ .portrait }

::: notes
* Led the team that wrote NASA's Apollo navigation software
* Coined the term "software engineering"
:::

# Margaret Hamilton { data-state="page-portrait" data-background-image="../images/wood.jpg" }

![](../images/margaret-hamilton-lego.jpg){ .portrait }

::: notes
* Led the team that wrote NASA's Apollo navigation software
* Coined the term "software engineering"
:::

## Software engineering

* Programming

. . .

* Analysis
* Architecture
* UX design
* Testing

. . .

* Computer science

##

::: big
Wrapping up
:::

## Wrapping up

::: big
Many algorithms solve similar problems
:::

## Wrapping up

::: big
Many data structures solve similar problems
:::

## Wrapping up

::: big
Each performs differently
:::

## Wrapping up

::: big
Think about which is best for your situation
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

Keep this stuff in the back of your mind

## What's next?

Look it up when you need to choose

Tip: Google "Big O cheat sheet"

## What's next?

Read more about this

Tip:

[![](../images/book.jpg){ height=400px }](https://pragprog.com/titles/jwdsal2)

## What's next?

Experiment

* Tip:<br/>Implement your own HashMap!

* Advanced tip:<br/>Implement your own compression algorithm!

# Questions?

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