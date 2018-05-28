# Timeline Kata

## Goal

The goal of this kata is to work on class invariant.
The 90's OOP promess was to let developper design real world objects and was all about class responsabilities.

While we know the limits of designing the world in a program, class responsability is still something that is to be desired.
The responsability is here declined in class invariants that the developper is asked to maintain carefully.

So, this kata will ask you to design a simple concept and make it more and more harder to do so.

## Timeline

A timeline is simple a bunch of ordered dates with a beginning date and an end date
So here are the invariants to be aware of :
- the timeline has always at least 2 dates.
- the dates are provided in a sorted way.

### How to begin the kata

To start the kata, simply clone the dedicated branch (normally associated with the session)

Your job is to implements the Timeline class, so choose a unique name for your timeline implementation.
ex : MyTimeline.java

Implement the test class by inheriting the TimelineTest class and provide a constructor for your class and your Date implementation.

```java
public class MyTimelineTest implements TimelineTest<Date, MyTimeline<Date>> {

  public MyTimeline create(List<Date> dates) {
    return new MyTimeline(dates);
  }

}
```


