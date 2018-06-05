package dbus;

import java.util.Date;
import java.util.List;

public class PangolinTimelineTest extends DateTimelineTest<PangolinTimeline> {
    @Override
    PangolinTimeline construct(List<Date> input) {
        return new PangolinTimeline(input);
    }
}
