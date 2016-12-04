package taskjournal;

import taskjournal.task.Task;

import java.util.List;

/**
 * Created by Рената on 01.12.2016.
 */
public interface TaskList  {
    void addElement(Task task);
    Task findElement(Task task);
    List<Task> getTasks();

}
