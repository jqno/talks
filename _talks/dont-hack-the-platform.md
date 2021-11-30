---
title: "Don't hack the platform? ☠️💣💥"
tags:
- hack
- jvm
- java
- scala
- kotlin
- unicode
- reflection
- objenesis
- bytebuddy
- agents
---
A funny anthology of tricks and hacks for the JVM. Voted 2018’s ["best non-Venkat talk"](https://nljug.org/nieuws/j-fall-2018-the-top-10-sessions/) by the J-Fall audience!

## Abstract

Don’t go to this talk! Your coworkers will not be happy when you come back to work tomorrow and start applying the things you’ll learn here. You’ll do a lot of damage.

Mutating immutable objects is never a good idea. You shouldn’t be bypassing the constructor when you instantiate an object. You certainly don’t need to add constants to your enums at runtime. And don’t even think about including Java 8 code in your Java 7 codebase. Truly, nothing good will come from attending this talk.

In all seriousness, this talk will provide awareness about some of the lesser-known vulnerabilities of Java and the JVM. Maybe I’ll even tell you how to guard against them.

## Deliveries

* **JAX London**
  <br>
  _5 October 2021_
  <br>
  [[event](https://jaxlondon.com/program/)] [[slides](../slides/donthack/2021-10-05-jax-london)] [[code](https://github.com/jqno/talks/tree/main/_slides/donthack/2021-10-05-jax-london)]
* **Mendix Runtime Guild**
  <br>
  _2 July 2021_
  <br>
  [[slides](../slides/donthack/2021-07-02-mendix)] [[code](https://github.com/jqno/talks/tree/main/_slides/donthack/2021-07-02-mendix)]
* **GOTO Nights**
  <br>
  _14 September 2020_
  <br>
  [[event](https://www.meetup.com/GOTO-Nights-Amsterdam/events/273095070/)] [[slides](../slides/donthack/2020-09-14-goto-nights)] [[code](https://github.com/jqno/talks/tree/main/_slides/donthack/2020-09-14-goto-nights)]
* **Clean Architecture with Uncle Bob**
  <br>
  _8 February 2019_
  <br>
  [[event](https://www.meetup.com/Utrecht-Java-User-Group/events/257794904/)] [[slides](../slides/donthack/2019-02-08-uncle-bob-utrecht)] [[code](https://github.com/jqno/talks/tree/main/_slides/donthack/2019-02-08-uncle-bob-utrecht)] [[sketchnotes by Silke Henderickx](https://www.silkehenderickx.be/unclebobutrechtcleanarchitecture/)]
* **J-Fall Netherlands**
  <br>
  _8 November 2018_
  <br>
  [[event](https://2018.jfall.nl/sessions/dont-hack-the-jvm/)] [[slides](http://jqno.nl/dont-hack-the-platform-talk/2018-11-08-jfall/)] [[code](https://github.com/jqno/talks/tree/main/_slides/donthack/2018-11-08-jfall)] [[video](https://www.youtube.com/watch?v=3750lsxn8m8)]
* **JavaZone Oslo**
  <br>
  _12 September 2018_
  <br>
  [[event](https://2018.javazone.no/)] [[slides](http://jqno.nl/dont-hack-the-platform-talk/2018-09-12-javazone/)] [[code](https://github.com/jqno/talks/tree/main/_slides/donthack/2018-09-12-javazone)] [[video](https://vimeo.com/289655964)]
* **JBCNConf Barcelona**
  <br>
  _12 June 2018_
  <br>
  [[event](http://www.jbcnconf.com/2018/infoSpeaker.html?ref=SmFuT3V3ZW5zamFuLm91d2Vuc0BnbWFpbC5jb20=)] [[slides](http://jqno.nl/dont-hack-the-platform-talk/2018-06-12-jbcnconf/)] [[code](https://github.com/jqno/talks/tree/main/_slides/donthack/2018-06-12-jbcnconf)]
* **Philips DigiLabs Meetup**
  <br>
  _29 May 2018_
  <br>
  [[slides](../slides/donthack/2018-05-29-philips/)] [[code](http://github.com/jqno/talks/tree/main/_slides/donthack/2018-05-29-philips)]
* **ING Backend Guild**
  <br>
  _17 May 2018_
  <br>
  [[slides](../slides/donthack-2018-05-17-ing/)] [[code](https://github.com/jqno/talks/tree/main/_slides/donthack/2018-05-17-ing)]
* **Utrecht JUG**
  <br>
  _17 April 2018_
  <br>
  [[event](https://www.meetup.com/Utrecht-Java-User-Group/events/247737886/)] [[slides](http://jqno.nl/dont-hack-the-platform-talk/2018-04-17-utrecht-jug/)] [[code](https://github.com/jqno/talks/tree/main/_slides/donthack/2018-04-17-utrecht-jug)]
* **Ordina Code & Comedy**
  <br>
  _4 April 2018_
  <br>
  [[event](https://codeandcomedy.nl/)] [[slides](../slides/donthack/2018-04-04-ordina-code-&-comedy/)] [[code](https://github.com/jqno/talks/tree/main/_slides/donthack/2018-04-04-ordina-code-&-comedy)] [[aftermovie](https://www.youtube.com/watch?v=fmaOWGnHJuM)]
* **Portbase Rotterdam**
  <br>
  _23 February 2018_
  <br>
  [[slides](../slides/donthack/2018-02-23-portbase/)] [[code](https://github.com/jqno/talks/tree/main/_slides/donthack/2018-02-23-portbase)]
* **JVMCON Netherlands**
  <br>
  _20 January 2018_
  <br>
  [[event](https://jvmcon.com/)] [[slides](http://jqno.nl/dont-hack-the-platform-talk/2018-01-30-jvmcon/)] [[code](https://github.com/jqno/talks/tree/main/_slides/donthack/2018-01-30-jvmcon)] [🇳🇱 [blog](https://blogs.infosupport.com/kom-naar-sessie/)] [🇳🇱 [blog](https://blogs.infosupport.com/terugblik-op-allereerste-jvmcon/)]

## Image credits

* [Bob_at_Easel](/talks/slides/donthack/images/Bob_at_Easel.jpg) - by Bob Ross Incoroprated - [source](https://en.wikipedia.org/wiki/File:Bob_at_Easel.jpg)
* [accident](/talks/slides/donthack/images/accident.jpg) - by stevepb - [source](https://pixabay.com/photos/slip-up-danger-careless-slippery-709045/)
* [anna](/talks/slides/donthack/images/anna.jpg) - by Riemke Ouwens
* [background](/talks/slides/donthack/images/background.jpg) - by Jan Ouwens
* [boring](/talks/slides/donthack/images/boring.jpg) - by PublicDomainPictures - [source](https://pixabay.com/photos/book-bored-college-education-15584/)
* [boring1](/talks/slides/donthack/images/boring1.jpg) - unable to find source
* [dr-evil](/talks/slides/donthack/images/dr-evil.jpg) - by New Line Cinema
* [evil](/talks/slides/donthack/images/evil.jpg) - by RyanMcGuire - [source](https://pixabay.com/photos/suit-business-man-business-man-673697/)
* [flowchart-blurred](/talks/slides/donthack/images/flowchart-blurred.jpg) - by Christina Morillo - [source](https://www.pexels.com/photo/white-dry-erase-board-with-red-diagram-1181311/)
* [flowchart](/talks/slides/donthack/images/flowchart.jpg) - by Christina Morillo - [source](https://www.pexels.com/photo/white-dry-erase-board-with-red-diagram-1181311/)
* [jfall-program](/talks/slides/donthack/images/jfall-program.jpg) - by Jan Ouwens
* [no-spring](/talks/slides/donthack/images/no-spring.png) - by Jan Ouwens, based on Spring Framework logo - [source](https://spring.io)
* [ribbon.jpg](/talks/slides/donthack/images/ribbon.jpg) - by Miguel Á. Padriñán - [source](https://www.pexels.com/photo/breast-cancer-awareness-on-teal-wooden-surface-579474/)
* [ribbon.png](/talks/slides/donthack/images/ribbon.png) - by MesserWoland - [source](https://commons.wikimedia.org/wiki/File:Purple_ribbon.svg)
* [rtlnieuws](/talks/slides/donthack/images/rtlnieuws.png) - screenshot taken by Jan Ouwens - [source](https://www.rtlnieuws.nl/nieuws/nederland/artikel/223651/zo-werkt-het-softwaresysteem-dat-onze-stemmen-telt)
* [scala](/talks/slides/donthack/images/scala.png) - official Scala logo - [source](https://scala-lang.org/)
* [schedule](/talks/slides/donthack/images/schedule.png) - by Jan Ouwens
* [sombrero](/talks/slides/donthack/images/sombrero.jpg) - by one of Jan Ouwens's relatives
* [tarot](/talks/slides/donthack/images/tarot.jpg) - by Jan Ouwens
* [thats-all-folks](/talks/slides/donthack/images/thats-all-folks.png) - by Warner Bros. Television
* [trump.jpg](/talks/slides/donthack/images/trump.jpg) - unable to find source
* [trump.png](/talks/slides/donthack/images/trump.png) - by OpenClipart Vectors - [source](https://pixabay.com/vectors/cartoon-celebrity-comic-2026571/)
* [zalgo](/talks/slides/donthack/images/zalgo.png) - by Jan Ouwens

**NOTE**: I've compiled this list long after I built the presentation, and I was unable to find the sources for some of them. Please let me know if you know the source of one of the missing ones.
