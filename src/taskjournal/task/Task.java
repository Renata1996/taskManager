package taskjournal.task;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Created by Рената on 30.11.2016.
 */
public class Task {

    private String contacts;
    private String description;
    private GregorianCalendar dueDate;
    private String name;
    private boolean complite;

    public Task() {
    }

    public Task(String description, GregorianCalendar dueDate, String name, String contacts) {
        this.description = description;
        this.dueDate = dueDate;
        this.name = name;
        this.contacts = contacts;
        complite = false;
    }

    public boolean isComplite() {
        return complite;
    }

    public void setComplite(boolean complite) {
        this.complite = complite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GregorianCalendar getDueDate() {
        return dueDate;
    }

    public void setDueDate(GregorianCalendar dueDate) {
        this.dueDate = dueDate;
    }

    public String dueDateToString() {
        SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy' 'hh:mm");
        String formattedDate = formatter.format(dueDate.getTime());
        return formattedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (o == this)
            return true;
        if (o.getClass() != getClass())
            return false;
        Task t = (Task) o;
        return this.getName().equals(t.getName())
                && this.getContacts().equals(t.getContacts())
                && this.description.equals(t.getDescription())
                && this.getDueDate().equals(t.getDueDate());

    }


}
