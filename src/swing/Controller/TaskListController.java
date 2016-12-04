package swing.Controller;

import clock.Signal;
import clock.SignalImpl;
import swing.Controller.Action.SelectListAction;
import swing.forms.AddForm;
import swing.forms.PostponeForm;
import swing.forms.TaskObserverForm;
import taskjournal.TaskListImpl;
import taskjournal.task.Task;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Рената on 30.11.2016.
 */
public class TaskListController {

    private final DefaultListModel<Task> jListModel;
    private final TaskObserverForm form;
    private SelectListAction selectListAction;
    JList<Task> jListComponent;
    private Signal signal;

    public TaskListController(TaskObserverForm form, DefaultListModel<Task> jListModel) {
        this.form = form;
        this.jListModel = jListModel;
        jListComponent = form.getJListComponent();
        signal = new SignalImpl();
        init();

    }

    private void init() {
        initForm();
        initUpdateButton();
        initDeleteButton();
        initCompliteButton();
        initPostponeButton();
        loadDefaultList();
        update();
    }

    private void initForm() {
        form.getJListComponent().setModel(jListModel);
    }

    private void loadDefaultList() {
        selectListAction = new SelectListAction(form, jListModel);
        selectListAction.loadDefaultList();
    }

    private void initUpdateButton() {
        form.getUpdateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
            }
        });
    }

    private void update() {
        new Thread() {
            public void run() {
                for (; ; ) {
                    signal.beep();
                    jListModel.removeAllElements();
                    loadDefaultList();
                    try {
                        Thread.sleep(7000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.
                start();
    }

    private void initDeleteButton() {
        form.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < jListModel.getSize(); i++) {
                    if (jListComponent.isSelectedIndex(i)) {
                        jListModel.remove(i);
                        TaskListImpl.getTaskListImpl().delete(i);
                    }
                }
            }
        });
    }

    private void initCompliteButton() {
        form.getCompliteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddForm addForm = new AddForm();
            }
        });
    }

    private void initPostponeButton() {
        form.getPostponeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < jListModel.getSize(); i++) {
                    if (jListComponent.isSelectedIndex(i)) {
                        PostponeForm postponeForm = new PostponeForm(jListModel.get(i));
                    }
                }
            }
        });
    }
}
