---
title: "Growing a DSL for financial calculations"
tags:
- scala
- dsl
- rabobank
- finance
---
The story of how my colleague and I 'discovered' a Scala DSL for writing complex mortgage calculations. 

## Abstract
Rabobank is a Dutch multinational banking and financial services company headquartered in Utrecht, the Netherlands. One of their services is providing mortgage loans. Determining the height of the loans involves some rather complex calculations. They were struggling to represent these calculations in an understandable and reliably testable way for both domain experts and developers. We helped them develop an internal DSL in Scala that allows them to express these complex calculations in an idiomatic way that is not just easy to read for both developers and business analysts, but more testable as well. Harnessing functional programming principles and the strong Scala compiler, it also provides full typesafety with a syntax that lies very close to human language, allowing fully typesafe constructs such as 'amount per month' and 'amount per year'. In this talk, I will explain the concepts behind the DSL, how we implemented them without adding any dependencies to the project (except ScalaTest, of course), and the design decisions we had to make along the way.

## Deliveries
* _7 October 2016_, HBO-ICT Job & Student event Rotterdam: [[event](http://www.hboictjobevent.nl/)]
* _4 May 2016_, Typelevel Summit Oslo: [[event](https://typelevel.org/event/2016-05-summit-oslo/)] [[video](https://www.youtube.com/watch?v=W37Mp3mBYLw)]
* _13 April 2016_, Appril Festival: [[event](http://appril.nl/)]
* _31 March 2016_, Brabant Scala Meetup: [[event](https://www.meetup.com/brabant-scala/events/228851052/?eventId=228851052)]
* _24 March 2016_, Codestar Launch Event: [[event](https://www.codestar.nl/#team/launchevent)] [[partial video](https://www.youtube.com/watch?v=gmCQS72yFTg)]
* _23 November 2015_, Scala Utrecht Meetup

