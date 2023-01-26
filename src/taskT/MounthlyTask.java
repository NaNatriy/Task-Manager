package taskT;

import eType.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MounthlyTask extends Task {
    public MounthlyTask( String title, Type type,  LocalDateTime dateTime, String description) {
        super( title, type, dateTime, description);
    }

    public boolean appearsIn(LocalDate localDate) {
        boolean getOnCurrenDate;
        LocalDate compareDateTask = getDateTime().toLocalDate();
        boolean equalOfDates = compareDateTask.isEqual(localDate);
        getOnCurrenDate = (getDateTime().getDayOfMonth() == localDate.getDayOfMonth()) &&
                (getDateTime().isBefore(localDate.atStartOfDay()) || equalOfDates);
        return getOnCurrenDate;
    }
}
