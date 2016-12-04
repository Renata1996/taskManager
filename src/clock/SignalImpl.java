package clock;

import taskjournal.TaskListImpl;
import taskjournal.task.Task;

import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Рената on 01.12.2016.
 */
public class SignalImpl implements Signal {

    private List<Task> tasks;

    {
        tasks = TaskListImpl.getTaskListImpl().getTasks();
    }

    public SignalImpl() {
    }

    @Override
    public void beep() {
        new Thread() {
            public void run() {
                GregorianCalendar currentTime = new GregorianCalendar();
                Calendar signalTime;
                for (int i = 0; i < tasks.size(); i++) {
                    Task task = tasks.get(i);
                    signalTime = task.getDueDate();
                    if ((signalTime.getTimeInMillis() - currentTime.getTimeInMillis() <= 0) && task.isComplite() == false) {
                        task.setComplite(true);
                        for (int j = 0; j < 5; j++) {
                            Toolkit.getDefaultToolkit().beep();
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                return;
            }
        }.
                start();
    }
}
