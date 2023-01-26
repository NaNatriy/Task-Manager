package taskT;

import eType.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task {
    public WeeklyTask( String title, Type type,  LocalDateTime dateTime, String description) {
        super( title, type, dateTime, description);
    }

    public boolean appearsIn(LocalDate localDate) {
        LocalDate compareDateTask = getDateTime().toLocalDate();
        boolean equalOfDates = compareDateTask.isEqual(localDate);
        return (getDateTime().getDayOfWeek().equals(localDate.getDayOfWeek()))  &&
                (getDateTime().isBefore(localDate.atStartOfDay()) || equalOfDates);
    }
}
