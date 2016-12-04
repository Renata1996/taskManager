package swing.forms;

import clock.Signal;
import swing.Controller.Action.TaskListCellRenderer;
import taskjournal.task.Task;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Рената on 30.11.2016.
 */
public class TaskObserverForm extends JFrame {
    private JList<Task> jListComponent;
    private JButton compliteButton;
    private JButton postponeButton;
    private JPanel listSelectorPanel;
    private JPanel mainPanel;
    private JButton updateButton;
    private JButton deleteButton;
    private Signal signal;

    public TaskObserverForm() throws HeadlessException {
        $$$setupUI$$$();

        setTitle("Task manager");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add($$$getRootComponent$$$());
        initJList();
        pack();
        setLocationRelativeTo(null);


    }

    private TaskObserverForm getTaskObserverFrame() {
        return this;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JButton getPostponeButton() {
        return postponeButton;
    }

    public JButton getCompliteButton() {
        return compliteButton;
    }

    private void initJList() {
        jListComponent.setCellRenderer(new TaskListCellRenderer());
    }

    public JList<Task> getJListComponent() {
        return jListComponent;
    }

    private void initTaskListSelector() {
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(new Color(-2630936));
        mainPanel.setMinimumSize(new Dimension(400, 400));
        mainPanel.setPreferredSize(new Dimension(700, 700));
        final JScrollPane scrollPane1 = new JScrollPane();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 10, 10, 10);
        mainPanel.add(scrollPane1, gbc);
        jListComponent = new JList();
        jListComponent.setBackground(new Color(-4008488));
        jListComponent.setFont(new Font("Segoe Script", jListComponent.getFont().getStyle(), 12));
        scrollPane1.setViewportView(jListComponent);
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        panel1.setBackground(new Color(-2630936));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 10, 0, 10);
        mainPanel.add(panel1, gbc);
        compliteButton = new JButton();
        compliteButton.setBackground(new Color(-2630936));
        compliteButton.setFont(new Font("Serif", Font.PLAIN, 24));
        compliteButton.setPreferredSize(new Dimension(130, 49));
        compliteButton.setText("Add ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(compliteButton, gbc);
        deleteButton = new JButton();
        deleteButton.setBackground(new Color(-2630936));
        deleteButton.setFont(new Font("Serif", Font.PLAIN, 24));
        deleteButton.setHorizontalAlignment(0);
        deleteButton.setHorizontalTextPosition(0);
        deleteButton.setText("Delete");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(deleteButton, gbc);
        updateButton = new JButton();
        updateButton.setBackground(new Color(-2630936));
        updateButton.setFont(new Font("Serif", Font.PLAIN, 24));
        updateButton.setText("Update");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(updateButton, gbc);
        postponeButton = new JButton();
        postponeButton.setBackground(new Color(-2630936));
        postponeButton.setFont(new Font("Serif", Font.PLAIN, 24));
        postponeButton.setPreferredSize(new Dimension(130, 49));
        postponeButton.setText("Postpone");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(postponeButton, gbc);
        listSelectorPanel = new JPanel();
        listSelectorPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.6;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(listSelectorPanel, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

    /**
     * @noinspection ALL
     */

}