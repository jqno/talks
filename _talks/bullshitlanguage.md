---
title: "Building a Bullshit Language"
tags:
  - annotationscript
  - lisp
  - annotations
  - java
---

How I took Java annotations to their logical extreme by implementing a fully functioning, Turing-complete LISP dialect within them.

## Abstract

I have created AnnotationScript, a programming language whose syntax is expressed entirely in Java annotations. Yes, you read that right: Java annotations.

WTF!?

The pandemic lockdowns of 2020 did strange things to people. Some people started learning the guitar. Others decided to get in shape. But not me. I decided to take Java annotations to their logical extreme.

I think annotations are over-used in the Java ecosystem: you can use them for dependency injection, handling HTTP requests, and interacting with databases. You can even use them to generate code in various ways. But for some reason, nobody has actually used them to implement a full-blown, Turing-complete programming language. Until now.

Do you want to know how easy it is to actually implement LISP? Do you want to know how easy it is to recursively implement LISP in the LISP you just implemented? Do you want to know about the weird restrictions that Java annotations have?

You will be amazed. Weirded-out and amazed.

## What's this AnnotationScript language?

You can find it [on GitHub](https://github.com/jqno/AnnotationScript)!

## Deliveries

- **Brabant JUG**
  <br>
  _6 September 2022_
  <br>
  [[event](https://twitter.com/BrabantJug/status/1556653234726518785)] [[slides](/talks/slides/bullshitlanguage/2022-09-06-brabantjug)]

## Image credits

- [annotationscript](/talks/slides/bullshitlanguage/images/annotationscript.png) - by [moinart on Fiverr](https://www.fiverr.com/moinart)
- [architecture-1](/talks/slides/bullshitlanguage/images/architecture-1.png) - by Jan Ouwens
- [architecture-2](/talks/slides/bullshitlanguage/images/architecture-2.png) - by Jan Ouwens
- [background](/talks/slides/bullshitlanguage/images/background.png) - by Jan Ouwens
- [bored](/talks/slides/bullshitlanguage/images/bored.png) - by DreamStudio (Stable Diffusion) with prompt _"Nerd behind laptop looking bored. Many Salvador Dali melting clocks."_
- [climate-change](/talks/slides/bullshitlanguage/images/climate-change.png) - by DreamStudio (Stable Diffusion) with prompt _"Laptop with image of a coal plant emitting thick black smoke. It's on a table next to a pile of books and a coffee cup. In the background lush springtime forest"_
- [code-generator](/talks/slides/bullshitlanguage/images/code-generator.png) - by DreamStudio (Stable Diffusion) with prompt _"Monkey typing at a computer"_
- [discoverability](/talks/slides/bullshitlanguage/images/discoverability.png) - Screenshot from IntelliJ IDEA, taken by Jan Ouwens
- [duke-says-no](/talks/slides/bullshitlanguage/images/duke-says-no.png) - by Jeff Dinkins for Sun/Oracle - [source](https://wiki.openjdk.org/display/duke/Gallery)
- [duke-says-yes](/talks/slides/bullshitlanguage/images/duke-says-yes.png) & [duke-says-yes-background](/talks/slides/bullshitlanguage/images/duke-says-yes-background.png) - by Jeff Dinkins for Sun/Oracle - [source](https://wiki.openjdk.org/display/duke/Gallery)
- [environment-1](/talks/slides/bullshitlanguage/images/environment-1.png) - by Jan Ouwens
- [environment-2](/talks/slides/bullshitlanguage/images/environment-2.png) - by Jan Ouwens
- [evaluator](/talks/slides/bullshitlanguage/images/evaluator.png) - by Jan Ouwens
- [finisher](/talks/slides/bullshitlanguage/images/finisher.png) - by DreamStudio (Stable Diffusion) with prompt _"Running fat nerd with glasses and unkempt beard crossing the finish line"_
- [fun](/talks/slides/bullshitlanguage/images/fun.png) - by DreamStudio (Stable Diffusion) with prompt _"childrens drawing of stick fligure children playing in a school playground with a swing, a slide and a tree"_
- [hackernews](/talsk/slides/bullshitlanguage/images/hackernews.png) - Screenshot from [Hacker News](https://news.ycombinator.com/), taken by Jan Ouwens on 2023-09-11
- [jan-ouwens](/talks/slides/bullshitlanguage/images/jan-ouwens.jpg) - by Riemke Ouwens
- [lockdown](/talks/slides/bullshitlanguage/images/lockdown.png) - by DreamStudio (Stable Diffusion) with prompt _"fat nerdy person at computer. man cave. messy room with parcels, stacks of books, empty pizza boxes, gadgets"_
- [meta-evaluator](/talks/slides/bullshitlanguage/images/meta-evaluator.png) & [meta-parser](/talks/slides/bullshitlanguage/images/meta-parser.png) & [meta-tokenizer](/talks/slides/bullshitlanguage/images/meta-tokenizer.png) - by Jan Ouwens
- [mind-blown-1](/talks/slides/bullshitlanguage/images/mind-blown-1.png) - by DreamStudio (Stable Diffusion) with prompt _"Person looking at a computer screen, very surprised, wide eyes, open mouth"_
- [mind-blown-2](/talks/slides/bullshitlanguage/images/mind-blown-2.png) - by DreamStudio (Stable Diffusion) with prompt _"Person looking at a computer screen, very surprised, wide eyes, open mouth"_
- [nerd-cred](/talks/slides/bullshitlanguage/images/nerd-cred.png) - by DreamStudio (Stable Diffusion) with prompt _"Rap music album cover in the style of Eminem, 50ct and notorious BIG. Photograph one face of fat, white, nerdy guy with large beard, messy hair, jewelry and colored glasses. Fish eye lens. Album title "nerd cred" appears next to face"_
- [paralleljava](/talks/slides/bullshitlanguage/images/paralleljava.png) - by J-Fall - [source](https://www.youtube.com/watch?v=R0WnUd01f14)
- [parser](/talks/slides/bullshitlanguage/images/parser.png) - by Jan Ouwens
- [rite-of-passage](/talks/slides/bullshitlanguage/images/rite-of-passage.png) - by DreamStudio (Stable Diffusion) with prompt _"Graduation ceremony. Fat nerdy man with glasses and unkempt beard on stage."_
- [stackoverflow](/talsk/slides/bullshitlanguage/images/stackoverflow.png) - Screenshot from [StackOverflow](https://stackoverflow.com/), taken by Jan Ouwens on 2023-09-11
- [the-little-schemer](/talks/slides/bullshitlanguage/images/the-little-schemer.jpg) - by MIT Press - [source](https://mitpress.mit.edu/9780262560993/the-little-schemer/)
- [tokenizer](/talks/slides/bullshitlanguage/images/tokenizer.png) - by Jan Ouwens
- [turing-machine](/talks/slides/bullshitlanguage/images/turing-machine.png) - by DreamStudio (Stable Diffusion) with prompt _"A sewing machine sewing a long, straight, white ribbon that must not be bundled up"_
- [vim](/talks/slides/bullshitlanguage/images/vim.png) - by Jan Ouwens

### Images used in previous iterations

- [bored-old](/talks/slides/bullshitlanguage/images/bored-old.png) - by DALL·E with prompt _"photo of a bored white nerd with a neckbeard, sitting at a desk with a computer displaying java code, glancing at an alarm clock while surrounded by melting clocks"_ <small>(not sure where the neckbeard went 😉)</small>
- [code-generator-old](/talks/slides/bullshitlanguage/images/code-generator-old.png) - by DALL·E with prompt _"pixel art of a monkey typing at a computer"_
- [fun-old](/talks/slides/bullshitlanguage/images/fun-old.png) - by DALL·E with prompt _"childrens drawing of stick fligure children playing in a school playground with a swing, a slide and a tree"_
- [lockdown-old](/talks/slides/bullshitlanguage/images/lockdown-old.png) - by DALL·E with prompt _"photo of a programmer wearing only short pants and no shirt sitting behind a computer in his man cave showing code on the screen, surrounded by amazon packages, books, game controllers and a guitar"_
- [mind-blown-1-old](/talks/slides/bullshitlanguage/images/mind-blown-1-old.png) - by DALL·E with prompt _"meme of a person looking very surprised whose head explodes"_
- [mind-blown-2-old](/talks/slides/bullshitlanguage/images/mind-blown-2-old.png) - by DALL·E with prompt _"meme of a person looking very surprised"_
- [nerd-cred-old](/talks/slides/bullshitlanguage/images/nerd-cred-old.png) - by DALL·E with prompt _"hip hop album cover with nerds"_
- [rite-of-passage-old](/talks/slides/bullshitlanguage/images/rite-of-passage-old.png) - by DALL·E with prompt _"photo of a fat nerd with a spear in attack pose facing an angry male lion on the african savannah"_
