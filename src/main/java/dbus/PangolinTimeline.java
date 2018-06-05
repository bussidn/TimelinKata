package dbus;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

public class PangolinTimeline implements DateTimeline {
    public PangolinTimeline(List<Date> input) {

    }

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
