package taskT;

import eType.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task {
    public YearlyTask( String title, Type type, LocalDateTime dateTime, String description) {
        super( title, type,  dateTime, description);
    }

    public boolean appearsIn(LocalDate localDate) {
        return (getDateTime().getDayOfMonth() == (localDate.getDayOfMonth())) &&
                (getDateTime().getDayOfYear() == localDate.getDayOfYear());
    }
}
