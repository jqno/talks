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

::: subtitle
and what to learn from them
:::

# Why?

* Language of the Year
* Change your thinking

# Ruby

![](../images/ruby.svg.png){ .bigimg }

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
```

## Ruby - what does it look like?

```ruby
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

Beautifully extensible OO model

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
[GitHub hack](https://gist.github.com/peternixey/1978249)
:::

###
