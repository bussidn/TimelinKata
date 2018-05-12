package dbus;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public abstract class TimelineTest<E extends Date, T extends Timeline<E>> {

    abstract T construct(List<E> input);
    abstract E date(int time);

    private final T timeline = construct(dates(0, 1, 2));

    private List<E> dates(int... times) {
        return Arrays.stream(times)
                .mapToObj(this::date)
                .collect(Collectors.toList());
    }

    @Test(expected = NullPointerException.class)
    public void constructor_should_throw_NullPointerException_when_given_date_list_is_null() {
        // given
        // when
        construct(null);
        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_should_throw_IllegalArgumentException_when_given_date_list_is_not_ordered() {
        // given
        // when
        construct(dates(1, 2, 0));
        // then
    }

}