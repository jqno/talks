---
title: "Not all equals methods are created equal"
tags:
- java
- equalsverifier
- equals
- hashcode
- reflexivity
- symmetry
- transitivity
---
How to write a good `equals` method, and to test it with [EqualsVerifier](http://jqno.nl/equalsverifier).

## Abstract

Did you know your equals method can contain bugs, even if you have it generated by your IDE?

As the creator of EqualsVerifier, I have seen the good, the bad and the ugly. I will show you how to recognise potential bugs in equals(), and why you should care about them. You will see how to craft an ironclad equals method. Also, you will see how to test your equals method and gain 100% coverage with a single line of test code, using EqualsVerifier. Because testing equals shouldn’t have to take pages of code.

## Deliveries

* **JAX London**
  <br>
  _5 October 2021_
  <br>
  [[event](https://jaxlondon.com/program/)] [[slides](https://github.com/jqno/talks/tree/main/_slides/equalsverifier/2021-10-05-jaxlondon) | [code](https://github.com/jqno/talks/tree/main/_slides/equalsverifier/2021-10-05-jaxlondon)]
* **Devoxx Belgium**
  <br>
  _6 November 2017_
  <br>
  [[event](https://devoxx.be/2017/)] [[slides](https://github.com/jqno/talks/tree/main/_slides/equalsverifier/2017-11-06-devoxx) | [code](https://github.com/jqno/talks/tree/main/_slides/equalsverifier/2017-11-06-devoxx)] [[video](https://www.youtube.com/watch?v=pNJ_O10XaoM)]
* **Sogeti**
  <br>
  _19 March 2015_
  <br>
  [[slides](https://github.com/jqno/talks/tree/main/_slides/equalsverifier/2015-03-19-sogeti) | [code](https://github.com/jqno/talks/tree/main/_slides/equalsverifier/2015-03-19-sogeti)]
* **Sogeti**
  <br>
  _25 November 2014_
  <br>
  [[slides](https://github.com/jqno/talks/tree/main/_slides/equalsverifier/2014-11-25-sogeti) | [code](https://github.com/jqno/talks/tree/main/_slides/equalsverifier/2014-11-25-sogeti)]
* **Sioux Weekend of Code**
  <br>
  _24 August 2013_
  <br>
  [[slides](https://github.com/jqno/talks/tree/main/_slides/equalsverifier/2013-08-24-sioux) | [code](https://github.com/jqno/talks/tree/main/_slides/equalsverifier/2013-08-24-sioux)]
