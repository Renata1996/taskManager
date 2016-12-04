package swing.Controller.Action;

import swing.forms.TaskObserverForm;
import taskjournal.TaskListImpl;
import taskjournal.task.Task;

import javax.swing.*;

/**
 * Created by Рената on 30.11.2016.
 */
public class SelectListAction {

    private final DefaultListModel<Task> jListModel;
    private final TaskObserverForm form;

    public SelectListAction(TaskObserverForm form, DefaultListModel<Task> jListModel) {
        this.form = form;
        this.jListModel = jListModel;
    }

    public void loadDefaultList() {
       TaskListImpl.getTaskListImpl().getTasks().forEach(jListModel::addElement);
    }
}
