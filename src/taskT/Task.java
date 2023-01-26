package taskT;

import eType.Type;
import exception.IncorrectArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {
    private static int idGenerator;
    private String title;
    private final Type type;
    public  int id;
    private final LocalDateTime dateTime;
    private String description;

    public Task(String title, Type type, LocalDateTime dateTime, String description){
        idGenerator++;
        this.id = idGenerator;
        setTitle(title);
        this.type = type;
        this.dateTime = dateTime;
        setDescription(description);
    }

    @Override
    public String toString() {
        return "Task{" +
                "idGenerator=" + idGenerator +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", id=" + id +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public Type getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) throws IncorrectArgumentException {
        if (title == null || title.isEmpty()) {
            throw new IncorrectArgumentException("Не заполнено поле заголовок.");
        }
        this.title = title;
    }

    public void setDescription(String description) throws IncorrectArgumentException {
        if (description == null || description.isEmpty()) {
            throw new IncorrectArgumentException("Не заполнено поле заголовок.");
        }
        this.description = description;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return idGenerator == task.idGenerator && id == task.id && Objects.equals(title, task.title) && type == task.type && Objects.equals(dateTime, task.dateTime) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGenerator, title, type, id, dateTime, description);
    }

    public abstract boolean appearsIn(LocalDate localDate);
}





