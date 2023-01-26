import eType.Type;
import exception.IncorrectArgumentException;
import exception.TaskNotFoundException;
import tFunction.TaskService;
import taskT.DailyTask;
import taskT.Task;
import taskT.YearlyTask;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args){
        TaskService taskService = new TaskService();

        DailyTask dailyTask2 = null;
        try {
            dailyTask2 = new DailyTask( "sag", Type.WORK, LocalDateTime.now(), "fghfhdgg");
        } catch (IncorrectArgumentException e) {
            System.out.println(e.getMessage());
        }
        DailyTask dailyTask = new DailyTask( "gif", Type.PERSONAL,  LocalDateTime.now(), "dfdfdf");

        taskService.add(dailyTask2);
        taskService.add(dailyTask);

        System.out.println(taskService.getAllByDate(LocalDate.now()));

        try {
            taskService.remove(2);
        } catch (TaskNotFoundException e) {
            System.out.println("Такой задачи нет!");
        }
        System.out.println(taskService.getAllByDate(LocalDate.now()));
    }
}