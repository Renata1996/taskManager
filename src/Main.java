import swing.Controller.TaskListController;
import swing.forms.TaskObserverForm;
import taskjournal.TaskListImpl;
import taskjournal.task.Task;

import javax.swing.*;

/**
 * Created by Рената on 28.11.2016.
 */
public class Main {
    private TaskObserverForm form;
    private DefaultListModel<Task> jListModel;
    private TaskListImpl taskListImpl;


    public Main() {


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jListModel= new DefaultListModel<Task>();
                form = new TaskObserverForm();
                form.setVisible(true);
                postGUIConstruction();

            }
        });

    }

    private void postGUIConstruction() {
        new TaskListController(form,jListModel);
    }

    public static void main(String[] args) {

        //спец класс для запуска юай
        new Main();

    }
}
