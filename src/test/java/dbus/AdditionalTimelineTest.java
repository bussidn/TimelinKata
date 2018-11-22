package dbus;

import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public abstract class AdditionalTimelineTest<E extends Date, T extends Timeline<E>> extends TimelineTest<E, T> {

    @Test(expected = IllegalArgumentException.class)
    public void constructor_should_throw_IllegalArgumentException_when_provided_list_has_not_at_least_two_elements() {
        // given
        List<E> dates = dates(0);
        // when
        construct(dates);
        // then
    }

    @Test
    public void remove_should_not_mix_indexes() {
        // given
        timeline.add(date(4));
        // when
        timeline.remove(between(3).and(6));
        // then
    }

    private And<Integer, Predicate<E>> between(int lowerBound) {
        final E date2 = date(lowerBound);
        return higherBound -> date -> date.compareTo(date2) > 0 && date.compareTo(date(higherBound)) < 0;
    }

    @FunctionalInterface
    private interface And<T, R> extends Function<T, R> {
        R and(T t);

        @Override
        default R apply(T t) {
            return and(t);
        }
    }
}
