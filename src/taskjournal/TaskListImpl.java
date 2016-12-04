package taskjournal;

import save.SaveTask;
import save.SaveTasksImpl;
import taskjournal.task.Task;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Рената on 30.11.2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "taskListImpl")


public class TaskListImpl implements TaskList {

    @XmlElement(name = "person")
    private List<Task> tasks;
    private static TaskListImpl taskListImpl;
    private static SaveTask saveTask;

    {
        saveTask = new SaveTasksImpl();
        tasks = new ArrayList<>();
    }

    private TaskListImpl() {
    }

    public static TaskListImpl getTaskListImpl() {
        if (taskListImpl == null) {
            taskListImpl = new TaskListImpl();
            taskListImpl = saveTask.fromXmlToObject(getTaskListImpl());
        }

        return taskListImpl;
    }

    @Override
    public void addElement(Task task) {
        tasks.add(task);
        save();
    }

    @Override
    public Task findElement(Task task) {
        return null;
    }

    @Override
    public List<Task> getTasks() {
        return tasks;
    }

    private void save() {
        saveTask.convertObjectToXml(taskListImpl);
    }

    public void delete(int i) {
        tasks.remove(i);
    }

    public Task getTask(Task task) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).equals(task))
                return task;
        }
        return null;
    }






}
