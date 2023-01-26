package taskT;

import eType.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task{
    public DailyTask( String title, Type type,  LocalDateTime dateTime, String description) {
        super( title, type,  dateTime, description);
    }


    @Override
    public boolean appearsIn(LocalDate localDate){
        return localDate.isAfter(getDateTime().toLocalDate());


    }
}
