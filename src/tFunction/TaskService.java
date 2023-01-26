package tFunction;

import exception.TaskNotFoundException;
import taskT.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskService {
    private Map<Integer, Task> taskMap = new HashMap<>();
    private Collection<Task> removedTasks = new ArrayList<>();

    public void add(Task task){
            taskMap.put(task.getId(), task);
        }


    public Task remove(int id) throws TaskNotFoundException {
        if (taskMap.containsKey(id)) {
            Task tempTask = taskMap.get(id);
            removedTasks.add(tempTask);
            taskMap.remove(id);
            return tempTask;
        }
        throw new TaskNotFoundException();
    }

    public Collection<Task> getAllByDate(LocalDate localDate){
        return taskMap.values().stream().filter(task -> task.appearsIn(localDate)).collect(Collectors.toList());
    }
}
