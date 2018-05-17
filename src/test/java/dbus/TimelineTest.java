package dbus;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public abstract class TimelineTest<E extends Date, T extends Timeline<E>> {

    abstract T construct(List<E> input);
    abstract E date(int time);

    private final E zero = date(0);
    private final List<E> dates = new ArrayList<>(asList(zero, date(5), date(9)));
    private final T timeline = construct(dates);

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

    @Test(expected = NullPointerException.class)
    public void add_should_throw_NullPointerException_when_given_date_is_null() {
        // given
        // when
        timeline.add(null);
        // then
    }

    @Test
    public void add_should_modify_the_timeline_when_given_date_is_not_already_in() {
        // given
        E date = date(4);
        // when
        timeline.add(date);
        // then
        assertThat(timeline.getDates()).isEqualTo(dates(0, 4, 5, 9));
    }

    @Test
    public void add_should_not_modify_the_timeline_when_given_date_is_already_in() {
        // given
        E date = date(5);
        // when
        timeline.add(date);
        // then
        assertThat(timeline.getDates()).isEqualTo(dates(0, 5, 9));
    }

    @Test(expected = NullPointerException.class)
    public void remove_should_throw_NullPointerException_when_provided_predicate_is_null() {
        // given
        // when
        timeline.remove(null);
        // then
    }

    @Test
    public void remove_should_remove_one_element_when_only_one_element_satisfy_the_predicate() {
        // given
        // when
        timeline.remove(d -> d.equals(new Date(5)));
        // then
        assertThat(timeline.getDates()).isEqualTo(dates(0, 9));
    }

    @Test
    public void remove_should_keep_at_least_two_elements() {
        // given
        // when
        timeline.remove(d -> true);
        // then
        assertThat(timeline.getDates().size()).isEqualTo(2);
    }

    @Test
    public void adding_a_date_in_the_input_list_should_not_change_encapsulated_list() {
        // given
        // when
        dates.add(date(1));
        // then
        assertThat(timeline.isSorted()).isTrue();
    }

    @Test
    public void changes_on_the_input_reference_list_should_not_impact_encapsulated_list() {
        // given
        // when
        dates.clear();
        // then
        assertThat(timeline.getDates().size()).isGreaterThan(2);
    }

    @Test
    public void adding_a_date_in_the_output_list_should_not_change_encapsulated_list() {
        // given
        // when
        timeline.getDates().add(date(4));
        // then
        assertThat(timeline.isSorted()).isTrue();
    }

    @Test
    public void changes_on_the_output_reference_list_should_not_impact_encapsulated_list() {
        // given
        // when
        timeline.getDates().clear();
        // then
        assertThat(timeline.getDates().size()).isGreaterThan(2);
    }

    @Test
    public void changes_on_the_input_zero_date_should_not_impact_encapsulated_date() {
        // given
        // when
        zero.setTime(10);
        // then
        assertThat(timeline.isSorted()).isTrue();
    }

    @Test
    public void changes_on_an_output_date_should_not_impact_encapsulated_date() {
        // given
        // when
        timeline.getDates().iterator().next().setTime(10);
        // then
        assertThat(timeline.isSorted()).isTrue();
    }

}