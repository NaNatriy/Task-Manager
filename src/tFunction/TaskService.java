package tFunction;

import exception.TaskNotFoundException;
import taskT.Task;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TaskService {
    private final Map<Integer, Task> taskMap = new HashMap<>();
    private final Collection<Task> removedTasks = new ArrayList<>();



    public void add(Task task){
            taskMap.put(task.getId(), task);
        }

    public void updateDescription(int id, String description) throws TaskNotFoundException {
        if (taskMap.containsKey(id)) {
        taskMap.get(id).setDescription(description);
        } else {
            throw new TaskNotFoundException();
        }
    }

    public void updateTitle(int id, String title) throws TaskNotFoundException {
        if (taskMap.containsKey(id)) {
            taskMap.get(id).setTitle(title);
        } else {
            throw new TaskNotFoundException();
        }
    }


    public Task remove(int id) throws TaskNotFoundException {
        if (taskMap.containsKey(id)) {
            Collections.addAll(removedTasks, taskMap.get(id));
            Task temp = taskMap.get(id);
            taskMap.remove(id);
            return temp;
        }
        throw new TaskNotFoundException();
    }

    public Collection<Task> getRemovedTasks(int id) throws TaskNotFoundException {
        Collections.addAll(removedTasks, taskMap.get(id));
        removedTasks.add(taskMap.remove(id));
        return removedTasks;
    }


    public Collection<Task> getAllByDate(LocalDate localDate){
        return taskMap.values().stream().filter(task -> task.appearsIn(localDate)).collect(Collectors.toList());
    }

    public Map<LocalDate, Collection<Task>> gelAllByGroupByDate(){
        return taskMap.values().stream()
                .collect(Collectors.toMap(task -> task.getDateTime().toLocalDate(),
                task -> {
                    Collection<Task> tasks = new ArrayList<>();
                    tasks.add(task);
                    return tasks;
                },(o, o2) -> {o.addAll(o2);
                    return o;

        }));
    }

}
