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

Your job is to implements the DateTimeline class, which is an interface extending Timaline for the java.util.Date class, so choose a unique name for your timeline implementation.
ex : MyTimeline.java

```java
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

public class MyTimeline implements DateTimeline {
    @Override
    public List<Date> getDates() {
        return null;
    }

    @Override
    public void add(Date date) {

    }

    @Override
    public void remove(Predicate<Date> predicate) {

    }
}
```

Implement the test class by inheriting the TimelineTest class and provide a constructor for your class and your Date implementation.

```java
import java.util.Date;
import java.util.List;

public class MyTimelineTest extends DateTimelineTest<MyTimeline> {
    @Override
    MyTimeline construct(List<Date> input) {
        return new MyTimeline(input);
    }
}
```


