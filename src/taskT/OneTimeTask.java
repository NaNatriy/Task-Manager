package taskT;

import eType.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task {
    public OneTimeTask(int idGenerator, String title, Type type, int id, LocalDateTime dateTime, String description) {
        super( title, type,  dateTime, description);
    }

    public boolean appearsIn(LocalDate localDate) {
        LocalDate compareDateTask = getDateTime().toLocalDate();
        return localDate.isEqual(compareDateTask);
    }
}
