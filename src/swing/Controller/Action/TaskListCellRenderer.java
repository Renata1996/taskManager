package swing.Controller.Action;

import taskjournal.task.Task;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Рената on 30.11.2016.
 */
public class TaskListCellRenderer extends JPanel implements ListCellRenderer<Task> {

    private JLabel description;
    private JLabel dueDate;
    private JLabel name;
    private JLabel contacts;
    private JLabel complite;

    public TaskListCellRenderer() {

        setLayout(new GridBagLayout());
        description = new JLabel();
        dueDate = new JLabel();
        name = new JLabel();
        contacts = new JLabel();
        complite = new JLabel();

        makeLabelProperties(name, 0, 0);
        makeLabelProperties(complite, 2, 0);
        makeLabelProperties(description, 0, 1);
        makeLabelProperties(contacts, 1, 1);
        makeLabelProperties(dueDate, 2, 1);

    }

    private void makeLabelProperties(JLabel label, int column, int line) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = column;
        gbc.gridy = line;
        gbc.weightx = 1;
        if (line == 0) {
            label.setFont(new Font("Segoe Script", Font.BOLD, 30));
        } else {
            label.setFont(new Font("Segoe Script", Font.ITALIC, 20));
        }
        gbc.fill = GridBagConstraints.WEST;
        add(label, gbc);

    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Task> list, Task value, int index, boolean isSelected, boolean cellHasFocus) {

        dueDate.setText("  " + value.dueDateToString() + "  ");
        description.setText("  " + value.getDescription());
        name.setText("  " + value.getName() + "  ");
        contacts.setText("  " + value.getContacts() + "  ");
        if (value.isComplite() == true) {
            complite.setText(" done ");
            setBackground(new Color(173, 216, 169));

        } else {
            complite.setText(" not done ");
            setBackground(Color.PINK);
        }
        if (isSelected) {
            setForeground(Color.PINK);
            setBackground(Color.gray);

        }
        return this;
    }
}
